package projectx.ohhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OhHiPuzzle {
    private List<List<OhHiBlock>> rows = new ArrayList<>();

    public OhHiPuzzle(String... stringRows) {
        Arrays.asList(stringRows).stream()
                .forEach(this::addRow);
    }

    private void addRow(String stringRow) {
        List<OhHiBlock> row = new ArrayList<>();
        for (int i = 0; i < stringRow.length(); i++) {
            row.add(new OhHiBlock("" + stringRow.toCharArray()[i]));
        }
        rows.add(row);
    }

    public boolean isDone() {
        return rows.stream()
                .allMatch(row -> row.stream()
                        .allMatch(b -> !b.isEmpty()));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        rows.stream()
                .forEach(row -> {
                    row.stream().forEach(block -> builder.append(block.toString()));
                    builder.append("\n");
                });
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OhHiPuzzle that = (OhHiPuzzle) o;

        if (rows != null ? !rows.equals(that.rows) : that.rows != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return rows != null ? rows.hashCode() : 0;
    }

    public List<List<OhHiBlock>> getRows() {
        return rows;
    }

    public OhHiPuzzle rotateCounterClockWise() {
        //   rrrr     rbrr
        //   bbbb     rbbb
        //   bbbr ==> rbbb
        //   bbbr     rbbb

        // the first row of the new puzzle will be formed by all
        // last elements of each row of the current puzzle,
        // starting with the top row;

        // the second row of the new puzzle will be formed by all
        // second-to-last elements of each row of the current puzzle,
        // starting with the top row;

        int puzzleSize = getRows().size();
        OhHiPuzzle newPuzzle = new OhHiPuzzle();
        for (int newRowCount = 0;newRowCount < puzzleSize; newRowCount++) {
            List<OhHiBlock> newRow = new ArrayList<>();
            for (int repeatForEachCurrentRow = 0;repeatForEachCurrentRow < puzzleSize; repeatForEachCurrentRow++) {
                newRow.add(getRows().get(repeatForEachCurrentRow).get(puzzleSize-newRowCount-1));
            }

            newPuzzle.getRows().add(newRow);
        }
        return newPuzzle;
    }

    public OhHiPuzzle rotateClockWise() {
        //   rrrr     bbbr
        //   bbbb     bbbr
        //   bbbr ==> bbbr
        //   bbbr     rrbr

        // the first row of the new puzzle will be formed by all
        // first elements of each row of the current puzzle,
        // starting with the bottom row;

        // the second row of the new puzzle will be formed by all
        // second elements of each row of the current puzzle,
        // starting with the bottom row;

        int puzzleSize = getRows().size();
        OhHiPuzzle newPuzzle = new OhHiPuzzle();
        for (int newRowCount = 0;newRowCount < puzzleSize; newRowCount++) {
            List<OhHiBlock> newRow = new ArrayList<>();
            for (int repeatForEachCurrentRow = puzzleSize-1;repeatForEachCurrentRow >=0; repeatForEachCurrentRow--) {
                newRow.add(getRows().get(repeatForEachCurrentRow).get(newRowCount));
            }

            newPuzzle.getRows().add(newRow);
        }
        return newPuzzle;
    }

    public OhHiPuzzle mirrorLeftToRight() {
        getRows().stream().forEach(Collections::reverse);
        return this;
    }

    public String getSignature() {
        StringBuilder builder = new StringBuilder();
        getRows().stream().forEach(row -> row.stream().forEach(block -> builder.append(block.getBlockColor().getColor())));
        return builder.toString();
    }
}
