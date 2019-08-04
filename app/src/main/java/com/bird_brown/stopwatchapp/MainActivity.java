package com.bird_brown.stopwatchapp;

//import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    private long startTime;

    private Handler handler = new Handler();
    private Runnable updateTimer;

    private Button startButton;
    private Button stopButton;
    private Button resetButton;
    private TextView timerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        timerLabel = (TextView) findViewById(R.id.timerLabel);

//        startButton.setEnabled(true);
//        stopButton.setEnabled(false);
//        resetButton.setEnabled(false);
        setButtonState(true, false,false);

    }
    public void setButtonState(boolean start, boolean stop, boolean reset) {
        startButton.setEnabled(start);
        stopButton.setEnabled(stop);
        resetButton.setEnabled(reset);
    }

    public void startTimer(View view) {
        // startTimeの取得
        startTime = SystemClock.elapsedRealtime(); // 起動してからの経過時間（ミリ秒）
        // 一定時間ごとに現在の経過時間を表示
        // Handler -> Runnable(処理) -> UI
        updateTimer = new Runnable() {
            @Override
            public void run() {
                long t = SystemClock.elapsedRealtime() - startTime; // ミリ秒
                SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS", Locale.US);
                timerLabel.setText(sdf.format(t));
            }
        };

        // ボタンの操作
        setButtonState(false,true,false);

    }
}
