package com.example.baseball;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

// Local variables set up
    TextView Strikes;
    TextView Balls;
    Button strikesUp;
    Button strikesDown;
    Button ballsUp;
    Button ballsDown;
    Button clear;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Local Variables given the values from XML
        Strikes = findViewById(R.id.strikesCount);
        Balls = findViewById(R.id.ballsCount);
        strikesUp = findViewById(R.id.strikesUp);
        strikesDown = findViewById(R.id.strikesDown);
        ballsUp = findViewById(R.id.ballsUp);
        ballsDown = findViewById(R.id.ballsDown);
        clear = findViewById(R.id.clear);
        exit = findViewById(R.id.exit);


// Onclick Listeners
        findViewById(R.id.strikesUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUp(view, Strikes);
            }
        });

        findViewById(R.id.ballsUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUp(view, Balls);
            }
        });

        findViewById(R.id.strikesDown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown(view, Strikes);
            }
        });
        findViewById(R.id.ballsDown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown(view, Balls);
            }
        });

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear(view);
            }
        });

        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }

    // counter functions
    public void countUp(View view, TextView textView) {
        String valueString = textView.getText().toString();
        Integer valueInt = Integer.parseInt(valueString);
        valueInt++;
        textView.setText(valueInt.toString());
    }

    public void countDown(View view, TextView textView) {
        String valueString = textView.getText().toString();
        Integer valueInt = Integer.parseInt(valueString);
        if(valueInt > 0){
            valueInt--;
        }
        textView.setText(valueInt.toString());
    }

    public void clear(View view) {
        Integer strikeCount = 0;
        Integer ballCount = 0;


        //Sets the value to the TextView
        Strikes.setText(strikeCount.toString());
        Balls.setText(ballCount.toString());
    }



}
