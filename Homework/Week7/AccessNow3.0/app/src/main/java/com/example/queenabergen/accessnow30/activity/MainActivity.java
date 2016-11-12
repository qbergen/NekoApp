package com.example.queenabergen.accessnow30.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.queenabergen.accessnow30.R;
import com.example.queenabergen.accessnow30.adapter.AccessAdapter;
import com.example.queenabergen.accessnow30.model.AccessService;
import com.example.queenabergen.accessnow30.model.GiphyRandom;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.queenabergen.accessnow30.adapter.AccessData.getListData;

public class MainActivity extends AppCompatActivity {
    private static String TAG;
    private RecyclerView recyclerView;
    private AccessAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.ImageView);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AccessAdapter(getListData(), this);
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://giphy.com/gifs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AccessService service = retrofit.create(AccessService.class);
        Call<GiphyRandom> call = service.getRandomGiphy();
        call.enqueue(new Callback<GiphyRandom>() {
            @Override
            public void onResponse(Call<GiphyRandom> call, Response<GiphyRandom> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success: " + response.body().getData());
                        imageView.setImageResource(Integer.parseInt((response.body().getData())));
                    } else {
                        Log.d(TAG, "Something Happened" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<GiphyRandom> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
