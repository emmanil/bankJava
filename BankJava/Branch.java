package BankJava;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    //initialise name and instantiate customers.
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double transaction) {
        Customer customer = findCustomer(name);
        if (customer == null) {
            return customers.add(new Customer(name, transaction));
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameOfCustomer, double transaction) {
        Customer customer = findCustomer(nameOfCustomer);
        if (customer != null){
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (this.customers.get(i).getName().equals(name)) {
                return customers.get(i);
            }
        }
        return null;
    }

}





