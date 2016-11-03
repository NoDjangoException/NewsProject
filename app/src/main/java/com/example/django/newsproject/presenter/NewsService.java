package com.example.django.newsproject.presenter;

import com.example.django.newsproject.model.NewsData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Django on 2016/11/1.
 */
public interface NewsService {
    /**
     * 结合Retrofit 与 RXjava ，通过retrofit获取网络数据做为被观察者
     * @param key app key
     * @param num 每页包含的数据量
     * @param page 页数
     * @return
     */
    @GET("social/")
    Observable<NewsData> getNewsList(@Query("key")String key,@Query("num")String num,@Query("page")int page);
}
