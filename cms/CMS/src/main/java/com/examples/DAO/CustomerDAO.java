package com.examples.DAO;

import com.examples.Entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    // select customer by id
    @Transactional
    public Customer selectCustomer(int id){
        Session session = sessionFactory.getCurrentSession();
        Customer c = session.createQuery("from Customer c WHERE c.id = :id", Customer.class)
                .setParameter("id", id).getSingleResult();
        return c;

        // return session.get(Customer.class,id);

    }

    // select all customers
    @Transactional
    public List<Customer> selectAll(){
        Session session = sessionFactory.getCurrentSession();
        List<Customer> c=session.createQuery("from Customer c", Customer.class).getResultList();
        return c;
    }

    // insert customer
    @Transactional
    public void insertCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
    }

    // update customer
    @Transactional
    public void updateCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        Customer c = selectCustomer(customer.getId());
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setEmail(customer.getEmail());
        session.persist(c);
    }

    // delete customer
    @Transactional
    public void deleteCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        session.remove(customer);
    }

    @Transactional
    public List<Customer> sortByName(){
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customers = session.createQuery("from Customer c ORDER BY c.firstName", Customer.class).getResultList();
        return customers;
    }

    @Transactional
    public List<Customer> searchByName(String name){
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customers = session.createQuery("from Customer c where c.firstName=:name", Customer.class).setParameter("name", name).getResultList();
        return customers;
    }

}
