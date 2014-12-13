package projectx.ohhi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rommert on 13-12-2014.
 */
public class OhHiPuzzleTest {

    @Test
    public void testMirror() {
        OhHiPuzzle puzzle = new OhHiPuzzle("rbbr",
                "brrb",
                "brbr",
                "rbrb");
        OhHiPuzzle expected = new OhHiPuzzle("rbbr",
                "brrb",
                "rbrb",
                "brbr");
        assertEquals(expected, puzzle.mirrorLeftToRight());
    }

    @Test
    public void testMirrorReflection() {
        OhHiPuzzle puzzle = new OhHiPuzzle("rbbr",
                "brrb",
                "brbr",
                "rbrb");
        assertEquals(puzzle, puzzle.mirrorLeftToRight().mirrorLeftToRight());
    }

    @Test
    public void testRotationClockWise() {
        //   rrrr     bbbr
        //   bbbb     bbbr
        //   bbbr ==> bbbr
        //   bbbr     rrbr
        OhHiPuzzle puzzle = new OhHiPuzzle( "rrrr",
                                            "bbbb",
                                            "bbbr",
                                            "bbbr");
        OhHiPuzzle expected = new OhHiPuzzle("bbbr",
                                            "bbbr",
                                            "bbbr",
                                            "rrbr");
        assertEquals(expected, puzzle.rotateClockWise());
    }

    @Test
    public void testRotationCounterClockWise() {
        //   rrrr     rbrr
        //   bbbb     rbbb
        //   bbbr ==> rbbb
        //   bbbr     rbbb
        OhHiPuzzle puzzle = new OhHiPuzzle( "rrrr",
                                            "bbbb",
                                            "bbbr",
                                            "bbbr");
        OhHiPuzzle expected = new OhHiPuzzle("rbrr",
                                            "rbbb",
                                            "rbbb",
                                            "rbbb");
        assertEquals(expected, puzzle.rotateCounterClockWise());
    }

    @Test
    public void testRotationReflection() {
        OhHiPuzzle puzzle = new OhHiPuzzle("rbbr",
                "brrb",
                "brbr",
                "rbrb");
        assertEquals(puzzle, puzzle.rotateClockWise().rotateCounterClockWise());
        assertEquals(puzzle, puzzle.rotateCounterClockWise().rotateClockWise());
    }

    @Test
    public void testSignature() {
        OhHiPuzzle puzzle = new OhHiPuzzle("rbbr",
                "brrb",
                "brbr",
                "rbrb");
        String expected = "rbbrbrrbbrbrrbrb";
        assertEquals(expected, puzzle.getSignature());
    }
}
