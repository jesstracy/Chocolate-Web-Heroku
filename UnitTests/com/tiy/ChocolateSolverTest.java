package com.tiy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jessicatracy on 9/22/16.
 */
public class ChocolateSolverTest {
    ChocolateSolver solver;
    ChocolateSolution solution;

    @Before
    public void setUp() throws Exception {
        solver = new ChocolateSolver();
        solution = new ChocolateSolution();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMisc2() throws Exception {
        solution = solver.makeChocolate(12, 5, 19);
        assertEquals(4, solution.smalls);
        assertEquals(3, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void testEnoughSmallsNoBigs2() throws Exception {
        solution = solver.makeChocolate(12, 0, 7);
        assertEquals(7, solution.smalls);
        assertEquals(0, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void testEnoughBigsNoSmalls2() throws Exception {solution = solver.makeChocolate(0, 2, 10);
        assertEquals(0, solution.smalls);
        assertEquals(2, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void testNoBigsNoSmallsEqualsZero2() throws Exception {solution = solver.makeChocolate(0, 0, 0);
        assertEquals(0, solution.smalls);
        assertEquals(0, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void testNoBigsNoSmallsEqualsOne2() throws Exception {solution = solver.makeChocolate(0, 0, 1);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void enoughBigsEnoughSmalls2() throws Exception {
        solution = solver.makeChocolate(9, 3, 19);
        assertEquals(4, solution.smalls);
        assertEquals(3, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void negativeBigs2() throws Exception {
        solution = solver.makeChocolate(2, -5, 25);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void negativeSmalls2() throws Exception {
        solution = solver.makeChocolate(-3, 1, 8);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void negativeSmallsWithLargeNumberBigs2() throws Exception {
        solution = solver.makeChocolate(-3, 51, 8);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void moreBigsThanNeededPossible2() throws Exception {
        solution = solver.makeChocolate(3, 4, 12);
        assertEquals(2, solution.smalls);
        assertEquals(2, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void moreBigsThanNeededNotPossible2() throws Exception {
        solution = solver.makeChocolate(2, 6, 18);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void enoughSmallsNotEnoughBigsButNotZero2() throws Exception {
        solution = solver.makeChocolate(30, 1, 11);
        assertEquals(6, solution.smalls);
        assertEquals(1, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void sameAmountOfSmallsAsBigs2() throws Exception {
        solution = solver.makeChocolate(15, 3, 15);
        assertEquals(0, solution.smalls);
        assertEquals(3, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void moreSmallsAndBigsThanGoal2() throws Exception {
        solution = solver.makeChocolate(7, 2, 1);
        assertEquals(1, solution.smalls);
        assertEquals(0, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void goalZeroEnoughBigsEnoughSmalls2() throws Exception {
        solution = solver.makeChocolate(7, 2, 0);
        assertEquals(0, solution.smalls);
        assertEquals(0, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void notEnoughSmallsNotEnoughBigs2() throws Exception {
        solution = solver.makeChocolate(17, 3, 100);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void lotsOfSmallsButCanBeDoneWithBigs2() throws Exception {
        solution = solver.makeChocolate(100, 20, 100);
        assertEquals(0, solution.smalls);
        assertEquals(20, solution.bigs);
        assertTrue(solution.hasSolution);
    }
//
    @Test
    public void lotsOfSmallsCantBeDoneWithOnlyBigs2() throws Exception {
        solution = solver.makeChocolate(75, 2, 70);
        assertEquals(60, solution.smalls);
        assertEquals(2, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void lotsOfSmallsNoBigs2() throws Exception {
        solution = solver.makeChocolate(75, 0, 70);
        assertEquals(70, solution.smalls);
        assertEquals(0, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void exactNumberWorks2() throws Exception {
        solution = solver.makeChocolate(5, 4, 25);
        assertEquals(5, solution.smalls);
        assertEquals(4, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void notEnoughBigsAlmostEnoughSmall2() throws Exception {
        solution = solver.makeChocolate(6, 7, 42);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void exampleTestFromSite12() throws Exception {
        solution = solver.makeChocolate(4, 1, 9);
        assertEquals(4, solution.smalls);
        assertEquals(1, solution.bigs);
        assertTrue(solution.hasSolution);
    }

    @Test
    public void exampleTestFromSite22() throws Exception {
        solution = solver.makeChocolate(4, 1, 10);
        assertEquals(-1, solution.smalls);
        assertEquals(-1, solution.bigs);
        assertFalse(solution.hasSolution);
    }

    @Test
    public void exampleTestFromSite32() throws Exception {
        solution = solver.makeChocolate(4, 1, 7);
        assertEquals(2, solution.smalls);
        assertEquals(1, solution.bigs);
        assertTrue(solution.hasSolution);
    }

}