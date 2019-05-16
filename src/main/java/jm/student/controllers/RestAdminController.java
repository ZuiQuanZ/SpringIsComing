package jm.student.controllers;

import jm.student.models.Role;
import jm.student.models.User;
import jm.student.services.RoleService;
import jm.student.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    private RestAdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/getUser/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/getUserByLogin/{login}/1",
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
    public void removeUserById(@PathVariable("id") Long id) {
        userService.removeUser(id);
    }

    @PostMapping(path = "/addUser", consumes = "application/json")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping(path = "/editUser", consumes = "application/json")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

}
