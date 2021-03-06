package com.example.django.newsproject.model;

import java.util.List;

/**
 * Created by Django on 2016/11/1.
 */
public class NewsData {

    /**
     * code : 200
     * msg : success
     * newslist :
     * */

    private int code;
    private String msg;
    /**
     * ctime : 2016-10-11 10:53
     * title : 南京六合区：继续组织搜捕外逃眼镜蛇，幼蛇毒性不大过
     * description : 网易社会
     * picUrl :
     * url : http://news.163.com/16/1011/10/C33ET2G000014SEH.html#f=slist
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
