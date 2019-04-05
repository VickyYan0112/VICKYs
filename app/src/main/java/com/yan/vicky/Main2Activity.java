package com.yan.vicky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView score;
    TextView score1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket);

        score = (TextView)findViewById(R.id.score);
        score1 = (TextView)findViewById(R.id.score1);
    }

    public void threePointA(View btn){
        if (btn.getId()==R.id.btn1){
            showScore(3);
        }else{
            showScore1(3);
        }
    }
    public void twoPointA(View btn){
        if (btn.getId()==R.id.btn2){
            showScore(2);
        }else{
            showScore1(2);
        }
    }
    public void onePointA(View btn){
        if (btn.getId()==R.id.btn3){
            showScore(1);
        }else{
            showScore1(1);
        }
    }
    public void resetA(View btn){
        score.setText("0");
        score1.setText("0");
    }
    private void showScore(int inc){
        Log.i("show","inc="+inc);
        String oldscore = (String)score.getText();
        int newscore = Integer.parseInt(oldscore)+inc;
        score.setText(""+newscore);
    }

    private void showScore1(int inc){
        Log.i("show","inc="+inc);
        String oldscore = (String)score1.getText();
        int newscore = Integer.parseInt(oldscore)+inc;
        score1.setText(""+newscore);
    }
}
