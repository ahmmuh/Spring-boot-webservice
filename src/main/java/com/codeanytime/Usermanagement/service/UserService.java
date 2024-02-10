package com.codeanytime.Usermanagement.service;
import com.codeanytime.Usermanagement.model.User;
import com.codeanytime.Usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
       User newUser = userRepository.save(user);
       return newUser;
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
public User getUser(Long id){
        return userRepository.findById(id).get();
}


public User updateUser(User user){
       User updatedUser = userRepository.save(user);
       return updatedUser;
}


public void deleteUser(User user){
  userRepository.delete(user);
}

public void findByPersonnummer(Long personNummer){
        userRepository.findByPersonNummer(personNummer);
}

public User findUserByfirstName(String firstName){
    return (User) userRepository.findFirstName(firstName);
}

public void findByEmail(String email){
        userRepository.findByEmail(email);
}
}
