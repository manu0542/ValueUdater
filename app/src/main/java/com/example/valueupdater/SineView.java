package com.example.valueupdater;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class SineView  extends View {
    String val;float h;
    Paint mPaint,darkpaint;
    public SineView(Context context, String value) {
        super(context);
        mPaint = new Paint();
        this.val=value;

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.rgb(66,176,245));
        mPaint.setStrokeWidth(5);
        darkpaint = new Paint();
        darkpaint.setAntiAlias(true);
        darkpaint.setStyle(Paint.Style.STROKE);
        darkpaint.setColor(Color.rgb(58,62,64));
        darkpaint.setStrokeWidth(15);
    }

    public SineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float a, w,x,y;
        w=4200;
        try{h=Float.parseFloat(val);}catch (Exception e){h=134;}
        x=0;
        while(x<10000)
        {

            a=(x/w)*((float)2.0*(float)3.131592654);
            y=(h/2)-((float)Math.sin(a)*(h/(float)2.1));
            canvas.drawLine(x-10,y-10,(int)x-400,y-400,mPaint);
            if(x>=480&&x<=510){}
            if(x<=480){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=530&&x<560){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=560&&x<590){

            }
            if(x>=590&&x<620){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=620&&x<650){

            }
            if(x>=650&&x<680){
                canvas.drawPoint(x,y,darkpaint);
            }

            if(x>=680&&x<710){

            }
            if(x>=710&&x<730){
                canvas.drawPoint(x,y,darkpaint);            }
            if(x>=730&&x<770){

            }
            if(x>=770&&x<800){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=800&&x<830){

            }
            if(x>=830&&x<860){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=860&&x<890){

            }
            if(x>=890&&x<910){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=910&&x<940){

            }
            if(x>=940&&x<970){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=970&&x<1000){

            }
            if(x>=1000&&x<1030){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=1030&&x<1060){

            }
            if(x>=1060&&x<1090){
                canvas.drawPoint(x,y,darkpaint);
            }
            if(x>=1090&&x<1120){

            }



            x++;

        }

             x=500;
             a=(x/w)*((float)2.0*(float)3.131592654);
             y=(h/2)-((float)Math.sin(a)*(h/(float)2.1));
             canvas.drawCircle(x,y,17,darkpaint);

    }
}
