package com.xujingrong.luckytest;
import android.os.*;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

public class AboutA extends Base
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.abouta);
		Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_a);
		setSupportActionBar(toolbar);
		ActionBar actionbar=getSupportActionBar();
		actionbar.setTitle(" ");
		actionbar.setDisplayHomeAsUpEnabled(true);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:   //返回键的id
                this.finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
