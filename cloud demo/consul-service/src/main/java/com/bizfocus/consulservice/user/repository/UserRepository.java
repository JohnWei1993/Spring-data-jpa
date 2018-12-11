package com.bizfocus.consulservice.user.repository;

import com.bizfocus.consulservice.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-11-30 15:58
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    Page<User> findByNameAndAge(String name, int age, Pageable pageable);

    @Query("select u from User u where u.name = :name")
    Page<User> getUserListByName(@Param("name") String name, Pageable pageable);

    @Query("select u from User u where u.name = ?1 and u.age = ?2")
    Page<User> getUserListByNameAndAge(String name, int age, Pageable pageable);
}
