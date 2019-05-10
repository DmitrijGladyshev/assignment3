package com.shpp.p2p.cs.dgladyshev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class assignment1part1 extends KarelTheRobot {
    /**
     * Karel want to move outside some room, pick up the newspaper
     * and turn back to start position
     */
    public void run() throws Exception {
        moveToNewspaper();
        pickNewsletter();
        backToStartPosition();

    }

    /**
     * well. we know where is it. lets move
     * Karel staing in the start position and waiting for something )
     * Karel does strife and moving to our newspaper
     */
    private void moveToNewspaper() throws Exception {
        turnRight();
        move();
        turnLeft();
        while (noBeepersPresent()) {
            move();
        }
    }

    /**
     * Karel staing above newspaper and looking for it )
     * just pick that, Karel
     */
    private void pickNewsletter() throws Exception {
        pickBeeper();
    }


    /**
     * Karel pickes newspaper and looks away from our room
     * Karel turns around and move back to the start position
     */
    private void backToStartPosition() throws Exception {
        turnLeft();
        turnLeft();
        while (frontIsClear()) {
            move();
        }
        turnRight();
        move();
        turnRight();
    }

    
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }


}


