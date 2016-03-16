package com.cs2114.simonsays;

// -------------------------------------------------------------------------
/**
 *  This is the base code for the simon says game.
 *  This class handles all the funcions of the game that are not visual.
 *
 *  @author Cameron Byers
 *  @version Dec 3, 2014
 */
public class SimonSays
{
    /**
     * The array that holds the colors that simon chooses
     */
    int[] simon;
    /**
     * The array that holds the colors that you choose
     */
    int[] player;
    /**
     * The level that you are currently on
     */
    int level;

    // ----------------------------------------------------------
    /**
     * Create a new SimonSays object.
     * @param n the level you are on
     */
    public SimonSays(int n)
    {
        level = n;
        simon = new int[level];
        player = new int[level];
    }

    // ----------------------------------------------------------
    /**
     * Adds a number that represents a color to the simon array.
     * @param space place in the array
     * @param color number that represents a color
     */
    public void simonAdd(int space, int color)
    {
        simon[space] = color;
    }

    // ----------------------------------------------------------
    /**
     * Adds a number that represents a color to the user array..
     * @param space place in the array
     * @param color number that represents a color
     */
    public void playerAdd(int space, int color)
    {
        player[space] = color;
    }

    // ----------------------------------------------------------
    /**
     * Compares the values of the simon array and user array to see if they all
     * match.
     * @return true if they are the same false otherwise
     */
    public boolean compare()
    {
        int count = 0;

        for (int i = 0; i < simon.length; i++)
        {
            if (simon[i] == player[i])
            {
                count++;
            }
        }

        if (count == simon.length)
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}
