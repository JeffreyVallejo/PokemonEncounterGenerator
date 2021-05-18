package com.PokemonEncounterGenerator.RivalLockePEG.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Location {

    public String name;
    public List<Pokemon> pokemonList;

    public Location(@JsonProperty("name") String name,
                    @JsonProperty("pokemon") List<Pokemon> pokemonList) {
        this.name = name;
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
