package com.example.androidstudio_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinkedList<String> mWordList = new LinkedList<String>();
        mWordList.add("Word 1");
        mWordList.add("Word 2");
        mWordList.add("Word 3");

        mAdapter = new WordListAdapter(this, mWordList);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        this.floatingActionButton = findViewById(R.id.floatingActionButton);


        this.floatingActionButton.setOnClickListener(view -> {
            int itemCount = this.mAdapter.getItemCount() + 1;
            mWordList.add("Word " + itemCount);
            mRecyclerView.getAdapter().notifyItemInserted(itemCount);
            mRecyclerView.smoothScrollToPosition(itemCount);
        });

    }
}