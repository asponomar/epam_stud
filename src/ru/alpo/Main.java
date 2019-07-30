package ru.alpo;

public class Main {
    private static Double x1, x2;

    public static void main(String[] args) {
        squareEquation(2, -5, 4);
        squareEquation(1, 4, 4);
        squareEquation(2, -6, 3);
    }

    public static void squareEquation(int a, int b, int c) {
        System.out.printf("The equation is: %dx^2%+dx%+d=0 \n", a, b, c);
        double D = Math.pow(b, 2) - 4 * a * c;
        //System.out.print("D = " + D + ". ");

        if (D > 0) {
            x1 = (- b + Math.sqrt(D)) / (2 * a);
            x2 = (- b - Math.sqrt(D)) / (2 * a);
            System.out.println("There are two real roots here: \nX1=" + x1 + "\nX2=" + x2 + "\n");
            //System.out.printf("(x%+.3f)*(x%+.3f)=0 \n\n", x1, x2);
        } else if (D == 0) {
            x1 = x2 = (double) - b / (2 * a);
            System.out.println("There is one real root here: \nX =" + x1 + "\n");
            //System.out.printf("(x%+.0f)^2=0 \n\n", x1, x2);
        } else {
            System.out.println("There is no real roots here\n");
        }
    }
}
