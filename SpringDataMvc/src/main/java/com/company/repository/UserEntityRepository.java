package com.company.repository;

import com.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "SELECT * FROM users " +
            "WHERE email IS NOT NULL " +
            "AND extract(MONTH FROM birthday) = :month " +
            "AND extract(DAY FROM birthday) = :day",
            nativeQuery = true)
    List<UserEntity> findByMatchMonthAndMatchDay(@Param("month") int month, @Param("day") int day);
}
