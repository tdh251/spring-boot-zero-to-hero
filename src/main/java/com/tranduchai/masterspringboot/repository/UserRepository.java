package com.tranduchai.masterspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranduchai.masterspringboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
