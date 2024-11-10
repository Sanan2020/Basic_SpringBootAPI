package com.example.demo.controllers;

import com.example.demo.controllers.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0);
        return userService.save(user);
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User myUser = userService.findById(id);
        if(myUser==null){
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส"+id);
        }
        return myUser;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        User myUser = userService.findById(id);
        if(myUser==null){
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส"+id);
        }
        userService.deleteById(id);
        return "ลบข้อมูลผู้ใช้รหัส "+id+" เรียบร้อยแล้ว";
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
//    @GetMapping("/users")
//    public List<User> getUsers(){
//        List<User> data = new ArrayList<User>();
//        data.add(new User("Kun","Nut"));
//        data.add(new User("Kun","TATA"));
//        data.add(new User("MR.","Conan"));
//        return data;
//    }

//    @GetMapping("/about")
//    public String getAbout(){
//        return "Am a developer";
//    }
//
//    @GetMapping("/address")
//    public String getAddress(){
//        return "Bangkok";
//    }
//
//    @GetMapping("/job")
//    public String getJob(){
//        return "Programmer";
//    }
}
