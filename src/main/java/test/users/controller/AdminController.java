package test.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.users.model.User;
import test.users.service.UserService;
import test.users.service.UserServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService service;
    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String adminPage() {
        return "admin";
    }

    @GetMapping(value = "/admin/users")
    public String printAllUsers(ModelMap model) {
        List<User> list = service.allUsers();
        model.addAttribute("allUsers", list);
        return "admin";
    }

    @GetMapping(value = "/admin/add")
    public String addUserPage(Model model) {
        model.addAttribute("addUser");
        return "edit";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute("user") User user) {
        service.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/admin/edit/{id}")
    public String editUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/admin/edit")
    public String editFilm(@ModelAttribute("user") User user) {
        service.edit(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public String deleteUserPage(@PathVariable("id") int id) {
        User user = service.getUserById(id);
        service.delete(user);
        return "redirect:/admin/users";
    }
}
