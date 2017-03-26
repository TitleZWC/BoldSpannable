package com.titlezwc.boldspannable.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.titlezwc.boldspannable.R;
import com.titlezwc.boldspannable.adapter.ContentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TitleZWC on 2017/3/26.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ContentAdapter mContentAdapter;
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContentAdapter = new ContentAdapter();
        mRecyclerView.setAdapter(mContentAdapter);
        addData();
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
                mContentAdapter.setSearchText(mEditText.getText().toString());
            }
        });
    }

    private void addData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item:" + i);
        }
        mContentAdapter.addData(list);
    }
}
