package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThirdActivity extends AppCompatActivity {

    int noteid = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        EditText editTextBox = (EditText) findViewById(R.id.editTextBox);

        Intent intent = getIntent();
        noteid = intent.getIntExtra("noteid", -1);

        if (noteid != -1) {
            Note note = Welcome.notes.get(noteid);
            String noteContent = note.getContent();
            editTextBox.setText(noteContent);
        }

    }

    public void clickSave(View view) {
        EditText editTextBox = (EditText) findViewById(R.id.editTextBox);
        String note = editTextBox.getText().toString();
        DBHelper dbHelper = null;

        String username = getSharedPreferences("username", MODE_PRIVATE).toString();
        String title;
        String content = "";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        if (noteid == -1) {
            title = "NOTE_" + (Welcome.notes.size() + 1);
            dbHelper.saveNotes(username, title, content, date);
        } else {
            title = "NOTE_" + (noteid + 1);
            dbHelper.updateNote(title, date, content, username);
        }
    }
}