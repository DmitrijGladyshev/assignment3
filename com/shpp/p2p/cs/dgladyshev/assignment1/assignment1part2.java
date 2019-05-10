package com.shpp.p2p.cs.dgladyshev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class assignment1part2 extends KarelTheRobot {

    /**
     * Karel must repair all the columns which be able to find
     * room can be large but columns can be at 1 - 5 - 9 and ect positions.
     * columns must attend in each edge of the room
     */
    public void run() throws Exception {
        while (frontIsClear()) {             //if false = that is last column
            checkTheHigh();
            repairTheColumn();
            moveToTheNextColumn();
        }
        checkTheHigh();                      //do something with last column
        repairTheColumn();

    }


    /**
     * we know about 4 steps to the next column. 1 - 5 - 9 and ect.
     * Karel has finished repairing the column and looking forward
     * and move to the next column
     */
    private void moveToTheNextColumn() throws Exception {
        move();
        move();
        move();
        move();
    }

    /**
     * Karel sitting on the top block of present column and is looking down
     * Karel climb down and repair damaged blocks
     * checks the last block and turn to find next column
     */
    private void repairTheColumn() throws Exception {
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
                move();
            } else {
                move();
            }
        }
        turnLeft();
        if (noBeepersPresent()) {           //check last block
            putBeeper();
        }
    }

    /**
     * Karel staing above present column and looks forward
     * Karel looked up and climb up to the top of column and "put down eyes"
     */
    private void checkTheHigh() throws Exception {
        turnLeft();                         //looks up
        while (frontIsClear()) {            //climbs up
            move();
        }
        turnLeft();                         //turn around
        turnLeft();
    }


}
