package com.PokemonEncounterGenerator.RivalLockePEG.Helper;

import com.PokemonEncounterGenerator.RivalLockePEG.model.Location;
import com.PokemonEncounterGenerator.RivalLockePEG.model.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GenerateRandomEncounter {
    private int totalChance = 0;
    private HashMap<String, ArrayList<Integer>> pokemonAppearanceRates = new HashMap<>();

    /**
     * Takes a location and generates a random encounter.
     *
     * @param location  Contains the location name and the pokemon associated with it.
     */
    public String generateRandomEncounter(Location location) {

        for(Pokemon pokemon : location.getPokemonList()) {
            assignChanceToPokemon(pokemon);
            totalChance += pokemon.appearancerate;
        }

        String encounter = randomlyPickEncounter();

        return encounter;

    }

    /**
     * Assigns a number range to the pokemon given the rate at which the pokemon would appear.
     *
     * @param pokemon  Name to be associated with the number range.
     */
    private void assignChanceToPokemon(Pokemon pokemon) {
        ArrayList<Integer> numRange = new ArrayList<>();

        if(pokemonAppearanceRates.containsKey(pokemon.name)) {
            numRange = pokemonAppearanceRates.get(pokemon.name);
        }

        // Fill the array with the numbers that will represent the chances.
        for(int i = totalChance; i < totalChance + pokemon.appearancerate; i++) {
            numRange.add(i);
        }

        pokemonAppearanceRates.put(pokemon.name, numRange);
    }

    /**
     * Generates a number to pick a pokemon from then returns the appropriate pokemon.
     */
    private String randomlyPickEncounter() {
        int rand = (int)Math.floor(Math.random()*(totalChance-0+1)+0);

        Iterator it = pokemonAppearanceRates.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            ArrayList<Integer> list = (ArrayList<Integer>) pair.getValue();
            if(list.contains(rand)) {
                return pair.getKey().toString();
            }
        }

        return "";
    }

}
