package com.example.personal_library.personal_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wxl on 2018/1/10.
 */

public class BeiSaiErView extends View {
    Paint paint=new Paint();
    private int centerX, centerY;

    private PointF start, end, control;
    private float nowx;
    private float nowy;
    private PointF control2;
    private int action;
    private float mPosX;
    private float mPosY;
    private float mCurPosX;
    private float mCurPosY;

    private boolean movechenge=true;

    public BeiSaiErView(Context context) {
        super(context);
        initpaint();
    }

    private void initpaint() {
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control  = new PointF(0, 0);

        control2  = new PointF(0, 0);
    }

    public BeiSaiErView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initpaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w/2;
        centerY = h/2;

        // 初始化数据点和控制点的位置
        start.x = centerX-200;
        start.y = centerY;
        end.x = centerX+200;
        end.y = centerY;
        control.x = centerX;
        control.y = centerY-100;
        control2.x=centerX+50;
        control.y = centerY+100;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        //        control.x = event.getX();
//        control.y = event.getY();
        if(movechenge){
            control.x= event.getX();
            control.y= event.getY();
            invalidate();
        }else{
            control2.x= event.getX();
            control2.y= event.getY();
            invalidate();
            movechenge=true;
        }

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mPosX = event.getX();
                mPosY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mCurPosX = event.getX();
                mCurPosY = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                movechenge=false;

                break;
        }
        return true;

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.scale(1,-1);
//        canvas.drawColor(Color.YELLOW);
        paint.setColor(Color.BLACK);
        canvas.drawPoint(start.x,start.y,paint);
        canvas.drawPoint(end.x,end.y,paint);
        canvas.drawPoint(control.x,control.y,paint);
        canvas.drawPoint(control2.x,control2.y,paint);
        //绘制辅助xian
        canvas.drawLine(start.x,start.y,control.x,control.y,paint);

        canvas.drawLine(control.x,control.y,control2.x,control2.y,paint);

        canvas.drawLine(control2.x,control2.y,end.x,end.y,paint);

        paint.setColor(Color.RED);
        Path path=new Path();
        path.moveTo(start.x,start.y);
        path.cubicTo(control.x,control.y,control2.x,control2.y,end.x,end.y);
        canvas.drawPath(path,paint);



    }

}
