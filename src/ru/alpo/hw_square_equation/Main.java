package ru.alpo.hw_square_equation;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        SquareEquation[] equations = new SquareEquation[3];
        Random randomNumber = new Random();
        for (int i = 0; i < equations.length; i++) {
            equations[i] = new SquareEquation(randomNumber.nextInt(20) - 10, randomNumber.nextInt(20) - 10, randomNumber.nextInt(20) - 10);
            equations[i].solving();
        }

    }
}
