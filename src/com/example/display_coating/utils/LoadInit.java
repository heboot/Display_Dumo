package com.example.display_coating.utils;

import java.io.File;
import java.io.InputStream;

import com.example.display_coating.activitys.MainActivity;

import android.content.res.AssetManager;

public class LoadInit {
	public static void loadAllResInit(){
		FileHelper f=new FileHelper(MainActivity.getInstance());
		File file=new File(f.getSdPath());
		if(!file.exists()){
			file.mkdirs();
		}
		File file1=new File(f.getSdPath()+"dumo.ll");
		
		try {//
			if(!file1.exists()){
				
				AssetManager ass=MainActivity.getInstance().getAssets();
				InputStream is=ass.open("zip/dumo.zip");
				if(is!=null){
					ZipUtil.unZip(is, f.getSdPath());
					file1.createNewFile();
				}
				
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
