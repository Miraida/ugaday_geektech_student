package com.geek.ugadai.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.ugadai.R;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder> {
    ArrayList<String> list;
    ChooseClick listener;
    public LevelAdapter(ArrayList<String> list ,ChooseClick listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LevelViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LevelViewHolder extends RecyclerView.ViewHolder {
        Button button;
        public LevelViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.item_btn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }

        public void onBind(String s) {
            button.setText(s);
        }
    }
    public interface ChooseClick{
        void onItemClick(int position);
    }
}
