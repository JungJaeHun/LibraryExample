package jungjaehun.libraryexample.Example.SimplePagerIndicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import jungjaehun.libraryexample.ExtendsClass.BaseActivity;
import jungjaehun.libraryexample.R;
import jungjaehun.simplepagerindicator.SimplePagerIndicator;

public class SimplePagerIndicatorActivity extends BaseActivity {

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.simplePagerIndicator) SimplePagerIndicator simplePagerIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_pager_indicator);

        initViewPager();

    }

    private void initViewPager(){

        AdapterColorView adapterColorView = new AdapterColorView(getApplicationContext());

        viewPager.setAdapter(adapterColorView);

        simplePagerIndicator.remoteViewPager(getApplicationContext(), viewPager, LinearLayoutManager.HORIZONTAL);

    }


    @BindView(R.id.buttonIndicatorFilled) Button buttonIndicatorFilled;
    @OnClick(R.id.buttonIndicatorFilled)
    public void buttonIndicatorFilled(){
        simplePagerIndicator.setColorFill(!simplePagerIndicator.isColorFill());
        buttonIndicatorFilled.setText("COLOR FILL : " + simplePagerIndicator.isColorFill());
    }

}
