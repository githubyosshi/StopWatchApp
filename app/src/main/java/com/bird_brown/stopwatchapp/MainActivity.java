package com.bird_brown.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button stopButton;
    private Button resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        resetButton = (Button) findViewById(R.id.resetButton);

//        startButton.setEnabled(true);
//        stopButton.setEnabled(false);
//        resetButton.setEnabled(false);
        setButtonState(true, false,false)

    }
    public void setButtonState(boolean start, boolean stop, boolean reset) {
        startButton.setEnabled(start);
        stopButton.setEnabled(stop);
        resetButton.setEnabled(reset);
    }
}
