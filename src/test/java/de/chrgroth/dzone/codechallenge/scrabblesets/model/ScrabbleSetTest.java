package de.chrgroth.dzone.codechallenge.scrabblesets.model;

import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.chrgroth.dzone.codechallenge.scrabblesets.init.ScrabbleSetEnglishEditionInitializer;

public class ScrabbleSetTest {

    private ScrabbleSet scrabbleSet;

    @Before
    public void setup() {
        scrabbleSet = ScrabbleSet.build(new ScrabbleSetEnglishEditionInitializer());
    }

    @Test
    public void testDataInit() {
        Assert.assertEquals(scrabbleSet.getAvailable('A'), 9);
        Assert.assertEquals(scrabbleSet.getAvailable('B'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('C'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('D'), 4);
        Assert.assertEquals(scrabbleSet.getAvailable('E'), 12);
        Assert.assertEquals(scrabbleSet.getAvailable('F'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('G'), 3);
        Assert.assertEquals(scrabbleSet.getAvailable('H'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('I'), 9);
        Assert.assertEquals(scrabbleSet.getAvailable('J'), 1);
        Assert.assertEquals(scrabbleSet.getAvailable('K'), 1);
        Assert.assertEquals(scrabbleSet.getAvailable('L'), 4);
        Assert.assertEquals(scrabbleSet.getAvailable('M'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('N'), 6);
        Assert.assertEquals(scrabbleSet.getAvailable('O'), 8);
        Assert.assertEquals(scrabbleSet.getAvailable('P'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('Q'), 1);
        Assert.assertEquals(scrabbleSet.getAvailable('R'), 6);
        Assert.assertEquals(scrabbleSet.getAvailable('S'), 4);
        Assert.assertEquals(scrabbleSet.getAvailable('T'), 6);
        Assert.assertEquals(scrabbleSet.getAvailable('U'), 4);
        Assert.assertEquals(scrabbleSet.getAvailable('V'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('W'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('X'), 1);
        Assert.assertEquals(scrabbleSet.getAvailable('Y'), 2);
        Assert.assertEquals(scrabbleSet.getAvailable('Z'), 1);
        Assert.assertEquals(scrabbleSet.getAvailable('_'), 2);
    }

    @Test
    public void testUseTileOnce() {
        scrabbleSet.useTile('A');
        Assert.assertEquals(scrabbleSet.getAvailable('A'), 8);
    }

    @Test
    public void testUseTileMultipleTImes() {
        scrabbleSet.useTile('A', 5);
        Assert.assertEquals(scrabbleSet.getAvailable('A'), 4);
    }

    @Test
    public void testPocessUsedTiles() {
        scrabbleSet.processUsedTiles("ABCACAZZ");
        Assert.assertEquals(scrabbleSet.getAvailable('A'), 6);
        Assert.assertEquals(scrabbleSet.getAvailable('B'), 1);
        Assert.assertEquals(scrabbleSet.getAvailable('C'), 0);
        Assert.assertEquals(scrabbleSet.getAvailable('Z'), -1);
    }

    @Test
    public void testTileValidity() {
        Assert.assertTrue(scrabbleSet.findTile('Z').isValid());
        scrabbleSet.useTile('Z');
        Assert.assertTrue(scrabbleSet.findTile('Z').isValid());
        scrabbleSet.useTile('Z');
        Assert.assertFalse(scrabbleSet.findTile('Z').isValid());
    }

    @Test
    public void testDzoneInputOne() {

        // process
        scrabbleSet.processUsedTiles("PQAREIOURSTHGWIOAE_");
        ScrabbleSetTilesReport report = scrabbleSet.generateTilesReport();
        Assert.assertNotNull(report);

        // check report errors
        Set<Character> tilesInErrorState = report.getTilesInErrorState();
        Assert.assertNotNull(tilesInErrorState);
        Assert.assertTrue(tilesInErrorState.isEmpty());

        // check report data
        NavigableMap<Integer, Set<Character>> tilesByAvailabilityCount = report.getTilesByAvailabilityCount();
        Assert.assertNotNull(tilesByAvailabilityCount);
        Assert.assertFalse(tilesByAvailabilityCount.isEmpty());
        Assert.assertEquals(tilesByAvailabilityCount.remove(10), treeSet('E'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(7), treeSet('A', 'I'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(6), treeSet('N', 'O'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(5), treeSet('T'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(4), treeSet('D', 'L', 'R'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(3), treeSet('S', 'U'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(2), treeSet('B', 'C', 'F', 'G', 'M', 'V', 'Y'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(1), treeSet('H', 'J', 'K', 'P', 'W', 'X', 'Z', '_'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(0), treeSet('Q'));
        Assert.assertTrue(tilesByAvailabilityCount.isEmpty());
    }

    @Test
    public void testDzoneInputTwo() {

        // process
        scrabbleSet.processUsedTiles("LQTOONOEFFJZT");
        ScrabbleSetTilesReport report = scrabbleSet.generateTilesReport();
        Assert.assertNotNull(report);

        // check report errors
        Set<Character> tilesInErrorState = report.getTilesInErrorState();
        Assert.assertNotNull(tilesInErrorState);
        Assert.assertTrue(tilesInErrorState.isEmpty());

        // check report data
        NavigableMap<Integer, Set<Character>> tilesByAvailabilityCount = report.getTilesByAvailabilityCount();
        Assert.assertNotNull(tilesByAvailabilityCount);
        Assert.assertFalse(tilesByAvailabilityCount.isEmpty());
        Assert.assertEquals(tilesByAvailabilityCount.remove(11), treeSet('E'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(9), treeSet('A', 'I'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(6), treeSet('R'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(5), treeSet('N', 'O'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(4), treeSet('D', 'S', 'T', 'U'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(3), treeSet('G', 'L'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(2), treeSet('B', 'C', 'H', 'M', 'P', 'V', 'W', 'Y', '_'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(1), treeSet('K', 'X'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(0), treeSet('F', 'J', 'Q', 'Z'));
        Assert.assertTrue(tilesByAvailabilityCount.isEmpty());
    }

    @Test
    public void testDzoneInputThree() {

        // process
        scrabbleSet.processUsedTiles("AXHDRUIOR_XHJZUQEE");
        ScrabbleSetTilesReport report = scrabbleSet.generateTilesReport();
        Assert.assertNotNull(report);

        // check report errors
        Set<Character> tilesInErrorState = report.getTilesInErrorState();
        Assert.assertNotNull(tilesInErrorState);
        Assert.assertFalse(tilesInErrorState.isEmpty());
        Assert.assertTrue(tilesInErrorState.remove('X'));
        Assert.assertTrue(tilesInErrorState.isEmpty());

        // check report data
        NavigableMap<Integer, Set<Character>> tilesByAvailabilityCount = report.getTilesByAvailabilityCount();
        Assert.assertNotNull(tilesByAvailabilityCount);
        Assert.assertFalse(tilesByAvailabilityCount.isEmpty());
        Assert.assertEquals(tilesByAvailabilityCount.remove(10), treeSet('E'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(8), treeSet('A', 'I'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(7), treeSet('O'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(6), treeSet('N', 'T'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(4), treeSet('L', 'R', 'S'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(3), treeSet('D', 'G'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(2), treeSet('B', 'C', 'F', 'M', 'P', 'U', 'V', 'W', 'Y'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(1), treeSet('K', '_'));
        Assert.assertEquals(tilesByAvailabilityCount.remove(0), treeSet('H', 'J', 'Q', 'Z'));
        Assert.assertTrue(tilesByAvailabilityCount.isEmpty());
    }

    private TreeSet<Character> treeSet(char... chars) {
        TreeSet<Character> data = new TreeSet<>();
        for (char c : chars) {
            data.add(c);
        }
        return data;
    }
}
