package ru.yapridu.aptbooking.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.yapridu.aptbooking.model.entity.User;
import ru.yapridu.aptbooking.service.security.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        System.out.println("До проверок ***************************************");
        if (bindingResult.hasErrors()) {
            System.out.println("***************");
            System.out.println("Ошибка1");
            System.out.println("***************");
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            System.out.println("***************");
            System.out.println("Ошибка2");
            System.out.println("***************");
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveUser(userForm)) {
            System.out.println("***************");
            System.out.println("Ошибка3");
            System.out.println("***************");
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        System.out.println("После проверок ***************************************");
        return "redirect:/";
    }
}
