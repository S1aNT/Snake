package com.zanyxdev.snake;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.zanyxdev.snake.framework.IOnSwipeGestureEventListener;
import com.zanyxdev.snake.framework.SwipeDirection;
import com.zanyxdev.snake.framework.onGestureListener;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainFullscreenActivity extends Activity {
    private GestureDetector gestureDetector;
    private Context mcontext;

    private onGestureListener listener;
//    private ScreenSize screenSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fullscreen);
        mcontext = this;
        //      screenSize = new ScreenSize(mcontext);

        // Detect touched area
        listener = new onGestureListener();
        listener.setSwipeGestureEventListener(new IOnSwipeGestureEventListener() {
            @Override
            public void onEvent(SwipeDirection direction) {
                String str = "";

                switch (direction) {

                    case RIGHT:
                        str = "Swipe Right";
                        break;
                    case LEFT:
                        str = "Swipe Left";
                        break;
                    case DOWN:
                        str = "Swipe Down";
                        break;
                    case UP:
                        str = "Swipe Up";
                        break;
                }
                Toast.makeText(mcontext, str, Toast.LENGTH_SHORT).show();

            }
        });
        gestureDetector = new GestureDetector(this, listener);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }


}
