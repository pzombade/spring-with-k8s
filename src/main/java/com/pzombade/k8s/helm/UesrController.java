package com.pzombade.k8s.helm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController("/")
public class UesrController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String greet2(){
        return "It is now " + new Date();
    }

    @GetMapping("/greet")
    public String greet(){
        return "Good Morning";
    }


    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
       userRepository.save(user);
    }


    @DeleteMapping("/{userId}")
    public void saveUser(@PathVariable long userId){
        userRepository.deleteById(userId);
    }


    @GetMapping("/list")
    public Iterable<User> saveUser(){
       return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable long userId){
        return userRepository.findById(userId);
    }
}
