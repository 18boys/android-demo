package com.qunar.asp.pms;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelList extends ListActivity {
    private Handler handler = new Handler();
    private Activity currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        currentActivity = this;
        getHotelList();
    }

    private List<Map<String, ?>> getData(String result) {

        List<Map<String, ?>> list = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(result);
            JSONArray subjects = object.getJSONArray("subjects");
            int i,j=subjects.length();
            for(i=0;i<j;i++){
                JSONObject item=(JSONObject)subjects.get(i);
                Map map = new HashMap();
                map.put("title", item.getString("title"));
                map.put("info", "android 1");
                map.put("img", R.mipmap.ic_launcher);
                list.add(map);
            }
        }catch (Exception e){
            Log.e("HotelList:","解析json数据异常");
        }
        return list;
    }

    private void getHotelList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //从网络获取数据
                final String response = NetUtils.get("https://api.douban.com/v2/movie/top250");
                //向Handler发送处理操作
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //在UI线程更新UI

                        Log.i("HotelList:", "相应" + response);
                        SimpleAdapter adapter = new SimpleAdapter(currentActivity, getData(response),
                                R.layout.content_hotel_list,
                                new String[]{"title", "info", "img"},
                                new int[]{R.id.title, R.id.info, R.id.img});
                        setListAdapter(adapter);
                    }
                });
            }
        }).start();
    }
}
