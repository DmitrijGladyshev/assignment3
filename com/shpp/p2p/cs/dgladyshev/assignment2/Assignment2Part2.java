package com.shpp.p2p.cs.dgladyshev.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram {

    /**
     * here we can change sizes of programm window
     */
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    /**
     * Diameter size of ovals
     */
    private static final int DIAMETR = 100;

    /**
     * Must print some circles in the corners of our window
     * And one rectangle with its tops in the centre of previous circles
     */
    public void run() {
        printOvals();
        printRectangle();
    }

    /**
     * make 4 circles in the corners
     * filled with black color
     */
    private void printOvals() {
        double x = 0;
        double y = 0;
        printOval(x, y);
        printOval(getWidth() - DIAMETR, y);
        printOval(x, getHeight() - DIAMETR);
        printOval(getWidth() - DIAMETR, getHeight() - DIAMETR);
    }

    /**
     * Print circle depends coordinates
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    private void printOval(double x, double y) {
        GOval oval = new GOval(x, y, DIAMETR, DIAMETR);
        oval.setColor(Color.BLACK);
        oval.setFilled(true);
        oval.setFillColor(Color.BLACK);
        add(oval);
    }

    /**
     * print rectangle
     * white colour and without frame (white frame)
     */
    private void printRectangle() {
        GRect r = new GRect(DIAMETR / 2, DIAMETR / 2, getWidth() - DIAMETR, getHeight() - DIAMETR);
        r.setColor(Color.WHITE);
        r.setFilled(true);
        r.setFillColor(Color.WHITE);
        add(r);
    }

}
