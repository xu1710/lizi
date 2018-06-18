package com.whut.zhangl;

import android.content.Intent;  
import android.content.pm.PackageInfo;  
import android.content.pm.PackageManager;  
import android.os.Bundle;  
import android.support.v7.app.AppCompatActivity;  
import android.view.Window;  
import android.view.WindowManager;  
import android.view.animation.AlphaAnimation;  
import android.widget.RelativeLayout;  
import android.widget.TextView;  
import java.util.Timer;  
import java.util.TimerTask;
import android.os.*;
import android.content.*;  


public class Wecome extends AppCompatActivity
{
	static int flag=0;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
        //设置为无标题栏  
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);  
        //设置为全屏模式  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);  
							 
		SharedPreferences sp=getSharedPreferences("wenhou",MODE_PRIVATE);
		SharedPreferences.Editor e=sp.edit();
		e.putString("name","同学");
		e.putString("geyan","no zuo no death");
		e.commit();
		
     /*   //创建Timer对象  
        Timer timer = new Timer();  

        //创建TimerTask对象  
        TimerTask timerTask = new TimerTask() {  
            @Override  
            public void run() {  
                Intent intent = new Intent(Wecome.this, MainActivity.class);  
                startActivity(intent);  
                finish();  
            }  
        };
	
        //使用timer.schedule（）方法调用timerTask，定时3秒后执行run  
		if(flag==0){
			flag=1;
			timer.schedule(timerTask, 1000);  
		}*/
		
		Handler handler = new Handler();
		//当计时结束,跳转至主界面
		handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent intent = new Intent(Wecome.this, MainActivity.class);
					startActivity(intent);
					Wecome.this.finish();
				}
			}, 1500);
		/*new Thread(new Runnable() {
				@Override
				public void run() {
					//此处运行耗时任务
					runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Intent intent = new Intent(Wecome.this, MainActivity.class);
								startActivity(intent);
								Wecome.this.finish();
							}
						});

				}
			}).start();*/
	}
	
}
