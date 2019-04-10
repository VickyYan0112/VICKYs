package com.yan.vicky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RateChangeActivity extends AppCompatActivity {

    private final String TAG ="Rate";
    private float dollarRate =0.1f;
    private float euroRate =0.2f;
    private float wonRate = 0.3f;

    TextView show;
    EditText rmb;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_change);

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
        Log.i(TAG,"onClick:r="+f);

        float value=0;
        if(btn.getId()==R.id.btn_dollar){
            show.setText(String.format("%.2f",f*dollarRate));
        }else if(btn.getId()==R.id.btn_euro){
            show.setText(String.format("%.2f",f*euroRate));
        }else if(btn.getId()==R.id.btn_won) {
            show.setText(String.format("%.2f",f*wonRate));
        }

    }

    public void openOne(View btn){
        openConfig();

    }

    private void openConfig() {
        Intent config = new Intent(this,ConfigActivity.class);
        config.putExtra("dollar_rate_key", dollarRate);
        config.putExtra("euro_rate_key", euroRate);
        config.putExtra("won_rate_key", wonRate);
        Log.i(TAG,"openOne:dollarRate="+dollarRate);
        Log.i(TAG,"openOne:euroRate="+euroRate);
        Log.i(TAG,"openOne:wonRate="+wonRate);

        startActivityForResult(config,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.rate,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if(item.getItemId()==R.id.menu_set){
           openConfig();
       }
       return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode==1 && resultCode==2){
           Bundle bundle = data.getExtras();
           dollarRate = bundle.getFloat("key_dollar",0.1f);
           euroRate = bundle.getFloat("key_euro",0.1f);
           wonRate = bundle.getFloat("key_won",0.1f);

           Log.i(TAG,"onAcitivityResult:dollarRate="+dollarRate);
           Log.i(TAG,"onAcitivityResult:euroRate="+euroRate);
           Log.i(TAG,"onAcitivityResult:wonRate="+wonRate);

       }
        super.onActivityResult(requestCode, resultCode, data);
    }
}