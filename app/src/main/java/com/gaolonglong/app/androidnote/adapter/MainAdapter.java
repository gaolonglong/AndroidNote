package com.gaolonglong.app.androidnote.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaolonglong.app.androidnote.ui.activity.MainActivity;
import com.gaolonglong.app.androidnote.ui.activity.widget.TextViewActivity;
import com.gaolonglong.app.androidnote.ui.activity.widget.WidgetActivity;

import java.util.List;

/**
 * Created by Admin on 2017/5/26.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<String> list;

    public MainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        holder.text.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof MainActivity){
                    context.startActivity(new Intent(context, WidgetActivity.class));
                }else {
                    context.startActivity(new Intent(context, TextViewActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
