package com.yan.vicky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);
        out = findViewById(R.id.txtout);
        EditText inp = findViewById(R.id.inp);
        String str = inp.getText().toString();
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TextView out =findViewById(R.id.txtout);
        EditText inp = findViewById(R.id.inp);
        String str = inp.getText().toString();
        float  f = Float.parseFloat(str);
        out.setText(32+f*1.8+"华氏度");
        Log.i("main","btn clicked");
    }
}
