package com.cs2114.simonsays;

import sofia.graphics.ShapeView;
import android.widget.Button;

// -------------------------------------------------------------------------
/**
 *  This class is the test class for the simonscreen class.
 *  Tests all the methods in the simonscreen class.
 *
 *  @author Cameron Byers
 *  @version Dec 3, 2014
 */
public class SimonScreenTest
    extends student.AndroidTestCase<SimonScreen>
{

    // ----------------------------------------------------------
    /**
     * Create a new SimonScreenTest object.
     */
    public SimonScreenTest()
    {
        super(SimonScreen.class);
        // TODO Auto-generated constructor stub
    }

    private SimonScreen s;
    private Button start;
    private ShapeView shapeView;

    protected void setUp()
        throws Exception
    {
        s = getScreen();
    }

    // ----------------------------------------------------------
    /**
     * Tests the startClicked method.
     */
    public void testStartClicked()
    {
        click(start);
        assertTrue(s.simon.simon[0] >= 0);
    }

    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown method.
     */
    public void testOnTouchDownGreen()
    {
        touchDown(shapeView, 5, 5);
        assertTrue(s.simon.player[0] >= 0);
    }

    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown method.
     */
    public void testOnTouchDownRed()
    {
        touchDown(shapeView, shapeView.getWidth(), shapeView.getHeight());
        assertTrue(s.simon.player[0] >= 0);
    }

    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown method.
     */
    public void testOnTouchDownYellow()
    {
        touchDown(shapeView, 5, shapeView.getHeight());
        assertTrue(s.simon.player[0] >= 0);
    }

    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown method.
     */
    public void testOnTouchDownBlue()
    {
        touchDown(shapeView, shapeView.getWidth(), 5);
        assertTrue(s.simon.player[0] >= 0);
    }
}
