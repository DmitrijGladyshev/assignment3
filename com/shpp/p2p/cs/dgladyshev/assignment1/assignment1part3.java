package com.shpp.p2p.cs.dgladyshev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class assignment1part3 extends KarelTheRobot {

    /**
     *Karel must find the centre
     *and put there beeper
     */
    public void run() throws Exception {
        moveToCentre();
        putBeeper();
    }

    /**
     * karel staing in start position and looking forward
     * karel steps twice forward (if there are no obstacles)
     * and "remember" 1 step, which be able to move back later
     * Karel staing in the central positions when finishes
     */
    private void moveToCentre() throws Exception {
        if(frontIsClear()){             //one step of two
            move();
            if(frontIsClear()){         //second step
                move();
            }
            moveToCentre();             //repeat 2 steps forward while has the place
            move();                     //just "remember it" and do, when turn around
        }
        else {                          //turn around and start do steps which Karel "remember"
            turnLeft();
            turnLeft();
        }
    }
    }



