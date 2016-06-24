package de.chrgroth.dzone.codechallenge.scrabblesets.model;

import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import de.chrgroth.dzone.codechallenge.scrabblesets.init.api.ScrabbleSetInitializer;

public class ScrabbleSet {

    public static ScrabbleSet build(ScrabbleSetInitializer initializer) {
        return new ScrabbleSet(initializer.createData());
    }

    private final Set<ScrabbleSetTile> tiles = new HashSet<>();

    private ScrabbleSet(Set<ScrabbleSetTile> tiles) {
        if (tiles != null) {
            this.tiles.addAll(tiles);
        }
    }

    public int getAvailable(char key) {
        ScrabbleSetTile tile = findTile(key);
        return tile != null ? tile.getAvailable() : -1;
    }

    public ScrabbleSetTile findTile(char key) {
        return tiles.stream().filter(t -> t.getKey() == key).findFirst().orElse(null);
    }

    public void processUsedTiles(String input) {
        for (char key : input.toCharArray()) {
            useTile(key);
        }
    }

    public void useTile(char key) {
        useTile(key, 1);
    }

    public void useTile(char key, int amount) {
        tiles.stream().filter(t -> t.getKey() == key).forEach(t -> t.decrease(amount));
    }

    public ScrabbleSetTilesReport generateTilesReport() {

        // find all tiles in error state
        Set<Character> tilesInErrorState = tiles.stream().filter(t -> !t.isValid()).map(t -> t.getKey()).collect(Collectors.toSet());

        // group tiles by available count, descending
        NavigableMap<Integer, Set<Character>> tilesByAvailabilityCount = tiles.stream().filter(t -> t.isValid())
                .collect(Collectors.toMap((ScrabbleSetTile t) -> t.getAvailable(), (ScrabbleSetTile t) -> {
                    Set<Character> set = new TreeSet<Character>();
                    set.add(t.getKey());
                    return set;
                } , (Set<Character> a, Set<Character> b) -> {
                    a.addAll(b);
                    return a;
                } , TreeMap::new)).descendingMap();

        // done
        return new ScrabbleSetTilesReport(tilesByAvailabilityCount, tilesInErrorState);
    }
}
