package com.qunar.asp.pms;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.content_hotel_list,
                new String[]{"title","info","img"},
                new int[]{R.id.title,R.id.info,R.id.img});
        setListAdapter(adapter);
    }

    private List<Map<String,?>> getData() {
        List<Map<String,?>> list = new ArrayList<>();

        Map map = new HashMap();

        String discount_info = this.getString(R.string.discount_info);//相应字符串在String.xml中设置
        String recommend_shop = this.getString(R.string.recommend_shop);
        String about_us = this.getString(R.string.about_us);

        map.put("title", discount_info);
        map.put("info", "android 1");
        map.put("img", R.mipmap.ic_launcher);
        list.add(map);

        map = new HashMap();
        map.put("title", recommend_shop);
        map.put("info", "android 2");
        map.put("img", R.mipmap.ic_launcher);
        list.add(map);

        map = new HashMap();
        map.put("title", about_us);
        map.put("info", "android 3");
        map.put("img", R.mipmap.ic_launcher);
        list.add(map);

        return list;
    }
}
