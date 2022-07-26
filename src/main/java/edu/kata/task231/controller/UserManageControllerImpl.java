package edu.kata.task231.controller;

import edu.kata.task231.model.User;
import edu.kata.task231.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserManageControllerImpl {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user_manage";
    }

    @GetMapping("/update/{id}")
    public String preUpdate(ModelMap modelMap, @PathVariable("id") Long id) {
        modelMap.addAttribute("user", userService.findOne(id));
        return "user_manage";
    }

    @PostMapping("/create")
    public String create(User user) {
        userService.save(user);
        return "redirect:/index";
    }

    @PostMapping("/update")
    public String update(User user) {
        userService.save(user);
        return "redirect:/index";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        userService.remove(id);
        return "redirect:/index";
    }
}
