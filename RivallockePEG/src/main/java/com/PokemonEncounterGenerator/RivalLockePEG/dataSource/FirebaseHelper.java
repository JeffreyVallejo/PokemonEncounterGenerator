package com.PokemonEncounterGenerator.RivalLockePEG.dataSource;

import com.PokemonEncounterGenerator.RivalLockePEG.model.Pokemon;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FirebaseHelper {

    /**
     * This method will get all pokemon for a given location and version.
     *
     * @param location  Given location query parameter.
     * @param version   Given version query parameter
     */
    public static List<Pokemon> getAllPokemonForLocation(String location, String version) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        List<Pokemon> tempList = new ArrayList<>();

        CollectionReference locations = db.collection("Locations");
        Query query = locations.whereEqualTo("Locations", location).whereEqualTo("Version", version);
        ApiFuture<QuerySnapshot> querySnapShot = query.get();

        for(DocumentSnapshot document : querySnapShot.get().getDocuments()) {
            String pokemonName = document.get("Pokemon").toString();
            int rate = Integer.parseInt(document.get("Appearance rate").toString());
            tempList.add(new Pokemon(pokemonName, rate));
        }

        return tempList;
    }
}
