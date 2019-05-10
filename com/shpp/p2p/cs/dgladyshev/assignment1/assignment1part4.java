package com.shpp.p2p.cs.dgladyshev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class assignment1part4 extends KarelTheRobot {

    /**
     * making checkerboard with "black" start position
     * Karel staing in the start position. And is looking for deck side
     */
    public void run() throws Exception {
        putBeeper();                        //our black position
        while (frontIsClear()) {            //not last column = fill and go to the next
            checkTheDirection();
            fillTheColumn();
            moveToNextColumn();
        }
        checkTheDirection();                //last column = fill it and finish
        fillTheColumn();
    }

    /**
     * Karel chills while looking forward )
     * Karel checks from which side our board is located and depending on this
     * turns left or right
     */
    private void checkTheDirection() throws Exception {
        if (rightIsBlocked()){
            turnLeft();
        }
        else {
            turnRight();
        }
    }

    /**
     * hm. used only once. but already done it
     */
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Karel finished to fill the present row and is looking far away )
     * Karel decide to move for the next column and do it )
     */
    private void moveToNextColumn()throws Exception {
        while (notFacingEast()) {           //turn face to the next column
            turnLeft();
        }
        if (beepersPresent()) {             //check "color" of present position
            move();                         //if black
        }
        else {
            move();                         //if white
            putBeeper();
        }
    }

    /**
     * Karel is looking for present row direction
     * checks the colors and moves for the rows end, filling the row
     */
    private void fillTheColumn() throws Exception {
        while (frontIsClear()) {
            if (beepersPresent()) {             //check "color" of present position
                move();                         //if black
            }
            else {
                move();                         //if white
                putBeeper();
            }
        }
    }


}