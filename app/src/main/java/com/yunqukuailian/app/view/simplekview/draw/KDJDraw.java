package com.yunqukuailian.app.view.simplekview.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.yunqukuailian.app.view.simplekview.BaseKChartView;
import com.yunqukuailian.app.view.simplekview.EntityImpl.KDJImpl;
import com.yunqukuailian.app.view.simplekview.base.IChartDraw;
import com.yunqukuailian.app.view.simplekview.base.IValueFormatter;
import com.yunqukuailian.app.view.simplekview.formatter.ValueFormatter;


/**
 * KDJ实现类
 * Created by tifezh on 2016/6/19.
 */

public class KDJDraw implements IChartDraw<KDJImpl> {

    private Paint mKPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mDPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mJPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public KDJDraw(BaseKChartView view) {
    }

    @Override
    public void drawTranslated(@Nullable KDJImpl lastPoint, @NonNull KDJImpl curPoint, float lastX, float curX, @NonNull Canvas canvas, @NonNull BaseKChartView view, int position) {
        view.drawChildLine(canvas, mKPaint, lastX, lastPoint.getK(), curX, curPoint.getK());
        view.drawChildLine(canvas, mDPaint, lastX, lastPoint.getD(), curX, curPoint.getD());
        view.drawChildLine(canvas, mJPaint, lastX, lastPoint.getJ(), curX, curPoint.getJ());
    }

    @Override
    public void drawText(@NonNull Canvas canvas, @NonNull BaseKChartView view, int position, float x, float y) {
        String text = "";
        KDJImpl point = (KDJImpl) view.getItem(position);
        text = "K:" + view.formatValue(point.getK()) + " ";
        canvas.drawText(text, x, y, mKPaint);
        x += mKPaint.measureText(text);
        text = "D:" + view.formatValue(point.getD()) + " ";
        canvas.drawText(text, x, y, mDPaint);
        x += mDPaint.measureText(text);
        text = "J:" + view.formatValue(point.getJ()) + " ";
        canvas.drawText(text, x, y, mJPaint);
    }

    @Override
    public float getMaxValue(KDJImpl point) {
        return Math.max(point.getK(), Math.max(point.getD(), point.getJ()));
    }

    @Override
    public float getMinValue(KDJImpl point) {
        return Math.min(point.getK(), Math.min(point.getD(), point.getJ()));
    }

    @Override
    public IValueFormatter getValueFormatter() {
        return new ValueFormatter();
    }

    /**
     * 设置K颜色
     */
    public void setKColor(int color) {
        mKPaint.setColor(color);
    }

    /**
     * 设置D颜色
     */
    public void setDColor(int color) {
        mDPaint.setColor(color);
    }

    /**
     * 设置J颜色
     */
    public void setJColor(int color) {
        mJPaint.setColor(color);
    }

    /**
     * 设置曲线宽度
     */
    public void setLineWidth(float width)
    {
        mKPaint.setStrokeWidth(width);
        mDPaint.setStrokeWidth(width);
        mJPaint.setStrokeWidth(width);
    }

    /**
     * 设置文字大小
     */
    public void setTextSize(float textSize)
    {
        mKPaint.setTextSize(textSize);
        mDPaint.setTextSize(textSize);
        mJPaint.setTextSize(textSize);
    }
}