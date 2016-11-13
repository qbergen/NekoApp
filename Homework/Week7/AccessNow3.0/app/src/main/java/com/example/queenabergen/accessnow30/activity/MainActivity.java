package com.example.queenabergen.accessnow30.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.queenabergen.accessnow30.R;
import com.example.queenabergen.accessnow30.adapter.AccessAdapter;
import com.example.queenabergen.accessnow30.model.AccessService;
import com.example.queenabergen.accessnow30.model.Example;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static String TAG;
    private RecyclerView recyclerView;
    private AccessAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewholder);
        context = getApplicationContext();
        final ImageView imageView = (ImageView) findViewById(R.id.ImageView);
        final ImageView imageView2 = (ImageView) findViewById(R.id.ImageView2);

//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        adapter = new AccessAdapter(getListData(), this);
//        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AccessService service = retrofit.create(AccessService.class);
        Call<Example> call = service.getRandomGiphy("dc6zaTOxFJmzC");
        Call<Example> call1 = service.getRandomGiphy("dc6zaTOxFJmzC");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success: " + response.body());
                        String something = response.body().getData().getImageUrl();
                        Glide.with(context).load(something).into(imageView);

                    } else {
                        Log.d(TAG, "ERROR: Something Happened" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

        call1.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success: " + response.body());
                        String something2 = response.body().getData().getImageUrl();
                        Glide.with(context).load(something2).into(imageView2);

                    } else {
                        Log.d(TAG, "ERROR: Something Happened" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
