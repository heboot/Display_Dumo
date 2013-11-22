package com.example.display_coating.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.display_coating.adapter.DuibiEntity;

public class Utils {
	public static String dumotu = "dumotu";
	public static String kangfushe = "kangfushe";
	public static String dumoduibi = "dumoduibi";
	public static String dumotedian = "dumotedian";
	
	
	public static List<Bitmap> bitList = null;

	public static Bitmap currentBit = null;

	public static List<Bitmap> load(Context context, String name) {
		bitList = new ArrayList<Bitmap>();
		FileHelper mFileHelper = new FileHelper(context);
		List<File> fileList = mFileHelper.getFileList(name);
		Log.i("=========filelist" + fileList, "============filelist" + fileList);
		// MulitPointTouchListener mulit=new MulitPointTouchListener();
		for (int i = 0; i < fileList.size(); i++) {
			Bitmap bit = BitmapFactory.decodeFile(fileList.get(i)
					.getAbsolutePath());
			Log.i("=========bit" + bit, "============bit" + bit);
			if (bit != null) {
				bitList.add(bit);
				// if (i == 0) {
				// // setScreenOrientation(bit.getWidth()>bit.getHeight());
				// }
				// setScreenOrientation(bit.getWidth()>bit.getHeight());
			}

		}
		return bitList;
	}

	public static DuibiEntity loadDuiBi(Context context) {
		FileHelper mFileHelper = new FileHelper(context);
		FileInputStream fis = null;
		DuibiEntity de = new DuibiEntity();
		try {
			fis = mFileHelper.readSDFile("dumo/duibi.txt");
			InputStreamReader read = new InputStreamReader(fis, "GBK");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			List<String> txtString = new ArrayList<String>();
			while ((lineTxt = bufferedReader.readLine()) != null) {
				System.out.println(lineTxt);
				txtString.add(lineTxt);
			}
			fis.close();
			read.close();

			int count = 0;
			List<String[]> valueList = new ArrayList<String []>();
			String[] value1 = null;
			String [] value2 = null;
			List<Bitmap> left = null;
			List<Bitmap> right = null;

			String countString = txtString.get(0);
			countString = (String) countString.subSequence(5, countString.length());
			count = Integer.parseInt(countString);
			
			String valueString = txtString.get(1);
			
			valueString = (String)valueString.substring(4,valueString.length());
			
			value1 = valueString.split(",");
			
			valueList.add(value1);
			
			if(txtString.size() > 2){
				valueString = txtString.get(2);
				
				valueString = (String)valueString.substring(4,valueString.length());
				
				value2 = valueString.split(",");
				
				valueList.add(value2);
			}
			
			left = load(context,"dumoduibi/left");
			right = load(context,"dumoduibi/right");
			
		
			
			de.setCount(count);
			de.setLeft(left);
			de.setRight(right);
			de.setValue(valueList);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return de;
	}

}
