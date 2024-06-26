package springBoot_CRUD.controller;

import org.springframework.validation.BindingResult;
import springBoot_CRUD.model.User;
import springBoot_CRUD.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showUsers(ModelMap model) {
        model.addAttribute("users", userService.listUser());
        return "allUsers";
    }

    @GetMapping(value = "/addUser")
    public String addUser(@ModelAttribute("newUser") User user) {
        return "newUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newUser";
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/editUser")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "editUser";
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
