package com.example.coolform;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ShowEvent extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showevent);
        gestureObject = new GestureDetectorCompat(this,new LearnGesture());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);


    }
    public void showDetails(View view){
        startActivity(new Intent(this,EventDetails.class));
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(e1.getX()<e2.getX()){
                startActivity(new Intent(ShowEvent.this,MainActivity.class));
            }
            return true;
        }
    }
}
