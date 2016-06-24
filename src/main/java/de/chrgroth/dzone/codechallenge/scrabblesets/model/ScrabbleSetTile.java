package de.chrgroth.dzone.codechallenge.scrabblesets.model;

public class ScrabbleSetTile {
    private final char key;
    private int available;

    public ScrabbleSetTile(char key, int available) {
        this.key = key;
        this.available = available;
    }

    public void decrease(int amount) {
        available -= amount;
    }

    public boolean isValid() {
        return available >= 0;
    }

    public char getKey() {
        return key;
    }

    public int getAvailable() {
        return available;
    }
}
