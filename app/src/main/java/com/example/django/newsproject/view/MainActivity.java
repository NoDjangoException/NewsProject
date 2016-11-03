package com.example.django.newsproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.django.newsproject.R;
import com.example.django.newsproject.presenter.NewsPrensenter;
import com.jude.easyrecyclerview.EasyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.news_list_rv)
    EasyRecyclerView mNewsListRv;



    /*
    RecyclerView 与list view不同的操作包括--设置布局管理器，设置特殊的适配器，
    设置增加移除的动画，添加分割线
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        newsListView.setLayoutManager(layoutManager);*/
        Log.d("test", "try to receive news");
        new Thread() {
            @Override
            public void run() {
                super.run();
                NewsPrensenter.receiveNews(0);
            }
        }.start();

    }
}
