package com.xujingrong.luckytest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {

    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private Paint mPaint;
    private int mViewWidth = 0;
    private int mTranslate = 0;

    private boolean mAnimating = true;

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(-mViewWidth, 0, 0, 0,
													 new int[] { 0xff99ffff, 0xff66ffcc, 0xff33ff66 },
													 null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAnimating && mGradientMatrix != null) {
            mTranslate += mViewWidth / 10;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(500);
        }
    }

}
	/*
import android.view.View;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.widget.TextView;

public class MyTextView extends TextView
{
	private LinearGradient mLinearGradient;
	private Paint mPaint;
	private int mViewWidth = 0;
	private Rect mTextBound = new Rect();

	public MyTextView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		mViewWidth = getMeasuredWidth();
		mPaint = getPaint();
		String mTipText = getText().toString();
		mPaint.getTextBounds(mTipText, 0, mTipText.length(), mTextBound);
		mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0,
											 new int[]{0xFF266459, 0xFF14A49F},
											 new float[] { 0, 0.5f, 1}, Shader.TileMode.REPEAT);
		mPaint.setShader(mLinearGradient);
		canvas.drawText(mTipText, getMeasuredWidth() / 2 - mTextBound.width() / 2, getMeasuredHeight() / 2 + mTextBound.height() / 2, mPaint);
	}
}*/
