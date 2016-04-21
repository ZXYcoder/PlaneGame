package com.pg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static MainActivity instance;
	EditText et_user;
	EditText et_password;
	public final int UI=1;
	public Handler handler=new Handler(){
		@SuppressLint("NewApi") public void handleMessage(android.os.Message msg) {
			if(msg.what==UI){
				et_user.setFocusable(true);
				setContentView(new MySurfaceView(MainActivity.this));
			}
		};
	};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//设置全屏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		et_user=(EditText) findViewById(R.id.editText1);
	    et_password=(EditText) findViewById(R.id.password);
	    Button bt=(Button) findViewById(R.id.button1);
	    bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String user=et_user.getText().toString().trim();
				String password=et_password.getText().toString().trim();
				if(user.equals("")||password.equals(""))
					Toast.makeText(MainActivity.this, "密码帐号不能为空", Toast.LENGTH_SHORT).show();
				else if(user.equals("yuxia")&&password.equals("123")){
					new Thread(){
						public void run() {
							Message msg=new Message();
							msg.what=UI;
							handler.sendMessage(msg);
						};
						
					}.start();
				}
					else{
						Toast.makeText(MainActivity.this, "密码或帐号错误", Toast.LENGTH_SHORT).show();}
					}
				
			
				
		});
	    
		//显示自定义的SurfaceView视图
		//setContentView(new MySurfaceView(this));
	}

}