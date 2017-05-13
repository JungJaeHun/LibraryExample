package jungjaehun.simplepagerindicator;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by jaehoonjung on 2017. 5. 13..
 */

public class SimpleIndicatorView extends ImageView {

    public SimpleIndicatorView(Context context) {
        super(context);
    }

    public SimpleIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int defaultColor = Color.parseColor("#999999");
    private int focusColor = Color.parseColor("#000000");
    private int currentColor = defaultColor;
    private int animDuration = 500;

    public void changeColorByFocus(boolean focus){
        ValueAnimator colorAnimator;
        colorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), currentColor, focus ? focusColor : defaultColor);
        colorAnimator.setDuration(animDuration);
        colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentColor = (int) valueAnimator.getAnimatedValue();
                setColorFilter(currentColor);
            }
        });
        colorAnimator.start();
    }

    public void setDefaultColor(int defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void setFocusColor(int focusColor) {
        this.focusColor = focusColor;
    }

    public void setAnimDuration(int animDuration) {
        this.animDuration = animDuration;
    }
}
