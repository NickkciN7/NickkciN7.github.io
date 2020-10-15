package com.example.polyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.GONE;

public class userProfileActivity extends AppCompatActivity {

    private EditText mBioEdit;
    private TextView mBioText;
    private Button mEditFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mBioEdit = findViewById(R.id.bioEdit);
        mBioText = findViewById(R.id.bio);
        mEditFinish = findViewById(R.id.editButton);
    }


    public void editInfo(View view){
        if(mEditFinish.getText().equals("Edit Bio")) {
            mEditFinish.setText("Finish");
            mBioText.setVisibility(GONE);
            mBioEdit.setVisibility(View.VISIBLE);
            return;
        }
        if(mEditFinish.getText().equals("Finish")) {
            mEditFinish.setText("Edit Bio");
            mBioText.setText(mBioEdit.getText());
            mBioText.setVisibility(View.VISIBLE);
            mBioEdit.setVisibility(View.GONE);
            return;
        }

    }
}