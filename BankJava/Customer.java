package BankJava;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double deposit) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(deposit);
    }

    public String getName() {
        return name;
    }


    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double deposit) {
        this.transactions.add(deposit);
    }
}
