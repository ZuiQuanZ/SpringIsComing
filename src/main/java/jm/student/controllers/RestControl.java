package jm.student.controllers;

import jm.student.models.User;
import jm.student.service.abstraction.RoleService;
import jm.student.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getLogin")
    public  String getLogin(@RequestParam(value = "id", required = false) Long id){

        return userService.getById(Long.valueOf(id)).getLogin();}

    @GetMapping("/getResp")
    public ResponseEntity<User> getResponse(@RequestParam(value = "id", required = false) Long id){
        return  ResponseEntity.ok(userService.getById(Long.valueOf(id)));}

    @GetMapping("/getUser")
    public void getUser(User user){
        System.out.println(user.getId()+" "+user.getLogin()+" "+user.getPassword());

    }
}
