package com.example.conference.model.db.repository;

import com.example.conference.model.db.entity.Conference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConferenceRepo extends JpaRepository<Conference, Long> {

    Page<Conference> findById(Pageable request, Long userId);

    @Query("select c from Conference c where c.user.firstName = :userFirstName")
    List<Conference> findConferences(@Param("userFirstName") String userFirstName);

    Page<Conference> findByUserId(Pageable request, Long id);
}
