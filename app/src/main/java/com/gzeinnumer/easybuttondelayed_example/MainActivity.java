package com.gzeinnumer.easybuttondelayed_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gzeinnumer.ebd.DelayButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        example1();
        example2();
    }

    private void example1() {
        Button button = findViewById(R.id.btn_example1);

        button.setOnClickListener(new DelayButton(button, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void example2() {
        Button button = findViewById(R.id.btn_example2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
                button.setEnabled(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setEnabled(true);
                    }
                }, 2000);
            }
        });
    }
}