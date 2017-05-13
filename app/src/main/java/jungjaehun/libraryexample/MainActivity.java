package jungjaehun.libraryexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jungjaehun.libraryexample.Example.SimplePagerIndicator.SimplePagerIndicatorActivity;
import jungjaehun.libraryexample.ExtendsClass.BaseActivity;

public class MainActivity extends BaseActivity implements AdapterExample.OnClickExampleItemListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initExampleList(getExampleDatas());

    }

    @BindView(R.id.listExample) RecyclerView listExample;

    private void initExampleList(List<ExampleData> datas){
        AdapterExample adapterExample = new AdapterExample(this);
        adapterExample.setDatas(datas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        listExample.setLayoutManager(linearLayoutManager);
        listExample.setAdapter(adapterExample);
    }

    @Override
    public void onClickExampleItem(ExampleData exampleData) {
        startActivity(exampleData.getExampleIntent());
    }

    private List<ExampleData> getExampleDatas(){
        List<ExampleData> datas = new ArrayList<ExampleData>();
        datas.add(new ExampleData("Simple pager indicator", new Intent(getApplicationContext(), SimplePagerIndicatorActivity.class)));
        return datas;
    }

}
