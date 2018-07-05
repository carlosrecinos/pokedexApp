package com.example.korinver.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.korinver.first.Adapters.PokemonListAdapter;
import com.example.korinver.first.api.ApiService;
import com.example.korinver.first.api.Models.GetPokemonResponse;
import com.example.korinver.first.api.Models.Pokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Pokedex";
    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.pokemonListRecyclerView);
        pokemonListAdapter = new PokemonListAdapter(this);
        recyclerView.setAdapter(pokemonListAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getData(retrofit);
    }
    public void getData(Retrofit retrofit){
        ApiService service = retrofit.create(ApiService.class);
        Call<GetPokemonResponse> pokemonResponseCall = service.getPokemonList();
        pokemonResponseCall.enqueue(new Callback<GetPokemonResponse>() {
            @Override
            public void onResponse(Call<GetPokemonResponse> call, Response<GetPokemonResponse> response) {
                if(response.isSuccessful()){
                    Log.e(TAG, "Response");
                    GetPokemonResponse pokemonResponse = response.body();
                    ArrayList<Pokemon> pokemonList = pokemonResponse.getResults();

                    pokemonListAdapter.addPokemonList(pokemonList);
                }else{
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<GetPokemonResponse> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }
}
