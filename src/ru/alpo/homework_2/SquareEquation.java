package ru.alpo.homework_2;

public class SquareEquation {
    private int a, b, c;

    public SquareEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.printf("The equation is: %dx^2%+dx%+d=0 \n", a, b, c);
    }

    public void solving() {
        double discriminant = getDiscriminant(a, b, c);
        if (isSquare(a)) {
            if (hasRoots(discriminant)) {
                double x1 = getRoot1(discriminant, a, b);
                double x2 = getRoot2(discriminant, a, b);
                printRoots(x1, x2);
            } else System.out.println("There are no real roots \n");
        } else System.out.println("The equation is not square \n");
    }

    public static boolean isSquare(int a) {
        boolean isSquare;
        switch (a) {
            case 0: {
                isSquare = false;
                break;
            }
            default:
                isSquare = true;
        }
        return isSquare;
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