package com.gaolonglong.app.androidnote.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gaolonglong.app.androidnote.MainActivity;
import com.gaolonglong.app.androidnote.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohailong on 2016/9/21.
 */
public class GuideActivity extends Activity {
    private ViewPager viewPager;
    private ImageView imageDot;
    private RelativeLayout indicatorZone;
    private Button goMain;
    private List<View> imageDots;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.guide_layout);

        final RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        imageDot = (ImageView) findViewById(R.id.move_dot);
        indicatorZone = (RelativeLayout) findViewById(R.id.indicator_zone);
        goMain = (Button) findViewById(R.id.btn_go_main);

        imageDots = new ArrayList<>();
        imageDots.add(View.inflate(this, R.layout.guide_item01,null));
        imageDots.add(View.inflate(this, R.layout.guide_item02,null));
        imageDots.add(View.inflate(this, R.layout.guide_item03,null));

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageDots.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = imageDots.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageDots.get(position));
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int marginLeft = (int) (position * 25 * 3 + positionOffset * 25 * 3);
                lp.width = 36;
                lp.height = 36;
                lp.setMargins(marginLeft, 0, 0, 0);
                imageDot.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2){
                    indicatorZone.setVisibility(View.GONE);
                    goMain.setVisibility(View.VISIBLE);
                }else {
                    indicatorZone.setVisibility(View.VISIBLE);
                    goMain.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        goMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
