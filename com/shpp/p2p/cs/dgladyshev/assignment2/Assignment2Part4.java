package com.shpp.p2p.cs.dgladyshev.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


public class Assignment2Part4 extends WindowProgram {

    /**
     * Here we can change sizes of program window
     */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 400;

    /**
     * Here we can change sizes of our flag
     */
    private static final int FLAG_WIDTH = 400;
    private static final int FLAG_HEIGHT = 300;

    /**
     * We have to print some treecolor flag in the centre of our programs window
     * and put the title of it in the right down corner
     */
    public void run() {
        printFlag();
        printText();
    }

    /**
     * there we have to check position and print our flag
     * in the centre of programs window
     * want to print the flag of Germany - tree horizontal strips
     * (black, red and yellow one)
     */
    private void printFlag() {
        double x = (getWidth() - FLAG_WIDTH) / 2.0;                   //start x position
        double y = (getHeight() - FLAG_HEIGHT) / 2.0;                 //start y position
        double h = (FLAG_HEIGHT / 3.0);                               //height of one strip

        printStrip(x, y, (FLAG_WIDTH), h, Color.BLACK);
        printStrip(x, y + h, (FLAG_WIDTH), h, Color.RED);
        printStrip(x, y + 2 * h, (FLAG_WIDTH), h, Color.YELLOW);
    }

    /**
     * Draw one flag strip, depends of paremeters:
     *
     * @param x     - x coordinate
     * @param y     - y coordinate
     * @param width - strip width
     * @param h     - strip height
     * @param color - color or strip
     */
    private void printStrip(double x, double y, int width, double h, Color color) {
        GRect rect = new GRect(x, y, width, h);
        rect.setColor(color);
        rect.setFilled(true);
        rect.setFillColor(color);
        add(rect);
    }

    /**
     * Print our text depend its sizes.
     */
    private void printText() {
        GLabel text = new GLabel("Flag of Germany");
        text.setFont("SERIF-25");
        double x = (getWidth() - text.getWidth());
        double y = (getHeight() - ((text.getHeight()) - (text.getAscent())));

        //Print text
        add(text, x, y);
    }
}
