package com.example.django.newsproject.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.django.newsproject.model.NewsData;
import com.example.django.newsproject.util.Conts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;

/**
 * Created by Django on 2016/11/1.
 */
public class NewsPrensenter {

    public static final String TAG = "NewsPrensenter";
    public static void receiveNews(int page){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                .addConverterFactory(ScalarsConverterFactory.create())//将其转化为String
                .addConverterFactory(GsonConverterFactory.create())//在转化为gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//通过rxjava适配数据
                .build();
        NewsService service = retrofit.create(NewsService.class);//采用动态注册
        service.getNewsList(Conts.MY_APP_KEY,"10",page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<NewsData, List<NewsData.NewslistBean>>() {
                    @Override
                    public List<NewsData.NewslistBean> call(NewsData newsData) {
                        Log.d("test","news size:"+newsData.getNewslist().size());
                        return newsData.getNewslist();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsData.NewslistBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("test","网路连接出错："+e);
                    }

                    @Override
                    public void onNext(List<NewsData.NewslistBean> newslistBeans) {
                        Log.d("test","获取网络数据成功，数据量为："+newslistBeans.size());
                    }
                });
    }

    public static void rxTest(){
        Log.d(TAG, "rxTest所在的线程为：" + Thread.currentThread().getName());
        List<String> array = new ArrayList<String>();
        array.add("小红");
        array.add("小黄");
        array.add("小绿");
        array.add("小兰");
        array.add("小紫");
        array.add("小黑");
        Observable.from(array)
                .subscribeOn(AndroidSchedulers.mainThread())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        Log.d(TAG, s + "map--str to str be called,run in :" + Thread.currentThread().getName());
                        return s + " be changed";
                    }
                })
                .observeOn(Schedulers.io())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, s+"map2--str to str be called,run in :" + Thread.currentThread().getName());
                        return s + " once more.";
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "on completed. run on:" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        doSomeWork(s);
                    }
                });
    }

    private static void doSomeWork(String s) {
        Log.d(TAG,"doSomeWork:"+Thread.currentThread().getName());
    }
}
