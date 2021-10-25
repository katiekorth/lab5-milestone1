package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickLogin(View view) {
        EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        String username = editTextUsername.getText().toString();
        goToWelcome(username);
    }

    public void goToWelcome(String s) {
        Intent intent = new Intent(this, Welcome.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}