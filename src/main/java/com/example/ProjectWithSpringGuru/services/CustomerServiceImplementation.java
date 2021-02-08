package com.example.ProjectWithSpringGuru.services;

import com.example.ProjectWithSpringGuru.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImplementation() {
        loadCustomers();
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("John");
        customer1.setLastName("McCain");
        customer1.setEmail("McCain@gmail.com");
        customer1.setPhoneNumber("111111111");
        customer1.setAddressLine1("address1");
        customer1.setAddressLine2("address2");
        customer1.setCity("Washington");
        customer1.setState("Columbia District");
        customer1.setZipCode("some zip Washington");
        customers.put(1, customer1);


        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Barack");
        customer2.setLastName("Obama");
        customer2.setEmail("Obama@gmail.com");
        customer2.setPhoneNumber("111111112");
        customer2.setAddressLine1("address1");
        customer2.setAddressLine2("address2");
        customer2.setCity("New York");
        customer2.setState("New Jersey");
        customer2.setZipCode("some zip New York");
        customers.put(2, customer2);


        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Dick");
        customer3.setLastName("Cheney");
        customer3.setEmail("Cheney@gmail.com");
        customer3.setPhoneNumber("111111113");
        customer3.setAddressLine1("address1");
        customer3.setAddressLine2("address2");
        customer3.setCity("Dallas");
        customer3.setState("Texas");
        customer3.setZipCode("some zip Dallas");
        customers.put(3, customer3);


        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setFirstName("Joe");
        customer4.setLastName("Biden");
        customer4.setEmail("Biden@gmail.com");
        customer4.setPhoneNumber("111111114");
        customer4.setAddressLine1("address1");
        customer4.setAddressLine2("address2");
        customer4.setCity("Seattle");
        customer4.setState("Washington");
        customer4.setZipCode("some zip Seattle");
        customers.put(4, customer4);


        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setFirstName("Ronald");
        customer5.setLastName("Reagan");
        customer5.setEmail("Reagan@gmail.com");
        customer5.setPhoneNumber("111111115");
        customer5.setAddressLine1("address1");
        customer5.setAddressLine2("address2");
        customer5.setCity("Las Vegas");
        customer5.setState("Nevada");
        customer5.setZipCode("some zip Las Vegas");
        customers.put(5, customer5);
    }

    @Override
    public List<Customer> getListOfAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                customer.setId(generateNextCustomerId());
            }
            customers.put(customer.getId(), customer);
            return customer;
        } else {
            throw new RuntimeException("Customer cannot be null");
        }
    }


    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private Integer generateNextCustomerId() {
        return customers.keySet().stream().max(Comparator.comparingInt(k -> k)).get()+1;
    }
}
