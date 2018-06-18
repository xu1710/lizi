package com.whut.zhangl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.content.*;
import android.view.View.*;
import android.support.v7.app.*;
import android.support.v4.widget.*;
import android.os.*;
import android.view.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
	//static int flag=0;
	private SwipeRefreshLayout refreah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
		ActionBar actionbar1=getSupportActionBar();
		actionbar1.setTitle("首页");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
		SharedPreferences sph=getSharedPreferences("wenhou",MODE_PRIVATE);
		String name=sph.getString("name"," ");
		String geyan=sph.getString("geyan","");
		TextView edit=(TextView) findViewById(R.id.zhangliTextView_wh);
		TextView edi=(TextView) findViewById(R.id.zhangliTextView_wh1);
		edit.setText("你好,"+name+"！");
		edi.setText(geyan);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
			localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
		}
		refreah=(SwipeRefreshLayout) findViewById(R.id.refresh);
		refreah.setColorSchemeResources(R.color.colorPrimary);
		refreah.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

				@Override
				public void onRefresh()
				{
					Toast.makeText(MainActivity.this,"hh=",Toast.LENGTH_SHORT).show();
					refreah.setRefreshing(false);
				}
			});
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        //noinspection SimplifiableIfStatement
		switch(id){
			case R.id.wifiid:
				Toast.makeText(this,"wifi",Toast.LENGTH_SHORT).show();
				break;
			case R.id.searchid:
				Toast.makeText(this,"seacch",Toast.LENGTH_SHORT).show();
				break;
			case R.id.action_settings:
				Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
				break;
			default:
				return super.onOptionsItemSelected(item);
			}
		return false;
	}

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
		
		switch(id){
			case R.id.nav_camera:
				Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
				break;
			case R.id.nav_gallery:
				Toast.makeText(this,"自习室",Toast.LENGTH_SHORT).show();
				break;
			case R.id.nav_slideshow:
				Toast.makeText(this,"二手市场",Toast.LENGTH_SHORT).show();
				break;
			case R.id.nav_manage:
				Toast.makeText(this,"失物招领",Toast.LENGTH_SHORT).show();
				break;
			case R.id.nav_manage1:
				Toast.makeText(this,"更多功能",Toast.LENGTH_SHORT).show();
				break;
			case R.id.nav_share:
				Toast.makeText(this,"反馈",Toast.LENGTH_SHORT).show();
				break;
			case R.id.nav_send:
				Toast.makeText(this,"设置",Toast.LENGTH_SHORT).show();
				break;
			case R.id.nav_send1:
				Toast.makeText(this,"关于",Toast.LENGTH_SHORT).show();
				break;
			default:
				return false;
			}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
	public void contentonClick(View p1){
		switch(p1.getId()){
			
			case R.id.content_mainLinearLayout_wenhou:
				//Toast.makeText(this,"wenhouedit",Toast.LENGTH_SHORT).show();
				Intent intent=new Intent();
				intent.setClass(this,WenhouEdit.class);
				startActivity(intent);
				//finish();
				break;
			default:
				break;
		}
	}
	
}
