package com.kishore.semo_surgicals.Controller;

import com.kishore.semo_surgicals.Model.Customer;
import com.kishore.semo_surgicals.Model.Transactions;
import com.kishore.semo_surgicals.Repository.CustomerRepository;
import com.kishore.semo_surgicals.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionsRepository transactionsRepository;
    @GetMapping("/viewCustomers")
    public String View(Model model) {
        List<Customer> customers = customerRepository.findAll();
        int counter = 0;
        for (Customer customer : customers){
            Boolean transaction = transactionsRepository.existsByDefaulter(customer.getCustomerId());
            customer.setPaymentStatus(transaction?"Paid":"Defaulter");
            customers.set(counter,customer);
            counter++;
        }
        model.addAttribute("itemDtoList", customerRepository.findAll());
        return "/customer/View";
    }

    @GetMapping("/createCustomer")
    public String Create(Model model) {
        Customer itemIssuanceDto = new Customer();
        model.addAttribute("itemDto", itemIssuanceDto);
        return "/customer/Create";
    }

    @PostMapping("/createCustomer")
    public String Created(@ModelAttribute("itemDto") Customer itemDto, BindingResult result, Model model) {
        itemDto.setCustomerId(null);
        customerRepository.save(itemDto);
        return "redirect:/viewCustomers";
    }

}
