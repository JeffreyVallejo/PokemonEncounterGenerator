package com.PokemonEncounterGenerator.RivalLockePEG.api;

import com.PokemonEncounterGenerator.RivalLockePEG.model.Location;
import com.PokemonEncounterGenerator.RivalLockePEG.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RequestMapping("api/v1/locations")
@RestController
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String index() {
        return "api is running";
    }

    @GetMapping("/pokemon")
    public Location getLocation(@RequestParam("location") String location, @RequestParam("version")String version) throws ExecutionException, InterruptedException {
        return locationService.getLocation(location, version);
    }

    @GetMapping("/encounter")
    public String getEncounter(@RequestParam("location") String location, @RequestParam("version")String version) throws ExecutionException, InterruptedException {
        System.out.println("Request received");
        String result = locationService.getRandomEncounter(location, version);
        return result;
    }
}
