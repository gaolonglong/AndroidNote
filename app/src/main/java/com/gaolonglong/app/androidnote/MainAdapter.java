package com.gaolonglong.app.androidnote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaolonglong.app.androidnote.guide.GuideActivity;
import com.gaolonglong.app.androidnote.parallaxlistview.ParallaxActivity;
import com.gaolonglong.app.androidnote.toolbar.ToolbarActivity;

import java.util.List;

/**
 * Created by gaohailong on 2016/10/19.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<String> titleList;

    public MainAdapter(Context context, List<String> titleList) {
        this.context = context;
        this.titleList = titleList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, final int position) {
        holder.title.setText(titleList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        context.startActivity(new Intent(context, ToolbarActivity.class));
                        break;
                    case 1:
                        context.startActivity(new Intent(context, GuideActivity.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context, ParallaxActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }
}
