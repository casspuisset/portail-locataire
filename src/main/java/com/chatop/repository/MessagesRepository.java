package com.chatop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatop.model.Messages;

@Repository
public interface MessagesRepository extends CrudRepository<Messages, Long>{
}
