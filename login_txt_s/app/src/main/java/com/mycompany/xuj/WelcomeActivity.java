package com.mycompany.xuj;

import android.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;

public class WelcomeActivity extends Activity
{
	EditText editText0;
	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomeactivity);
		editText0=(EditText) findViewById(R.id.welcomeactivityEditText0);
		SharedPreferences sha=getSharedPreferences("wenjian",MODE_APPEND);
		String neirong=sha.getString("neir","hh");
		editText0.setText(neirong);
	}
	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu)
	{
		menu.add(0,0,0,"undo");
		menu.add(1,1,1,"redo");
		menu.add(2,2,2,"save");
		menu.add(3,3,3,"save as");
		menu.add(4,4,4,"setting");
		menu.add(5,5,5,"about");
		menu.add(6,6,6,"exit");
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		String string=editText0.getText().toString();
		if(item.getItemId()==0){
			inputfile(string);
			Toast.makeText(this,"undo",Toast.LENGTH_SHORT).show();
		}else if(item.getItemId()==1){
			Toast.makeText(this,"redo",Toast.LENGTH_SHORT).show();
		}else if(item.getItemId()==2){
			Toast.makeText(this,"save",Toast.LENGTH_SHORT).show();
			savefile(string);
		}else if(item.getItemId()==3){
			Toast.makeText(this,"save as",Toast.LENGTH_SHORT).show();
			saveshared(string);
		}else if(item.getItemId()==4){
			Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
		}else if(item.getItemId()==5){
			Toast.makeText(this,"about",Toast.LENGTH_SHORT).show();
		}else if(item.getItemId()==6){
			Toast.makeText(this,"exit",Toast.LENGTH_SHORT).show();
		}
		return false;
	}
	public void saveshared(String string){
		SharedPreferences sh=getSharedPreferences("wenjian",MODE_APPEND);
		SharedPreferences.Editor ea=sh.edit();
		ea.putString("neir",string);
		ea.commit();
		Toast.makeText(this,"save succeed",Toast.LENGTH_SHORT).show();
	}
	public void savefile(String string){
		FileOutputStream out=null;
		try{
			Toast.makeText(this,"0",Toast.LENGTH_SHORT).show();
			out = openFileOutput("@raw/text0.txt",Context.MODE_APPEND);
			out.write(string.getBytes());
			Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
			out.flush();
			out.close();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		if(out==null){
			Toast.makeText(this,"fault1",Toast.LENGTH_SHORT).show();
		}
	}
	public void inputfile(String string){
		String string9 = null;
		String string8=null;
		File file1;
		InputStreamReader input;
		BufferedReader buf;
		try{
			file1=new File("/res/raw/text0.txt");
			input=new InputStreamReader(new FileInputStream(file1),"UTF-8");
			buf=new BufferedReader(input);
			while((string8=buf.readLine())!=null){
				string9+=string8;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		editText0.setText(string9);
		if(string9==null){
			Toast.makeText(this,"fault2",Toast.LENGTH_SHORT).show();
		}
	}
}
