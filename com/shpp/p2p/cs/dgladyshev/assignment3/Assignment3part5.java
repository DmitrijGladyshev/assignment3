package com.shpp.p2p.cs.dgladyshev.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class Assignment3part5 extends TextProgram {

    /**
     * Back to the St. Petersburg Paradox?
     * <p>
     * Lets play St. Petersburg game ;)
     * There realized ability to play more than once
     * And added some statistics.
     */
    public void run() {
        /* maximum value of win and quantity of tries */
        int maxixumwin = 0;
        int tries = 0;
        /* Play until the player answers either but yes */
        while (true) {
            tries++;
            int win = playGame();               // Here we have our game
            maxixumwin = (maxixumwin < win) ? win : maxixumwin;
            String answer = readLine("Play again? y means yes :)");
            if (!answer.equals("y")) {
                break;
            }
        }
        println("For " + tries + " tries your maximum win was $" + maxixumwin);
    }

    /**
     * The initial stake starts at 1 dollar and is doubled every time heads appears.
     * The first time tails appears, the session ends and the player wins whatever is in the pot.
     * Game ends when total prize raises over 20 dollars.
     * <p>
     * In the games end program must show to user, how many tries needed for getting 20 dollars.
     *
     * @return value of players prize for either statistics.
     */
    private int playGame() {
        int totalPrize = 0;
        int count = 0;
        int sessionPrize = 1;                                   // initial stake starts
        RandomGenerator rgen = RandomGenerator.getInstance();
        while (totalPrize < 20) {
            if (rgen.nextBoolean()) {                           //for head
                sessionPrize *= 2;
            } else {                                            //for tail
                totalPrize = totalPrize + sessionPrize;
                count++;
                println("This game, you earned $" + sessionPrize + "\nYour total is $" + totalPrize);
                sessionPrize = 1;                               // make new initial stake
            }
        }
        println("It took " + count + " games to earn $20");
        return totalPrize;
    }
}
