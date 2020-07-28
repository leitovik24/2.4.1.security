package test.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test.users.dao.RoleDao;
import test.users.model.Role;
import test.users.model.User;
import test.users.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RoleDao roleDao;
    private final UserService service;
    @Autowired
    public AdminController(RoleDao roleDao, UserService service) {
        this.roleDao = roleDao;
        this.service = service;
    }

    @GetMapping
    public String adminPage(ModelMap model) {
        List<User> users = service.allUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping(value = "/addAdmin")
    public String addAdmin(Model model) {
        model.addAttribute("addUser");
        return "addAdmin";
    }

    @PostMapping(value = "/addAdmin")
    public String addAdmin(@ModelAttribute("user") User user) {
        service.addAdmin(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/add")
    public String addUserPage(Model model) {
        model.addAttribute("addUser");
        return "add";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        service.add(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUserPage(@PathVariable("id") int id,
                               Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@RequestParam String id,
                           @RequestParam String name,
                           @RequestParam String password,
                           @RequestParam Set<Integer> roles){
        User user = new User(Integer.parseInt(id),name, password);
        user.setRoles(service.getRolesByName(roles));
        service.edit(user);
        return "redirect:/admin";

    }

     @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
     public String deleteUser(@PathVariable("id") int id) {
        User user = service.getUserById(id);
        service.delete(user);
        return "redirect:/admin";
    }
}
