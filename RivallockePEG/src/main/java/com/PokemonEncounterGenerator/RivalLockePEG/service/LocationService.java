package com.PokemonEncounterGenerator.RivalLockePEG.service;

import com.PokemonEncounterGenerator.RivalLockePEG.Helper.GenerateRandomEncounter;
import com.PokemonEncounterGenerator.RivalLockePEG.dao.LocationDao;
import com.PokemonEncounterGenerator.RivalLockePEG.dataSource.FirebaseHelper;
import com.PokemonEncounterGenerator.RivalLockePEG.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class LocationService {

    private final LocationDao locationDao;

    @Autowired
    public LocationService(@Qualifier("LocationDao") LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    /**
     * Initial driver for getting all information about a given location.
     *
     * @param location  Given location.
     * @param version  Given version.
     */
    public Location getLocation(String location, String version) throws ExecutionException, InterruptedException {
        Location locationInfo = new Location(location, FirebaseHelper.getAllPokemonForLocation(location, version));

        return locationInfo;
    }

    /**
     * Initial driver for getting all information about a given location.
     *
     * @param location  Given location.
     * @param version  Given version.
     */
    public String getRandomEncounter(String location, String version) throws ExecutionException, InterruptedException {
        Location locationInfo = new Location(location, FirebaseHelper.getAllPokemonForLocation(location, version));

        GenerateRandomEncounter generateRandomEncounter = new GenerateRandomEncounter();

        return generateRandomEncounter.generateRandomEncounter(locationInfo);
    }
}
