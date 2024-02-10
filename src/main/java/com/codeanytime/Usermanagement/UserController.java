package com.codeanytime.Usermanagement;

import com.codeanytime.Usermanagement.model.User;
import com.codeanytime.Usermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity<User> addUser(User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = (List<User>) userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUsers(@PathVariable("id") Long id){
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(User user){userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<User> getUserByFirstName(@PathVariable String firstName){
        User user = userService.findUserByfirstName(firstName);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/{personnummer}")
    public ResponseEntity<?> getUserByPersonnummer(@PathVariable Long personnummer){
        userService.findByPersonnummer(personnummer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
