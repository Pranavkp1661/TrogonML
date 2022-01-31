package com.pranav.trogonml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {
    private static final Integer HANDLER_TIME = 1500;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            finish();
            startActivity(new Intent(context, HomePageActivity.class));
        }, HANDLER_TIME);

    }
}