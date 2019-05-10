package com.shpp.p2p.cs.dgladyshev.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3part3 extends TextProgram {

    /**
     * Here we must do simplifier version of Math.pow(base, power).
     * <p>
     * If the first and second arguments are zero, then there are no availible roots.
     * If the first argument is zero and second argument is negative integer,
     * then there are no availible roots.
     */
    public void run() {
        double base = readDouble("Enter a base number: ");
        int exponent = readInt("Enter a natural exponent: ");
        if ((base == 0 & exponent == 0) || (base == 0 & exponent < 0)) {
            println("There are no availible roots");
        } else {
            double result = raiseToPower(base, exponent);
            println("Resultat of calculations " + base + "^" + exponent + " is: " + result);
        }
    }

    /**
     * If the exponent number is zero, then the result is 1.0.
     * If exponent is positive integer then result is equal to the result of calculations
     * result = 1/x^(-e)
     * If exponent is positive integer then result is equal to the result of raising the value of
     * the first argument to the power of the second argument
     *
     * @param x base number
     * @param e exponent number
     * @return result of calculations or 1.0 if e == 0
     */
    private double raiseToPower(double x, int e) {
        double result = 1;
        if (e > 0) {
            result = positiveExponent(x, e);
        }
        if (e < 0) {
            result = (1 / positiveExponent(x, -e));
        }
        return result;
    }

    /**
     * If exponent is positive integer then result is equal to the result of raising the value of
     * the first argument to the power of the second argument
     *
     * @param x base number
     * @param e exponent number
     * @return result of calculations.
     */
    private double positiveExponent(double x, int e) {
        double result = x;
        for (int i = 0; i < (e - 1); i++) {
            result = result * x;
        }
        return result;
    }

}

