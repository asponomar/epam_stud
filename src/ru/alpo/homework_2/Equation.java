package ru.alpo.homework_2;

public class Equation {
    private int a, b, c;

    public Equation() {
    }

    public Equation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.printf("The equation is: %dx^2%+dx%+d=0 \n", a, b, c);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }


}