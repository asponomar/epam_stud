package ru.alpo.homework_2;

public class Solving {

    public Solving(Equation equation) {
        int a = equation.getA();
        int b = equation.getB();
        int c = equation.getC();
        double discriminant = getDiscriminant(a, b, c);
        if (hasRoots(discriminant)) {
            double x1 = getRoot1(discriminant, a, b);
            double x2 = getRoot2(discriminant, a, b);
            printRoots(x1, x2);
        } else System.out.println("There are no real roots \n");
    }

    public static double getDiscriminant(int a, int b, int c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public static boolean hasRoots(double discriminant) {
        return discriminant >= 0;
    }

    public static double getRoot1(double discriminant, int a, int b) {
        return -b + Math.sqrt(discriminant) / (2 * a);
    }

    public static double getRoot2(double discriminant, int a, int b) {
        return -b - Math.sqrt(discriminant) / (2 * a);
    }

    public static void printRoots(double x1, double x2) {
        System.out.println("X1 = " + x1 + ", X2 = " + x2 + "\n");
    }
}