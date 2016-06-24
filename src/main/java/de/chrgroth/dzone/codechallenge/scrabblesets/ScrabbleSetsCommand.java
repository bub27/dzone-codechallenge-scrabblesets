package de.chrgroth.dzone.codechallenge.scrabblesets;

import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import de.chrgroth.dzone.codechallenge.scrabblesets.init.ScrabbleSetEnglishEditionInitializer;
import de.chrgroth.dzone.codechallenge.scrabblesets.model.ScrabbleSet;
import de.chrgroth.dzone.codechallenge.scrabblesets.model.ScrabbleSetTilesReport;

public class ScrabbleSetsCommand {

    public static void main(String[] args) {

        // get input data
        String input;
        if (args == null || args.length != 1) {
            System.err.println("please pass input data as parameter!!");
        }
        input = args[0];

        // process
        processInput(input);
    }

    public static void processInput(String input) {

        // initialize new set
        ScrabbleSet scrabbleSet = ScrabbleSet.build(new ScrabbleSetEnglishEditionInitializer());

        // process input
        scrabbleSet.processUsedTiles(input);

        // generate report and print to sysout
        ScrabbleSetTilesReport tilesReport = scrabbleSet.generateTilesReport();
        printReport(tilesReport);
    }

    public static void printReport(ScrabbleSetTilesReport tilesReport) {

        // check for error state
        Set<Character> tilesInErrorState = tilesReport.getTilesInErrorState();
        if (tilesInErrorState != null && !tilesInErrorState.isEmpty()) {
            for (Character key : tilesInErrorState) {
                System.out.println(String.format("Invalid input. More %s's have been taken from the bag than possible.", key));
            }
        } else {

            // print tiles grouped by remaining availability
            for (Entry<Integer, Set<Character>> entry : tilesReport.getTilesByAvailabilityCount().entrySet()) {
                System.out.println(String.format("%d: %s", entry.getKey(), entry.getValue().stream().map(k -> k.toString()).collect(Collectors.joining(", "))));
            }
        }
    }
}
