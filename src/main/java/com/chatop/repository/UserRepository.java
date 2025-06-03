package com.chatop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatop.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{
    Users findByUserName(String email);
}
