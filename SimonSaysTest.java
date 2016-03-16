package com.cs2114.simonsays;

// -------------------------------------------------------------------------
/**
 *  Test class for the simonsays class.
 *  Tests all the methods in the simonsays class.
 *
 *  @author Cameron Byers
 *  @version Dec 3, 2014
 */
public class SimonSaysTest
    extends student.TestCase
{

    private SimonSays s;

    protected void setUp()
        throws Exception
    {
        s = new SimonSays(2);
    }

    // ----------------------------------------------------------
    /**
     * Tests the simonAdd method.
     */
    public void testSimonAdd()
    {
        s.simonAdd(0, 0);
        s.simonAdd(1, 1);
        assertEquals(s.simon[0], 0);
        assertEquals(s.simon[1], 1);
    }

    // ----------------------------------------------------------
    /**
     * Tests the playerAdd method.
     */
    public void testPlayerAdd()
    {
        s.playerAdd(0, 0);
        s.playerAdd(1, 1);
        assertEquals(s.player[0], 0);
        assertEquals(s.player[1], 1);
    }

    // ----------------------------------------------------------
    /**
     * Tests the compare method.
     */
    public void testCompare()
    {
        s.simonAdd(0, 0);
        s.simonAdd(1, 1);
        s.playerAdd(0, 0);
        s.playerAdd(1, 1);
        assertTrue(s.compare());
    }
}
