package com.yan.vicky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView score;
    TextView score1;
    private final String TAG ="score";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket);
        Log.i(TAG,"onCreate:");

        score = (TextView)findViewById(R.id.score);
        score1 = (TextView)findViewById(R.id.score1);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String scorea =((TextView)findViewById(R.id.score)).getText().toString();
        String scoreb =((TextView)findViewById(R.id.score1)).getText().toString();

        Log.i(TAG,"onSaveInstanceState:");

        outState.putString("teama_score",scorea);
        outState.putString("teamb_score",scoreb);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String scorea = savedInstanceState.getString("teama_score");
        String scoreb = savedInstanceState.getString("teamb_score");

        Log.i(TAG,"onRestoreInstanceState:");

        ((TextView)findViewById(R.id.score)).setText(scorea);
        ((TextView)findViewById(R.id.score1)).setText(scoreb);
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
        }else {
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
