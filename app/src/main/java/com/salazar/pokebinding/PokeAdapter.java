package com.salazar.pokebinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.salazar.pokebinding.databinding.PokemonItemBinding;

import java.util.List;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.PokeHolder> {

    private final List<Pokemon> pokemonList;

    public PokeAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PokemonItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.pokemon_item, parent, false);
        return new PokeHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeHolder holder, int position) {
        holder.bindConnection(pokemonList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    static class PokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final PokemonItemBinding binding;

        public PokeHolder(PokemonItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this);
        }

        public void bindConnection(Pokemon pokemon) {
            binding.setPokemon(pokemon);
        }

        @Override
        public void onClick(View v) {
            //TODO(Go to detail Pokemon)
        }
    }
}