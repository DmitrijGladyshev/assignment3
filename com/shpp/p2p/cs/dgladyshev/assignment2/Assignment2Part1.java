package com.shpp.p2p.cs.dgladyshev.assignment2;

import com.shpp.cs.a.console.TextProgram;

public class Assignment2Part1 extends TextProgram {

    /**
     * have to make some console program, which can read 0some a, b, c
     * and calculate      a*(x^2) + b*x + c = 0
     * then print result
     */
    public void run() {
        double a = readDouble("Please enter a: ");
        double b = readDouble("Please enter b: ");
        double c = readDouble("Please enter c: ");
        checkMethods(a, b, c);
    }

    /**
     * if a = 0, we cant use discriminant method
     */
    private void checkMethods(double a, double b, double c) {
        if (a != 0) {
            discriminantMethod(a, b, c);
        } else {
            linearCalculate(b, c);
        }
    }

    /**
     * there we can use some mathematics for calculation our roots
     * we have 3 cases: when discriminant >0, <0 or =0
     * so, using some formulas we can calculate roots and print them
     */
    private void discriminantMethod(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double kd = Math.sqrt(d);
            double root1 = (-b + kd) / (2 * a);
            double root2 = (-b - kd) / (2 * a);
            println("There are two roots: " + root1 + " and " + root2);
        } else if (d < 0) {
            println("There are no real roots.");
        } else {
            double root = -(b / (2 * a));
            println("There is one root: " + root);
        }
    }

    /**
     * This is linear equation like b*x + c = 0
     */
    private void linearCalculate(double b, double c) {
        if (b == 0 && c == 0) {
            println("There are infinite roots.");
        } else if (b == 0 && c != 0) {
            println("There are no real roots.");
        } else {
            double root = -c / b;
            println("There is one root: " + root);
        }
    }
}
