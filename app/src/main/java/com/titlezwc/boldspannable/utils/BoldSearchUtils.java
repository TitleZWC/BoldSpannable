package com.titlezwc.boldspannable.utils;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;

import com.titlezwc.boldspannable.SearchStyleSpan;

/**
 * Created by TitleZWC on 2017/3/26.
 */

public class BoldSearchUtils {
    public static SpannableStringBuilder changeSearchContentStyle(String content, String searchContent) {
        SpannableStringBuilder searchStyle = new SpannableStringBuilder();
        int start;
        while (content.contains(searchContent)) {
            start = content.indexOf(searchContent);
            searchStyle.append(getBoldSpannable(content.substring(0, start + searchContent.length()), searchContent));
            content = content.substring(start + searchContent.length());
        }
        searchStyle.append(content);
        return searchStyle;
    }

    private static SpannableStringBuilder getBoldSpannable(String content, String searchContent) {
        Log.d("subContent:", content);
        int start = content.indexOf(searchContent);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new SearchStyleSpan(Typeface.NORMAL), start, start + searchContent.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
