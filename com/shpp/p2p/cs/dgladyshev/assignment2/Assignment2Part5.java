package com.shpp.p2p.cs.dgladyshev.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


public class Assignment2Part5 extends WindowProgram {

    /**
     * Here we can change sizes of program window
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    /**
     * The number of rows and columns in the grid, respectively.
     */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /**
     * The width and height of each box.
     */
    private static final double BOX_SIZE = 40;

    /**
     * The horizontal and vertical spacing between the boxes.
     */
    private static final double BOX_SPACING = 10;

    /**
     * We have to print some "optic illusion" which is a grid of some squares
     * We have 5 rows and 6 columns (or can change it :) )
     * put it in the centre of our window
     */
    public void run() {
        /*check our margin left (x) and margin top (y) */
        double x = (getWidth() - ((NUM_COLS * BOX_SIZE) + ((NUM_COLS - 1) * BOX_SPACING))) / 2.0;
        double y = (getHeight() - ((NUM_ROWS * BOX_SIZE) + ((NUM_ROWS - 1) * BOX_SPACING))) / 2.0;
        double dist = (BOX_SIZE + BOX_SPACING);

        printGrid(x, y, dist);     //set our squares and print that all
    }

    /**
     * Print our grid depends margins top (y) and left (x)
     *
     * @param x    - margin left
     * @param y    - margin top
     * @param dist - distance for next box
     */
    private void printGrid(double x, double y, double dist) {
        for (int i = 0; i < NUM_ROWS; i++) {                //continue while all rows will be filled
            printRow(x, y, dist, i);
        }
    }

    /**
     * Fill rows depends parameters:
     *
     * @param x    - x coordinate
     * @param y    - y coordinate
     * @param dist - distance for next box
     * @param row  - number of row
     */
    private void printRow(double x, double y, double dist, int row) {
        for (int i = 0; i < NUM_COLS; i++) {
            GRect rect = new GRect(x + i * dist, y + row * dist, BOX_SIZE, BOX_SIZE);
            rect.setColor(Color.BLACK);
            rect.setFilled(true);
            rect.setFillColor(Color.BLACK);
            add(rect);
        }
    }
}


