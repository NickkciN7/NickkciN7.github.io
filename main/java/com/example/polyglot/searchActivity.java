package com.example.polyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class searchActivity extends AppCompatActivity {

    private Spinner spinner;
    private ViewGroup mLinearLayout;
    TextView tv;
    profileTile pt;

    ArrayList<profileTile> newTiles =  new ArrayList<profileTile>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        mLinearLayout = (ViewGroup) findViewById(R.id.scrollableLinear);
        pt = new profileTile(this);

        //mLinearLayout.addView(pt);

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.language_array, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String)adapterView.getItemAtPosition(i);
                generateTiles(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    public void generateTiles(String lang){
        int numPeople= 0;


        List<String[]> UsersInfo = new ArrayList<String[]>();
        switch (lang){
            case "English":
                UsersInfo.clear();
                fillUserInfo(UsersInfo, R.array.Users_English);
                break;
            case "Spanish":
                UsersInfo.clear();
                fillUserInfo(UsersInfo, R.array.Users_Spanish);
                break;
            case "French":
                UsersInfo.clear();
                fillUserInfo(UsersInfo, R.array.Users_French);
                break;
            case "German":
                UsersInfo.clear();
                fillUserInfo(UsersInfo, R.array.Users_German);
                break;
        }

        newTiles.clear(); //clear arraylist
        mLinearLayout.removeAllViews(); //to get rid of tiles from other language results

        for(int i = 0; i < UsersInfo.size(); i++){
            newTiles.add(new profileTile(this, UsersInfo.get(i)[0], UsersInfo.get(i)[1], UsersInfo.get(i)[2], UsersInfo.get(i)[3], UsersInfo.get(i)[4]));
            //newTiles.add(new profileTile(this, "a", "b", "c", "d" ,"e")); //this works
            //newTiles.add(new profileTile(this)); //this works
            mLinearLayout.addView(newTiles.get(i));
        }

        /*for(int i = 0; i < UsersInfo.size(); i++){
            for(int j = 0; j < UsersInfo.get(i).length; j++){
                Log.d("user" + i, " " + UsersInfo.get(i)[j]);
            }
        }*/
    }

    public void fillUserInfo(List<String[]> theInfo, int langID){
        String[] unbroken = getResources().getStringArray(langID);
        for(int i = 0; i < unbroken.length; i++){
            theInfo.add(unbroken[i].split("`"));
        }
    }




    public void startProfileActivity(String userID){
        Intent intent = new Intent(this, profileActivity.class);
        intent.putExtra("USERID", userID);
        startActivity(intent);
    }

}