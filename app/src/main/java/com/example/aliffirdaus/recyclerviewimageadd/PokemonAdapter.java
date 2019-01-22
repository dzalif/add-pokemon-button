package com.example.aliffirdaus.recyclerviewimageadd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // View Types
    private static final int ITEM = 0;
    private static final int BUTTON = 1;

    private Context context;
    private List<Pokemon> pokemons;

    public PokemonAdapter(Context context, List<Pokemon> pokemons) {
        this.context = context;
        setListItem(pokemons);
    }

    public void setListItem(List<Pokemon> listItem) {
        this.pokemons = new ArrayList<>();
        pokemons.addAll(listItem);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View viewItem = null;

        if (viewType == ITEM) {
            viewItem = inflater.inflate(R.layout.pokemon_item, viewGroup, false);
        } else if (viewType == BUTTON) {
            viewItem = inflater.inflate(R.layout.pokemon_item_add, viewGroup, false);
        }

        return new PokemonAdapter.ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (position == pokemons.size()) {
            final PokemonAdapter.ViewHolder itemVH = (PokemonAdapter.ViewHolder) viewHolder;
        } else {
            Pokemon current = pokemons.get(position);
            final PokemonAdapter.ViewHolder itemVH = (PokemonAdapter.ViewHolder) viewHolder;
            itemVH.pokemonImage.setBackgroundResource(current.getPicture());
            itemVH.pokemonName.setText(current.getName());
        }
    }

    @Override
    public int getItemCount() {
        return pokemons.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == pokemons.size()) {
            return BUTTON;
        } else {
            return ITEM;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pokemonImage;
        ImageView pokemonAdd;
        TextView pokemonName;
        public ViewHolder(View view) {
            super(view);
            pokemonImage = view.findViewById(R.id.pokemon_item);
            pokemonAdd = view.findViewById(R.id.pokemon_item_add);
            pokemonName = view.findViewById(R.id.pokemon_name);
        }
    }
}
