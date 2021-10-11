package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReviewDetailActivity extends AppCompatActivity {


    String movieTitle;
    SingleAdapter singleAdapter;
    String review;
    Float stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewdetail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        movieTitle = intent.getStringExtra("movieTitle");
        TextView movie_title = findViewById(R.id.movieTitle);
        movie_title.setText(movieTitle);

        ImageButton backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("review",review);
                intent.putExtra("stars",stars);
                startActivity(intent);
                finish();
            }
        });


        ListView listView = findViewById(R.id.listView);

        singleAdapter = new SingleAdapter();
        singleAdapter.addItem(new SingleItem("jihyun1",2, (float) 3.5, "괜찮은 영화였어요.", 3));
        singleAdapter.addItem(new SingleItem("jihyun2",10, (float) 2.5, "좋은 영화였어요.", 0));
        singleAdapter.addItem(new SingleItem("jihyun3",1, (float) 3.0, "즐거운 영화였어요.", 3));
        singleAdapter.addItem(new SingleItem("jihyun4",12, (float) 3.5, "괜찮은 영화였어요.", 0));
        singleAdapter.addItem(new SingleItem("jihyun5",3, (float) 2.5, "즐거운 영화였어요.", 3));
        singleAdapter.addItem(new SingleItem("jihyun6",4, (float) 2.5, "즐거운 영화였어요.", 1));
        singleAdapter.addItem(new SingleItem("jihyun7",5, (float) 3.5, "좋은 영화였어요.", 1));

        float temp = intent.getFloatExtra("stars",-1);
        if(temp!=(-1)){
            review = intent.getStringExtra("review");
            stars = intent.getFloatExtra("stars",0);
            singleAdapter.addItem(new SingleItem("jihyun",1, (float) stars, review, 0));
        }


        listView.setAdapter(singleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingleItem item = (SingleItem) singleAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),item.getId()+"님이 작성하신 한줄평입니다.",Toast.LENGTH_LONG).show();
                Log.i("클릭: " ,item.getId()+"님이 작성하신 한줄평입니다.");
            }
        });


    }

    class SingleAdapter extends BaseAdapter {

        ArrayList<SingleItem> items = new ArrayList<SingleItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingleItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingleItemView view = new SingleItemView(getApplicationContext());
            SingleItem item = items.get(position);
            view.setUserId(item.id);
            view.setComment(item.comment);
            view.setRecommend_count(item.recommend_count);
            view.setStars(item.stars_count);
            view.setTime(item.time);
            return view;
        }
    }




}
