package com.example.polyglot;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class messageActivity extends AppCompatActivity {
    String userID;
    char idLetter;
    StringBuilder idNumberString = new StringBuilder();
    int idNumber;
    private TextView mName;
    private ImageView mProfPic;
    private EditText mMessageToSend;
    ArrayList<TextView> messageViews =  new ArrayList<TextView>();
    ArrayList<TextView> messageViewsSent =  new ArrayList<TextView>();
    private String[] messageString;

    private ViewGroup mMessageLayout;


    //try to make spacing between the messages

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        Intent intent = getIntent();
        userID = intent.getStringExtra("USERID");
        //get message id for string then set messageString


        messageString = getResources().getString(R.string.E1Message).split("`");
        /*for(int i = 0; i< messageString.length; i++){
            Log.d("string" + i, messageString[i]);
        }*/
        mMessageToSend = findViewById(R.id.editTMessage);
        mName = findViewById(R.id.name);
        mProfPic = findViewById(R.id.profPic);

        mMessageLayout = findViewById(R.id.scrollableLinear);

        //TextView a  = new TextView(this);
        //a.setText("poo");
        //TextView b  = new TextView(this);
        //b.setText("whatsup");
        //mMessageLayout.addView(a);
        //mMessageLayout.addView(b); // this works*/


        breakID();
        determinePlace_Set();
        if(userID.equals("E1")) {
            displayMessages();
        }
    }

    public void startProfileActivity(View view){
        Intent intent = new Intent(this, profileActivity.class);
        intent.putExtra("USERID", userID);
        startActivity(intent);
    }

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
                set_Image_Name(R.array.Users_English, idNumber);
                break;
            case 'S':
                set_Image_Name(R.array.Users_Spanish, idNumber);
                break;
            case 'F':
                set_Image_Name(R.array.Users_French, idNumber);
                break;
            case 'G':
                set_Image_Name(R.array.Users_German, idNumber);
                break;
        }
    }

    private void set_Image_Name(int arrayID, int profNum){
        String[] allUsers = getResources().getStringArray(arrayID);
        String[] user = allUsers[profNum-1].split("`");

        mName.setText(user[1]);
        mProfPic.setImageResource(getImageId( this, user[3]));
    }

    public static int getImageId(Context context, String profilePic) {
        return context.getResources().getIdentifier("drawable/" + profilePic, null, context.getPackageName());
    }



    public  void displayMessages(){

        for(int i = 0; i < messageString.length; i++){
            messageViews.add(new TextView(this));
            textViewSettings(i);
            mMessageLayout.addView(messageViews.get(i));
        }
    }

    public void textViewSettings(int i){
        messageViews.get(i).setText(messageString[i]);
        messageViews.get(i).setTextSize(20);
        if(i%2 == 0){
            messageViews.get(i).setGravity(Gravity.RIGHT);
            messageViews.get(i).setTextColor(getResources().getColor(R.color.usermessage));
        }
        else{
            messageViews.get(i).setTextColor(getResources().getColor(R.color.partnermessage));
        }
    }

    private int index = 0;
    public void sendMessage(View view){
        messageViewsSent.add(new TextView(this));
        messageViewsSent.get(index).setText(mMessageToSend.getText().toString());
        mMessageToSend.getText().clear();
        messageViewsSent.get(index).setTextSize(20);
        messageViewsSent.get(index).setGravity(Gravity.RIGHT);
        messageViewsSent.get(index).setTextColor(getResources().getColor(R.color.usermessage));
        mMessageLayout.addView(messageViewsSent.get(index));
        index++;
    }
}