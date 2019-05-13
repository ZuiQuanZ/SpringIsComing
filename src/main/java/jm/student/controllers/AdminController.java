package jm.student.controllers;

import jm.student.models.Role;
import jm.student.models.User;
import jm.student.service.abstraction.RoleService;
import jm.student.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    private AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/getUser/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/getUserByLogin/{login}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public User getUser(@PathVariable("login") String login) {
        return userService.getUserByLogin(login);
    }

    @GetMapping(value = "/getRole/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Role getRole(@PathVariable("id") Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping(value = "/getRoleList")
    public List<Role> getRoleList() {
        return roleService.getAllRoles();
    }

    @GetMapping(value = "/getUserList")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/removeUserById/{id}")
    @ResponseBody
    public void removeUserByIdFrClient(@PathVariable("id") Long id) {
        userService.removeUser(id);
    }

    @PostMapping(path = "/addUserFromClient", consumes = "application/json")
    public void addUserFromClient(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping(path = "/editUserFromClient", consumes = "application/json")
    public void editUserFromClient(@RequestBody User user) {
        userService.editUser(user);
    }

}
