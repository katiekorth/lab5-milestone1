package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(usernameKey, "").equals("")){
            String username = sharedPreferences.getString(usernameKey,"");
            setContentView(R.layout.activity_welcome);
            goToWelcome(username);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void clickLogin(View view) {
        EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        String username = editTextUsername.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("editTextUsername",username).apply();
        goToWelcome(username);
    }

    public void goToWelcome(String s) {
        Intent intent = new Intent(this, Welcome.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

}