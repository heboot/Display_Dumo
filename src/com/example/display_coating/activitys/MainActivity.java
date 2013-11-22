package com.example.display_coating.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.display_coating.R;
import com.example.display_coating.adapter.DuibiEntity;
import com.example.display_coating.utils.LoadInit;
import com.example.display_coating.utils.Utils;

public class MainActivity extends Activity implements OnClickListener {

	Button btn1, btn2, btn3, btn4;
	Intent i;
	private static MainActivity gla;
	
	
	public static MainActivity getInstance() {
		return gla;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gla = this;
		LoadInit.loadAllResInit();
		initView();
	}

	private void initView() {
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn1:
			i = new Intent(MainActivity.this, Gallery3DActivity.class);
			i.putExtra("name", Utils.dumotu);
			startActivity(i);
			break;
		case R.id.btn2:
			i = new Intent(MainActivity.this, Gallery3DActivity.class);
			i.putExtra("name", Utils.kangfushe);
			startActivity(i);
			break;
		case R.id.btn3:
			i = new Intent(MainActivity.this,DuiBiActivity.class);
			i.putExtra("name", Utils.dumoduibi);
			startActivity(i);
			break;
		case R.id.btn4:
			i = new Intent(MainActivity.this, Gallery3DActivity.class);
			i.putExtra("name", Utils.dumoduibi);
			startActivity(i);
			break;
		default:
			break;
		}
	}

	

}
