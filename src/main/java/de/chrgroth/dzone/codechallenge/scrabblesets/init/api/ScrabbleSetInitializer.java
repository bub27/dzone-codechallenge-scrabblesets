package de.chrgroth.dzone.codechallenge.scrabblesets.init.api;

import java.util.Set;

import de.chrgroth.dzone.codechallenge.scrabblesets.model.ScrabbleSetTile;

public interface ScrabbleSetInitializer {
    Set<ScrabbleSetTile> createData();
}
