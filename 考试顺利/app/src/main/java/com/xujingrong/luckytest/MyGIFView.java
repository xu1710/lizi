package com.xujingrong.luckytest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

public class MyGIFView extends View{
	private long movieStart;
	private Movie movie;
    //此处必须重写该构造方法
	public MyGIFView(Context context,AttributeSet attributeSet) {
		super(context,attributeSet);
//以文件流（InputStream）读取进gif图片资源
		movie=Movie.decodeStream(getResources().openRawResource(R.drawable.about));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		long curTime=android.os.SystemClock.uptimeMillis();
//第一次播放
		if (movieStart == 0) {
			movieStart = curTime;
		}
		if (movie != null) {
			int duraction = movie.duration();
			int relTime = (int) ((curTime-movieStart)%duraction);
			movie.setTime(relTime);
			movie.draw(canvas, 0, 0);
//强制重绘
			invalidate();
		}
		super.onDraw(canvas);
	}
}
