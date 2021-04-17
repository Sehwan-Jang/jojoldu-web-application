package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {   // CRUD 메소드 자동 생성, Entity 와 Repository 는 함께 위치해야함.
}
