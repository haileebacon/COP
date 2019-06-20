import java.util.Scanner;
import java.lang.Math;

public class SciCalculator {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {

//hello

        double currentResult = 0.0;
        double userSelection = -1;
        double firstOperand;
        double secondOperand;
        double resultTotal = 0.0;
        int numCalculations = 0;
        double numAverages;
        boolean printMenu = true;
        //this gives control over when the menu is printed and after which operations (such as 0 or 7)
        //number averages, not number of averages


        //start the while loop to not include 0, then you can include it after every operation
        while (userSelection != 0) {
            if (printMenu) {
                System.out.println("Current Result: " + currentResult);
                System.out.println();
                System.out.println("Calculator Menu");
                System.out.println("---------------");
                System.out.println("0. Exit Program");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exponentiation");
                System.out.println("6. Logarithm");
                System.out.println("7. Display Average");
                System.out.println();
            }
            System.out.println("Enter Menu Selection: ");
            userSelection = myScanner.nextDouble();


            //if a number is negative or greater than 7 then it won't go through the rest of the while loop body
            if (userSelection < 0 || userSelection > 7) {
                System.out.println("Error: Invalid selection!\n");
                printMenu = false;
            } else if (userSelection == 1) {
                System.out.println("Enter first operand: ");
                firstOperand = askUser(currentResult);
                //changed from myScanner.nextDouble(); to incorporate the RESULT method at bottom

                System.out.println("Enter second operand: ");
                secondOperand = askUser(currentResult);
                System.out.println();

                currentResult = firstOperand + secondOperand;
                numCalculations++;
                resultTotal += currentResult;
                printMenu = true;
            } else if (userSelection == 2) {
                System.out.println("Enter first operand: ");
                firstOperand = askUser(currentResult);

                System.out.println("Enter second operand: ");
                secondOperand = askUser(currentResult);
                System.out.println();

                currentResult = firstOperand - secondOperand;
                numCalculations++;
                //incremental addition, +1 every time
                resultTotal += currentResult;
                printMenu = true;
            } else if (userSelection == 3) {
                System.out.println("Enter first operand: ");
                firstOperand = askUser(currentResult);

                System.out.println("Enter second operand: ");
                secondOperand = askUser(currentResult);
                System.out.println();

                currentResult = firstOperand * secondOperand;
                numCalculations++;
                resultTotal += currentResult;
                // this updates the resultTotal variable after each operand, which is why it is included in each if statement.
                printMenu = true;
            } else if (userSelection == 4) {
                System.out.println("Enter first operand: ");
                firstOperand = askUser(currentResult);

                System.out.println("Enter second operand: ");
                secondOperand = askUser(currentResult);
                System.out.println();

                currentResult = firstOperand / secondOperand;
                //will work because variables are doubles and not integers
                numCalculations++;
                resultTotal += currentResult;
                printMenu = true;
            } else if (userSelection == 5) {
                System.out.println("Enter first operand: ");
                firstOperand = askUser(currentResult);

                System.out.println("Enter second operand: ");
                secondOperand = askUser(currentResult);
                System.out.println();

                currentResult = Math.pow(firstOperand, secondOperand);
                //math class
                numCalculations++;
                resultTotal += currentResult;
                printMenu = true;
            } else if (userSelection == 6) {
                System.out.println("Enter first operand: ");
                firstOperand = askUser(currentResult);

                System.out.println("Enter second operand: ");
                secondOperand = askUser(currentResult);
                System.out.println();

                currentResult = Math.log(secondOperand) / Math.log(firstOperand);
                //this is a math identity.. log(a)/log(b) = log_b (a)
                numCalculations++;
                resultTotal += currentResult;
                printMenu = true;
            } else if (userSelection == 7) {
                if (numCalculations == 0) {
                    System.out.println("Error: No calculations yet to average!\n");
                    printMenu = false;
                    //control over when the menu is printed. It is not supposed to be printed again but prompt the user for more input
                } else if (numCalculations > 0) {
                    resultTotal = Math.round(resultTotal*100d) / 100d;
                    System.out.println("Sum of calculations: " + resultTotal);
                    System.out.println("Number of calculations: " + numCalculations);
                    numAverages = Math.round((resultTotal / numCalculations) * 100d) / 100d;
                    System.out.println("Average of calculations: " + numAverages);
                    System.out.println();
                    printMenu = false;
                    //exercising control over when to print menu
                }
            }


        }
        System.out.println("Thanks for using this calculator. Goodbye!");
    }
//asks the user for a string that is compared to the "RESULT", and if it is equal, returns the currentValue of the most recent operation
//Otherwise the string is parsed into a double that is returned instead
    public static double askUser(double currentValue){
        double val = 0;
        String response;
        response = myScanner.next();
        if (response.equals("RESULT")) {
            val = currentValue;
        } else {
            val = Double.parseDouble(response);
        }

        return val;
    }

}