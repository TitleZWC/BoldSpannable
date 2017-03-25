package com.titlezwc.boldspannable;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditText;
    private String mTextContent = "123456789012345678901234567890";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mTextView.setText(mTextContent);
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkSearchContent(mEditText.getText().toString());
            }
        });
    }

    private void checkSearchContent(String searchContent) {
        Log.d("searchContent:", searchContent);
        if (0 < searchContent.length() && mTextContent.contains(searchContent)) {
            mTextView.setText(changeSearchContentStyle(mTextContent, searchContent));
        } else {
            mTextView.setText(mTextContent);
        }
    }

    private SpannableStringBuilder changeSearchContentStyle(String content, String searchContent) {
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

    private SpannableStringBuilder getBoldSpannable(String content, String searchContent) {
        Log.d("subContent:", content);
        int start = content.indexOf(searchContent);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new SearchStyleSpan(Typeface.NORMAL), start, start + searchContent.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
