package jungjaehun.simplepagerindicator;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaehoonjung on 2017. 5. 13..
 */

public class AdapterIndicator extends RecyclerView.Adapter<AdapterIndicator.ViewHolder> implements ViewPager.OnPageChangeListener{

    private ViewPager targetViewPager = null;

    private SimplePagerIndicator simplePagerIndicator = null;

    private List<ViewHolder> circleIndicatorList = new ArrayList<ViewHolder>();

    private int focusPosition = 0;

    public AdapterIndicator(SimplePagerIndicator simplePagerIndicator) {
        this.simplePagerIndicator = simplePagerIndicator;
    }

    public void remoteViewPager(ViewPager viewPager){
        targetViewPager = viewPager;
        targetViewPager.addOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.position = position;

        circleIndicatorList.add(position, holder);

        changeColorToChild(holder);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_indicator_circle, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public int getItemCount() {
        return targetViewPager == null ? 0 : targetViewPager.getAdapter().getCount();
    }

    @Override
    public void onPageSelected(int position) {
        focusPosition = position;
        changeStep();
    }

    private void changeColorToChild(ViewHolder viewHolder){
        if(simplePagerIndicator.isColorFill())
            viewHolder.simpleIndicatorView.changeColorByFocus(viewHolder.position <= focusPosition ? true : false);
        else
            viewHolder.simpleIndicatorView.changeColorByFocus(viewHolder.position == focusPosition ? true : false);
    }

    private void changeStep(){
        for(ViewHolder viewHolder : circleIndicatorList)
            changeColorToChild(viewHolder);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimpleIndicatorView simpleIndicatorView;
        int position;
        public ViewHolder(View itemView) {
            super(itemView);
            this.simpleIndicatorView = (SimpleIndicatorView) itemView;
            simpleIndicatorView.setAnimDuration(simplePagerIndicator.getAnimDuration());
            simpleIndicatorView.setDefaultColor(simplePagerIndicator.getDefaultColor());
            simpleIndicatorView.setFocusColor(simplePagerIndicator.getFocusColor());

            simpleIndicatorView.setLayoutParams(new ViewGroup.LayoutParams(simplePagerIndicator.getIndicatorSize(), simplePagerIndicator.getIndicatorSize()));

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



}
