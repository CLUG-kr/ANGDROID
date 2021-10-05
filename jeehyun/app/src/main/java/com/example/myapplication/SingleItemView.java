package com.example.myapplication;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;


public class SingleItemView extends ConstraintLayout {

    TextView userId;
    TextView time;
    RatingBar stars;
    TextView comment;
    TextView recommend_count;


    public SingleItemView(@NonNull Context context) {
        super(context);

        init(context);
    }

    public SingleItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.single_item,this,true);

        userId = findViewById(R.id.userId);
        time = findViewById(R.id.time);
        stars = findViewById(R.id.stars);
        comment= findViewById(R.id.comment);
        recommend_count = findViewById(R.id.recommend_count);


    }

    public void setUserId(String userid){
        userId.setText(userid);
    }
    public void setTime(Integer times){
        time.setText(times+"분전");
    }
    public void setStars(Float stars_count){
        stars.setRating(stars_count);
    }
    public void setComment(String comments){
        comment.setText(comments);
    }
    public void setRecommend_count(Integer recommendCount){
        recommend_count.setText("추천 "+recommendCount+" |");
    }



}