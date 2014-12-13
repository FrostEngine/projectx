package projectx.ohhi;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Rommert on 30-11-2014.
 */
public class OhHiSolverTest {

    OhHiSolver solver = new OhHiSolver();

    @Test
    public void horizontalTwinLeftTest() {
        OhHiPuzzle actual;
        OhHiPuzzle initial = new OhHiPuzzle(".b.rr..r");

        actual = solver.determineNextState(initial);
        OhHiPuzzle expected = new OhHiPuzzle(".bbrr..r");
        assertEquals(expected, actual);
    }

    @Test
    public void horizontalTwinRightTest() {
        OhHiPuzzle actual;
        OhHiPuzzle initial = new OhHiPuzzle("rbbrr..r");

        actual = solver.determineNextState(initial);
        OhHiPuzzle expected = new OhHiPuzzle("rbbrrb.r");
        assertEquals(expected, actual);
    }

    @Test
    public void totalRowTest() {
        OhHiPuzzle actual;
        OhHiPuzzle initial = new OhHiPuzzle("b..rr..r");

        OhHiPuzzle expected = new OhHiPuzzle("brbrrbbr");
        actual = solver.solve(initial);
        assertEquals(expected, actual);
    }

}
