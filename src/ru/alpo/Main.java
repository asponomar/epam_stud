package ru.alpo;

public class Main {
    public static void main(String[] args) {
        System.out.println(squareEquation(2, -5, 4) + "\n");
        System.out.println(squareEquation(1,4,4));
    }

    public static double squareEquation(int a, int b, int c) {
        System.out.println("The equation is: " + a + "x^2" + "+" + b + "x" + "+" + c + "=0");
        double D = Math.pow(b, 2) - 4 * a * c;
        System.out.println("D = " + D);
        double x;
        if (D >= 0) {
            x = (-1 * b + Math.sqrt(D)) / (2 * a);
        } else {
            System.out.println("There is no real x here");
            x = 0;
        }
        return x;


    }
}
