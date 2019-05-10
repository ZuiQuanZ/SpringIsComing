package jm.student.controllers;

import jm.student.models.Role;
import jm.student.models.User;
import jm.student.service.abstraction.RoleService;
import jm.student.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/admin/delRest")
    public void delRest(Long id) {
        userService.removeUser(id);
    }


    @PostMapping(path = "/admin/addUser", consumes = "application/json")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping(path = "/admin/editUser", consumes = "application/json")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @GetMapping("/admin/getUsers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/admin/getAllRoles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /// split app task

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
    public void removeUserByIdFrClient (@PathVariable("id") Long id){
        userService.removeUser(id);
    }
    @PostMapping(path = "/addUserFromClient", consumes = "application/json")
    public void addUserFromClient(@RequestBody User user) {
        user.setId(null);
        userService.addUser(user);
        System.out.println(userService.getById(user.getId()).getLogin());
    }

    @PostMapping(path = "/editUserFromClient", consumes = "application/json")
    public void editUserFromClient(@RequestBody User user) {
        userService.editUser(user);
        System.out.println(userService.getById(user.getId()).getLogin());
    }

}
