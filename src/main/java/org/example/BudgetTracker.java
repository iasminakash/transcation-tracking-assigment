package org.example;

public class BudgetTracker {
    public static void main(String[] args) {

    }
    /*public static void main(String[] args) {
        //instansierar en scanner objekt
        Scanner scanner = new Scanner(System.in);
        //instansierar objekter av klasses UserMaganer, IncomeManager, ExpenseManager
        UserManager userManager = new UserManager();
        IncomeManager incomeManager = new IncomeManager();
        ExpenseManager expenseManager = new ExpenseManager();
        //ger objektet user värde av null
        User loggedInUser = null;



        //Skriver ut valkomstmedelande och ber att välja en av alternativen
        while (true) {
            System.out.println("Welcome to the budget tracker. Please choose an alternative.");
            System.out.println("1. Sign In if you already have an account.");
            System.out.println("2. Sign Up if you're a new user.");
            System.out.println("3. Exit.");
            try {
                //tar emot användarens val och sparar det som värde av variabel firstMenuOption
                int firstMenuOption = scanner.nextInt();
                //om valet är 1, dvs användaren har ett konto och vill logga in, frågar efter namn och efternamn och sparar svan till variabler
                if (firstMenuOption == 1) {
                    System.out.println("Please write your first name: ");
                    String existingUserFirstName = scanner.next();
                    System.out.println("Please write your last name: ");
                    String existingUserLastName = scanner.next();
                    //anropar metoden logInExistingUser från klasses UserManager och skickar med namnet och efternamnet (metoden ser till om user finns med i hashmap users)
                    loggedInUser = userManager.logInExistingUser(existingUserFirstName, existingUserLastName);
                    //så länge användaren är inloggad
                    while(loggedInUser != null) {
                        //presentera olika val, ber användaren att välja vad vill hen göra och sparar svaret i variabeln secondMenuOption
                        System.out.println("Please choose one of the options: ");
                        System.out.println("1. Add an income transaction.");
                        System.out.println("2. Add an expense transaction..");
                        System.out.println("3. Show all transactions.");
                        System.out.println("4. Delete an income transaction.");
                        System.out.println("5. Change the amount of an income transaction.");
                        System.out.println("6. Delete an expense transaction.");
                        System.out.println("7. Change the amount of expense transaction.");
                        System.out.println("8. Log out.");
                        int secondMenuOption = scanner.nextInt();
                        //om svaret är 1, dvs användaren vill lägga till inkomst, frågar efter summma och ber att använda kategorin för inkomsten
                        if (secondMenuOption == 1) {
                            System.out.println("Please introduce amount of the income: ");
                            double amountOfNewIncome = scanner.nextInt();
                            System.out.println("Please choose a category of the income: ");
                            System.out.println("1. Salary");
                            System.out.println("2. Studygrant");
                            System.out.println("3. Childbenefit");
                            //initialiserar enum objekt category och ger det värde null
                            EIncomeCategory category = null;
                            int thirdMenuOption = scanner.nextInt();
                            //här avgörs kategorier av inkomsten avseende användarens svar
                            if (thirdMenuOption == 1) {
                                category = EIncomeCategory.SALARY;
                            }
                            if (thirdMenuOption == 2) {
                                category = EIncomeCategory.STUDYGRANT;
                            }
                            if (thirdMenuOption ==3) {
                                category = EIncomeCategory.CHILDBENEFIT;
                            }
                            //anroppar metoden addIncome från klasses incomeManager och skickar med summan, kategorin, usern
                            //metoden läger till inkomsten till inkomstlistan hos usern
                            incomeManager.addIncome(amountOfNewIncome, category, loggedInUser);
                        }
                        //om svaret är 2, dvs användaren vill lägga till en utgift, frågar efter summan av avgiften och sparat det som värde av variabeln amountOfNewExpense
                        if (secondMenuOption == 2) {
                            System.out.println("Please introduce an amount of the expense: ");
                            double amountOfNewExpense = scanner.nextDouble();
                            //presenterar en ny menu, där frågar om av vilken kategori ska utgiften vara
                            System.out.println("Please choose the category of the expense: ");
                            System.out.println("1. Rent");
                            System.out.println("2. Bills");
                            System.out.println("3. Kindergarten");
                            System.out.println("4. Transportation");
                            System.out.println("5. Groceries");
                            System.out.println("6. Others");
                            //initialiserar enum objekt category och ger det värde null
                            EExpenseCategory category = null;
                            //här avgörs kategorier av inkomsten avseende användarens svar
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
                            //anropar metoden addExpense och skickar med summa, kategorin, usern
                            //metoden lägger till utgiften till utgiftlistan hos usern
                            expenseManager.addExpense(amountOfNewExpense, category, loggedInUser);

                        }
                        //ifall användaren vill visa listan över inkomser och utgifter ska jag anroppa på metodena som visar de
                        //metoderna kommer från klasserna incomeManager och expenseManager och loppar genom users egna arraylistor
                        if (secondMenuOption == 3){
                            System.out.println("Here comes the list of all transactions:" );
                            System.out.println("________________________________________");
                            System.out.println("Income transactions:");
                            System.out.println("____________________");
                            incomeManager.displayIncomeList(loggedInUser);
                            System.out.println("Expense transactions:");
                            System.out.println("____________________");
                            expenseManager.displayExpenseList(loggedInUser);
                        }
                        //ifall användaren vill ta bort inkomst, presenterar listan över inkomster genom att anropa på metoden displayIncomeList från klassen incomeManager och ber att välja inkomst efter nummer
                        if (secondMenuOption == 4){
                            System.out.println("You chose to delete an income transaction. Here come the current list of all income transactions.\n" +
                                    "Please introduce the number of the transaction you want to delete.");
                            incomeManager.displayIncomeList(loggedInUser);
                            int incomeTransactionNumber = scanner.nextInt();
                            //anropar på metoden deleteIncome, skickar med usern och inkomst nummer, metoden tar bort inkomsten från users arraylista av inkomster
                            incomeManager.deleteIncome(loggedInUser, incomeTransactionNumber);
                        }
                        //ifall användaren ändra summan av en viss inkomst, presenterar listan över inkomster genom att anropa på metoden displayIncomeList från klassen incomeManager och ber att välja inkomst efter nummer
                        if (secondMenuOption == 5){
                            System.out.println("You chose to change the amount of an income transaction. Here come the current list of all income transactions.\n" +
                                    "Please introduce the number of the transaction you want to change.");
                            incomeManager.displayIncomeList(loggedInUser);
                            int incomeTransactionNumber = scanner.nextInt();
                            //ber att skriva in en ny summa
                            System.out.println("Please introduce the new amount of the transaction.");
                            double newIncomeAmount = scanner.nextDouble();
                            //anropar metoden changeIncome från klassen incomeManager och skickar med usern, ny summa, number av inkomsten på listan
                            incomeManager.changeIncome(loggedInUser, newIncomeAmount, incomeTransactionNumber);
                        }
                        //ifall användaren vill ta bort utgift, presenterar listan över utgifter genom att anropa på metoden displayExpenseList från klassen incomeManager och ber att välja utgift efter nummer
                        if (secondMenuOption == 6) {
                            System.out.println("You chose to delete an expense transaction. Here come the current list of all expense transactions.\n" +
                                    "Please introduce the number of the transaction you want to delete.");
                            expenseManager.displayExpenseList(loggedInUser);
                            int expenseTransactionNumber = scanner.nextInt();
                            //anropar på metoden deleteExpense, skickar med usern och utgift nummer, metoden tar bort utgiften från users arraylista av utgifter
                            expenseManager.deleteExpense(expenseTransactionNumber, loggedInUser);
                        }
                        //ifall användaren ändra summan av en viss utgift, presenterar listan över utgiftert genom att anropa på metoden displayExpenseList från klassen expenseManager och ber att välja expense efter nummer
                        if (secondMenuOption == 7){
                            System.out.println("You chose to change the amount of an expense transaction. Here come the current list of all expense transactions.\n" +
                                    "Please introduce the number of the transaction you want to change.");
                            expenseManager.displayExpenseList(loggedInUser);
                            int expenseTransactionNumber = scanner.nextInt();
                            //ber att skriva in en ny summa
                            System.out.println("Please introduce the new amount of the transaction.");
                            double newExpenseAmount = scanner.nextDouble();
                            //anropar metoden changeExpense från klassen expenseManager och skickar med usern, ny summa, number av utgiften på listan
                            expenseManager.changeExpense(loggedInUser, newExpenseAmount, expenseTransactionNumber);
                        }
                        //ifall användaren har valt att logga ut, ger värdet null till variabeln loggedInUser
                        if (secondMenuOption == 8){
                            loggedInUser = null;
                        }
                    }

                //Ifall användaren valt att registreras som ny användaren, tar emot användarens namn och efternamn och lägger till en ny user till systemet genom att anropa metoden addUser
                } else if (firstMenuOption == 2) {
                    System.out.println("Please write your first name: ");
                    String newUserFirstName = scanner.next();
                    System.out.println("Please write your last name: ");
                    String newUserLastName = scanner.next();
                    userManager.addUser(newUserFirstName, newUserLastName);


                    //Ifall användaren 3. avslutar programmet
                } else if (firstMenuOption == 3) {
                    System.exit(0);
                    //ifall användaren har introducerat annat än 1,2,3 skriver ut felmedelande
                } else {
                    System.out.println("Invalid option. Please choose.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Please choose 1, 2. or 3.");
                scanner.next();
            }
        }
    }*/

}
