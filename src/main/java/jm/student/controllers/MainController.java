package jm.student.controllers;

import jm.student.models.Role;
import jm.student.models.User;
import jm.student.secutiry.utility.CodeMessenger;
import jm.student.secutiry.utility.ErrorCode;
import jm.student.secutiry.utility.SuccessCode;
import jm.student.service.abstraction.RoleService;
import jm.student.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    private MainController(UserService userService,RoleService roleService){
        this.userService=userService;
        this.roleService=roleService;
    }

    @GetMapping("/users")
    public ModelAndView getUserPage(ModelAndView model) {
        User user = userService.getById(Long.valueOf(1));
        model.setViewName("hello");
        String password = user.getLogin();
        model.addObject("name", password);
        return model;
    }
    @GetMapping("/")
    public String toLoginPage() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView loginPage(ModelAndView model, HttpServletRequest request) {
        ErrorCode code = CodeMessenger.getErrorCode();
        SuccessCode successCode = CodeMessenger.getSuccessCode();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(user);
        if (!user.equals("anonymousUser")) {
            // todo: доделать

            model.setViewName("redirect:" + request.getHeader("refer"));
            return model;
        }

        model.setViewName("login");
        if (code != null && code.equals(ErrorCode.LOGIN)) {
            model.addObject("isNotValid", true);
        }

        if (successCode != null && successCode.equals(SuccessCode.LOGOUT)) {
            model.addObject("logout", true);
        }

        return model;
    }

    @GetMapping("/admin/uList")
    public ModelAndView usersListPage(@ModelAttribute ModelAndView model) {
        List<User> users = userService.getAllUsers();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("admin", user);
        model.addObject("users", users);
        model.addObject("roles", roleService.getAllRoles());
        return model;
    }

    @RequestMapping(value = {"/admin/deleteUser/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin/uList";
    }

    @RequestMapping(value = { "/addUser" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "addUser";
    }

    @RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
    public String savePerson(
                             @ModelAttribute("user") User user) {

        Set<Role> roles = new HashSet<>();
            Role role=roleService.getRoleById(Long.valueOf(1));
            roles.add(role);
        user.setRoles(roles);
        userService.addUser(user);
        return "users";
    }
}
