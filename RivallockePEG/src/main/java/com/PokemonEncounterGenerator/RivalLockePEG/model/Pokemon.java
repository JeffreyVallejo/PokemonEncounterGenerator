package com.PokemonEncounterGenerator.RivalLockePEG.model;

public class Pokemon {

    public String name;
    public int appearancerate;

    public Pokemon(String name, int appearancerate) {
        this.name = name;
        this.appearancerate = appearancerate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppearancerate() {
        return appearancerate;
    }

    public void setAppearancerate(int appearancerate) {
        this.appearancerate = appearancerate;
    }
}
