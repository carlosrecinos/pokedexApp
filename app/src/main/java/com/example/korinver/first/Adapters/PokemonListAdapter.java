package com.example.korinver.first.Adapters;

import android.content.Context;
import android.service.autofill.Dataset;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.korinver.first.R;
import com.example.korinver.first.api.Models.Pokemon;

import java.util.ArrayList;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {
    private ArrayList<Pokemon> dataSet;
    private Context context;
    public PokemonListAdapter(Context context){
        dataSet = new ArrayList<>();
        this.context = context;
    }
    @Override
    public PokemonListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonListAdapter.ViewHolder holder, int position) {
        Pokemon pokemon = dataSet.get(position);
        holder.name.setText(pokemon.getName());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ pokemon.getId() +".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addPokemonList(ArrayList<Pokemon> pokemonList) {
        dataSet.addAll(pokemonList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView name;
        public ViewHolder(View view){
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
