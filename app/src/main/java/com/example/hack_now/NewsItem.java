package com.example.hack_now;

public class NewsItem {
    String title;
    String desc;
    String postedBy;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public NewsItem(String title, String desc, String postedBy) {
        this.title=title;
        this.desc=desc;
        this.postedBy=postedBy;
    }
}
