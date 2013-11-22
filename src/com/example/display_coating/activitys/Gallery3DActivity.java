package com.example.display_coating.activitys;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.display_coating.R;
import com.example.display_coating.adapter.ImageAdapter;
import com.example.display_coating.utils.Utils;
import com.example.display_coating.widget.GalleryFlow;

public class Gallery3DActivity extends Activity {

	public static List<Bitmap> bitList = null;
	Intent i;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_gallery);

		// Integer[] images = { R.drawable.img0001, R.drawable.img0030,
		// R.drawable.img0100, R.drawable.img0130, R.drawable.img0200,
		// R.drawable.img0230, R.drawable.img0330,R.drawable.img0354 };
		//

		String stringValue = getIntent().getStringExtra("name");

		i = new Intent();
		bitList = Utils.load(this, stringValue);
		Log.i("=================", "============" + bitList.size());
		ImageAdapter adapter = new ImageAdapter(this, bitList);
		adapter.createReflectedImages();// 创建倒影效果

		GalleryFlow galleryFlow = (GalleryFlow) this
				.findViewById(R.id.Gallery01);
		galleryFlow.setFadingEdgeLength(0);
		galleryFlow.setSpacing(-100); // 图片之间的间距
		galleryFlow.setAdapter(adapter);

		galleryFlow.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				i.setClass(Gallery3DActivity.this, ImageActivity.class);
				Utils.currentBit = bitList.get(position);
				startActivity(i);
				// Toast.makeText(getApplicationContext(),
				// String.valueOf(position), Toast.LENGTH_SHORT).show();
			}

		});

		galleryFlow.setSelection(adapter.getCount() / 2);

	}
}
