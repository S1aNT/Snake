package com.zanyxdev.snake.framework;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class onGestureListener extends GestureDetector.SimpleOnGestureListener {

    private static String TAG = onGestureListener.class.getSimpleName();
    private IOnSwipeGestureEventListener swipeGestureEventListener; //listener field


    private int swipe_Min_Distance = 100;
    private int swipe_Max_Distance = 350;
    private int swipe_Min_Velocity = 100;

    //setting the listener
    public void setSwipeGestureEventListener(IOnSwipeGestureEventListener eventListener) {
        this.swipeGestureEventListener = eventListener;
    }


    public void setSwipeMaxDistance(int distance) {
        this.swipe_Max_Distance = distance;
    }

    public void setSwipeMinDistance(int distance) {
        this.swipe_Min_Distance = distance;
    }

    public void setSwipeMinVelocity(int distance) {
        this.swipe_Min_Velocity = distance;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TAG, "e1:" + e1.toString() + " e2:" + e2.toString());
        boolean result = false;
        Double angle = Math.toDegrees(Math.atan2(e1.getY() - e2.getY(), e2.getX() - e1.getX()));

        if (this.swipeGestureEventListener != null) {
            if (angle > 45 && angle <= 135) {
                this.swipeGestureEventListener.onEvent(SwipeDirection.UP);
                result = true;
            }
            if (angle >= 135 && angle < 180 || angle < -135 && angle > -180) {
                this.swipeGestureEventListener.onEvent(SwipeDirection.LEFT);
                result = true;
            }
            if (angle < -45 && angle >= -135) {
                this.swipeGestureEventListener.onEvent(SwipeDirection.DOWN);
                result = true;
            }
            if (angle > -45 && angle <= 45) {
                this.swipeGestureEventListener.onEvent(SwipeDirection.RIGHT);
                result = true;
            }
        }

        return result;
    }

}
