package com.examples.Controllers;

import com.examples.Entities.Customer;
import com.examples.Services.CustomerService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService cs;

    @RequestMapping("/add")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @RequestMapping("/process")
    public String processAddCustomer(Customer customer, Model model, BindingResult bindingResult){
        cs.insertCustomer(customer);
        model.addAttribute("customer", cs.selectAll());
        if(bindingResult.hasErrors())
            return "add-customer";
        else return "customer-list";
    }

    @RequestMapping("/showAll")
    public String showCustomers(Model model){
        model.addAttribute("customer", cs.selectAll());
        return "customer-list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        Customer customer = cs.select(id);
        cs.deleteCustomer(customer);
        model.addAttribute("customer", cs.selectAll());
        return "customer-list";
    }

    @RequestMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable int id, Model model){
        model.addAttribute("customer", cs.select(id));
        return "update-customer";
    }

    @RequestMapping("/updateCustomer/update")
    public String processUpdateCustomer(Customer customer, Model model, BindingResult bindingResult){
        cs.update(customer);
        model.addAttribute("customer", cs.selectAll());
        if(bindingResult.hasErrors())
            return "update-customer";
        else return "customer-list";
    }

    @RequestMapping("/sort")
    public String sort(Model model){
        model.addAttribute("customer", cs.sortByName());
        return "customer-list";
    }

    @RequestMapping("/search")
    public String search(Model model){
        model.addAttribute("customer",new Customer());
        return "search";
    }

    @RequestMapping("/searchByName")
    public String searchByName(String name, Model model){
        List<Customer> customers = cs.searchByName(name);
        model.addAttribute("customer", customers);
        return "customer-list";
    }

}
