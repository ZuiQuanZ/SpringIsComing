package jm.student.controllers;

import jm.student.models.User;
import jm.student.service.abstraction.RoleService;
import jm.student.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    private RestControl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/getUser")
    public User getUser(){ return userService.getById(Long.valueOf(1));}
}
