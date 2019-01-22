package com.example.aliffirdaus.recyclerviewimageadd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    PokemonAdapter adapter;
    List<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        initRecycler();
        initData();
    }

    private void initData() {
        Pokemon pokemon = new Pokemon("Bulbasaur", R.drawable.bulbasaur);
        pokemons.add(pokemon);
        pokemon = new Pokemon("Pikachu", R.drawable.pikachu);
        pokemons.add(pokemon);
        pokemon = new Pokemon("Eevee", R.drawable.eevee);
        pokemons.add(pokemon);
        pokemon = new Pokemon("Psyduck", R.drawable.psyduck);
        pokemons.add(pokemon);

        adapter.setListItem(pokemons);
        adapter.notifyDataSetChanged();
    }

    private void initRecycler() {
        //Recyclerview
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new PokemonAdapter(this, new ArrayList<Pokemon>());
        recyclerView.setAdapter(adapter);
    }
}
