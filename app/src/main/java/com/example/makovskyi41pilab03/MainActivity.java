package com.example.makovskyi41pilab03;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;



public class MainActivity extends AppCompatActivity {
    TextView textView;
    int seconds = 0;
    boolean isRunning = false;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textVw);


    }

    public void onClickStartTimer(View v) {
        isRunning = true;
        mHandler.postDelayed(timeUpdaterRunnable, 100);
//        this.runTimer();
    }


    public void onClickPauseTimer(View v) {
        isRunning = false;

    }

    public void onClickResetTimer(View v) {
        isRunning = false;
        seconds = 0;
    }
//    public void runTimer(){

        private Runnable timeUpdaterRunnable   = new Runnable() {
                    public void run() {
                        int hours = (int) TimeUnit.SECONDS.toHours(seconds);
                        int minutes = (int) ((int) TimeUnit.SECONDS.toMinutes(seconds) % TimeUnit.HOURS.toMinutes(1));
                        int second = (int) ((int)TimeUnit.SECONDS.toSeconds(seconds) % TimeUnit.MINUTES.toSeconds(1));
                        String s= String.format(Locale.getDefault(),
                                "%d:%02d:%02d",hours,minutes, second);
                        textView.setText(s);

                        if (isRunning) {
                            seconds += 1;
                        }
                        mHandler.postDelayed(this,1000);
                    }
                };

}


//}