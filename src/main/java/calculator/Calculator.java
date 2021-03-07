package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private double num1, num2;
    public Calculator(){

    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Calculator Devops Mini project. ");
        int ch;
        boolean flag=true;
        while(flag){
            System.out.println("\n1. Square root\n2. Factorial\n3. Natural Logarithm\n4. Power Function\n5. Exit");
            System.out.println("\nchoose an option: ");

            try {
                ch = scanner.nextInt();
            } catch (InputMismatchException error) {
                System.out.print("Enter input in decimals");
                return;
            }
            switch (ch) {
                case 1:

                    System.out.print("\nEnter number: ");
                    calculator.num1 = scanner.nextDouble();

                    if(calculator.num1 < 0)
                    {
                        System.out.println("please enter positive value\n");
                    }
                    else
                        System.out.println("The Square root of " + calculator.num1 + " is: " + callSQRT(calculator.num1));
                    break;

                case 2:

                    try {
                        System.out.print("\nEnter number: ");
                        calculator.num1 = scanner.nextInt();

                        if (calculator.num1 < 0)
                        {
                            System.out.println("You have entered either a negative value. Factorial cannot be calculated for negative value!!\n");
                        }
                        else
                            System.out.println("The Factorial of " + calculator.num1 + " is: " + callFact(calculator.num1));

                    } catch (InputMismatchException error) {
                        System.out.println("Please enter input in integer format");
                        flag=false;
                    }

                    break;

                case 3:

                    try {
                        System.out.print("\nEnter number: ");
                        calculator.num1 = scanner.nextDouble();
                        if (calculator.num1 <= 0)
                            System.out.println("You have entered either 0 or negative value. Logarithm cannot be calculated for such values!!\n");
                        else
                            System.out.println("The Natural logarithm of " + calculator.num1 + " is: " + callNatLog(calculator.num1));
                    } catch (InputMismatchException error) {
                        System.out.println("Please enter input in decimal format");
                        flag=false;
                    }
                    break;

                case 4:

                    try {
                        System.out.print("\nEnter first number: ");
                        calculator.num1 = scanner.nextDouble();
                        System.out.print("\nEnter second number: ");
                        calculator.num2 = scanner.nextDouble();

                        System.out.println(calculator.num1 + " to the power " + calculator.num2 + " is: " + callPower(calculator.num1, calculator.num2));
                    } catch (InputMismatchException error) {
                        System.out.println("Please enter input in decimal format");
                        flag=false;
                    }
                    break;
                default:
                    System.out.println("\nExiting....\nThank you!! :)\n");
                    return;
            }
        }
    }
    public static double callSQRT(double n)
    {
        return Math.sqrt(n);
    }

    public static double callNatLog(double n)
    {
        return Math.log(n);
    }

    public static double callPower(double n1, double n2)
    {
        if(n1==0 && n2==0)
            return Double.NaN;
        return Math.pow(n1, n2);
    }

    public static double callFact(double n)
    {
        if(n<0)
            return Double.NaN;
        if(n==0)
            return 1;
        else
            return n*callFact(n-1);
    }
}