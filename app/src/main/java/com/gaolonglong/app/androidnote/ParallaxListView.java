package com.gaolonglong.app.androidnote;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by gaohailong on 2016/9/19.
 */
public class ParallaxListView extends ListView {

    private ImageView headerImage;
    private int originalHeight;
    private int drawableHeight;

    public ParallaxListView(Context context) {
        super(context);
    }

    public ParallaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setParallaxImage(ImageView parallaxImage){
        this.headerImage = parallaxImage;
        originalHeight = headerImage.getHeight();
        drawableHeight = headerImage.getDrawable().getIntrinsicHeight();
        Log.e("233",originalHeight+"--"+drawableHeight);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        //Toast.makeText(getContext(),deltaY+"--"+isTouchEvent,Toast.LENGTH_SHORT).show();
        Log.e("233",deltaY+"--"+isTouchEvent);
        if (deltaY < 0 && isTouchEvent){
            int newHeight = headerImage.getHeight() + Math.abs(deltaY);
            if (newHeight <= drawableHeight){
                headerImage.getLayoutParams().height = newHeight;
                //scaleHeaderImage();
                headerImage.requestLayout();
            }
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    private void scaleHeaderImage() {
        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.3f,1.0f,1.3f,
                Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(500);
        headerImage.startAnimation(scaleAnimation);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                int currentHeight = headerImage.getHeight();
                ValueAnimator animator = ValueAnimator.ofInt(currentHeight,originalHeight);
                animator.setDuration(300);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int) animation.getAnimatedValue();
                        headerImage.getLayoutParams().height = value;
                        headerImage.requestLayout();
                        Log.e("233",value+"--");
                    }
                });
                animator.setInterpolator(new OvershootInterpolator(2));
                animator.start();
                break;
        }
        return super.onTouchEvent(ev);
    }
}
