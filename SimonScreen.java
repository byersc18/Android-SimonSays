package com.cs2114.simonsays;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import android.widget.Button;
import android.widget.TextView;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 *  This class represents the screen of the simon app.
 *  Handles the visual functions of the simon says game.
 *
 *  @author Cameron Byers
 *  @version Dec 3, 2014
 */
public class SimonScreen
    extends ShapeScreen
{
    /**
     * This is the SimonSays variable
     */
    SimonSays simon;

    /**
     * This shows the level you are on
     */
    TextView level;

    /**
     * This variable represents the start button on the screen
     */
    Button start;

    /**
     * This variable is a counter so it correctly adds colors to the proper
     * spots in the arrays
     */
    int counter;

    public void initialize()
    {
        simon = new SimonSays(1);
        counter = 0;

        level.setText("1");

        RectangleShape greenTile = new RectangleShape(0, 0, getWidth() / 2,
            getHeight() / 2);
        add(greenTile);
        greenTile.setFillColor(Color.green);

        RectangleShape redTile = new RectangleShape(getWidth() / 2, 0,
            getWidth(), getHeight() / 2);
        add(redTile);
        redTile.setFillColor(Color.red);

        RectangleShape yellowTile = new RectangleShape(0, getHeight() / 2,
            getWidth() / 2, getHeight());
        add(yellowTile);
        yellowTile.setFillColor(Color.yellow);

        RectangleShape blueTile = new RectangleShape(getWidth() / 2, getHeight()
            / 2,
            getWidth(), getHeight());
        add(blueTile);
        blueTile.setFillColor(Color.blue);
    }

    // ----------------------------------------------------------
    /**
     * Draws a green square.
     */
    public void drawGreen()
    {
        RectangleShape greenTile = new RectangleShape(0, 0, getWidth() / 2,
            getHeight() / 2);
        add(greenTile);
        greenTile.setFillColor(Color.green);
    }

    // ----------------------------------------------------------
    /**
     * Draws a red square.
     */
    public void drawRed()
    {
        RectangleShape redTile = new RectangleShape(getWidth() / 2, 0,
            getWidth(), getHeight() / 2);
        add(redTile);
        redTile.setFillColor(Color.red);
    }

    // ----------------------------------------------------------
    /**
     * Draws a yellow square.
     */
    public void drawYellow()
    {
        RectangleShape yellowTile = new RectangleShape(0, getHeight() / 2,
            getWidth() / 2, getHeight());
        add(yellowTile);
        yellowTile.setFillColor(Color.yellow);
    }

    // ----------------------------------------------------------
    /**
     * Draws a blue square.
     */
    public void drawBlue()
    {
        RectangleShape blueTile = new RectangleShape(getWidth() / 2, getHeight()
            / 2,
            getWidth(), getHeight());
        add(blueTile);
        blueTile.setFillColor(Color.blue);
    }

    // ----------------------------------------------------------
    /**
     * This shows the colors that simon chooses and waits for you to match it.
     * @throws InterruptedException
     */
    public void startClicked() throws InterruptedException
    {
        for (int i = 0; i < simon.level; i++)
        {
            int x = (int)(Math.random() * 4);
            simon.simonAdd(i, x);
            if (x == 0)
            {
                RectangleShape blackTile = new RectangleShape(0, 0, getWidth()
                    / 2,
                    getHeight() / 2);
                add(blackTile);
                blackTile.setFillColor(Color.black);
                Thread.sleep(1000);
                drawGreen();
                Thread.sleep(500);
            }

            else if (x == 1)
            {
                RectangleShape blackTile = new RectangleShape(getWidth() / 2, 0,
                    getWidth(), getHeight() / 2);
                add(blackTile);
                blackTile.setFillColor(Color.black);
                Thread.sleep(1000);
                drawRed();
                Thread.sleep(500);
            }

            else if (x == 2)
            {
                RectangleShape blackTile = new RectangleShape(0, getHeight()
                    / 2,
                    getWidth() / 2, getHeight());
                add(blackTile);
                blackTile.setFillColor(Color.black);
                Thread.sleep(1000);
                drawYellow();
                Thread.sleep(500);
            }

            else
            {
                RectangleShape blackTile = new RectangleShape(getWidth() / 2,
                    getHeight() / 2,
                    getWidth(), getHeight());
                add(blackTile);
                blackTile.setFillColor(Color.black);
                Thread.sleep(1000);
                drawBlue();
                Thread.sleep(500);
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Adds the colors to the user array and when your done choosing colors it
     * compares the two arrays to see if they match. If they do match then it
     * increases the level. If not the level goes back to 1.
     * @param x x coordinate
     * @param y y coordinate
     */
    public void onTouchDown(float x, float y)
    {
        int xCoor = (int)(x / (getWidth() / 2));
        int yCoor = (int)(y / (getHeight() / 2));

        if (xCoor == 0 && yCoor == 0)
        {
            simon.playerAdd(counter, 0);
            counter++;
            if (counter == simon.level)
            {
                if (simon.compare())
                {
                    level.setText(Integer.toString(simon.level + 1));
                    simon = new SimonSays(simon.level + 1);
                    counter = 0;
                }
                else
                {
                    level.setText("1");
                    simon = new SimonSays(1);
                    counter = 0;
                }
            }
        }

        else if (xCoor == 1 && yCoor == 0)
        {
            simon.playerAdd(counter, 1);
            counter++;
            if (counter == simon.level)
            {
                if (simon.compare())
                {
                    level.setText(Integer.toString(simon.level + 1));
                    simon = new SimonSays(simon.level + 1);
                    counter = 0;
                }
                else
                {
                    level.setText("1");
                    simon = new SimonSays(1);
                    counter = 0;
                }
            }
        }

        else if (xCoor == 0 && yCoor == 1)
        {
            simon.playerAdd(counter, 2);
            counter++;
            if (counter == simon.level)
            {
                if (simon.compare())
                {
                    level.setText(Integer.toString(simon.level + 1));
                    simon = new SimonSays(simon.level + 1);
                    counter = 0;
                }
                else
                {
                    level.setText("1");
                    simon = new SimonSays(1);
                    counter = 0;
                }
            }
        }

        else
        {
            simon.playerAdd(counter, 3);
            counter++;
            if (counter == simon.level)
            {
                if (simon.compare())
                {
                    level.setText(Integer.toString(simon.level + 1));
                    simon = new SimonSays(simon.level + 1);
                    counter = 0;
                }
                else
                {
                    level.setText("1");
                    simon = new SimonSays(1);
                    counter = 0;
                }
            }
        }
    }

}
