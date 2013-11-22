package com.example.display_coating.activitys;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.display_coating.R;
import com.example.display_coating.utils.Utils;

public class ImageActivity extends Activity{

	private PhotoViewAttacher mAttacher;
	private ImageView mImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_image);
		
		mImageView = (ImageView) findViewById(R.id.iv_photo);
		
		BitmapDrawable bd = new BitmapDrawable(Utils.currentBit);
		
		mImageView.setImageDrawable(bd);
		
		mAttacher = new PhotoViewAttacher(mImageView);

		// Lets attach some listeners, not required though!
//		mAttacher.setOnMatrixChangeListener(new MatrixChangeListener());
//		mAttacher.setOnPhotoTapListener(new PhotoTapListener());
		
	}
	
}
