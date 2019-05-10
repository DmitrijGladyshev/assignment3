package com.shpp.p2p.cs.dgladyshev.assignment3;

import acm.graphics.*;

import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3part6 extends WindowProgram {

    /**
     * Here we can set sun diameter.
     */
    private static final double SUN_DIAMETR = 75;

    /**
     * Here we can set sizes of area over programs window
     * And filling our scene by horizon
     * 1.0 means 100%
     */
    private static final double OVERSIZES = 1.2;
    private static final double HORIZON_FILLING = 0.2;

    /**
     * Here we can set our clouds
     * Percentage filling of scene area on top
     * Percentage sizes of clouds depend sizes of scene
     * 1.0 means 100%
     * And clouds velocity
     */
    private static final double CLOUDS_FILLING = 0.4;
    private static final double CLOUDS_MIN_SIZE = 0.04;
    private static final double CLOUDS_MAX_SIZE = 0.15;
    private static final double CLOUDS_VELOCITY = 0.3;

    /**
     * Pause time 1000/24 means about 24fps
     * Thats why itll be 120frames for 5 second
     */
    private static final double PAUSE_TIME = 1000 / 24;
    private static final double TOTAL_FRAMES = 120;

    /**
     * Here we can set colors of sky and grace.
     */
    private static final Color DAY_SKY = new Color(170, 200, 255);
    private static final Color NIGHT_SKY = new Color(110, 80, 255);
    private static final Color DAY_GRACE = new Color(40, 130, 0);
    private static final Color NIGHT_GRACE = new Color(0, 35, 0);

    /**
     * Link for clouds
     */
    GOval[] clouds = new GOval[10];

    /**
     * Ok. Here I tried to create some animation
     *
     * Draw the sun, clouds and horison.
     * Then make the sun and clouds moving.
      */
    public void run() {
        setBackground(DAY_SKY);
        GOval sun = makesun();
        makeClouds();
        GRect horizon = makeHorizon();
        performMoves(sun);
        afterSunset(horizon);
    }

    /**
     * Creating sun.
     *
     * @return object sun
     */
    private GOval makesun() {
        double x = -SUN_DIAMETR;
        double y = getHeight() / 3.0;
        GOval sun = drawCircle(x, y, SUN_DIAMETR, SUN_DIAMETR, Color.ORANGE, Color.YELLOW);
        return sun;
    }

    /**
     * Creating clouds.
     *
     * With random position and sizes (height - random, width = height*3)
     */
    private void makeClouds() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        for (int i = 0; i < clouds.length; i++) {
            double leftIndent = (getWidth() * OVERSIZES - getWidth()) / 2;
            double x = rgen.nextDouble(-leftIndent, getWidth() - leftIndent);
            double y = rgen.nextDouble(0, getHeight() * CLOUDS_FILLING);
            double cloudsHeight = rgen.nextDouble(getHeight() * CLOUDS_MIN_SIZE, getHeight() * CLOUDS_MAX_SIZE);
            clouds[i] = drawCircle(x, y, cloudsHeight * 3, cloudsHeight, Color.BLUE, Color.CYAN);
        }

    }

    /**
     * Creating horizon
     *
     * @return object horizon (rectangle)
     */
    private GRect makeHorizon() {
        double x = -((getWidth() * OVERSIZES - getWidth()) / 2.0);
        double y = getHeight() - (getHeight() * HORIZON_FILLING);
        GRect horizon = drawRect(x, y, getWidth() * OVERSIZES,
                (getHeight() * HORIZON_FILLING * OVERSIZES),
                NIGHT_GRACE, DAY_GRACE);

        return horizon;
    }

    /**
     * Makes sun move to top and down after half part of animation.
     * Makes some clouds move up, and some clouds move down.
     *
     * @param sun object sun
     */
    private void performMoves(GOval sun) {
        /*magic delta y - for sunflying to top position while 60 frames ends*/
        double dy = -(getHeight() / TOTAL_FRAMES);
        while (sun.getX() < getWidth()) {
            sun.move((getWidth() + SUN_DIAMETR) / TOTAL_FRAMES, dy);
            for (int i = 0; i < clouds.length; i++) {
                double y = (i % 2 == 0) ? CLOUDS_VELOCITY : -CLOUDS_VELOCITY;
                clouds[i].move(0, y);
            }
            pause(PAUSE_TIME);
            dy += ((getHeight() / TOTAL_FRAMES)) / (TOTAL_FRAMES/2);           // did DY=0 for 2,5sec
        }
    }

    /**
     * Darkens after sunset.
     *
     * @param horizon object horizon for recoloring
     */
    private void afterSunset(GRect horizon) {
        setBackground(NIGHT_SKY);
        horizon.setFillColor(NIGHT_GRACE);
    }

    /**
     * Constructor for ovals
     *
     * @param x x coordinate position
     * @param y y coordinate position
     * @param width width of element
     * @param height    height of element
     * @param circleColor  elements frame color
     * @param fillColor     fill color of element
     * @return  object GOval
     */
    private GOval drawCircle(double x, double y, double width,
                             double height, Color circleColor, Color fillColor) {
        GOval oval = new GOval(x, y, width, height);
        oval.setColor(circleColor);
        oval.setFilled(true);
        oval.setFillColor(fillColor);
        add(oval);
        return oval;
    }

    /**
     * Constructor for ovals
     *
     * @param x x coordinate position
     * @param y y coordinate position
     * @param width width of element
     * @param height    height of element
     * @param rectangleColor  elements frame color
     * @param fillColor     fill color of element
     * @return  object GRect
     */
    private GRect drawRect(double x, double y, double width,
                           double height, Color rectangleColor, Color fillColor) {
        GRect rect = new GRect(x, y, width, height);
        rect.setColor(rectangleColor);
        rect.setFilled(true);
        rect.setFillColor(fillColor);
        add(rect);
        return rect;
    }
}




