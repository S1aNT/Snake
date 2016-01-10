package com.zanyxdev.snake.framework;

import android.content.Context;


public class ScreenSize {
    private Context mcontext;

    private int screenWidth;
    private int screenHeight;


    public ScreenSize(Context context) {
        mcontext = context;
        screenHeight = mcontext.getResources().getDisplayMetrics().heightPixels;
        screenWidth = mcontext.getResources().getDisplayMetrics().widthPixels;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }


}
