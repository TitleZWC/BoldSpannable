package com.titlezwc.boldspannable.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.titlezwc.boldspannable.R;
import com.titlezwc.boldspannable.viewholder.ContentViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TitleZWC on 2017/3/26.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentViewHolder> {
    private List<String> mList = new ArrayList<>();
    private List<String> mSearchList = new ArrayList<>();
    private String mSearchTex;

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        if (TextUtils.isEmpty(mSearchTex)) {
            holder.render(mList.get(position));
        } else {
            holder.render(mSearchList.get(position));
            holder.checkSearchContent(mSearchList.get(position), mSearchTex);
        }
    }

    @Override
    public int getItemCount() {
        return TextUtils.isEmpty(mSearchTex) ? mList.size() : mSearchList.size();
    }

    public void addData(List<String> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void setSearchText(String searchText) {
        mSearchTex = searchText;
        mSearchList = new ArrayList<>();
        for (String content : mList) {
            if (content.contains(searchText)) {
                mSearchList.add(content);
            }
        }
        notifyDataSetChanged();
    }
}
