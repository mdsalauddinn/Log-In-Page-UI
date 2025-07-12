package com.example.simpleLoginPageUi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        TextView txtGreet = findViewById(R.id.txtGreet);

        Intent fromMainActivity = getIntent();

        String username = fromMainActivity.getStringExtra("username");

        String finalUsername = getString(R.string.greet) + ", " + username;

        txtGreet.setText(finalUsername);
    }
}