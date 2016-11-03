package com.example.django.newsproject.presenter;

import com.example.django.newsproject.model.NewsData;

/**
 * Created by Django on 2016/11/3.
 */
public interface INewsView {
    void setItem(NewsData.NewslistBean newsBean);
}
