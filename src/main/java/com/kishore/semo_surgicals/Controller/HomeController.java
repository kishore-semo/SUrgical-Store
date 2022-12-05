package com.kishore.semo_surgicals.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;



@Controller
public class HomeController {

    @GetMapping("/")
    public String Index(Model model){
        model.addAttribute("chartData", getChartData());

        return "index";
    }
    private List<List<Object>> getChartData() {
        return List.of(
                List.of("September", new Random().nextInt(5)),
                List.of("October", new Random().nextInt(5)),
                List.of("November", new Random().nextInt(5)),
                List.of("December", new Random().nextInt(5))
        );
    }
}