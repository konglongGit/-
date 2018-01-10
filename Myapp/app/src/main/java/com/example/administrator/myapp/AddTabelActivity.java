package com.example.administrator.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/10.
 */

public class AddTabelActivity extends Activity {
    ListView listView;
    ArrayList<Map<String, Object>> results;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_table);
        initUI();
    }

    private void initUI(){

        listView = (ListView)findViewById(R.id.addTableList);


        results = new ArrayList<Map<String, Object>>();

        SimpleAdapter simplead = new SimpleAdapter(this, results,
                R.layout.addtablelist_item, new String[] { "name", "leixing"},
                new int[] {R.id.item_name,R.id.item_leixing});

        listView.setAdapter(simplead);

        findViewById(R.id.addTableButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAddDialog();
            }
        });

        findViewById(R.id.addTableDoneButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDoneDialog();
            }
        });
    }


    private void done(){

    }

    private void getDoneDialog(){
        final EditText et=new EditText(this);
        et.setText("杨洋");
        new AlertDialog.Builder(this).setTitle("输入表名").setView(et).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1){
                        String size=et.getText().toString();

                        String tableStr = "create table "+size+" (id integer primary key autoincrement";

                        for (int i = 0; i< results.size();i++){
                            Map<String, Object> listem = results.get(i);
                            tableStr = tableStr+", "+listem.get("name")+" varchar(20)";
                        }
                        tableStr = tableStr+")";
                        ContactInjfoDao mDao=new ContactInjfoDao(AddTabelActivity.this);
                        mDao.createTable(tableStr,size);
                        finish();
                    }
                }).setNegativeButton("取消",null).show();
    }

    private void getAddDialog(){
        final EditText et=new EditText(this);
        et.setText("杨洋");
        new AlertDialog.Builder(this).setTitle("关键字").setView(et).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1){
                        String size=et.getText().toString();

                        Map<String, Object> listem = new HashMap<String, Object>();
                        listem.put("name", size);
                        listem.put("leixing", "var");

                        results.add(listem);
                        SimpleAdapter simplead = (SimpleAdapter) listView.getAdapter();
                        simplead.notifyDataSetChanged();

                    }
                }).setNegativeButton("取消",null).show();
    }
}
