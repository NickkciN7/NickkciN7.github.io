package com.example.polyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class messageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
    }

    public void startMessageActivity(String userID){
        Intent intent = new Intent(this, messageActivity.class);
        intent.putExtra("USERID", userID);
        startActivity(intent);
    }
}