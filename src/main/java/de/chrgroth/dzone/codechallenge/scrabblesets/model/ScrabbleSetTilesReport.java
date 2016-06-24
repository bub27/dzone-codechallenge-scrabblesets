package de.chrgroth.dzone.codechallenge.scrabblesets.model;

import java.util.NavigableMap;
import java.util.Set;

public class ScrabbleSetTilesReport {

    private final NavigableMap<Integer, Set<Character>> tilesByAvailabilityCount;
    private final Set<Character> tilesInErrorState;

    public ScrabbleSetTilesReport(NavigableMap<Integer, Set<Character>> tilesByAvailabilityCount, Set<Character> tilesInErrorState) {
        this.tilesByAvailabilityCount = tilesByAvailabilityCount;
        this.tilesInErrorState = tilesInErrorState;
    }

    public NavigableMap<Integer, Set<Character>> getTilesByAvailabilityCount() {
        return tilesByAvailabilityCount;
    }

    public Set<Character> getTilesInErrorState() {
        return tilesInErrorState;
    }
}
