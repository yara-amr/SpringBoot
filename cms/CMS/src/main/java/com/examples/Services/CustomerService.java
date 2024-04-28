package com.examples.Services;

import com.examples.DAO.CustomerDAO;
import com.examples.Entities.Customer;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> selectAll(){
        return this.customerDAO.selectAll();
    }

    public Customer select(int id){ return this.customerDAO.selectCustomer(id);}

    public void insertCustomer(Customer customer){
        customerDAO.insertCustomer(customer);
    }

    public void update(Customer customer){customerDAO.updateCustomer(customer);}

    public void deleteCustomer(Customer customer){
        customerDAO.deleteCustomer(customer);
    }

    public List<Customer> sortByName(){
        return this.customerDAO.sortByName();
    }

    public List<Customer> searchByName(String name){
        return this.customerDAO.searchByName(name);
    }


}
