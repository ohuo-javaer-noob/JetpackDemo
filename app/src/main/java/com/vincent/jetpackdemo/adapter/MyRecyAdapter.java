package com.vincent.jetpackdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vincent.jetpackdemo.R;
import com.vincent.jetpackdemo.databinding.CellNormalBinding;
import com.vincent.jetpackdemo.entity.EntityWord;

import java.util.ArrayList;
import java.util.List;

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.MyViewHolder> {

    private List<EntityWord> wordList = new ArrayList<>();


    public void setWordList(List<EntityWord> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        CellNormalBinding binding = DataBindingUtil.inflate(inflater, R.layout.cell_normal, parent, false);
        return new MyViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getBinding().chTxt.setText(wordList.get(position).getChinesMeaning());
        holder.getBinding().enTxt.setText(wordList.get(position).getWord());
        holder.getBinding().seqTxt.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private CellNormalBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public MyViewHolder(@NonNull View itemView, CellNormalBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public CellNormalBinding getBinding() {
            return binding;
        }
    }
}
