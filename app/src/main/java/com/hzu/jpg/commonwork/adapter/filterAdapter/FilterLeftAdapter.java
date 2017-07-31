package com.hzu.jpg.commonwork.adapter.filterAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzu.jpg.commonwork.R;
import com.hzu.jpg.commonwork.adapter.BaseListAdapter;
import com.hzu.jpg.commonwork.enity.FilterTwoEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sunfusheng on 16/4/23.
 */
public class FilterLeftAdapter extends BaseListAdapter<FilterTwoEntity> {


    public FilterLeftAdapter(Context context) {
        super(context);
    }

    public FilterLeftAdapter(Context context, List<FilterTwoEntity> list) {
        super(context, list);
    }

    public void setSelectedEntity(FilterTwoEntity filterEntity) {
        for (FilterTwoEntity entity : getData()) {
            entity.setSelected(filterEntity != null && entity.getType().equals(filterEntity.getType()));
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_filter_left, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FilterTwoEntity entity = getItem(position);

        holder.tvTitle.setText(entity.getType());
        if (entity.isSelected()) {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.llRootView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        } else {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.font_black_2));
            holder.llRootView.setBackgroundColor(mContext.getResources().getColor(R.color.font_black_6));
        }

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.ll_root_view)
        LinearLayout llRootView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
