package com.xujingrong.luckytest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Base extends AppCompatActivity
{
	long firstTime = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		Acollector.adda(this);
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		Acollector.removea(this);
	}
	@Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        
		if (secondTime - firstTime > 1500)
		{
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else {
            Acollector.finishall();
        }/*
	@Override
    public void onBackPressed() {
        //1.点击的时间差如果大于2000，则提示用户点击两次退出
        long mExitTime = 0;
		if (System.currentTimeMillis() - mExitTime > 2000)
		{
            //2.保存当前时间
            mExitTime  = System.currentTimeMillis();
            //3.提示
            showShortToast("再按一次退出");
        } else {
            //4.点击的时间差小于2000，调用父类onBackPressed方法执行退出。
            super.onBackPressed();
        }*/
    }
}
