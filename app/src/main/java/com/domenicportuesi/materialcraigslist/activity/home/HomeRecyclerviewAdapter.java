package com.domenicportuesi.materialcraigslist.activity.home;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.domenicportuesi.materialcraigslist.R;

import java.util.ArrayList;


public class HomeRecyclerviewAdapter extends RecyclerView.Adapter
{
    ArrayList<HomeItem> mValues;
    Context mContext;
    protected ItemListener mListener;

    public HomeRecyclerviewAdapter(Context context, ArrayList values, ItemListener itemListener)
    {
        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        HomeItem item;

        public ViewHolder(View v)
        {
            super(v);

            v.setOnClickListener(this);/**/
            textView = (TextView) v.findViewById(R.id.textView_rv_home);
            imageView = (ImageView) v.findViewById(R.id.imageView_rv_home);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);

        }

        public void setData(HomeItem item)
        {
            this.item = item;

            textView.setText(item.text);
            imageView.setImageResource(item.drawable);
            relativeLayout.setBackgroundColor(Color.parseColor(item.color));
        }


        @Override
        public void onClick(View view)
        {
            if (mListener != null)
            {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public HomeRecyclerviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_recyclerview_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position)
    {
        ViewHolder vh = (ViewHolder) viewHolder;
        vh.setData(mValues.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mValues.size();
    }

    public interface ItemListener
    {
        void onItemClick(HomeItem item);
    }
}