package com.taobao.newwidgetdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rowandjj on 2015/7/6.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private List<String> mDataSet = null;

    public MyAdapter(List<String> dataSet)
    {
        this.mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        viewHolder.bindData(mDataSet.get(i));
    }

    @Override
    public int getItemCount()
    {
        return mDataSet.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextView;


        public ViewHolder(View itemView)
        {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.info_text);
        }

        public void bindData(String data)
        {
            if(mTextView != null)
                mTextView.setText(data);
        }
    }
}















