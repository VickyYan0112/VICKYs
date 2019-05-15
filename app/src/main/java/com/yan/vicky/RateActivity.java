package com.yan.vicky;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {

    EditText rmb;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        rmb= (EditText) findViewById(R.id.rmb);
        show = (TextView) findViewById(R.id.showout);
    }

    public void onClick(View btn){
        //获取用户输入,输入为空时float会报错
        String str =rmb.getText().toString();
        float f=0;
        if(str.length()>0) {
            f = Float.parseFloat(str);
        }else{
            //提示用户输入内容
            Toast.makeText(this,"请输入金额",Toast.LENGTH_SHORT).show();
        }
        float value=0;
        if(btn.getId()==R.id.btn_dollar){
            value = f*(1/6.7f);
        }else if(btn.getId()==R.id.btn_euro){
            value = f*(1/11f);
        }else if(btn.getId()==R.id.btn_won) {
            value = f * 500;
        }
            show.setText(String.valueOf(value));

    }

    public void openOne(View btn){
        //打开一个页面Activity
        Log.i("open","openOne:");
        Intent hello = new Intent(this,Main2Activity.class);
        Intent web = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jd.com"));
        startActivity(web);
    }
}
