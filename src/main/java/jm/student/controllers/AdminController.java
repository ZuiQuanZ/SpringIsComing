package jm.student.controllers;

import jm.student.models.Role;
import jm.student.models.User;
import jm.student.service.abstraction.RoleService;
import jm.student.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    private AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/getLogin")
    public String getLogin(@RequestParam(value = "id", required = false) Long id) {

        return userService.getById(Long.valueOf(id)).getLogin();
    }

    @GetMapping("/getResp")
    public ResponseEntity<User> getResponse(@RequestParam(value = "id", required = false) Long id) {
        return ResponseEntity.ok(userService.getById(Long.valueOf(id)));
    }

    @GetMapping("/getUser")
    public void getUser(User user) {
        System.out.println(user.getId() + " " + user.getLogin() + " " + user.getPassword());
    }

    @GetMapping("/delRest")
    public void delRest(Long id) {
        userService.removeUser(id);
    }

    @GetMapping("/printUser")
    public void printUser(Long id, String login) {
        System.out.println(id + ' ' + login);
    }

    //    @PostMapping("/addUser")
//    public void addUser(User user, @RequestParam(value="idRoles" , required = false)  Long[] idRoles){
//        Set<Role> roles = new HashSet<>();
//        if (idRoles != null) {
//            for (Long id : idRoles) {
//                roles.add(roleService.getRoleById(id));
//            }
//        }
//        user.setRoles(roles);
//        userService.addUser(user);
//    }

    @PostMapping("/addUser")
    public void addUser( @RequestBody( required = false) Long[] idRoles) {
        System.out.println(idRoles[0]);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

}
