package com.example.deskmate;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deskmate.Adapters.FeedAdapter;
import com.example.deskmate.model.Feed;
import com.example.deskmate.model.feedInfo;
import com.example.deskmate.service.getFeedService;
import com.example.deskmate.service.retrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Feed> results;

    private FeedAdapter feedAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFeed();
    }public Object getFeed() {

        getFeedService getFeedService = retrofitInstance.getFeedService();
        Call<feedInfo> call = getFeedService.getFeed();

        call.enqueue(new Callback<feedInfo>() {
            @Override
            public void onResponse(Call<feedInfo> call, Response<feedInfo> response) {

                feedInfo feedInfo = response.body();

                if(feedInfo !=null && feedInfo.getResponse() !=null) {
                    results = (ArrayList<Feed>) feedInfo.getResponse().getFeed();

                  /*  for (Feed r:results) {
                        Log.i("testing", "haiyaaaa"+ r.getPostMsg());
                    } */

                    viewData();
                }
            }

            @Override
            public void onFailure(Call<feedInfo> call, Throwable t) {

            }
        });

        return results;
    }

    private  void  viewData() {

        recyclerView = recyclerView.findViewById(R.id.mainList);
        feedAdapter = new FeedAdapter(results);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(feedAdapter);



    }




}
