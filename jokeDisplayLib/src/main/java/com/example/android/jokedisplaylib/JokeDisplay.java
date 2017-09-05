package com.example.android.jokedisplaylib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class JokeDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Toast.makeText(this, getIntent().getStringExtra(getString(R.string.joke)), Toast.LENGTH_SHORT).show();
    }
}
