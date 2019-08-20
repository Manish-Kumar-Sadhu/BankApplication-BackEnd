package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {

}
