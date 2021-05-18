package com.PokemonEncounterGenerator.RivalLockePEG.dao;

import com.PokemonEncounterGenerator.RivalLockePEG.model.Location;
import org.springframework.stereotype.Repository;

@Repository("LocationDao")
public class LocationDataAccessService implements LocationDao {

    @Override
    public Location getLocations(String location, String version) {
        return null;
    }
}
