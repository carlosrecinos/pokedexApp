package com.example.korinver.first.api.Models;

import java.util.ArrayList;

public class GetPokemonResponse {
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
