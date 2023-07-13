package dev.belavirag.calculator;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Welcome to my simple calculator!");

        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Begin by entering the first number");
            double firstNumber = getNumber(scanner);
            System.out.println("Enter the second number");
            double secondNumber = getNumber(scanner);

            System.out.println("Enter operand");

            char operand = ' ';
            while (true) {
                final String str = scanner.nextLine().trim();
                if (str.length() != 1) {
                    continue;
                }
                final char firstChar = str.charAt(0);
                if (!MathOperation.isValid(firstChar)) {
                    System.out.println("Invalid operand: " + firstChar + ", try again!");
                    continue;
                }

                operand = firstChar;
                break;
            }

            System.out.printf("Result: %.2f %s %.2f = %.2f%n", firstNumber, operand, secondNumber, MathOperation.execute(firstNumber, secondNumber, operand));

            System.out.println("Would you like to calculate something again? [Y/n]");
            final String line = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            if (line.startsWith("n")) {
                break;
            }
        }
    }

    public static double getNumber(final Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (Exception ignored) {
                scanner.nextLine(); // clear input buffer
                System.out.println("That's not a number! Try again");
            }
        }
    }
}