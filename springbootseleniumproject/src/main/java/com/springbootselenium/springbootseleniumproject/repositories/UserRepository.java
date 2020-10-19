package com.springbootselenium.springbootseleniumproject.repositories;

import com.springbootselenium.springbootseleniumproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
