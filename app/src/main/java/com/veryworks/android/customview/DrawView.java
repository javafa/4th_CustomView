package com.veryworks.android.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 9/18/2017.
 */

public class DrawView extends View {
    Paint paint;
    Path currentPath;

    List<PathTool> paths = new ArrayList<>();

    // 소스코드에서 사용하기 때문에 생성자 파라미터는 context만 필요
    public DrawView(Context context) {
        super(context);
        paint = new Paint();
        init();
    }

    public void init(){
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        setColor(Color.BLACK);
    }

    public void setColor(int color){
        PathTool tool = new PathTool();
        tool.setColor(color);
        currentPath = tool;
        paths.add(tool);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    // 화면을 그려주는 onDraw 오버라이드
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(PathTool tool:paths) {
            paint.setColor(tool.getColor());
            canvas.drawPath(tool, paint);
        }
    }
}

class PathTool extends Path {
    private int color;
    public void setColor(int color){
        this.color = color;
    }
    public int getColor(){
        return this.color;
    }
}