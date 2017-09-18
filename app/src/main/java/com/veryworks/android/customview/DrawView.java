package com.veryworks.android.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by pc on 9/18/2017.
 */

public class DrawView extends View {
    Paint paint;
    Path currentPath;

    // 소스코드에서 사용하기 때문에 생성자 파라미터는 context만 필요
    public DrawView(Context context) {
        super(context);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(5f);

        currentPath = new Path();
    }

    // 화면을 그려주는 onDraw 오버라이드
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1. 화면에 터치가 되면...
        // 2. 연속해서 그림을 그려준다
        // 2.1. 터치된 좌표에 작은 동그라미를 그려준다.
        canvas.drawPath(currentPath, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 이전점과 현재점 사이를 그리지 않는다
                currentPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                // 이전점과 현재점 사이를 그린다.
                currentPath.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                // nothing to do
                break;
        }


        // onDraw 를 호출하는 메서드를 호출
        invalidate(); // <- 다른 언어에서는 대부분 그림을 그려주는 함수를 호출하는 메서드는
                      //    기존 그림을 유지하는데, 안드로드는 지운다.
        // 리턴이 false 일 경우는 touch 이벤트를 연속해서 발생시키지 않는다
        // 즉, 드래그를 하면 onTouchEvent가 재 호출되지 않는다.
        return true;
    }
}
