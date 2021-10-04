package com.example.myapplication;

public class SingleItem {

    String id;
    Integer time;
    Float stars_count;
    String comment;
    Integer recommend_count;

    public SingleItem(String id, Integer time, Float stars_count, String comment, Integer recommend_count) {
        this.id = id;
        this.time = time;
        this.stars_count = stars_count;
        this.comment = comment;
        this.recommend_count = recommend_count;
    }

    public String getId() {
        return id;
    }

    public Integer getTime() {
        return time;
    }

    public Float getStars_count() {
        return stars_count;
    }

    public String getComment() {
        return comment;
    }

    public Integer getRecommend_count() {
        return recommend_count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setStars_count(Float stars_count) {
        this.stars_count = stars_count;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRecommend_count(Integer recommend_count) {
        this.recommend_count = recommend_count;
    }

    @Override
    public String toString() {
        return "SingleItem{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", stars_count=" + stars_count +
                ", comment='" + comment + '\'' +
                ", recommend_count=" + recommend_count +
                '}';
    }
}
