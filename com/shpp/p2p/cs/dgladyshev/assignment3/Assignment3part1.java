package com.shpp.p2p.cs.dgladyshev.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3part1 extends TextProgram {

    /**
     * Here we can change medical recomendation
     * about quantity (DAYS) and duration (MIN) of workout for better Cardiovacular health
     */
    private static final int CARDIOHEALTH_DAYS = 5;
    private static final double CARDIOHEALTH_MINS = 30;

    /**
     * Here we can change medical recomendation
     * about quantity (DAYS) and duration (MIN) of workout for better Blood Pressure health
     */
    private static final int PRESSUREHEALTH_DAYS = 3;
    private static final double PRESSUREHEALTH_MINS = 40;


    /**
     * In this program we must realise some health calculator
     * First of all we must ask user, how many time he spent with exercises.
     * Than calculate results and show it for our user
     * He(or she) must to work hard at least 5 times over 30min for a week for good cardiovacular health
     * And work hard at least 3 times over 40 min for a week for good blood pressure.
     */
    public void run() {
        double[] trainingsTime = new double[7];
        makeTrainingsGrafic(trainingsTime);
        checkCardioVacularHeath(trainingsTime);
        checkBloodPressure(trainingsTime);
    }

    /**
     * Here we must aks the user about durations of workout for each day
     *
     * @param trainingsTime massive with training durations for each day
     */
    private void makeTrainingsGrafic(double[] trainingsTime) {
        for (int i = 0; i < trainingsTime.length; i++) {
            trainingsTime[i] = readDouble("How many minutes did you do on day " + (i + 1) + "? ");
        }
    }

    /**
     * Check the equals our data with medical recommendations for cardiovacular health
     * And print results for our user.
     *
     * @param trainingsTime massive with training durations for each day
     */
    private void checkCardioVacularHeath(double[] trainingsTime) {
        int niceTrainingDays = 0;
        for (double i : trainingsTime) {
            if (i >= CARDIOHEALTH_MINS) {
                niceTrainingDays += 1;
            }
        }
        println("Cardiovacular health:");
        if (niceTrainingDays < CARDIOHEALTH_DAYS) {
            println("You needed to train hard for at least "
                    + (CARDIOHEALTH_DAYS - niceTrainingDays) + " more day(s) a week!");
        } else {
            println("Great job! You've done enough exercise for cardiovacular health.");
        }
    }

    /**
     * Check the equals our data with medical recommendations for good blood pressure.
     * And print results for our user.
     *
     * @param trainingsTime massive with training durations for each day
     */
    private void checkBloodPressure(double[] trainingsTime) {
        int niceTrainingDays = 0;
        for (double i : trainingsTime) {
            if (i >= PRESSUREHEALTH_MINS) {
                niceTrainingDays += 1;
            }
        }
        println("Blood pressure:");
        if (niceTrainingDays < PRESSUREHEALTH_DAYS) {
            println("You needed to train hard for at least "
                    + (PRESSUREHEALTH_DAYS - niceTrainingDays) + " more day(s) a week!");
        } else {
            println("Great job! You've done enough exercise to keep a low blood pressure.");
        }
    }
}
