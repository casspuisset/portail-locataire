package com.chatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chatop.models.DBUser;

public interface DBUserRepository extends JpaRepository<DBUser, Integer> {
    public DBUser findByUsername(String username);
}