package com.example.newsfeed.repository;

import com.example.newsfeed.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommenetRepository extends JpaRepository<Comment, Long> {
}
