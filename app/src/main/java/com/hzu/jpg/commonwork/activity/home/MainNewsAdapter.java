package com.hzu.jpg.commonwork.activity.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hzu.jpg.commonwork.R;
import com.hzu.jpg.commonwork.adapter.service.NewsAdapter;
import com.hzu.jpg.commonwork.enity.service.NewsVo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

/**
 * Created by cimcitech on 2017/7/13.
 */

public class MainNewsAdapter extends BaseAdapter {

    private List<NewsVo.Data> data;
    private LayoutInflater inflater;

    public MainNewsAdapter(Context context, List<NewsVo.Data> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public List<NewsVo.Data> getAll() {
        return data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemViewHolder holder;
        NewsVo.Data item = data.get(i);
        if (view == null) {
            holder = new ItemViewHolder();
            view = inflater.inflate(R.layout.new_item_view, null);
            holder.newsDate = (TextView) view.findViewById(R.id.newsDate);
            holder.newsType = (TextView) view.findViewById(R.id.newsType);
            holder.title = (TextView) view.findViewById(R.id.title);
            view.setTag(holder);
        } else {
            holder = (ItemViewHolder) view.getTag();
        }
        holder.title.setText(item.getTitle());
        holder.newsType.setText(item.getNewsType());
        holder.newsDate.setText(item.getNewsDate());
        return view;
    }

    public class ItemViewHolder {
        TextView newsDate;
        TextView newsType;
        TextView title;
    }
}
