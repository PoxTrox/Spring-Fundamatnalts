package org.example.pathfinder.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class HomeController {


//    @GetMapping("/")
//    public ModelAndView index() {
//        double dobrichTemp = new Random().nextDouble();
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("index");
//        mav.addObject("dobrichTemperature", dobrichTemp);
//
//
//        return mav;
//    }


    @GetMapping("/")
    public String index (Model model)  {
        double dobrichTemp = new Random().nextDouble();
        model.addAttribute("dobrichTemperature", dobrichTemp);

        return "index";
    }


}
