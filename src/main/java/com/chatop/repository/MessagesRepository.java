package com.chatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatop.model.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long>{
}
