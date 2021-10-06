package com.example.mylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView= (ListView) findViewById(R.id.listView);

        SingerAdapter adapter=new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대","010-10000-0000"));
        adapter.addItem(new SingerItem("걸스데이","010-10300-0000"));
        adapter.addItem(new SingerItem("여자친구","010-103000-0000"));
        adapter.addItem(new SingerItem("티아라","010-100400-0000"));
        adapter.addItem(new SingerItem("애퍼터수쿨","010-100060-0000"));


        listView.setAdapter(adapter);
    }
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items=new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();

        }
        public void addItem(SingerItem item){
            items.add(item);
        }


        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            SingerItemView view= new SingerItemView(getApplicationContext());

            SingerItem item=  items.get(view);
            view.setName(item.getName());
            view.setMobile(item.getMobile());

            return view;
        }
    }
}