package com.example.mysummary1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButton1Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://movie.naver.com/movie/bi/mi/point.naver?code=99752"));
        startActivity(intent);
        }
    public void onButton2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
        startActivity(intent);
        }



}