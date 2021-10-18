package com.example.myevent;
import android.gesture.Gesture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action= motionEvent.getAction();
                float curX= motionEvent.getX();
                float curY= motionEvent.getY();

                if (action==MotionEvent.ACTION_DOWN){
                    println("손가락 눌렸음: "+curX+","+curY);
                } else if (action==MotionEvent.ACTION_UP){
                    println("손가락 뗐음: "+curX+","+curY);
                }else if (action==MotionEvent.ACTION_MOVE) {
                    println("손가락 움직였음: "+curX+","+curY);
                }
                return true;

            }
        });

        /**new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }
        }); **/

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,"시스템BACK 버튼 눌림.", Toast.LENGTH_LONG).show();

            return true;
        }

        return false;
    }

    public void println(String data) {
        textView.append(data + "\n");
    }




}