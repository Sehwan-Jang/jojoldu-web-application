package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
        // H2 데이터베이스 자동 실행
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    private final String title = "테스트 게시글";
    private final String content = "테스트 본문";

    @BeforeEach
    void setUp() {
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("aaron@gamil.com")
                .build());
    }

    @After
    public void cleanUp() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글 저장 불러오기")
    public void save() {
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    @DisplayName("BaseTimeEntity 등록 테스트")
    public void baseTimeEntity() {
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}