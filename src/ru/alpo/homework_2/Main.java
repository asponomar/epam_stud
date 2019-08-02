package ru.alpo.homework_2;

public class Main {
    public static void main(String[] args) {
        Equation equation_1 = new Equation(2, -6, 3);
        Solving solvingEquation_1 = new Solving(equation_1);

        Equation equation_2 = new Equation(1, 4, 4);
        Solving solvingEquation_2 = new Solving(equation_2);

        Equation equation_3 = new Equation(2, -5, 4);
        Solving solvingEquation_3 = new Solving(equation_3);
    }
}
