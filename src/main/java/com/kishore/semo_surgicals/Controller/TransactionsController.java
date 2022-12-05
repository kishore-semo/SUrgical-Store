package com.kishore.semo_surgicals.Controller;


import com.kishore.semo_surgicals.Model.Stock;
import com.kishore.semo_surgicals.Model.TransactionDTO;
import com.kishore.semo_surgicals.Model.Transactions;
import com.kishore.semo_surgicals.Repository.CustomerRepository;
import com.kishore.semo_surgicals.Repository.StockRepository;
import com.kishore.semo_surgicals.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class TransactionsController {

	@Autowired
	private TransactionsRepository transactionsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StockRepository stockRepository;


	@GetMapping("/ItemIssuanceView")
	public String View(Model model) {
		model.addAttribute("ItemIssuanceDtoList", transactionsRepository.findAll());
		return "/sale/View";
	}

	@GetMapping("/ItemIssuanceCreate")
	public String Create(Model model) {
		List<String> customerNames = customerRepository.findAllCustomerNames();
		List<String> stockNames = stockRepository.findAllStockNames();
		TransactionDTO itemIssuanceDto = new TransactionDTO();
		model.addAttribute("itemIssuanceDto", itemIssuanceDto);
		model.addAttribute("customerNames", customerNames);
		model.addAttribute("stockNames", stockNames);
		return "/sale/Create";
	}



	@PostMapping("/ItemIssuanceCreate")
	public String Create(@ModelAttribute("itemIssuanceDto") TransactionDTO transactionsDto,
			BindingResult result) {

		System.out.println(transactionsDto+"  "+transactionsDto.toString());
		if (transactionsDto.getPaymentStatus().equals("select")){
			ObjectError error = new ObjectError("globalError", "Please select the payment status");
			result.addError(error);

		}
		if (transactionsDto.getCustomerName().equals("0")||transactionsDto.getStockName().equals("0")){
			ObjectError error = new ObjectError("globalError", "Please select the Customer and stock");
			result.addError(error);
		}
		if (result.hasErrors()){
			return "/sale/Create";
		}else{
			Stock stock = stockRepository.findByName(transactionsDto.getStockName());
			Transactions transactions = new Transactions();
//			transactions.setTransactionId(1L);
			transactions.setPrice(transactionsDto.getPrice());
			transactions.setPaymentStatus(transactionsDto.getPaymentStatus().equals("Yes"));
			transactions.setQuantity(transactionsDto.getQuantity());
			transactions.setCustomer(customerRepository.findByCustomerName(transactionsDto.getCustomerName()).getCustomerId());
			transactions.setStock(stock.getStockId());
			if (transactions.getQuantity()>stock.getQuantity()){
				ObjectError error = new ObjectError("globalError", "There is only "+stock.getQuantity()+" quantity is remaining in the stock");
				result.addError(error);
				return "/sale/Create";
			}else {
				transactionsRepository.save(transactions);
				return "redirect:/ItemIssuanceView";
			}
		}
	}

	/**

	@GetMapping("/ItemIssuanceEdit/{id}")
	public String Edit(@PathVariable(value = "id") long id, Model model) {
		Loan loan = itemIssuanceService.findItemIssuedById(id);
		model.addAttribute("itemIssuanceDto", itemIssuanceConvertor.modelToDto(loan));
		return "/Item Issuance/Edit";
	}

	@GetMapping("/ItemIssuanceDelete/{id}")
	public String Delete(@PathVariable(value = "id") long id, Model model) {
		Loan loan = itemIssuanceService.findItemIssuedById(id);
		model.addAttribute("itemIssuanceDto", itemIssuanceConvertor.modelToDto(loan));
		return "/Item Issuance/Delete";
	}

	@PostMapping("/ItemIssuanceDelete/{id}")
	public String Delete(@PathVariable(value = "id") long id,
			@ModelAttribute("itemIssuanceDto") ItemIssuanceDto itemIssuanceDto) {
		itemIssuanceService.deleteIssuedItemById(id);
		return "redirect:/ItemIssuanceView";
	}
	**/
}
