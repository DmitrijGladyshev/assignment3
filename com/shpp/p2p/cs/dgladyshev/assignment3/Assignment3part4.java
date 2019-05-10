package com.shpp.p2p.cs.dgladyshev.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3part4 extends WindowProgram {

    /**
     * Here we can change sizes of our bricks
     */
    private static final int BRICK_HEIGHT = 40;
    private static final int BRICK_WIDTH = 80;

    /**
     * Here we can change quantity of our bricks in base
     * For better readability of code added NUM_ROW
     */
    private static final int BRICKS_IN_BASE = 7;
    private static final int NUM_ROWS = BRICKS_IN_BASE;

    /**
     * Here some settings. Sizes of program window
     */
    public static final int APPLICATION_WIDTH = BRICK_WIDTH * (BRICKS_IN_BASE + 1);
    public static final int APPLICATION_HEIGHT = BRICK_HEIGHT * (BRICKS_IN_BASE + 1);

    /**
     * We can use that link for using it further
     */
    GRect[][] pyramid = new GRect[NUM_ROWS][NUM_ROWS];

    /**
     * It prints centred pyramid with entered quantity of bricks in base
     * for each row of bricks becomes less by 1
     */
    public void run() {
        double topindent = getHeight() - NUM_ROWS * BRICK_HEIGHT;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < (1 + row); col++) {
                double leftindent = (getWidth() - ((1 + row) * BRICK_WIDTH)) / 2.0;
                pyramid[row][col] = putBrick((leftindent + col * BRICK_WIDTH), (topindent + row * BRICK_HEIGHT));
            }
        }
    }

    /**
     * Simple constructor which prints each brick.
     *
     * @param x x cooordinates (left indent + number this brick in the row (col) * brick width)
     * @param y y coordinates (top indent + number of this row * brick height)
     * @return brick like object
     */
    private GRect putBrick(double x, double y) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);

        brick.setColor(Color.BLACK);
        brick.setFilled(true);
        brick.setFillColor(Color.YELLOW);

        add(brick);
        return brick;
    }
}
