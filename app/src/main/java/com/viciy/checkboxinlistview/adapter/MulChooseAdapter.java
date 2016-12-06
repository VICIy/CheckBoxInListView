package com.viciy.checkboxinlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.viciy.checkboxinlistview.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by viciy on 2016/12/6.
 */

public class MulChooseAdapter extends BaseAdapter {
    protected       LayoutInflater           mInflater;
    private         List<String>             mDatas;
    // 用来控制CheckBox的选中状况

    private  static HashMap<Integer,Boolean> isSelected;

    public MulChooseAdapter(Context context, List<String> mDatas) {
        this.mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
        isSelected = new HashMap<>();
        //初始化isSelected的数据
        for(int i=0; i<mDatas.size();i++) {
            isSelected.put(i,false);
        }
    }



    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public String getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = mInflater.inflate(R.layout.item_checkbox_in_listview, parent,false);
            holder = new ViewHolder();
            holder.selected = (CheckBox)convertView.findViewById(R.id.cb_viciy);
            holder.tvViciy = (TextView)convertView.findViewById(R.id.tv_viciy) ;
            convertView.setTag(holder);
        }

        String item = getItem(position);
        holder.tvViciy.setText(item);
        // 根据isSelected来设置checkbox的选中状况
        holder.selected.setChecked(isSelected.get(position));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setItemCheckBoxStatus(v,position);
            }
        });
        return convertView;
    }

    //设置条目chebox的状态
    public void setItemCheckBoxStatus(View mView,int postion){
        ViewHolder holder = (ViewHolder) mView.getTag();
        // 改变CheckBox的状态
        holder.selected.toggle();
        // 将CheckBox的选中状况记录下来
        isSelected.put(postion,holder.selected.isChecked());

    }
    public static class ViewHolder {
        private CheckBox selected;
        private TextView tvViciy;
    }
}
