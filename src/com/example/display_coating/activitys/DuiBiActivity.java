package com.example.display_coating.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.display_coating.R;
import com.example.display_coating.adapter.DuibiEntity;
import com.example.display_coating.utils.MessageIds;
import com.example.display_coating.utils.Utils;
import com.example.display_coating.views.ArrayWheelAdapter;
import com.example.display_coating.views.WheelView;

public class DuiBiActivity extends Activity implements OnClickListener{

	static DuibiEntity de;
	
	public static WheelView wv_refraction1;
	public static WheelView wv_ray1;
	public static WheelView wv_refraction2;
	public static WheelView wv_ray2;
	
	Button btn_jia_1, btn_jia_2, btn_jia_3, btn_jia_4, btn_jian_1, btn_jian_2,
	btn_jian_3, btn_jian_4;
	
	static ImageView iv_left,iv_right;
	
	Intent i;
	
	static int flag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_refraction);
		
	    de = Utils.loadDuiBi(this);
	    i = new Intent();
	    initView();
		
	}
	
	private void initView(){
		
		iv_left = (ImageView)findViewById(R.id.iv_left);
		iv_right = (ImageView)findViewById(R.id.iv_right);
		
		wv_refraction1 = (WheelView) findViewById(R.id.wv_refraction1);
		wv_refraction2 = (WheelView) findViewById(R.id.wv_refraction2);
		wv_ray1 = (WheelView) findViewById(R.id.wv_ray1);
		wv_ray2 = (WheelView) findViewById(R.id.wv_ray2);
		
		wv_refraction1.setAdapter(new ArrayWheelAdapter<String>(de.getValue().get(0)));
		wv_refraction1.TEXT_SIZE = 30;
		wv_refraction1.setCurrentItem(de.getValue().get(0).length/2);

		wv_refraction2.setAdapter(new ArrayWheelAdapter<String>(de.getValue().get(0)));
		wv_refraction2.TEXT_SIZE = 30;
		wv_refraction2.setCurrentItem(de.getValue().get(0).length/2);

	
		
		
		
		btn_jia_1 = (Button) findViewById(R.id.btn_jia_1);
		btn_jia_2 = (Button) findViewById(R.id.btn_jia_2);
		btn_jia_3 = (Button) findViewById(R.id.btn_jia_3);
		btn_jia_4 = (Button) findViewById(R.id.btn_jia_4);
		btn_jian_1 = (Button) findViewById(R.id.btn_jian_1);
		btn_jian_2 = (Button) findViewById(R.id.btn_jian_2);
		btn_jian_3 = (Button) findViewById(R.id.btn_jian_3);
		btn_jian_4 = (Button) findViewById(R.id.btn_jian_4);
		
		
		btn_jia_1.setOnClickListener(this);
		btn_jia_2.setOnClickListener(this);
		btn_jia_3.setOnClickListener(this);
		btn_jia_4.setOnClickListener(this);

		btn_jian_1.setOnClickListener(this);
		btn_jian_2.setOnClickListener(this);
		btn_jian_3.setOnClickListener(this);
		btn_jian_4.setOnClickListener(this);
		
		iv_left.setOnClickListener(this);
		iv_right.setOnClickListener(this);

		
		if(de.getCount() == 2){
			//btn_jia_2
			btn_jia_2.setVisibility(View.GONE);
			//wv_ray1
			wv_ray1.setVisibility(View.GONE);
			//btn_jian_2
			btn_jian_2.setVisibility(View.GONE);
			//btn_jia_3
			btn_jia_3.setVisibility(View.GONE);
			//wv_ray2
			wv_ray2.setVisibility(View.GONE);
			//btn_jian_3
			btn_jian_3.setVisibility(View.GONE);
		}else{
			wv_ray1.setAdapter(new ArrayWheelAdapter<String>(de.getValue().get(1)));
			wv_ray1.TEXT_SIZE = 30;
			wv_ray1.setCurrentItem(de.getValue().get(1).length/2);

			wv_ray2.setAdapter(new ArrayWheelAdapter<String>(de.getValue().get(1)));
			wv_ray2.TEXT_SIZE = 30;
			wv_ray2.setCurrentItem(de.getValue().get(1).length/2);
		}
		iv_left.setDrawingCacheEnabled(true);
		iv_right.setDrawingCacheEnabled(true);
		iv_left.setImageBitmap(de.getLeft().get(0));
		iv_right.setImageBitmap(de.getRight().get(0));
		
		
		
	}
	
	
	public static Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case MessageIds.jia_1:
				if (wv_refraction1.getCurrentItem() + 1 <= wv_refraction1
						.getAdapter().getItemsCount()) {
					wv_refraction1.setCurrentItem(wv_refraction1
							.getCurrentItem() + 1);
					
					
					flag = wv_refraction1
							.getCurrentItem() + 1;
					
					iv_left.setImageBitmap(de.getLeft().get(flag));
				} else {
					wv_refraction1.setCurrentItem(wv_refraction1.getAdapter()
							.getItemsCount());
					
					flag = wv_refraction1.getAdapter()
							.getItemsCount();
					iv_left.setImageBitmap(de.getLeft().get(flag));
				}
				break;
			case MessageIds.jia_2:
				if (wv_ray1.getCurrentItem() + 1 <= wv_ray1.getAdapter()
						.getItemsCount()) {
					wv_ray1.setCurrentItem(wv_ray1.getCurrentItem() + 1);
					
					flag = wv_refraction1
							.getCurrentItem() + 1;
					
					iv_left.setImageBitmap(de.getLeft().get(flag));
				} else {
					wv_ray1.setCurrentItem(wv_ray1.getAdapter().getItemsCount());
					flag = wv_refraction1.getAdapter()
							.getItemsCount();
					iv_left.setImageBitmap(de.getLeft().get(flag));
				}
				break;
			case MessageIds.jia_3:
				if (wv_ray2.getCurrentItem() + 1 <= wv_ray2.getAdapter()
						.getItemsCount()) {
					wv_ray2.setCurrentItem(wv_ray2.getCurrentItem() + 1);
					

					flag = wv_refraction2
							.getCurrentItem() + 1;
					
					iv_right.setImageBitmap(de.getRight().get(flag));
					
				} else {
					wv_ray2.setCurrentItem(wv_ray2.getAdapter().getItemsCount());
					
					flag = wv_refraction2.getAdapter()
							.getItemsCount();
					
					iv_right.setImageBitmap(de.getRight().get(flag));
				}
				break;
			case MessageIds.jia_4:
				if (wv_refraction2.getCurrentItem() + 1 <= wv_refraction2
						.getAdapter().getItemsCount()) {
					wv_refraction2.setCurrentItem(wv_refraction2
							.getCurrentItem() + 1);
					
					
					flag = wv_refraction2
							.getCurrentItem() + 1;
					
					iv_right.setImageBitmap(de.getRight().get(flag));
					
				} else {
					wv_refraction2.setCurrentItem(wv_refraction2.getAdapter()
							.getItemsCount());
					
					flag = wv_refraction2.getAdapter()
							.getItemsCount();
					
					iv_right.setImageBitmap(de.getRight().get(flag));
				}
				break;
			case MessageIds.jian_1:
				if (wv_refraction1.getCurrentItem() - 1 >= 0) {
					wv_refraction1.setCurrentItem(wv_refraction1
							.getCurrentItem() - 1);
					
					flag = wv_refraction1
							.getCurrentItem() -1;
					
					iv_left.setImageBitmap(de.getLeft().get(flag));
					
				} else {
					wv_refraction1.setCurrentItem(0);
					
					flag = 0;
					iv_left.setImageBitmap(de.getLeft().get(flag));
				}
				break;
			case MessageIds.jian_2:
				if (wv_ray1.getCurrentItem() - 1 >= 0) {
					wv_ray1.setCurrentItem(wv_ray1.getCurrentItem() - 1);
					
					flag = wv_refraction1
							.getCurrentItem() -1;
					
					iv_left.setImageBitmap(de.getLeft().get(flag));
				} else {
					wv_ray1.setCurrentItem(0);
					
					flag = 0;
					iv_left.setImageBitmap(de.getLeft().get(flag));
				}
				break;
			case MessageIds.jian_3:
				if (wv_ray2.getCurrentItem() - 1 >= 0) {
					wv_ray2.setCurrentItem(wv_ray2.getCurrentItem() - 1);
					
					flag = wv_refraction2
							.getCurrentItem() - 1;
					
					iv_right.setImageBitmap(de.getRight().get(flag));
				} else {
					wv_ray2.setCurrentItem(0);
					
					flag = 0;
					
					iv_right.setImageBitmap(de.getRight().get(flag));
					
				}
				break;
			case MessageIds.jian_4:
				if (wv_refraction2.getCurrentItem() - 1 >= 0) {
					wv_refraction2.setCurrentItem(wv_refraction2
							.getCurrentItem() - 1);
					
					
					flag = wv_refraction2
							.getCurrentItem() - 1;
					
					iv_right.setImageBitmap(de.getRight()
							.get(flag));
				} else {
					wv_refraction2.setCurrentItem(0);
					
					flag = 0;
					
					iv_right.setImageBitmap(de.getRight().get(flag));
				}
				break;
			default:
				break;
			}

		}

	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_jia_1:
			mHandler.sendEmptyMessage(MessageIds.jia_1);
			break;
		case R.id.btn_jia_2:
			mHandler.sendEmptyMessage(MessageIds.jia_2);
			break;
		case R.id.btn_jia_3:
			mHandler.sendEmptyMessage(MessageIds.jia_3);
			break;
		case R.id.btn_jia_4:
			mHandler.sendEmptyMessage(MessageIds.jia_4);
			break;
		case R.id.btn_jian_1:
			mHandler.sendEmptyMessage(MessageIds.jian_1);
			break;
		case R.id.btn_jian_2:
			mHandler.sendEmptyMessage(MessageIds.jian_2);
			break;
		case R.id.btn_jian_3:
			mHandler.sendEmptyMessage(MessageIds.jian_3);
			break;
		case R.id.btn_jian_4:
			mHandler.sendEmptyMessage(MessageIds.jian_4);
			break;
		case R.id.iv_left:
			i.setClass(DuiBiActivity.this, ImageActivity.class);
			Utils.currentBit = de.getLeft().get(flag);
        	startActivity(i);
			break;
		case R.id.iv_right:
			i.setClass(DuiBiActivity.this, ImageActivity.class);
			Utils.currentBit = de.getRight().get(flag);
        	startActivity(i);
			break;
		default:
			break;
		}
	}
	

}
