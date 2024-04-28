package org.example.Controllers;

import org.example.pojo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/add")
    public String customerForm(Model model){
        model.addAttribute("theCustomer", new Customer());
        return "add-customer";
    }

    @RequestMapping("/process")
    public String addCustomer(@Valid @ModelAttribute("theCustomer") Customer customer, BindingResult result){
//        Customer customer = (Customer) model.getAttribute("theCustomer");
        if (result.hasErrors())
            return "add-customer";
        else return "customer-confirmation" ;
    }



}
