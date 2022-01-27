package com.example.hometaskandroid_03_06;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hometaskandroid_03_06.databinding.ItemOfSongsBinding;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.SimpleViewHolder> {
    private final ArrayList<Songs> list;
    private final Hlick click;

    public Adaptor(ArrayList<Songs> list, Hlick click) {
        this.list = list;
        this.click = click;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOfSongsBinding binding = ItemOfSongsBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new SimpleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.bind(list.get(position));
        if (MainActivity.isNotClicked) {
            holder.itemView.setOnClickListener(v -> click.onHlick(list.get(position)));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected static class SimpleViewHolder extends RecyclerView.ViewHolder{
        private final ItemOfSongsBinding binding;

        public SimpleViewHolder(@NonNull ItemOfSongsBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }

        public void bind(Songs s) {
            if (MainActivity.isNotClicked) {
                binding.someId.setText(s.getIdCount());
                binding.blankSpace.setText(s.getNameOfSong());
                binding.taylorSwif.setText(s.getNameOfSinger());
                binding.timer.setText(s.getLengthOfSong());
            }
        }
    }
}
