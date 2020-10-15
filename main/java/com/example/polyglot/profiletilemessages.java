package com.example.polyglot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class profiletilemessages extends ConstraintLayout {
    private ConstraintLayout mLayout;
    private String userID = "E1"; //will make this changeable in future. steve and profpic are put in layout for now. need to make this like the searchactivity
    private TextView lastMessage;
    public profiletilemessages(@NonNull Context context) {
        super(context);
        init();
    }

    public profiletilemessages(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public profiletilemessages(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public profiletilemessages(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        inflate(getContext(),R.layout.profiletilemessages,this);

        mLayout = findViewById(R.id.background);

        String[] messageContainer = getResources().getString(R.string.E1Message).split("`");
        lastMessage = findViewById(R.id.lastmessage);
        lastMessage.setText(messageContainer[(messageContainer.length)-1]);
    }

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
                ((messageListActivity) getContext()).startMessageActivity(userID);
                break;
        }
        return true;
    }
}
