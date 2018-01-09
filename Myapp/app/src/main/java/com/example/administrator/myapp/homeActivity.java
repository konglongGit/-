package com.example.administrator.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

//import com.example.goufei.test.AddPreActivity;
//import com.example.goufei.test.IncomeActivity;
//import com.example.goufei.test.ListComeActivity;//
//import com.example.goufei.test.ListPreActivity;
//import com.example.goufei.test.OutcomeActivity;
//import com.example.goufei.test.SettingActivity;
public class homeActivity extends Activity implements OnClickListener {

    private LinearLayout llIncome, llOutcome, llList, llSetting, llFenlei,
            llModle, llBiaoge;
    private ImageView iv01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //哎呀Git
        initView();
    }

    public void initView() {

        iv01 = (ImageView) findViewById(R.id.ivHomeIncome);
        llIncome = (LinearLayout) findViewById(R.id.llincome);
        llOutcome = (LinearLayout) findViewById(R.id.lloutcome);
        llList = (LinearLayout) findViewById(R.id.lllist);
        llSetting = (LinearLayout) findViewById(R.id.llsetting);
        llFenlei = (LinearLayout) findViewById(R.id.llfenlei);
        llModle = (LinearLayout) findViewById(R.id.llmodle);


        llIncome.setOnClickListener(this);
        llOutcome.setOnClickListener(this);
        llList.setOnClickListener(this);
        llSetting.setOnClickListener(this);
        llFenlei.setOnClickListener(this);
        llModle.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //�ж��Ƿ�������
            case R.id.llincome:
                Log.i("test", "aaa");
                Intent intentIncmoe = new Intent(homeActivity.this,ListActivity.class);
                startActivity(intentIncmoe);

                break;
            //֧��
            case R.id.lloutcome:
                Intent intent1 = new Intent(homeActivity.this,MainActivity.class);
                startActivity(intent1);

                break;
            //��֧�б�
            case R.id.lllist:


                break;
            //�������
            case R.id.llsetting:


                break;
            //�A���б�
            case R.id.llfenlei:

                break;
            //����A��
            case R.id.llmodle:

                break;
            //��֧ͼ��
		/*case R.id.lltubiao:
			Intent intentTubiao = new Intent(MainActivity.this,IncomeActivity.class);
			startActivity(intentTubiao);

			break;*/

            default:

                break;
    }
}
}

