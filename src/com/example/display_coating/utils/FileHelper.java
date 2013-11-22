package com.example.display_coating.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class FileHelper {

	private Context context;
	private String SDPATH;
	private String FILESPATH;

	public FileHelper(Context context)
	{
		this.context = context;
		try
		{
			SDPATH = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/gless/").toString();
			FILESPATH = (new StringBuilder(String.valueOf(this.context.getFilesDir().getPath()))).append("/").toString();
		}
		catch (Exception exception) { }
	}

	public String getSdPath()
	{
		return SDPATH;
	}

	public List<File> getFileList(String name)
	{
		List<File> list = new ArrayList<File>();
		String s = (new StringBuilder(String.valueOf(SDPATH)+"dumo/")).append(name).toString();
		Log.i("==============", "============"+s);
		File file = new File(s);
		Log.i("====", "====" + file.exists());
		File [] fs = null;
		if (file.exists())
			fs = file.listFiles();
		    for (int i = 0; i < fs.length; i++) {
		    	list.add(fs[i]);
			}
		Log.i("====list", "====list" + list.size());
		return list;
	}

	public String getpath()
	{
		return FILESPATH;
	}

	public File creatSDFile(String fileName)
		throws IOException
	{
		File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(fileName).toString());
		file.createNewFile();
		return file;
	}

	public boolean delSDFile(String fileName)
	{
		File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(fileName).toString());
		if (file == null || !file.exists() || file.isDirectory())
		{
			return false;
		} else
		{
			file.delete();
			return true;
		}
	}

	public File creatSDDir(String dirName)
	{
		File dir = new File((new StringBuilder(String.valueOf(SDPATH))).append(dirName).toString());
		if (!dir.exists())
			dir.mkdirs();
		return null;
	}

	boolean isFolderExists(String strFolder)
	{
		File file = new File(strFolder);
		if (!file.exists())
			return file.mkdirs();
		else
			return true;
	}

	public boolean isFileIsExists(String path)
	{
		File f = new File((new StringBuilder(String.valueOf(SDPATH))).append(path).toString());
		return f.exists();
	}

	public boolean delSDDir(String dirName)
	{
		File dir = new File((new StringBuilder(String.valueOf(SDPATH))).append(dirName).toString());
		return delDir(dir);
	}

	public boolean renameSDFile(String oldfileName, String newFileName)
	{
		File oleFile = new File((new StringBuilder(String.valueOf(SDPATH))).append(oldfileName).toString());
		File newFile = new File((new StringBuilder(String.valueOf(SDPATH))).append(newFileName).toString());
		return oleFile.renameTo(newFile);
	}

	public boolean copySDFileTo(String srcFileName, String destFileName)
		throws IOException
	{
		File srcFile = new File((new StringBuilder(String.valueOf(SDPATH))).append(srcFileName).toString());
		File destFile = new File((new StringBuilder(String.valueOf(SDPATH))).append(destFileName).toString());
		return copyFileTo(srcFile, destFile);
	}

	public boolean copySDFilesTo(String srcDirName, String destDirName)
		throws IOException
	{
		File srcDir = new File((new StringBuilder(String.valueOf(SDPATH))).append(srcDirName).toString());
		File destDir = new File((new StringBuilder(String.valueOf(SDPATH))).append(destDirName).toString());
		return copyFilesTo(srcDir, destDir);
	}

	public boolean moveSDFileTo(String srcFileName, String destFileName)
		throws IOException
	{
		File srcFile = new File((new StringBuilder(String.valueOf(SDPATH))).append(srcFileName).toString());
		File destFile = new File((new StringBuilder(String.valueOf(SDPATH))).append(destFileName).toString());
		return moveFileTo(srcFile, destFile);
	}

	public boolean moveSDFilesTo(String srcDirName, String destDirName)
		throws IOException
	{
		File srcDir = new File((new StringBuilder(String.valueOf(SDPATH))).append(srcDirName).toString());
		File destDir = new File((new StringBuilder(String.valueOf(SDPATH))).append(destDirName).toString());
		return moveFilesTo(srcDir, destDir);
	}

	public FileOutputStream writeSDFile(String fileName)
		throws IOException
	{
		File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(fileName).toString());
		FileOutputStream fos = new FileOutputStream(file);
		return fos;
	}

	public FileOutputStream appendSDFile(String fileName)
		throws IOException
	{
		File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(fileName).toString());
		FileOutputStream fos = new FileOutputStream(file, true);
		return fos;
	}

	public FileInputStream readSDFile(String fileName)
		throws IOException
	{
		File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(fileName).toString());
		if (file.exists())
		{
			FileInputStream fis = new FileInputStream(file);
			return fis;
		} else
		{
			return null;
		}
	}

	public InputStream readSDFile1(String fileName)
		throws IOException
	{
		File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(fileName).toString());
		if (file.exists())
		{
			InputStream is = new FileInputStream(file);
			return is;
		} else
		{
			return null;
		}
	}

	public File creatDataFile(String fileName)
		throws IOException
	{
		File file = new File((new StringBuilder(String.valueOf(FILESPATH))).append(fileName).toString());
		file.createNewFile();
		return file;
	}

	public File creatDataDir(String dirName)
	{
		File dir = new File((new StringBuilder(String.valueOf(FILESPATH))).append(dirName).toString());
		dir.mkdir();
		return dir;
	}

	public boolean delDataFile(String fileName)
	{
		File file = new File((new StringBuilder(String.valueOf(FILESPATH))).append(fileName).toString());
		return delFile(file);
	}

	public boolean delDataDir(String dirName)
	{
		File file = new File((new StringBuilder(String.valueOf(FILESPATH))).append(dirName).toString());
		return delDir(file);
	}

	public boolean renameDataFile(String oldName, String newName)
	{
		File oldFile = new File((new StringBuilder(String.valueOf(FILESPATH))).append(oldName).toString());
		File newFile = new File((new StringBuilder(String.valueOf(FILESPATH))).append(newName).toString());
		return oldFile.renameTo(newFile);
	}

	public boolean copyDataFileTo(String srcFileName, String destFileName)
		throws IOException
	{
		File srcFile = new File((new StringBuilder(String.valueOf(FILESPATH))).append(srcFileName).toString());
		File destFile = new File((new StringBuilder(String.valueOf(FILESPATH))).append(destFileName).toString());
		return copyFileTo(srcFile, destFile);
	}

	public boolean copyDataFilesTo(String srcDirName, String destDirName)
		throws IOException
	{
		File srcDir = new File((new StringBuilder(String.valueOf(FILESPATH))).append(srcDirName).toString());
		File destDir = new File((new StringBuilder(String.valueOf(FILESPATH))).append(destDirName).toString());
		return copyFilesTo(srcDir, destDir);
	}

	public boolean moveDataFileTo(String srcFileName, String destFileName)
		throws IOException
	{
		File srcFile = new File((new StringBuilder(String.valueOf(FILESPATH))).append(srcFileName).toString());
		File destFile = new File((new StringBuilder(String.valueOf(FILESPATH))).append(destFileName).toString());
		return moveFileTo(srcFile, destFile);
	}

	public boolean moveDataFilesTo(String srcDirName, String destDirName)
		throws IOException
	{
		File srcDir = new File((new StringBuilder(String.valueOf(FILESPATH))).append(srcDirName).toString());
		File destDir = new File((new StringBuilder(String.valueOf(FILESPATH))).append(destDirName).toString());
		return moveFilesTo(srcDir, destDir);
	}

	public OutputStream wirteFile(String fileName)
		throws IOException
	{
		OutputStream os = context.openFileOutput(fileName, 2);
		return os;
	}

	public OutputStream appendFile(String fileName)
		throws IOException
	{
		OutputStream os = context.openFileOutput(fileName, 32768);
		return os;
	}

	public InputStream readFile(String fileName)
		throws IOException
	{
		InputStream is = context.openFileInput(fileName);
		return is;
	}

	public boolean delFile(File file)
	{
		if (file.isDirectory())
			return false;
		else
			return file.delete();
	}

	public boolean delDir(File dir)
	{
		if (dir == null || !dir.exists() || dir.isFile())
			return false;
		File afile[];
		int j = (afile = dir.listFiles()).length;
		for (int i = 0; i < j; i++)
		{
			File file = afile[i];
			if (file.isFile())
				file.delete();
			else
			if (file.isDirectory())
				delDir(file);
		}

		dir.delete();
		return true;
	}

	public boolean copyFileTo(File srcFile, File destFile)
		throws IOException
	{
		if (srcFile.isDirectory() || destFile.isDirectory())
			return false;
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		int readLen = 0;
		byte buf[] = new byte[1024];
		while ((readLen = fis.read(buf)) != -1) 
			fos.write(buf, 0, readLen);
		fos.flush();
		fos.close();
		fis.close();
		return true;
	}

	public boolean copyFilesTo(File srcDir, File destDir)
		throws IOException
	{
		if (!srcDir.isDirectory() || !destDir.isDirectory())
			return false;
		if (!destDir.exists())
			return false;
		File srcFiles[] = srcDir.listFiles();
		for (int i = 0; i < srcFiles.length; i++)
			if (srcFiles[i].isFile())
			{
				File destFile = new File((new StringBuilder(String.valueOf(destDir.getPath()))).append("\\").append(srcFiles[i].getName()).toString());
				copyFileTo(srcFiles[i], destFile);
			} else
			if (srcFiles[i].isDirectory())
			{
				File theDestDir = new File((new StringBuilder(String.valueOf(destDir.getPath()))).append("\\").append(srcFiles[i].getName()).toString());
				copyFilesTo(srcFiles[i], theDestDir);
			}

		return true;
	}

	public boolean moveFileTo(File srcFile, File destFile)
		throws IOException
	{
		boolean iscopy = copyFileTo(srcFile, destFile);
		if (!iscopy)
		{
			return false;
		} else
		{
			delFile(srcFile);
			return true;
		}
	}

	public boolean moveFilesTo(File srcDir, File destDir)
		throws IOException
	{
		if (!srcDir.isDirectory() || !destDir.isDirectory())
			return false;
		File srcDirFiles[] = srcDir.listFiles();
		for (int i = 0; i < srcDirFiles.length; i++)
			if (srcDirFiles[i].isFile())
			{
				File oneDestFile = new File((new StringBuilder(String.valueOf(destDir.getPath()))).append("\\").append(srcDirFiles[i].getName()).toString());
				moveFileTo(srcDirFiles[i], oneDestFile);
				delFile(srcDirFiles[i]);
			} else
			if (srcDirFiles[i].isDirectory())
			{
				File oneDestFile = new File((new StringBuilder(String.valueOf(destDir.getPath()))).append("\\").append(srcDirFiles[i].getName()).toString());
				moveFilesTo(srcDirFiles[i], oneDestFile);
				delDir(srcDirFiles[i]);
			}

		return true;
	}
}
