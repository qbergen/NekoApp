package com.example.queenabergen.accessnow30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static com.example.queenabergen.accessnow30.AccessData.getListData;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AccessAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new AccessAdapter(getListData(),this);
        recyclerView.setAdapter(adapter);

    }
}
