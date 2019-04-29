package com.kirylshreyter.diamondapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kirylshreyter.diamondapp.R;
import com.kirylshreyter.diamondapp.common.Tags;
import com.kirylshreyter.diamondapp.factories.Urls;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button printUrlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tags.ON_CREATE.name(), "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        printUrlButton = findViewById(R.id.print_url_button);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        printUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(Urls.Base.getServerUrl());
            }
        });
    }
}
