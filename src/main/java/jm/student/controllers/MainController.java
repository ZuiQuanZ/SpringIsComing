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
    private MainController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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

    @GetMapping("/admin")
    public ModelAndView usersListPage(@ModelAttribute ModelAndView model) {
        List<User> users = userService.getAllUsers();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("admin", user);
        model.addObject("users", users);
        model.addObject("roles", roleService.getAllRoles());
        return model;
    }

    @GetMapping("/user")
    public ModelAndView userPage(@ModelAttribute ModelAndView model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.isAdmin());
        model.addObject("roles", roleService.getAllRoles());
        model.addObject("user", user);
        return model;
    }

    @GetMapping("/example")
    public ModelAndView examPage(@ModelAttribute ModelAndView model) {
        return model;
    }

    @GetMapping("/admin/editUser")
    public ModelAndView editUserPage(@ModelAttribute ModelAndView model, @RequestParam("id") Long id) {
        model.addObject("roles", roleService.getAllRoles());
        model.addObject("user", userService.getById(id));
        return model;
    }

    @PostMapping("/admin/editUser")
    public String editUser(@ModelAttribute User user, @RequestParam(value = "roled", required = false) Long[] idRoles) {
        Set<Role> roles = new HashSet<>();

        if (idRoles != null) {
            for (Long id : idRoles) {
                roles.add(roleService.getRoleById(id));
            }
        }

        user.setRoles(roles);
        userService.editUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/addUser")
    public ModelAndView addUserPage(@ModelAttribute ModelAndView model) {
        model.addObject("roles", roleService.getAllRoles());
        return model;
    }

    @PostMapping("/admin/addUser")
    public String addUser(@ModelAttribute User user, @RequestParam(value = "rol", required = false) Long[] idRoles) {
        Set<Role> roles = new HashSet<>();
        if (idRoles != null) {
            for (Long id : idRoles) {
                roles.add(roleService.getRoleById(id));
            }
        }
        user.setRoles(roles);
        userService.addUser(user);

        return "redirect:/admin";
    }
}
