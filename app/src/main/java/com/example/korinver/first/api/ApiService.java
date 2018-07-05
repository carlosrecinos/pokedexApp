package com.example.korinver.first.api;


import com.example.korinver.first.api.Models.GetPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("pokemon")
    Call<GetPokemonResponse> getPokemonList();
}
