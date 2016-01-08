package com.zanyxdev.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class FastRenderView extends SurfaceView implements Runnable {

    Thread renderThread = null;
    SurfaceHolder holder;
    volatile boolean running = false;

    public FastRenderView(Context context) {
        super(context);
        holder = getHolder();
    }

    /**
     * Starts executing the active part of the class' code. This method is
     * called when a thread is started that has been created with a class which
     * implements {@code Runnable}.
     */
    @Override
    public void run() {
        while (running) {
            if (!holder.getSurface().isValid())
                continue;

            Canvas canvas = holder.lockCanvas();
            canvas.drawRGB(255, 0, 0);
            holder.unlockCanvasAndPost(canvas);
        }

    }

    public void resume() {
        // Create and run new thread
        running = true;
        renderThread = new Thread(this);
        renderThread.start();
    }

    public void pause() {
        running = false;
        while (true) {
            try {
                renderThread.join(); //ожидание полного уничтожения потока, осуществляемое вызовом метода Thread.join() .
            } catch (InterruptedException e) {
            }
        }
    }
}
