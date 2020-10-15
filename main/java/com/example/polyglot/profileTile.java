package com.example.polyglot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

public class profileTile extends ConstraintLayout {
    //private String IMAGEID = "IMAGEID";
    //int tile = -100;
    private String userID;

    private TextView mBio, mNatLang, mName;
    private ImageView mProfPic;
    private ConstraintLayout mLayout;


    public profileTile(@NonNull Context context) {
        super(context);
        init();
    }

    public profileTile(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public profileTile(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public profileTile(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    public profileTile(@NonNull Context context,String userId, String name, String lang, String picture, String bio) {
        super(context);
        init(userId, name, lang, picture, bio);
    }


    private void init(){
        inflate(getContext(),R.layout.profiletile,this);
        mBio = (TextView)findViewById(R.id.bio);
        mNatLang = (TextView)findViewById(R.id.natLang);
        mProfPic = (ImageView)findViewById(R.id.profPic);
    }

    private void init(String id, String n, String lang, String picture, String bio){
        inflate(getContext(),R.layout.profiletile,this);
        userID = id;

        mLayout = findViewById(R.id.background);

        mName = (TextView)findViewById(R.id.name);
        mName.setText(n);

        mNatLang = (TextView)findViewById(R.id.natLang);
        mNatLang.setText(lang);

        mBio = (TextView)findViewById(R.id.bio);
        mBio.setText(bio);

        mProfPic = (ImageView)findViewById(R.id.profPic);
        mProfPic.setImageResource(getImageId( getContext(), picture));
    }

    public static int getImageId(Context context, String profilePic) {
        return context.getResources().getIdentifier("drawable/" + profilePic, null, context.getPackageName());
    }



    //accessors/modifiers
    public void setImage(){
        //mProfPic.setImageResource(R.drawable.german1);
        //String test = Integer.toString(R.drawable.german1);
        //Log.d(IMAGEID, test);
    }
    public void setName(int prevTile){
        //mBio.setText("Tile:" + Integer.toString(tile) + "    previous" + prevTile);

    }
    public void setBio(int prevTile){
        //mBio.setText("Tile:" + Integer.toString(tile) + "    previous" + prevTile);

    }
    public void setLang(int prevTile){
        //mBio.setText("Tile:" + Integer.toString(tile) + "    previous" + prevTile);
    }

    public void setUserId(){

    }
    public String getUserId(){
        return userID;
    }





    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLayout.setBackgroundColor(getResources().getColor(R.color.lightgray));
                break;
            case MotionEvent.ACTION_CANCEL:
                mLayout.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case MotionEvent.ACTION_UP:
                mLayout.setBackgroundColor(getResources().getColor(R.color.white));
                ((searchActivity) getContext()).startProfileActivity(userID);
                break;
        }
        return true;
    }
}