package com.domenicportuesi.materialcraigslist.activity.categories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.domenicportuesi.materialcraigslist.R;

import java.util.ArrayList;

public class CategoriesRecyclerviewAdapter extends RecyclerView.Adapter
{
    ArrayList<CategoryItem> mValues;
    Context mContext;
    protected ItemListener mListener;

    public CategoriesRecyclerviewAdapter(Context context, ArrayList values, ItemListener itemListener)
    {
        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView title;
        public TextView count;
        public RelativeLayout relativeLayout;
        CategoryItem item;

        public ViewHolder(View v)
        {
            super(v);

            v.setOnClickListener(this);/**/
            title = (TextView) v.findViewById(R.id.textView_categories_title);
            count = (TextView) v.findViewById(R.id.textview_categories_count);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout_categories);

        }

        public void setData(CategoryItem item)
        {
            this.item = item;

            title.setText(item.getName());
            count.setText(item.getCategoryCount() + " items");
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
    public CategoriesRecyclerviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.categories_recyclerview_item, parent, false);

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
        void onItemClick(CategoryItem item);
    }
}