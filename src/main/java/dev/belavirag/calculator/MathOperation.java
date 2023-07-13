package dev.belavirag.calculator;

import java.util.Arrays;

public class MathOperation {
    public static double execute(final double number1, final double number2, char operand) {
        double results = 0;

        switch (operand) {
            case '+' -> results = number1 + number2;
            case '-' -> results = number1 - number2;
            case '*' -> results = number1 * number2;
            case '/' -> results = number1 / number2;
        }

        return results;
    }

    public static boolean isValid(char operand)
    {
        final char[] chars = {'+', '-', '*', '/'};

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == operand) {
                return true;
            }
        }

        return false;
    }
}
