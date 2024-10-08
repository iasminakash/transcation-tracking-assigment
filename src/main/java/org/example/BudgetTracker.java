package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;



public class BudgetTracker {
    public static void main(String[] args) {
        //Initierar en scanner objekt
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        IncomeManager incomeManager = new IncomeManager();
        ExpenseManager expenseManager = new ExpenseManager();
        User loggedInUser = null;


        //Skriver ut valkomstmedelande och ber att välja en av alternativen
        while (true) {
            System.out.println("Welcome to the budget tracker. Please choose an alternative.");
            System.out.println("1. Sign In if you already have an account.");
            System.out.println("2. Sign Up if you're a new user.");
            System.out.println("3. Exit.");
            try {
                int firstMenuOption = scanner.nextInt();
                //
                if (firstMenuOption == 1) {
                    System.out.println("Please write your first name: ");
                    String existingUserFirstName = scanner.next();
                    System.out.println("Please write your last name: ");
                    String existingUserLastName = scanner.next();
                    loggedInUser = userManager.logInExistingUser(existingUserFirstName, existingUserLastName);
                    System.out.println("Please choose one of the options: ");
                    System.out.println("1. Add an income.");
                    System.out.println("2. Add an expense.");
                    System.out.println("3. Show all transactions.");
                    int secondMenuOption = scanner.nextInt();
                    if (secondMenuOption == 1) {
                        System.out.println("Please introduce amount of the income: ");
                        double amountOfNewIncome = scanner.nextInt();
                        System.out.println("Please choose a category of the income: ");
                        System.out.println("1. Salary");
                        System.out.println("2. Studygrant");
                        System.out.println("3. Childbenefit");
                        EIncomeCategory category = null;
                        int thirdMenuOption = scanner.nextInt();
                        if (thirdMenuOption == 1) {
                           category = EIncomeCategory.SALARY;
                        }
                        if (thirdMenuOption == 2) {
                            category = EIncomeCategory.STUDYGRANT;
                        }
                        if (thirdMenuOption ==3) {
                            category = EIncomeCategory.CHILDBENEFIT;
                        }
                        incomeManager.addIncome(amountOfNewIncome, category, loggedInUser);
                    }
                    if (secondMenuOption == 2) {
                        System.out.println("Please introduce an amount of the expense: ");
                        double amountOfNewExpense = scanner.nextDouble();
                        System.out.println("Please choose the category of the income: ");
                        System.out.println("1. Rent");
                        System.out.println("2. Bills");
                        System.out.println("3. Kindergarten");
                        System.out.println("4. Transportation");
                        System.out.println("5. Groceries");
                        System.out.println("6. Others");
                        EExpenseCategory category = null;
                        int fourthMenuOption = scanner.nextInt();
                        if (fourthMenuOption == 1){
                            category = EExpenseCategory.RENT;
                        }
                        if (fourthMenuOption == 2){
                            category = EExpenseCategory.BILLS;
                        }
                        if (fourthMenuOption == 3){
                            category = EExpenseCategory.KINDERGARTEN;
                        }
                        if (fourthMenuOption == 4){
                            category = EExpenseCategory.TRANSPORTATION;
                        }
                        if (fourthMenuOption == 5){
                            category = EExpenseCategory.GROCERIES;
                        }
                        if (fourthMenuOption == 6){
                            category = EExpenseCategory.OTHERS;
                        }
                        expenseManager.addExpense(amountOfNewExpense, category, loggedInUser);

                    }
                    if (secondMenuOption == 3){
                        System.out.println("Here comes the list of all transactions:" );
                        System.out.println("________________________________________");
                        System.out.println("Income transactions:");
                        System.out.println("____________________");
                        System.out.println();
                    }

                //Alternativ 2 tar emot användarens namn och efternamn och lägger till en ny user till systemet genom att anropa metoden addUser
                } else if (firstMenuOption == 2) {
                    System.out.println("Please write your first name: ");
                    String newUserFirstName = scanner.next();
                    System.out.println("Please write your last name: ");
                    String newUserLastName = scanner.next();
                    userManager.addUser(newUserFirstName, newUserLastName);
                //Alternativ 3 avslutar programmet
                } else if (firstMenuOption == 3) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid option. Please choose 1 or 2.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Please choose 1 or 2.");
                scanner.next();
            }
        }
    }

}
