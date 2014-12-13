package projectx.ohhi;

import java.util.Collections;
import java.util.List;

public class OhHiSolver {

    public static void main(String... args) {
        OhHiSolver solver = new OhHiSolver();


        OhHiPuzzle puzzle = new OhHiPuzzle(".r.b",
                ".r..",
                "....",
                "b...");

        OhHiPuzzle solution = solver.solve(puzzle);
        System.out.println(solution.toString());
    }

    public OhHiPuzzle solve(OhHiPuzzle puzzle) {
        while (!puzzle.isDone()) {
            String initialSignature = puzzle.getSignature();
            puzzle = determineNextState(puzzle);
            if (puzzle.getSignature().equals(initialSignature)) {
                System.out.println("no further progress, exiting...");
                return puzzle;
            }
        }
        return puzzle;

    }

    OhHiPuzzle determineNextState(OhHiPuzzle puzzle) {
        String initialSignature = puzzle.getSignature();
        puzzle = doChecks(puzzle);

        if (puzzle.getSignature().equals(initialSignature)) { // still no fix? Rotate 90 degrees and try again

            puzzle = puzzle.rotateClockWise();

            puzzle = doChecks(puzzle);

            puzzle.rotateCounterClockWise(); // rotate back for good measure :)
        }
        return puzzle;
    }

    private OhHiPuzzle doChecks(OhHiPuzzle puzzle) {
        String initialSignature = puzzle.getSignature();
        puzzle = doTwinCheck(puzzle);

        if (puzzle.getSignature().equals(initialSignature)) {
            puzzle = doGapCheck(puzzle);
        }

        if (puzzle.getSignature().equals(initialSignature)) {
            puzzle = doCountCheck(puzzle);
        }
        return puzzle;
    }

    private OhHiPuzzle doCountCheck(OhHiPuzzle puzzle) {
        return puzzle;
    }

    private OhHiPuzzle doGapCheck(OhHiPuzzle puzzle) {
        return puzzle;
    }

    private OhHiPuzzle doTwinCheck(OhHiPuzzle puzzle) {
        String initialSignature = puzzle.getSignature();
        doTwinPass(puzzle);

        if (puzzle.getSignature().equals(initialSignature)) {
            puzzle = puzzle.mirrorLeftToRight();
            puzzle = doTwinPass(puzzle);
            puzzle = puzzle.mirrorLeftToRight();
        }
        return puzzle;
    }

    private OhHiPuzzle doTwinPass(OhHiPuzzle puzzle) {
        for (List<OhHiBlock> row: puzzle.getRows()) {
            List<OhHiBlock> initial = Collections.unmodifiableList(row);
            row = fixTwins(row);
            if (!row.equals(initial)) {
                return puzzle;
            }
        }
        return puzzle;
    }

    private List<OhHiBlock> fixTwins(List<OhHiBlock> row) {
        OhHiBlock twoLeft = null;
        OhHiBlock left = null;
        for (OhHiBlock block : row) {
            if (twoLeft != null && twoLeft.isEmpty() &&
                    left != null && !left.isEmpty() &&
                    left.getBlockColor().equals(block.getBlockColor())) {
                twoLeft.setBlockColor(BlockColor.getInverseColor(block.getBlockColor()));
                break;
            }
            twoLeft = left;
            left = block;
        }
        return row;
    }
}

