package com.qunar.asp.demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DemoActivity","onDestroy run");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DemoActivity","onStop run");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("DemoActivity","onRestart run");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DemoActivity","onPause run");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DemoActivity","onResume run");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DemoActivity","onStart run");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.i("DemoActivity","onCreate run");

    }


}
