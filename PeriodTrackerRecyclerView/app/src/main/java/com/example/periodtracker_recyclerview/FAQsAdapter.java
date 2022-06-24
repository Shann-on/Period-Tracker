package com.example.periodtracker_recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FAQsAdapter extends RecyclerView.Adapter<FAQsAdapter.ViewHolder> {
    private ArrayList<FAQs> data;
    private Context context;

    public FAQsAdapter(Context context, ArrayList<FAQs> FAQsArrayList){
        this.context = context;
        data = FAQsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle, textInfo;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
        //Constructor takes in View

}