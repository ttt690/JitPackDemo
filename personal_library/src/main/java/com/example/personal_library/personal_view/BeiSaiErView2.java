package com.example.personal_library.personal_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wxl on 2018/1/10.
 */

public class BeiSaiErView2 extends View {
    private static Paint paint=new Paint();
    private int centery;
    private int centerx;
    private zuobiao top;
    private zuobiao bottom;
    private zuobiao left1;
    private zuobiao left2;
    private zuobiao right2;
    private zuobiao right1;
    static void drawline(Canvas canvas,Paint p,zuobiao zuobiao1,zuobiao zuobiao2){
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        canvas.drawLine(zuobiao1.x*20,zuobiao1.y*20,zuobiao2.x*20,zuobiao2.y*20,p);


    };
    //30dp做一个单位
    class zuobiao{
        float x;
        float y;

        public zuobiao(float x, float y) {
            this.x = x;
            this.y = y;
        }
        public  void drawpoint(Canvas canvas,Paint p) {

                canvas.drawPoint(x*20,y*20,p);

        }


    }


    public BeiSaiErView2(Context context) {
        super(context);
        initpaint();
    }

    private void initpaint() {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6f);
        paint.setAntiAlias(true);

    }

    public BeiSaiErView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initpaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerx=w/2;
        centery=h/2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
        canvas.drawColor(Color.YELLOW);
        canvas.translate(centerx,centery);
        paint.setColor(Color.RED);
        canvas.drawPoint(0,0,paint);
        paint.setColor(Color.BLACK);
         top=new zuobiao(3,7);top.drawpoint(canvas,paint);  //top
        bottom=new zuobiao(6,0);bottom.drawpoint(canvas,paint);    //bottom
        left1=new zuobiao(1.5f,2.5f);left1.drawpoint(canvas,paint);//left1
        left2=new zuobiao(2.8f,2.8f);left2.drawpoint(canvas,paint);//left2
        right1=new zuobiao(8f,5f);right1.drawpoint(canvas,paint);    //right1
        right2=new zuobiao(6.5f,4.5f);right2.drawpoint(canvas,paint); //right2
        //辅助线颜色
        drawline(canvas,paint,top,bottom);

//        drawline(canvas,paint,top,left2);
//        drawline(canvas,paint,left2,bottom);
//        drawline(canvas,paint,top,left1);
//        drawline(canvas,paint,left1,bottom);
//
//        drawline(canvas,paint,top,right1);
//        drawline(canvas,paint,right1,bottom);
//        drawline(canvas,paint,top,right2);
//        drawline(canvas,paint,right2,bottom);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);

        Path path=new Path();


        path.moveTo(top.x*20,top.y*20);
        path.quadTo( left2.x*20,left2.y*20,bottom.x*20,bottom.y*20);
        canvas.drawPath(path,paint);

        path.moveTo(top.x*20,top.y*20);
        path.quadTo( left1.x*20,left1.y*20,bottom.x*20,bottom.y*20);
        canvas.drawPath(path,paint);

        path.moveTo(top.x*20,top.y*20);
        path.quadTo( right1.x*20,right1.y*20,bottom.x*20,bottom.y*20);
        canvas.drawPath(path,paint);

        path.moveTo(top.x*20,top.y*20);
        path.quadTo( right2.x*20,right2.y*20,bottom.x*20,bottom.y*20);
        canvas.drawPath(path,paint);
    }


}
