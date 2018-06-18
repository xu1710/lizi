package com.xujingrong.xu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity
{
	private MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
		mediaPlayer=MediaPlayer.create(this,R.raw.m);
		if (!mediaPlayer.isPlaying()) {
			mediaPlayer.start();
		}
    }

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
	}
	
}
