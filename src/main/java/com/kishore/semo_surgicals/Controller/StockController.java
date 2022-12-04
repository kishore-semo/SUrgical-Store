package com.kishore.semo_surgicals.Controller;

import com.kishore.semo_surgicals.Model.Stock;
import com.kishore.semo_surgicals.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StockController {

	@Autowired
	private StockRepository stockRepository;


	@GetMapping("/ItemView")
	public String View(Model model) {
		model.addAttribute("itemDtoList", stockRepository.findAll());
		return "/stock/View";
	}


	@GetMapping("/ItemCreate")
	public String Create(Model model) {
		Stock stock = new Stock();
		model.addAttribute("itemDto", stock);
		model.addAttribute("itemTypeList", stockRepository.findAll());
		return "/stock/Create";
	}


	@PostMapping("/ItemCreate")
	public String Create(@ModelAttribute("itemDto") Stock itemDto, BindingResult result, Model model) {

		stockRepository.save(itemDto);
		return "redirect:/ItemView";
	}

	/**
	 *
	@GetMapping("/ItemEdit/{id}")
	public String Edit(@PathVariable(value = "id") long id, Model model) {
		Item item = itemService.getItemById(id);
		model.addAttribute("itemDto", itemConvertor.modelToDto(item));
		model.addAttribute("itemTypeList", itemTypeService.getAllItemTypes());
		return "/Item/Edit";
	}

	@GetMapping("/ItemDelete/{id}")
	public String Delete(@PathVariable(value = "id") long id, Model model) {
		Item item = itemService.getItemById(id);
		model.addAttribute("itemDto", itemConvertor.modelToDto(item));
		return "/Item/Delete";
	}

	@PostMapping("/ItemDelete/{id}")
	public String Delete(@PathVariable(value = "id") long id, @ModelAttribute("itemDto") ItemDto itemDto) {
		itemService.deleteItem(id);
		return "redirect:/ItemView";
	}

	**/
}
