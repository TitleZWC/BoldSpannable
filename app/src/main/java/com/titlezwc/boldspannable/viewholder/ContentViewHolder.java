package com.titlezwc.boldspannable.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.titlezwc.boldspannable.R;
import com.titlezwc.boldspannable.utils.BoldSearchUtils;

/**
 * Created by TitleZWC on 2017/3/26.
 */

public class ContentViewHolder extends ViewHolder {
    private TextView mContent;

    public ContentViewHolder(View itemView) {
        super(itemView);
        mContent = (TextView) itemView.findViewById(R.id.tv_item_content);
    }

    public void render(String content) {
        mContent.setText(content);
    }

    public void checkSearchContent(String content, String searchContent) {
        Log.d("searchContent:", searchContent);
        if (0 < searchContent.length() && content.contains(searchContent)) {
            mContent.setText(BoldSearchUtils.changeSearchContentStyle(content, searchContent));
        } else {
            mContent.setText(content);
        }
    }
}
