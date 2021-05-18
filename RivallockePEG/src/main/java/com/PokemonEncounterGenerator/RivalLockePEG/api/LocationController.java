package com.PokemonEncounterGenerator.RivalLockePEG.api;

import com.PokemonEncounterGenerator.RivalLockePEG.model.Location;
import com.PokemonEncounterGenerator.RivalLockePEG.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequestMapping("api/v1/locations")
@RestController
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/pokemon")
    public Location getLocation(@RequestHeader("location") String location, @RequestHeader("version")String version) throws ExecutionException, InterruptedException {
        return locationService.getLocation(location, version);
    }

    @GetMapping("/encounter")
    public String getEncounter(@RequestHeader("location") String location, @RequestHeader("version")String version) throws ExecutionException, InterruptedException {
        String result = locationService.getRandomEncounter(location, version);
        return result;
    }
}
