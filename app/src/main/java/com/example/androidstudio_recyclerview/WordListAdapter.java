package com.example.androidstudio_recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {


    private LayoutInflater mInflater;
    private LinkedList<String> mWordList;


    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater =
                LayoutInflater.from(context);
        this.mWordList = wordList;
    }


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.items, parent, false);

        return new WordViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }


    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    public static class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private final TextView wordItemView;


        public WordViewHolder(View itemView, WordListAdapter adapter) {


            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            wordItemView.setText("Clicked! " + wordItemView.getText());
        }

    }


}