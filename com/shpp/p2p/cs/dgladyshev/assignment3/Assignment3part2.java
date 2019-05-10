package com.shpp.p2p.cs.dgladyshev.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3part2 extends TextProgram {


    /**
     * Numberphile The Collatz Conjecture
     * <p>
     * Start with any positive integer n. Then each term is obtained from the previous term as follows:
     * if the previous term is even, the next term is one half the previous term. If the previous term is odd,
     * the next term is 3 times the previous term plus 1. The conjecture is that no matter what value of n,
     * the sequence will always reach 1.
     * Here some program to check that.
     */
    public void run() {
        int n = userPrint();
        makeCalculations(n);
    }

    /**
     * Ask user to enter some positive integer while entered correct integer
     *
     * @return only positive integer :)
     */
    private int userPrint() {
        int n = -1;
        while (n < 1) {
            try {
                n = Integer.parseInt(readLine("Enter a number: "));
            } catch (Exception ignored) {
                // ignore that if parse returns null  -  our n stands -1
            }
            if (n < 1) {
                println("Can enter only positive integers");
            }
        }
        return n;
    }

    /**
     * While take 1, we check our number:
     * for even we must take half of it
     * for odd we must take it 3 times and plus 1 )
     *
     * @param n positive integer entered by user
     */
    private void makeCalculations(int n) {
        if (n == 1) {
            println("Great, we already have 1.");
        }
        while (n != 1) {
            if (n % 2 == 0) {
                int tempint = (n / 2);
                println(n + " is even so I take half: " + tempint);
                n = tempint;

            } else {
                int tempint = (n * 3 + 1);
                println(n + " is odd so I make 3n + 1: " + tempint);
                n = tempint;

            }
        }
        println("End ;)");
    }
}
