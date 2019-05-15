package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM users " +
            "WHERE email IS NOT NULL " +
            "AND extract(MONTH FROM birthday) = :month " +
            "AND extract(DAY FROM birthday) = :day",
            nativeQuery = true)
    List<User> findByMatchMonthAndMatchDay(@Param("month") int month, @Param("day") int day);
}
