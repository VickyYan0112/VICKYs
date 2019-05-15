package com.yan.vicky;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class helloActivity extends AppCompatActivity implements View.OnClickListener{
    TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        TextView out = findViewById(R.id.textView3);

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putInt("score1", 3);
                editor.putInt("score2", 2);
                editor.putInt("score3", 1);
                editor.apply();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                int sc1 = preferences.getInt("score1", 0);
                Log.d("helloActivity", "score is" + sc1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                int sc2 = preferences.getInt("score2", 0);
                Log.d("helloActivity", "score is" + sc2);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                int sc3 = preferences.getInt("score3", 0);
                Log.d("helloActivity", "score is" + sc3);
            }
        });
    }

    @Override
    public void onClick(View v) {
        TextView out = findViewById(R.id.textView3);
        out.setText("clicked");
    }
}
