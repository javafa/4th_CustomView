package com.veryworks.android.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class DrawActivity extends AppCompatActivity {

    FrameLayout stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        stage = (FrameLayout) findViewById(R.id.stage);
        DrawView draw = new DrawView(this);

        stage.addView(draw);
    }
}
