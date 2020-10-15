package com.example.polyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class profileActivity extends AppCompatActivity {
    String userID;
    char idLetter;
    StringBuilder idNumberString = new StringBuilder();
    int idNumber;

    private Button mButton;
    private TextView mName, mLang, mBio;
    private ImageView mProfPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mName = findViewById(R.id.name);
        mLang = findViewById(R.id.natLang);
        mBio = findViewById(R.id.bio);
        mProfPic = findViewById(R.id.profPic);

        mButton = findViewById(R.id.messageButton);

        Intent intent = getIntent();
        userID = intent.getStringExtra("USERID");

        //Log.d("DOES USER ID PASS", userID);
        breakID();
        determinePlace_Set();
    }

    //*************
    //can I make class containing these and make them static methods to reference them over and over again? looks like ill use it 3 times I think...
    //*************
    private void breakID(){
        idLetter = userID.charAt(0); //may need to change this if more than one language has same first letter
        for(int i = 1; i < userID.length(); i++){
            idNumberString.append(userID.charAt(i));
        }
        idNumber = Integer.parseInt(idNumberString.toString());

        /*
        Log.d("USERIDTOTAL", userID);
        Log.d("USERIDLETTER", "" +idLetter);
        Log.d("USERIDTOTAL", "" + idNumber);
        */
    }
    private void determinePlace_Set(){
        switch (idLetter){
            case 'E':
                setViews(R.array.Users_English, idNumber);
                break;
            case 'S':
                setViews(R.array.Users_Spanish, idNumber);
                break;
            case 'F':
                setViews(R.array.Users_French, idNumber);
                break;
            case 'G':
                setViews(R.array.Users_German, idNumber);
                break;
        }
    }

    private void setViews(int arrayID, int profNum){
        String[] allUsers = getResources().getStringArray(arrayID);
        String[] user = allUsers[profNum-1].split("`");
        /*for(int i = 0; i < user.length; i++){  //works
            Log.d("USERPARTS", user[i]);
        }*/

        mName.setText(user[1]);
        mLang.setText(user[2]);
        mBio.setText(user[4]);
        mProfPic.setImageResource(getImageId( this, user[3]));
    }

    public static int getImageId(Context context, String profilePic) {
        return context.getResources().getIdentifier("drawable/" + profilePic, null, context.getPackageName());
    }


    public void startMessageActivity(View view){
        Intent intent = new Intent(this, messageActivity.class);
        intent.putExtra("USERID", userID);
        startActivity(intent);
    }



}