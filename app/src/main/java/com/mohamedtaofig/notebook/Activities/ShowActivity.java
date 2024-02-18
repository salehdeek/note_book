package com.mohamedtaofig.notebook.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mohamedtaofig.notebook.R;

public class ShowActivity extends AppCompatActivity {

    TextView textView,dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textView = findViewById(R.id.textText);
        dateTextView = findViewById(R.id.dateText);
        String text = getIntent().getStringExtra("text");
        String date = getIntent().getStringExtra("date");
        textView.setText(text);
        dateTextView.setText(date);
    }
}