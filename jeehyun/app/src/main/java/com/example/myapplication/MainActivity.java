package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView movie_text = findViewById(R.id.movie_text);
        movie_text.setText("군도, 백성을 구하라!\n" +
                " 양반과 탐관오리들의 착취가 극에 달했던 조선 철종 13년. 힘 없는 백성의 편이 되어\n" +
                " 세상을 바로잡고자 하는 의적떼인 군도(群盜), 지리산 추설이 있었다.\n" +
                " \n" +
                " 쌍칼 도치 vs 백성의 적 조윤\n" +
                " 잦은 자연재해, 기근과 관의 횡포까지 겹쳐 백성들의 삶이 날로 피폐해 져 가는 사이,\n" +
                " 나주 대부호의 서자로 조선 최고의 무관 출신인 조윤은 극악한 수법으로 양민들을 수탈,\n" +
                " 삼남지방 최고의 대부호로 성장한다. 한편 소, 돼지를 잡아 근근이 살아가던 천한 백정 돌무치는\n" +
                " 죽어도 잊지 못할 끔찍한 일을 당한 뒤 군도에 합류. 지리산 추설의 신 거성(新 巨星) 도치로 거듭난다.\n" +
                " \n" +
                " 뭉치면 백성, 흩어지면 도적!\n" +
                " 망할 세상을 뒤집기 위해, 백성이 주인인 새 세상을 향해 도치를 필두로 한 군도는 백성의 적,\n" +
                " 조윤과 한 판 승부를 시작하는데...");

        ImageButton thumb_up = findViewById(R.id.thumb_up);
        ImageButton thumb_down = findViewById(R.id.thumb_down);
        TextView thumb_up_count = findViewById(R.id.thumb_up_count);
        TextView thumb_down_count = findViewById(R.id.thumb_down_count);

        final boolean[] thumb_up_selected = {false};
        final boolean[] thumb_down_selected = {false};

        thumb_up.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thumb_up_selected[0] ==false){
                    thumb_up.setImageResource(R.drawable.ic_thumb_up_selected);
                    thumb_down.setImageResource(R.drawable.ic_thumb_down);
                    thumb_up_count.setText(Integer.parseInt(thumb_up_count.getText().toString())+1+"");
                    thumb_up_selected[0] =true;
                    if(thumb_down_selected[0] == true){
                        thumb_down_count.setText(Integer.parseInt(thumb_down_count.getText().toString())-1+"");
                    }
                    thumb_down_selected[0] = false;
                }
                else{
                    thumb_up.setImageResource(R.drawable.ic_thumb_up);
                    thumb_down.setImageResource(R.drawable.ic_thumb_down);
                    thumb_up_count.setText(Integer.parseInt(thumb_up_count.getText().toString())-1+"");
                    thumb_up_selected[0] =false;
                    thumb_down_selected[0] = false;
                }
            }
        });

        thumb_down.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thumb_down_selected[0] ==false){
                    thumb_up.setImageResource(R.drawable.ic_thumb_up);
                    thumb_down.setImageResource(R.drawable.ic_thumb_down_selected);
                    thumb_down_count.setText(Integer.parseInt(thumb_down_count.getText().toString())+1+"");
                    if(thumb_up_selected[0] == true){
                        thumb_up_count.setText(Integer.parseInt(thumb_up_count.getText().toString())-1+"");
                    }
                    thumb_up_selected[0] =false;
                    thumb_down_selected[0] = true;
                }
                else{
                    thumb_up.setImageResource(R.drawable.ic_thumb_up);
                    thumb_down.setImageResource(R.drawable.ic_thumb_down);
                    thumb_down_count.setText(Integer.parseInt(thumb_down_count.getText().toString())-1+"");
                    thumb_up_selected[0] =false;
                    thumb_down_selected[0] = false;
                }
            }
        });
    }
}