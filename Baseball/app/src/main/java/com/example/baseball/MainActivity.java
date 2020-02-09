package com.example.baseball;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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
        strikesUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUpStrikes(view, Strikes);
            }
        });

        ballsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUpBalls(view, Balls);
            }
        });

        strikesDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown(view, Strikes);
            }
        });

        ballsDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown(view, Balls);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear(view);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
    // button disablers
    public void disableButtons(){
        strikesUp.setEnabled(false);
        strikesDown.setEnabled(false);
        ballsUp.setEnabled(false);
        ballsDown.setEnabled(false);
    }

    public void enableButtons(){
        strikesUp.setEnabled(true);
        strikesDown.setEnabled(true);
        ballsUp.setEnabled(true);
        ballsDown.setEnabled(true);
    }

    // counter functions
    public void countUpStrikes(View view, TextView textView) {
        String valueString = textView.getText().toString();
        Integer valueInt = Integer.parseInt(valueString);
        valueInt++;
        if (valueInt==3){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("StrikeOut");
            builder.setMessage("Strike OUT");
            disableButtons();
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();
        }
        textView.setText(valueInt.toString());
    }

    public void countUpBalls(View view, TextView textView) {
        String valueString = textView.getText().toString();
        Integer valueInt = Integer.parseInt(valueString);
        valueInt++;
        if (valueInt==4){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("WALK");
            builder.setMessage("WALK");
            disableButtons();
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();
        }
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
        enableButtons();
    }

    public void openAboutActivity(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }


}
