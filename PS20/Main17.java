import java.util.Scanner;

class AdditionThread extends Thread {
    private double num1, num2;

    public AdditionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 + num2;
        System.out.println("Addition Result: " + num1 + " + " + num2 + " = " + result);
    }
}

class SubtractionThread extends Thread {
    private double num1, num2;

    public SubtractionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 - num2;
        System.out.println("Subtraction Result: " + num1 + " - " + num2 + " = " + result);
    }
}

class MultiplicationThread extends Thread {
    private double num1, num2;

    public MultiplicationThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 * num2;
        System.out.println("Multiplication Result: " + num1 + " * " + num2 + " = " + result);
    }
}

class DivisionThread extends Thread {
    private double num1, num2;

    public DivisionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        if (num2 != 0) {
            double result = num1 / num2;
            System.out.println("Division Result: " + num1 + " / " + num2 + " = " + result);
        } else {
            System.out.println("Division Error: Cannot divide by zero.");
        }
    }
}

public class Main17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user to enter two numbers
            System.out.print("Enter the first number: ");
            double num1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the second number: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            // Prompt the user to choose an arithmetic operation
            System.out.println("Choose an arithmetic operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Enter your choice (1-4): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    AdditionThread additionThread = new AdditionThread(num1, num2);
                    additionThread.start();
                    break;
                case 2:
                    SubtractionThread subtractionThread = new SubtractionThread(num1, num2);
                    subtractionThread.start();
                    break;
                case 3:
                    MultiplicationThread multiplicationThread = new MultiplicationThread(num1, num2);
                    multiplicationThread.start();
                    break;
                case 4:
                    DivisionThread divisionThread = new DivisionThread(num1, num2);
                    divisionThread.start();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter valid numeric values.");
        }

        scanner.close();
    }
}
