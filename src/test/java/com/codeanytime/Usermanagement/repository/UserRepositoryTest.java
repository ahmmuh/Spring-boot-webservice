package com.codeanytime.Usermanagement.repository;

import com.codeanytime.Usermanagement.model.Address;
import com.codeanytime.Usermanagement.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser(){
        User user = new User();
        user.setFirstName("Anas Ahmed");
        user.setLastName("Mukhtar");
        user.setPersonnummer(202001028223L);
        user.setEmail("anas@hotmail.com");
        user.setProfileImage("profile.png");

        Address address = new Address();
        address.setStreet("Al heyel asher");
        address.setCity("Cairo");
        address.setState("Cairo");
        address.setCountry("Egypt");
        address.setZipCode(992200);
        user.setAddress(address);
        userRepository.save(user);
        System.out.println(user);
    }

    @Test
    void getUsers(){
       Iterable<User> users = userRepository.findAll();
       users.forEach((user) -> System.out.println(user.getFirstName()));
    }

    @Test
    void getUser(){
        Optional<User> user = userRepository.findById(1L);
        System.out.println(user);

    }

    @Test
    void updateUser(){
      User user = userRepository.findById(1L).get();
      user.setEmail("abdinaasir@gmail.com");
      user.setPersonnummer(202001021199L);
      userRepository.save(user);
    }

@Test
void findUserByFirstName(){
        List<User> users = userRepository.findFirstName("Abdinaasir Ahmed");
        users.forEach((u) ->{
            System.out.println("Firstname is " + u.getFirstName());
        });
}

@Test
void findByPersonNummer(){
        User user = userRepository.findByPersonNummer(199501027214L);
    System.out.println("The person we have founded is " + user.getFirstName() + " " + user.getLastName());
}

@Test
void  findByEmail(){
        User user = userRepository.findByEmail("abdinaasir@hotmail.com");
    System.out.println("His email address is " + user.getEmail());
}

 @Test
    void deleteUser(){
        userRepository.deleteById(1L);
 }

}