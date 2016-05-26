package com.leke.volleydemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.leke.volleydemo.R;
import com.leke.volleydemo.volleyplug.LekeRequest;
import com.leke.volleydemo.volleyplug.LekeResponse;
import com.leke.volleydemo.volleyplug.LekeVolley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener{

	Button loginButton ;
	Button updataButton ;
	Button getHwDtlInfoButton ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loginButton = (Button) findViewById(R.id.login);
		updataButton = (Button) findViewById(R.id.updata);
		getHwDtlInfoButton = (Button)findViewById(R.id.getHwDtlInfo) ;
		loginButton.setOnClickListener(this);
		updataButton.setOnClickListener(this);
		getHwDtlInfoButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.login:
				login() ;
				break;
			case R.id.updata:

				break;
			case R.id.getHwDtlInfo:
				getHwDtlInfo();
				break;
			default:
				break;
		}

	}

	private void getHwDtlInfo(){
		String _s = "homework" ;
		String _m = "getHwDtlInfo" ;
		Map<String , String> params = new HashMap<>() ;
		params.put("homeworkDtlId","82672866") ;
		new LekeVolley(LekeRequest.ResposeType.StringType, _s, _m, params, new LekeResponse.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.i("Test2",response) ;
			}
		}, new LekeResponse.ErrorListener() {
			@Override
			public void onErrorResponse(String error) {

			}
		});

	}

	private void login(){
		String _s = "cas" ;
		String _m = "doLogin" ;
		Map<String , String> params = new HashMap<>() ;
		params.put("loginName","port_t1") ;
		params.put("password" , "1234567") ;
		LekeVolley lekeVolley = new LekeVolley(LekeRequest.ResposeType.StringType, _m, _s, params , new LekeResponse.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.i("Test_1" , response) ;
			}
		}, new LekeResponse.ErrorListener() {
			@Override
			public void onErrorResponse(String error) {

			}
		}) ;
	}
}
