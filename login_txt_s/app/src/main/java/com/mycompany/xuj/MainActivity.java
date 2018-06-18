package com.mycompany.xuj;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import java.security.*;
import android.widget.MediaController.*;
import android.media.*;
import android.content.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends Activity
{
	private EditText getkeyword;
	public String keyword;
	private Button login;
	static int flag;
	static int lastday0=0;
	/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");     
	Date curDate =  new Date(System.currentTimeMillis());  
	//获取当前时间    
	String str = formatter.format(curDate);*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		keyword="123456";
		login=(Button) findViewById(R.id.mainButton0);
		getkeyword=(EditText) findViewById(R.id.mainEditText1);
		SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);
		SharedPreferences.Editor e=sp.edit();
		e.putString("password","123456");
		e.commit();
		SharedPreferences sph=getSharedPreferences("login",MODE_PRIVATE);
		final String passwar=sph.getString("password"," ");
	    final int lastday=sph.getInt("lastday",0);
		lastday0=lastday;
		Calendar calendar = Calendar.getInstance();
		//获取系统的日期
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int date=year*1000+month*100+day;
		if(date>=lastday0){
			lastday0=date;
			flag=3;
		}
		//设置不可编辑
		if(flag<=0){
			getkeyword.setKeyListener(null);
		}
		//输入密码
		login.setOnClickListener(new OnClickListener()
		{
				@Override
				public void onClick(View p1)
				{
				if(flag>0){
					if(getkeyword.getText().toString().equals(passwar))
						{
							getkeyword.getText().clear();
							Intent welcome=new Intent();
							welcome.setClass(MainActivity.this,WelcomeActivity.class);
							startActivity(welcome);
						}
						else{
							flag-=1;
							if(flag<=0){
								getkeyword.getText().clear();
								lastday0+=1;
								SharedPreferences spi=getSharedPreferences("login",MODE_PRIVATE);
								SharedPreferences.Editor ei=spi.edit();
								ei.putInt("lastday",lastday0);
								ei.commit();
								Toast.makeText(MainActivity.this,"try it tomorrow!",Toast.LENGTH_SHORT).show();
								finish();
							}else{
							Toast.makeText(MainActivity.this,"Wrong! you have only "+flag+" times",Toast.LENGTH_SHORT).show();
							getkeyword.getText().clear();
							}
						}
					}
				}
		});
	}
	//退出
	public void Exitonclick(View p1){
		switch(p1.getId()){
			case R.id.mainButton1:
				finish();
		}
	}
}
