package main.service;

import main.interfaces.CustomerRepository;
import main.logic.Customer;
import main.repositories.CustomerRepositoryBinaryIml;
import main.repositories.CustomerRepositoryTxtIml;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private final CustomerRepository repository1 = new CustomerRepositoryTxtIml();
    private final CustomerRepository repository2 = new CustomerRepositoryBinaryIml();

    public void outputListTxt(List<Customer> customers, String fileName) {
        repository1.outputList(customers, fileName);
    }

    public void outputListBinary(List<Customer> customers, String fileName) {
        repository2.outputList(customers, fileName);
    }

    public List<Customer> readListTxt(String fileName) {
        return repository1.readList(fileName);
    }

    public List<Customer> readListBinary(String fileName) {
        return repository2.readList(fileName);
    }


    public List<Customer> findCustomersByLetters(List<Customer> customers, String prefix) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCustomerName().toLowerCase().startsWith(prefix.toLowerCase())) {
                result.add(customer);
            }
        }
        return result;
    }

    public List<Customer> findCustomersByCreditCardRange(List<Customer> customers, int a, int b) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            int cardNumber = customer.getCardNumber();
            if (cardNumber >= a && cardNumber <= b) {
                result.add(customer);
            }
        }
        return result;
    }

    public List<Customer> findCustomerByArrears(List<Customer> customers) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getAccBalance() < 0) {
                result.add(customer);
            }
        }
        return result;
    }

    public List<Customer> findCustomerByTotalPurchases(List<Customer> customers) {
        return customers.stream()
                .sorted(Comparator.comparingDouble(Customer::getTotalPurchases).reversed().thenComparing(Customer::getCustomerName))
                .collect(Collectors.toList());
    }

    public Customer findCustomerByName(List<Customer> customers, String name) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

}