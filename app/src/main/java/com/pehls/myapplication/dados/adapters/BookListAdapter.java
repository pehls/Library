package com.pehls.myapplication.dados.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pehls.myapplication.R;
import com.pehls.myapplication.bookDetailActivity;
import com.pehls.myapplication.bookDetailFragment;
import com.pehls.myapplication.bookListActivity;
import com.pehls.myapplication.dados.model.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bumptech.glide.Glide;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.MyViewHolder>{
    private Context context;
    private static Map<String, Book> ITEM_MAP = new HashMap<String, Book>();
    private  bookListActivity mParentActivity;
    private  List<Book> mValues;
    private  boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Book item = (Book) view.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(bookDetailFragment.ARG_ITEM_ID, item.getNome());
                bookDetailFragment fragment = new bookDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.book_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, bookDetailActivity.class);
                intent.putExtra(bookDetailFragment.ARG_ITEM_ID, item.getNome());

                context.startActivity(intent);
            }
        }
    };



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_content, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mIdView.setText(mValues.get(position).getNome());
        holder.mContentView.setText(mValues.get(position).getAutor());

        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);

        try {
            Glide.with(context)
                    .load(mValues.get(position).getThumbnail())
                    .into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mIdView;
        public TextView mContentView;
        public ImageView thumbnail;
        public RelativeLayout viewBackground, viewForeground;

        public MyViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.id_text);
            mContentView = (TextView) view.findViewById(R.id.content);
            thumbnail = view.findViewById(R.id.thumbnail);
            viewBackground = view.findViewById(R.id.view_background);
            viewForeground = view.findViewById(R.id.view_foreground);

        }
    }
    public void removeItem(int position) {
        mValues.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(Book item, int position) {
        mValues.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }
    public BookListAdapter(Context context, Map<String, Book> list) {
        this.context = context;
        this.ITEM_MAP = list;
    }
}
