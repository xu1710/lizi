package com.whut.zhangl;

import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.Toast;

import android.support.v7.widget.Toolbar;
import android.content.*;
import android.widget.TextView;
import android.widget.*;

public class WenhouEdit extends AppCompatActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wenhouedit);
		Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_w);
		setSupportActionBar(toolbar);
		ActionBar actionbar=getSupportActionBar();
		if(actionbar != null){
			actionbar.setDisplayHomeAsUpEnabled(true);
		}
		SharedPreferences sph=getSharedPreferences("wenhou",MODE_PRIVATE);
		String name=sph.getString("name"," ");
		String geyan=sph.getString("geyan","");
		EditText getname0=(EditText) findViewById(R.id.wenhoueditEditText0);
		EditText getgeyan0=(EditText) findViewById(R.id.wenhoueditEditText1);
		getname0.setText(name);
		getgeyan0.setText(geyan);
    }
	public void xiehaole(View p1){
		if(p1.getId()==R.id.wenhoueditButton){
		EditText getname=(EditText) findViewById(R.id.wenhoueditEditText0);
		EditText getgeyan=(EditText) findViewById(R.id.wenhoueditEditText1);
		String getnames=getname.getText().toString();
		String getgeyans=getgeyan.getText().toString();
		SharedPreferences sp=getSharedPreferences("wenhou",MODE_PRIVATE);
		SharedPreferences.Editor e=sp.edit();
		e.putString("name",getnames);
		e.putString("geyan",getgeyans);
		e.commit();
		Toast.makeText(this,getnames+"  "+getgeyans,Toast.LENGTH_SHORT).show();
		Intent in=new Intent();
		in.setClass(this,MainActivity.class);
		startActivity(in);
		finish();
	}}
}
