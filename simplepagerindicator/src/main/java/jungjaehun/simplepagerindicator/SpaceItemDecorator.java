package jungjaehun.simplepagerindicator;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jaehoonjung on 2017. 5. 13..
 */

public class SpaceItemDecorator extends RecyclerView.ItemDecoration{

    private int marginPixel = 0;
    private int orientation = LinearLayoutManager.HORIZONTAL;

    public SpaceItemDecorator(int marginPixel){
        this.marginPixel = marginPixel;
    }
    public SpaceItemDecorator(int marginPixel, int orientation){
        this.marginPixel = marginPixel;
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(orientation == LinearLayoutManager.HORIZONTAL){
            outRect.left = marginPixel;
            outRect.right = marginPixel;
        }else{
            outRect.top = marginPixel;
            outRect.bottom = marginPixel;
        }
    }
}
