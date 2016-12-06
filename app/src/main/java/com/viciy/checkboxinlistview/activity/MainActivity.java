package com.viciy.checkboxinlistview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.viciy.checkboxinlistview.R;
import com.viciy.checkboxinlistview.adapter.MulChooseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView       lv;
    private List<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initAdapter();
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv_viciy);
    }

    private void initAdapter() {
        MulChooseAdapter adapter = new MulChooseAdapter(this, dataList);
        lv.setAdapter(adapter);
    }

    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            dataList.add("viciy"+i);
        }
    }
}
