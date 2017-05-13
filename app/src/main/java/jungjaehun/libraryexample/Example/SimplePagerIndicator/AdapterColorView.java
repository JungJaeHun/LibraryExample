package jungjaehun.libraryexample.Example.SimplePagerIndicator;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jungjaehun.libraryexample.R;

/**
 * Created by jaehoonjung on 2017. 5. 13..
 */

public class AdapterColorView extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private List<Integer> backGroundColors = getBackGroundColors();

    private static List<Integer> getBackGroundColors(){
        List<Integer> imageResourceList = new ArrayList<Integer>();
        imageResourceList.add(Color.parseColor("#E3F2FD"));
        imageResourceList.add(Color.parseColor("#64B5F6"));
        imageResourceList.add(Color.parseColor("#C8E6C9"));
        imageResourceList.add(Color.parseColor("#FFAB91"));
        imageResourceList.add(Color.parseColor("#FFE0B2"));
        return imageResourceList;
    }

    public AdapterColorView(Context context){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View mView;

        mView = getPageViewByColor(backGroundColors.get(position));

        ((ViewPager) container).addView(mView, 0);

        return mView;
    }


    private View getPageViewByColor(Integer backgroundColor){

        View mView = layoutInflater.inflate(R.layout.view_color_page, null);

        mView.setBackgroundColor(backgroundColor);

        return mView;
    }


    @Override
    public int getCount() {
        return backGroundColors.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }
}
