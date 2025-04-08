package main.controller;

import main.io.View;
import main.logic.Customer;
import main.service.CustomerService;

import java.util.List;
import java.util.Scanner;


public class Controller {
    private final CustomerService customerService = new CustomerService();
    private final Scanner scanner = new Scanner(System.in);
    private final View view = new View();

    public void controller(List<Customer> customers) {
        int choice;
        while (true) {
            view.menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {break;}
            switch (choice) {
                case 1 -> {
                    view.showMessage("Enter customers first letters:");
                    String n = scanner.nextLine();
                    view.showCustomers(customerService.findCustomersByLetters(customers, n));
                }
                case 2 ->{
                    view.showMessage("Enter specified credit card range:");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    view.showCustomers(customerService.findCustomersByCreditCardRange(customers, a, b));
                }

                case 3 ->{
                    view.showMessage("List customers who have debt:");
                    view.showCustomers(customerService.findCustomerByArrears(customers));
                }
                case 4->{
                    view.showMessage("List customers:");
                    view.showCustomers(customerService.findCustomerByTotalPurchases(customers));
                }
                case 5->{
                    view.showMessage("Enter customer name:");
                    String name = scanner.nextLine();
                    Customer customer = customerService.findCustomerByName(customers,name);
                    if(customer == null) {
                        view.showMessage("Customer not found");
                    }else{
                        view.showMessage("Average purchase:" + customer.getAveragePurchase());
                    }
                }
                case 6 ->{
                    view.showMessage("Enter file name:");
                    String filename = scanner.nextLine();
                    customerService.outputListTxt(customers, filename);
                }
                case 7 ->{
                    view.showMessage("Enter file name:");
                    String filename = scanner.nextLine();
                    customerService.outputListBinary(customers, filename);
                }
                case 8->{
                    view.showMessage("Enter file name:");
                    String file = scanner.nextLine();
                    customerService.readListTxt(file);
                }
                case 9 ->{
                    view.showMessage("Enter file name:");
                    String file = scanner.nextLine();
                    customerService.readListBinary(file);
                }

                default ->{
                    System.out.println("Invalid choice");
                }
            }
        }
    }

}