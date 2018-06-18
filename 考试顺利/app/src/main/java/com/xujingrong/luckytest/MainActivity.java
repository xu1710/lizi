package com.xujingrong.luckytest;
/*
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.*;
import android.support.v4.widget.*;
import android.support.design.widget.*;
import android.support.v7.app.ActionBarDrawerToggle;*/

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;
import android.view.View.*;
import android.support.v7.app.ActionBar;
import android.support.v4.widget.SwipeRefreshLayout;

public class MainActivity extends Base implements NavigationView.OnNavigationItemSelectedListener 
{
	private SwipeRefreshLayout refreah;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		/*if(getActionBar()!=null){
			getActionBar().hide();
		}*/
        setContentView(R.layout.cehua_all);
		Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_w);
		setSupportActionBar(toolbar);
		ActionBar actionbar=getSupportActionBar();
		actionbar.setTitle(" ");
		/*if(actionbar != null){
		 actionbar.setDisplayHomeAsUpEnabled(true);
		 }*/
		/*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
			this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.cehua);
        navigationView.setNavigationItemSelectedListener(this);
		
		refreah=(SwipeRefreshLayout) findViewById(R.id.refresh);
		refreah.setColorSchemeResources(R.color.colorPrimary);
		refreah.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
				@Override
				public void onRefresh()
				{
					//Toast.makeText(MainActivity.this,"hh=",Toast.LENGTH_SHORT).show();
					refreah.setRefreshing(false);
				}
			});
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu,menu);
		return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId()){
			case R.id.about:
				//Toast.makeText(this,"a",Toast.LENGTH_SHORT).show();
				Intent i=new Intent(MainActivity.this,AboutA.class);
				startActivity(i);
			//	Toast.makeText(this,"a",Toast.LENGTH_SHORT).show();
				break;
			case R.id.exit:
			//	Toast.makeText(this,"e",Toast.LENGTH_SHORT).show();
				Acollector.finishall();
				break;
		}
		return true;
	}

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
		/*SharedPreferences sph=getSharedPreferences("cishu",MODE_PRIVATE);
		//int apptime=sph.getInt("apptime",0);
		int usetime=sph.getInt("usetime",0);
		if(usetime==0){
			SharedPreferences sp=getSharedPreferences("cishu",MODE_PRIVATE);
			SharedPreferences.Editor e=sp.edit();
			//e.putInt("apptime",1);
			e.putInt("usetime",1);
			e.commit();*/
		switch(id){
			case R.id.e:
				Intent mte=new Intent(MainActivity.this,Experience.class);
				startActivity(mte);
				//Toast.makeText(this,"e",Toast.LENGTH_SHORT).show();
				break;
			case R.id.r:
				Toast.makeText(this,"敬请期待",Toast.LENGTH_SHORT).show();
				break;
			case R.id.g:
				Toast.makeText(this,"敬请期待",Toast.LENGTH_SHORT).show();
				break;
		}
		/*}
		else{
			Toast.makeText(this,"you don't have times!",Toast.LENGTH_SHORT).show();
		}*/
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
	}
	
}
