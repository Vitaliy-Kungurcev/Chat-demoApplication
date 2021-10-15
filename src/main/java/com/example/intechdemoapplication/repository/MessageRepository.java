package com.example.intechdemoapplication.repository;

import com.example.intechdemoapplication.entity.Message;
import com.example.intechdemoapplication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
