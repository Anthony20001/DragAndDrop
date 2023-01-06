package com.example.draganddrop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private static final String IMAGEVIEW_TAG = "icon bitmap";
    ImageView reservation;
    RelativeLayout rl_mesa_10;
    RelativeLayout rl_mesa_11;
    ImageView iv_mesa_10, iv_mesa_11;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reservation = findViewById(R.id.reserva);
        rl_mesa_10 = findViewById(R.id.rl_mesa_10);
        rl_mesa_11 = findViewById(R.id.rl_mesa_11);

        iv_mesa_10 = findViewById(R.id.iv_mesa_10);
        iv_mesa_11 = findViewById(R.id.iv_mesa_11);

        reservation.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
                ClipData dragData = new ClipData(
                        (CharSequence) view.getTag(),
                        new String[]{
                                ClipDescription.MIMETYPE_TEXT_PLAIN
                        },
                        item);

                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(reservation){
                    @Override
                    public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
                        super.onProvideShadowMetrics(outShadowSize, outShadowTouchPoint);
                        //outShadowTouchPoint.set(190,210);
                    }

                    @Override
                    public void onDrawShadow(Canvas canvas) {
                        super.onDrawShadow(canvas);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(dragData, myShadow, null, 0);
                }

                return true;
            }
        });




        // Set the drag event listener for the View.
        rl_mesa_10.setOnDragListener( (v, e) -> {

            // Handles each of the expected events.
            switch(e.getAction()) {

                case DragEvent.ACTION_DRAG_STARTED:

                    // Determines if this View can accept the dragged data.
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                        // As an example of what your application might do, applies a blue color tint
                        // to the View to indicate that it can accept data.


                        // Invalidate the view to force a redraw in the new tint.
                        v.invalidate();

                        // Returns true to indicate that the View can accept the dragged data.
                        return true;

                    }

                    // Returns false to indicate that, during the current drag and drop operation,
                    // this View will not receive events again until ACTION_DRAG_ENDED is sent.
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:

                    // Applies a green tint to the View.
                    iv_mesa_10.setImageResource(R.drawable.mesa10_move);

                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate();

                    // Returns true; the value is ignored.
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:

                    // Ignore the event.
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    // Resets the color tint to blue.
                     iv_mesa_10.setImageResource(R.drawable.mesa10);


                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate();

                    // Returns true; the value is ignored.
                    return true;

                case DragEvent.ACTION_DROP:

                    // Gets the item containing the dragged data.
                    ClipData.Item item = e.getClipData().getItemAt(0);

                    // Gets the text data from the item.
                    CharSequence dragData = item.getText();

                    // Displays a message containing the dragged data.
                    Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();

                    // Turns off any color tints.
                    //((ImageView)v).clearColorFilter();
                    iv_mesa_10.setImageResource(R.drawable.mesa10);

                    // Invalidates the view to force a redraw.
                    v.invalidate();

                    // Returns true. DragEvent.getResult() will return true.
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:

                    // Turns off any color tinting.
                    //((ImageView)v).clearColorFilter();

                    // Invalidates the view to force a redraw.
                    v.invalidate();

                    // Does a getResult(), and displays what happened.
                    if (e.getResult()) {
                        Toast.makeText(this, "The drop was handled.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_LONG).show();
                    }

                    // Returns true; the value is ignored.
                    return true;

                // An unknown action type was received.
                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }

            return false;

        });


        // Set the drag event listener for the View.
        rl_mesa_11.setOnDragListener( (v, e) -> {

            // Handles each of the expected events.
            switch(e.getAction()) {

                case DragEvent.ACTION_DRAG_STARTED:

                    // Determines if this View can accept the dragged data.
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                        // As an example of what your application might do, applies a blue color tint
                        // to the View to indicate that it can accept data.


                        // Invalidate the view to force a redraw in the new tint.
                        v.invalidate();

                        // Returns true to indicate that the View can accept the dragged data.
                        return true;

                    }

                    // Returns false to indicate that, during the current drag and drop operation,
                    // this View will not receive events again until ACTION_DRAG_ENDED is sent.
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:

                    // Applies a green tint to the View.
                    iv_mesa_11.setImageResource(R.drawable.mesa10_move);

                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate();

                    // Returns true; the value is ignored.
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:

                    // Ignore the event.
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    // Resets the color tint to blue.
                    iv_mesa_11.setImageResource(R.drawable.mesa10);


                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate();

                    // Returns true; the value is ignored.
                    return true;

                case DragEvent.ACTION_DROP:

                    // Gets the item containing the dragged data.
                    ClipData.Item item = e.getClipData().getItemAt(0);

                    // Gets the text data from the item.
                    CharSequence dragData = item.getText();

                    // Displays a message containing the dragged data.
                    Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();

                    // Turns off any color tints.
                    //((ImageView)v).clearColorFilter();
                    iv_mesa_11.setImageResource(R.drawable.mesa10);

                    // Invalidates the view to force a redraw.
                    v.invalidate();

                    // Returns true. DragEvent.getResult() will return true.
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:

                    // Turns off any color tinting.
                    //((ImageView)v).clearColorFilter();

                    // Invalidates the view to force a redraw.
                    v.invalidate();

                    // Does a getResult(), and displays what happened.
                    if (e.getResult()) {
                        Toast.makeText(this, "The drop was handled.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_LONG).show();
                    }

                    // Returns true; the value is ignored.
                    return true;

                // An unknown action type was received.
                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }

            return false;

        });

    }
}