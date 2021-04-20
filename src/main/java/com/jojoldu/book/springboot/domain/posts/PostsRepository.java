package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {   // CRUD 메소드 자동 생성, Entity 와 Repository 는 함께 위치해야함.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")  // 굳이 쿼리를 작성하지 않아도 구현 가능하지만, 지원하지 않는 쿼리라도
    List<Posts> findAllDesc();                          // 이와 같이 직접 쿼리로 작성하여 구현하는 것도 가능. 가독성은 덤.
}
