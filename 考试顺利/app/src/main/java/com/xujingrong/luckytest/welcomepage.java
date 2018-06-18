package com.xujingrong.luckytest;

//import android.support.v7.app.;
import android.os.Bundle;
import android.content.Intent;
import android.view.WindowManager;
import android.os.Handler;
//import android.widget.Toast;

public class welcomepage extends Base
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (getActionBar() != null)
		{
			getActionBar().hide();
		}
		setContentView(R.layout.welcomepage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);  

		/*SharedPreferences sp=getSharedPreferences("cishu",MODE_PRIVATE);
		 SharedPreferences.Editor e=sp.edit();
		 e.putInt("apptime",0);
		 e.putInt("usetime",0);
		 e.commit();*/
		//int apptime=0;
		//Toast.makeText(this,"ijhg",Toast.LENGTH_SHORT).show();
		/*SharedPreferences sph=getSharedPreferences("cishu",MODE_PRIVATE);
		 int apptime=sph.getInt("apptime",0);
		 //int usetime=sph.getInt("usetime",0);
		 Toast.makeText(this,apptime,Toast.LENGTH_SHORT).show();*/
		//if (apptime == 0)
		//{
			/*SharedPreferences sp=getSharedPreferences("cishu",MODE_PRIVATE);
			 SharedPreferences.Editor e=sp.edit();
			 e.putInt("apptime",1);
			 //e.putInt("usetime",0);
			 e.commit();*/
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
					@Override
					public void run()
					{
						Intent intent = new Intent();
						intent.setClass(welcomepage.this, MainActivity.class);
						welcomepage.this.startActivity(intent);
						welcomepage.this.finish();

					}
				}, 1500);
		/*}
		else
		{
			Acollector.finishall();
		}*/
	}
}
