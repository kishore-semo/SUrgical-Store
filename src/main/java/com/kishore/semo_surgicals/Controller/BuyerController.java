package com.kishore.semo_surgicals.Controller;

import com.kishore.semo_surgicals.Model.Buyer;
import com.kishore.semo_surgicals.Model.Customer;
import com.kishore.semo_surgicals.Model.Stock;
import com.kishore.semo_surgicals.Repository.BuyerRepository;
import com.kishore.semo_surgicals.Repository.CustomerRepository;
import com.kishore.semo_surgicals.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuyerController {
    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/viewBuyers")
    public String View(Model model) {
        model.addAttribute("itemDtoList", buyerRepository.findAll());
        return "/buyer/View";
    }

    @GetMapping("/createBuyer")
    public String Create(Model model) {
        Buyer itemIssuanceDto = new Buyer();
        model.addAttribute("itemTypeList", stockRepository.findAll());
        model.addAttribute("itemDto", itemIssuanceDto);
        return "/buyer/Create";
    }

    @PostMapping("/createBuyer")
    public String Create(@ModelAttribute("itemDto") Buyer itemDto, BindingResult result, Model model) {
        buyerRepository.save(itemDto);
        return "redirect:/viewBuyers";
    }

}
