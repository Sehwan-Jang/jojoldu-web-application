package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity     //테이블과 링크될 클래스. 카멜케이스가 _로 변환되어 링크
public class Posts extends BaseTimeEntity {

    @Id     // 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)     // 테이블의 컬럼. 굳이 추가하지 않아도 모든 필드들은 컬럼으로 등록됨
    private String title;                       // 사용하는 이유는 추가적으로 설정하고자 하는 것이 있을때 설정 가능.

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
