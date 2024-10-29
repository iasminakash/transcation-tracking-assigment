package org.example;

public class User {
    private String id;
    private String username;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
/*

    private String firstName;

    private String lastName;

    private String userName = firstName + lastName;


    private ArrayList <Income> incomeArrayList;

    private ArrayList <Expense> expenseArrayList;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.incomeArrayList = new ArrayList<>();
        this.expenseArrayList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<Income> getIncomeArrayList() {
        return incomeArrayList;
    }

    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }
*/
}
