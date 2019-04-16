package com.mateusz.app.repository;

import com.mateusz.app.domain.Comment;
import com.mateusz.app.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
