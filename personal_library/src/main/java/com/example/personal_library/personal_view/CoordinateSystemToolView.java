package com.example.personal_library.personal_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wxl on 2018/1/11.
 * 坐标系工具
 */

public class CoordinateSystemToolView extends View {
    private int centerx;
    private int centery;

    public CoordinateSystemToolView(Context context) {
        super(context);
        initpaint();
    }
    private Paint paint;
    private void initpaint() {
        paint.setStrokeWidth(5f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
    }

    public CoordinateSystemToolView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);  initpaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerx=w;
        centery=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置左下角0点
        canvas.translate(0,centery);
        canvas.drawPoint(0,centery,paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(0,-centery,0,0,paint);
        canvas.drawLine(0,0,centerx,centery,paint);

    }
}
