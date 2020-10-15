package com.example.polyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mUserButton,  mMessagesButton, mSearchButton, mGamesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchButton = findViewById(R.id.searchButton);
    }

    public void startSearchActivity(View view){
        Intent intent = new Intent(this, searchActivity.class);
        startActivity(intent);
    }
    public void startMessageListActivity(View view){
        Intent intent = new Intent(this, messageListActivity.class);
        startActivity(intent);
    }
    public void startUserProfileActivity(View view){
        Intent intent = new Intent(this, userProfileActivity.class);
        startActivity(intent);
    }
}