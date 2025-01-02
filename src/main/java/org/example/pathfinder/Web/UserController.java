package org.example.pathfinder.Web;


import jakarta.validation.Valid;
import org.example.pathfinder.Web.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {


    @GetMapping("users/register")

    public String register( Model model) {
        model.addAttribute("registerDate", new UserRegisterDto());

        return "register";
    }

    @PostMapping("users/register")

    public String doRegister(@Valid UserRegisterDto date, BindingResult result, RedirectAttributes redirectAttributes ) {
        if(result.hasErrors()) {

            redirectAttributes.addAttribute("registerData", date);
            return "register";
        }




        return "redirect:/users/login";
    }

    @GetMapping("users/login")
    public String viewLogin() {
        return "login";
    }




}

