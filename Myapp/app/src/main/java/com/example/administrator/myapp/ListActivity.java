package com.example.administrator.myapp;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.myapp.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initUI();
    }

    private  void  initUI(){
        listview = (ListView)findViewById(R.id.listview);
        ContactInjfoDao  mDao=new ContactInjfoDao(ListActivity.this);
        final   ArrayList<String> list1 = mDao.getTableList();

        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("name", list1.get(i));
            listems.add(listem);
        }

        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.addtablelist_item, new String[] {"name"},
                new int[] {R.id.item_name});

        listview.setAdapter(simplead);
    }

    public void add(View view){
        Intent intent2=new  Intent();
        intent2.setClass(ListActivity.this,MainActivity.class);
        startActivity(intent2);
    }
}
