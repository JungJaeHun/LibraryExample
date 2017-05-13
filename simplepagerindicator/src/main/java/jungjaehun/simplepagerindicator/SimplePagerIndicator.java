package jungjaehun.simplepagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by jaehoonjung on 2017. 5. 13..
 */

public class SimplePagerIndicator extends RecyclerView {

    public SimplePagerIndicator(Context context) {
        super(context);
    }

    public SimplePagerIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        defaultColor = context.obtainStyledAttributes(attrs, R.styleable.SimpleIndicator)
                .getColor(R.styleable.SimpleIndicator_defaultColor, defaultColor);

        focusColor = context.obtainStyledAttributes(attrs, R.styleable.SimpleIndicator)
                .getColor(R.styleable.SimpleIndicator_focusColor, focusColor);

        animDuration = context.obtainStyledAttributes(attrs, R.styleable.SimpleIndicator)
                .getInt(R.styleable.SimpleIndicator_changeDuration, animDuration);

        colorFill = context.obtainStyledAttributes(attrs, R.styleable.SimpleIndicator)
                .getBoolean(R.styleable.SimpleIndicator_colorFill, colorFill);

        indicatorSize = context.obtainStyledAttributes(attrs, R.styleable.SimpleIndicator)
                .getDimensionPixelSize(R.styleable.SimpleIndicator_indicatorSize, indicatorSize);

        indicatorMargin = context.obtainStyledAttributes(attrs, R.styleable.SimpleIndicator)
                .getDimensionPixelSize(R.styleable.SimpleIndicator_indicatorMargin, indicatorMargin);

    }

    private int indicatorSize = (int) (6 * Resources.getSystem().getDisplayMetrics().density);
    private int indicatorMargin = (int) (6 * Resources.getSystem().getDisplayMetrics().density);
    private int defaultColor = Color.parseColor("#999999");
    private int focusColor = Color.parseColor("#000000");
    private int animDuration = 500;
    private boolean colorFill = false;

    private AdapterIndicator adapterIndicator = new AdapterIndicator(this);

    public void remoteViewPager(Context context, ViewPager viewPager, int orientation){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, orientation, false);

        SpaceItemDecorator spaceItemDecorator = new SpaceItemDecorator(indicatorMargin, orientation);

        addItemDecoration(spaceItemDecorator);

        setLayoutManager(linearLayoutManager);

        adapterIndicator.remoteViewPager(viewPager);

        setAdapter(adapterIndicator);
    }

    public void setColorFill(boolean colorFill) {
        this.colorFill = colorFill;
        adapterIndicator.notifyDataSetChanged();

    }

    public int getIndicatorSize() {
        return indicatorSize;
    }

    public int getDefaultColor() {
        return defaultColor;
    }

    public int getFocusColor() {
        return focusColor;
    }

    public int getAnimDuration() {
        return animDuration;
    }

    public boolean isColorFill() {
        return colorFill;
    }

}
