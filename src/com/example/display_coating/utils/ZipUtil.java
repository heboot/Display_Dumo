package com.example.display_coating.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtil {
	private static final String TAG = "ZipUtil";

	public ZipUtil()
	{
	}

	public static void unZip(String zipFileName, String outputDirectory)
		throws Exception
	{
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));
		String name = "";
		String extractedFile = "";
		int counter = 0;
		ZipEntry z;
		while ((z = in.getNextEntry()) != null) 
		{
			name = z.getName();
			if (z.isDirectory())
			{
				name = name.substring(0, name.length() - 1);
				File folder = new File((new StringBuilder(String.valueOf(outputDirectory))).append(File.separator).append(name).toString());
				folder.mkdir();
				if (counter == 0)
					extractedFile = folder.toString();
				counter++;
				folder = null;
			} else
			{
				File file = new File((new StringBuilder(String.valueOf(outputDirectory))).append(File.separator).append(name).toString());
				file.createNewFile();
				FileOutputStream out = new FileOutputStream(file);
				byte buffer[] = new byte[1024];
				int ch;
				while ((ch = in.read(buffer)) != -1) 
				{
					out.write(buffer, 0, ch);
					out.flush();
				}
				out.close();
				buffer = (byte[])null;
				out = null;
				file = null;
			}
		}
		in.close();
		in = null;
	}

	public static void unZip(InputStream zipInputStream, String outputDirectory)
		throws Exception
	{
		ZipInputStream in = new ZipInputStream(zipInputStream);
		String name = "";
		String extractedFile = "";
		int counter = 0;
		ZipEntry z;
		while ((z = in.getNextEntry()) != null) 
		{
			name = z.getName();
			if (z.isDirectory())
			{
				name = name.substring(0, name.length() - 1);
				File folder = new File((new StringBuilder(String.valueOf(outputDirectory))).append(File.separator).append(name).toString());
				folder.mkdir();
				if (counter == 0)
					extractedFile = folder.toString();
				counter++;
				folder = null;
			} else
			{
				File file = new File((new StringBuilder(String.valueOf(outputDirectory))).append(File.separator).append(name).toString());
				file.createNewFile();
				FileOutputStream out = new FileOutputStream(file);
				byte buffer[] = new byte[1024];
				int ch;
				while ((ch = in.read(buffer)) != -1) 
				{
					out.write(buffer, 0, ch);
					out.flush();
				}
				file.renameTo(new File((new StringBuilder(String.valueOf(outputDirectory))).append(File.separator).append(name).toString()));
				out.close();
				buffer = (byte[])null;
				out = null;
				file = null;
			}
		}
		in.close();
		in = null;
	}
}
