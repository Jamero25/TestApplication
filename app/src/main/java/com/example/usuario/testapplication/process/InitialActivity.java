package com.example.usuario.testapplication.process;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.example.usuario.testapplication.R;
import com.example.usuario.testapplication.data.Items;

import java.util.ArrayList;

public class InitialActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Items> itemses = null;

    final ReadLocalJSON readLocalJSON = new ReadLocalJSON();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        itemses = readLocalJSON.getItemses(getBaseContext(), 0);
        mAdapter = new MyAdapter(itemses);
        mRecyclerView.setAdapter(mAdapter);


    }
}
