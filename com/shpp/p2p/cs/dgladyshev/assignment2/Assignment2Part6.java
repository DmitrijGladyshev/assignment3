package com.shpp.p2p.cs.dgladyshev.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


public class Assignment2Part6 extends WindowProgram {

    /*Here we can change sizes of program window*/
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 200;

    /* The number of caterpillars segment */
    private static final int NUM_SEGMENTS = 7;

    /* The size of each caterpillars segment. */
    private static final double SEGMENT_SIZE = 100;

    /**
     * in this program we must create some caterpillar
     * I want to make it green with yellow lights;)
     * With black frames and eyes )
     * Check the positions and make some checker for caterpillar length
     * when printing segments. Then print eyes.
     */
    public void run() {
        double x = 0;
        double y = 0;
        for (int i = 0; i < NUM_SEGMENTS; i++) {
            x = i * (SEGMENT_SIZE * 2 / 3.0);
            y = (i % 2 == 0) ? 0 : SEGMENT_SIZE / 3.0;
            printSegments(x, y);
        }
        printEyes(x, y);
    }

    /**
     * print one segment and make some lights
     *
     * @param x x coordinates
     * @param y y coordinates
     */
    private void printSegments(double x, double y) {
        drawCircle(x,
                y,
                SEGMENT_SIZE,
                SEGMENT_SIZE,
                Color.BLACK,
                Color.GREEN);
        double lightSize = SEGMENT_SIZE * 75 / 100.0;
        drawCircle(x + ((SEGMENT_SIZE - lightSize) / 2.0),
                y + (SEGMENT_SIZE * 5 / 100.0),
                lightSize,
                lightSize,
                Color.YELLOW,
                Color.YELLOW);
    }

    /**
     * Print eyes. Decided that eye size = 1/5 of segment size
     * Eyes positions looks like (_O_O_)
     *
     * @param x eyes x coordinates
     * @param y eyes y coordinates
     */
    private void printEyes(double x, double y) {
        double eyesSize = SEGMENT_SIZE / 5;
        drawCircle(x + eyesSize,
                y + eyesSize * 3 / 2.0,
                eyesSize,
                eyesSize,
                Color.BLACK,
                Color.BLACK);
        drawCircle(x + eyesSize * 3.0,
                y + eyesSize * 3 / 2.0,
                eyesSize,
                eyesSize,
                Color.BLACK,
                Color.BLACK);
    }

    /**
     * Draw circle with parameters and add it to desc
     *
     * @param x                 coordinate of left angle
     * @param y                 coordinate of top angle
     * @param segmentSize       size of circle
     * @param secondSegmentSize size of smallest circle
     * @param circleColor       color of circle
     * @param fillColor         fill color
     */
    private void drawCircle(double x,
                            double y,
                            double segmentSize,
                            double secondSegmentSize,
                            Color circleColor,
                            Color fillColor) {
        GOval oval = new GOval(x, y, segmentSize, secondSegmentSize);
        oval.setColor(circleColor);
        oval.setFilled(true);
        oval.setFillColor(fillColor);
        add(oval);
    }
}



