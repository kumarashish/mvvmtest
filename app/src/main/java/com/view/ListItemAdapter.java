package com.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.testproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import model.Result;

public class ListItemAdapter extends BaseAdapter {
    List<Result> listItems;
    Activity act;
   public ListItemAdapter(List<Result> listItems , Activity act)
    {
        this.listItems=listItems;
        this.act=act;
    }
    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            LayoutInflater inflater=act.getLayoutInflater();
            convertView=inflater.inflate(R.layout.list_item, null,true);

        }else{
            holder=(ViewHolder)convertView.getTag();

        }
        convertView.setTag(holder);
        return convertView;
    }
    public class ViewHolder{
        @BindView(R.id.textView)
        TextView textView;
    }
}
