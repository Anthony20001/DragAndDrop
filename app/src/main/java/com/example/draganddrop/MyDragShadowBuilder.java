package com.example.draganddrop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyDragShadowBuilder extends View.DragShadowBuilder{

    // The drag shadow image, defined as a drawable object.
    private static Drawable shadow;

    // Constructor
    public MyDragShadowBuilder(View v) {
        super(v);
        shadow = new ColorDrawable(Color.LTGRAY);
    }

    public void onProvideShadowMetrics (Point size, Point touch) {

        int width, height;

        width = getView().getWidth() / 2;
        height = getView().getHeight() / 2;

        shadow.setBounds(0, 0, width, height);
        size.set(width, height);
        touch.set(width / 2, height / 2);
    }

    public void onDrawShadow(Canvas canvas) {

        // Draw the ColorDrawable on the Canvas passed in from the system.
        shadow.draw(canvas);
    }
}


