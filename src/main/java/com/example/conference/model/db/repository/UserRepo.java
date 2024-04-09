package com.example.conference.model.db.repository;

import com.example.conference.model.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "select * from users first_name =:firstName order by first_name desc limit 1")
    User findFirstName(@Param("firstName") String firstName);

    @Query("select u from User u where u.firstName =:firstName")
    List<User> findAllFirstName(@Param("firstName") String firstName);
}
