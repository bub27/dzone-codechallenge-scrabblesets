package de.chrgroth.dzone.codechallenge.scrabblesets.init;

import java.util.HashSet;
import java.util.Set;

import de.chrgroth.dzone.codechallenge.scrabblesets.init.api.ScrabbleSetInitializer;
import de.chrgroth.dzone.codechallenge.scrabblesets.model.ScrabbleSetTile;

public class ScrabbleSetEnglishEditionInitializer implements ScrabbleSetInitializer {

    @Override
    public Set<ScrabbleSetTile> createData() {
        Set<ScrabbleSetTile> data = new HashSet<>();
        data.add(new ScrabbleSetTile('A', 9));
        data.add(new ScrabbleSetTile('B', 2));
        data.add(new ScrabbleSetTile('C', 2));
        data.add(new ScrabbleSetTile('D', 4));
        data.add(new ScrabbleSetTile('E', 12));
        data.add(new ScrabbleSetTile('F', 2));
        data.add(new ScrabbleSetTile('G', 3));
        data.add(new ScrabbleSetTile('H', 2));
        data.add(new ScrabbleSetTile('I', 9));
        data.add(new ScrabbleSetTile('J', 1));
        data.add(new ScrabbleSetTile('K', 1));
        data.add(new ScrabbleSetTile('L', 4));
        data.add(new ScrabbleSetTile('M', 2));
        data.add(new ScrabbleSetTile('N', 6));
        data.add(new ScrabbleSetTile('O', 8));
        data.add(new ScrabbleSetTile('P', 2));
        data.add(new ScrabbleSetTile('Q', 1));
        data.add(new ScrabbleSetTile('R', 6));
        data.add(new ScrabbleSetTile('S', 4));
        data.add(new ScrabbleSetTile('T', 6));
        data.add(new ScrabbleSetTile('U', 4));
        data.add(new ScrabbleSetTile('V', 2));
        data.add(new ScrabbleSetTile('W', 2));
        data.add(new ScrabbleSetTile('X', 1));
        data.add(new ScrabbleSetTile('Y', 2));
        data.add(new ScrabbleSetTile('Z', 1));
        data.add(new ScrabbleSetTile('_', 2));
        return data;
    }
}
