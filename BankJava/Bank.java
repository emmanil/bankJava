package BankJava;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    //It initialises name and instantiates branches.
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String nameBranch) {
        Branch tempBranch = findBranch(nameBranch);
        if (tempBranch == null) {
            return branches.add(new Branch(nameBranch));
        }
        return false;
    }

    public boolean addCustomer(String nameBranch, String nameCustomer, double transaction) {

        Branch tempBranch = findBranch(nameBranch);

        if (tempBranch != null) {
            return tempBranch.newCustomer(nameCustomer, transaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameBranch, String nameCustomer, double transaction) {

        Branch tempBranch = findBranch(nameBranch);
        if (tempBranch == null) {
            return false;
        }
        return tempBranch.addCustomerTransaction(nameCustomer, transaction);
    }

    private Branch findBranch(String nameBranch) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(nameBranch)) {
                return branches.get(i);
            }
        }
        return null;
    }


    public boolean listCustomers(String nameBranch, boolean printTransaction) {
        Branch tempBranch = findBranch(nameBranch);
        if (tempBranch == null) {
            return false;
        }
        if (!printTransaction) {
            System.out.println("Customer details for branch " + tempBranch.getName());
            for (int i = 0; i < tempBranch.getCustomers().size(); i++) {
                System.out.println("Customer: " + tempBranch.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
            }
            return true;
        }

        System.out.println("Customer details for branch " + tempBranch.getName());
        for (int i = 0; i < tempBranch.getCustomers().size(); i++) {
            System.out.println("Customer: " + tempBranch.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
            System.out.println("Transactions");
            for (int j = 0; j < tempBranch.getCustomers().get(i).getTransactions().size(); j++) {
                System.out.println("[" + (j + 1) + "]  Amount " + tempBranch.getCustomers().get(i).getTransactions().get(j));
            }
        }
        return true;
    }
}
