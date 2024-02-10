package com.codeanytime.Usermanagement.repository;

import com.codeanytime.Usermanagement.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

@Query("select u from User u where u.firstName = ?1")
    List<User> findFirstName(String firstName);

    @Query("select p from User p where p.personnummer = ?1")
    User findByPersonNummer(Long personnummer);

    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
