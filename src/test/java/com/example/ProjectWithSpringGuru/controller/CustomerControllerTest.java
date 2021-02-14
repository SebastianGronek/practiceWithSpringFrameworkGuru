package com.example.ProjectWithSpringGuru.controller;

import com.example.ProjectWithSpringGuru.model.Customer;
import com.example.ProjectWithSpringGuru.services.CustomerService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getAllCustomersTest() throws Exception {
        //given
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());
        System.out.println(customers.size());

        //when
        when(customerService.listAll()).thenReturn((List) customers);
        //then
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("customerList", hasSize(2)));
    }

    @Test
    void addCustomer() {
    }

    @Test
    public void getCustomerById() throws Exception {
        //given
        Integer id = 1;
        //when
        when(customerService.getById(id)).thenReturn(new Customer());
        //then
        mockMvc.perform(get("/customer/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void saveOrUpdateCustomer() {
    }

    @Test
    void edit() {
    }
}

