package com.gaolonglong.app.androidnote.parallaxlistview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.gaolonglong.app.androidnote.R;

/**
 * Created by gaohailong on 2016/10/19.
 */

public class ParallaxActivity extends AppCompatActivity {

    private ParallaxListView parallaxListView;
    private ImageView headerImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parallax_listview_layout);

        parallaxListView = (ParallaxListView) findViewById(R.id.list_view);
        final View headerView = View.inflate(this, R.layout.layout_header, null);
        headerImage = (ImageView) headerView.findViewById(R.id.header_image);
        parallaxListView.addHeaderView(headerView);
        parallaxListView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Cheeses.USER_NAME));

        headerImage.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                parallaxListView.setParallaxImage(headerImage);
                headerImage.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
