package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonToAccount;
    private Button btnStartTimer;
    private SeekBar timeSeekBar;
    boolean isWork;

    private TextView inputTime;

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList <ReciclerViewItem> reciclerViewItems = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonToAccount = findViewById(R.id.button_to_account);
        buttonToAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Context context = MainActivity.this;
                Class destinationActivity = AccountActivity.class;
                Intent toAccountIntent = new Intent(context, destinationActivity);
                startActivity(toAccountIntent);

            }

        });
        timeSeekBar = findViewById(R.id.timeSeekBar);
        timeSeekBar.setProgress(0);
        inputTime = findViewById(R.id.textTime);
        btnStartTimer = findViewById(R.id.buttonStartTimer);
        timeSeekBar.setMax(99);
        isWork=false;
        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progres, boolean b) {

                int hour = progres/60;
                int minutes = progres-(hour*60);
                String zeroHours="";
                String zeroMinutes="";
                String zeroSeconds="00";
                    if( hour<10)
                    {
                     zeroHours="0"+hour;
                    }else{
                     zeroHours=""+hour;
                    }
                    if( minutes<10)
                    {
                    zeroMinutes="0"+minutes;
                    }else{
                    zeroMinutes=""+minutes;
                    }


                inputTime.setText(zeroHours+":"+zeroMinutes+":"+zeroSeconds);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        View.OnClickListener oclBtnStart = new View.OnClickListener() {
            CountDownTimer myTimer = null;
            @Override
            public void onClick(View view) {



                if (!isWork) {
                    btnStartTimer.setText("stop");
                    timeSeekBar.setEnabled(false);
                    isWork = true;
                    myTimer = new CountDownTimer(timeSeekBar.getProgress() * 60000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int hour = (int) millisUntilFinished / 1000 / 3600;
                            int minutes = (int) (millisUntilFinished / 1000 / 60) - (hour * 60);
                            int seconds = (int) ((millisUntilFinished / 1000) % 60) % 60;
                            String zeroHours = "";
                            String zeroMinutes = "";
                            String zeroSeconds = "";
                            if (hour < 10) {
                                zeroHours = "0" + hour;
                            } else {
                                zeroHours = "" + hour;
                            }
                            if (minutes < 10) {
                                zeroMinutes = "0" + minutes;
                            } else {
                                zeroMinutes = "" + minutes;
                            }
                            if (seconds == 0) {
                                zeroSeconds = "00";
                            } else if (seconds < 10) {
                                zeroSeconds = "0" + seconds;
                            } else {
                                zeroSeconds = "" + seconds;
                            }
                            ;

                            inputTime.setText(zeroHours + ":" + zeroMinutes + ":" + zeroSeconds);
                        }

                        @Override
                        public void onFinish() {
                            resetTimer();
                        }
                    };
                    myTimer.start();
                } else {
                    resetTimer();
                       }

            }
            private void resetTimer(){
                myTimer.cancel();
                inputTime.setText("00:00:00");
                timeSeekBar.setEnabled(true);
                timeSeekBar.setProgress(00);
                btnStartTimer.setText("start");
                isWork = false;
// Здесь надо реализовать создание записи в ArrayList <ReciclerViewItem> reciclerViewItems. Чтобы время таймера сохранялось. Я заебался.
            }
        };
        btnStartTimer.setOnClickListener(oclBtnStart);
    }
}