package com.titlezwc.boldspannable.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.titlezwc.boldspannable.R;
import com.titlezwc.boldspannable.utils.BoldSearchUtils;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;
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
        mButton = (Button) findViewById(R.id.btn_tip);
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

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    private void checkSearchContent(String searchContent) {
        Log.d("searchContent:", searchContent);
        if (0 < searchContent.length() && mTextContent.contains(searchContent)) {
            mTextView.setText(BoldSearchUtils.changeSearchContentStyle(mTextContent, searchContent));
        } else {
            mTextView.setText(mTextContent);
        }
    }
}
