package com.example.admin.slidingviewanim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mSlidingView;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlidingView = (LinearLayout) findViewById(R.id.linear);
        text = (TextView)findViewById(R.id.textView);
    }

    // Start the animation
    private void startViewAnim(View view) {
        view.animate()
                .translationY(view.getHeight())
                .alpha(1.0f);
    }

    // Start the animation
    private void endViewAnim(View view) {
        view.animate()
                .translationY(0)
                .alpha(1.0f);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();

        switch (action) {
            case (MotionEvent.ACTION_UP):
                if (mSlidingView.getTranslationY() == mSlidingView.getHeight()) {
                    text.setText("Hey, I'm back!\n Pull down again to hide me");
                    endViewAnim(mSlidingView);
                    return true;
                }
            case (MotionEvent.ACTION_DOWN):
                if (mSlidingView.getTranslationY() == 0) {
                    startViewAnim(mSlidingView);
                    return true;
                }
            default:
                return super.dispatchTouchEvent(ev);
        }

    }

}
