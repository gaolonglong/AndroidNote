package com.gaolonglong.app.androidnote.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Admin on 2017/5/26.
 */

public class MarqueeTextView extends TextView {

    public MarqueeTextView(Context context) {
        super(context);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*实现跑马灯效果：
    （1）如果在一个页面中只有一个TextView来实现跑马灯效果,那么只需要在系统TextView设置以下四个属性就可以了;
    android:singleLine="true"
    android:ellipsize="marquee"
    android:focusable="true"
    android:focusableInTouchMode="true"
    （2）如果在一个页面中有多个TextView来实现跑马灯效果,那么需要自定义TextView,并重写isFocused()方法,返回true,
    在布局引用这个自定义的MarqueeTextView,并设置以下属性即可;
    android:singleLine="true"
    android:ellipsize="marquee"
    android:focusable="true"
    android:focusableInTouchMode="true"*/

    @Override
    public boolean isFocused() {
        return true;
    }
}
