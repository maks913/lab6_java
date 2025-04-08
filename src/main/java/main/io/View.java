package main.io;

import main.logic.Customer;

import java.util.List;

public class View {
    public void showCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void menu() {
        System.out.println("Customer Menu:\n1.List customer by first letters\n2.List customers by specified credit card range\n3.List customers who have negative balance\n4.List customers sorted by descending total spend.\n5.Find customer by name.\n6.Save customers to txt\n7.Save customers to bin\n8.Load customers from txt\n9.Load customers from bin\n0.Exit");
    }
}