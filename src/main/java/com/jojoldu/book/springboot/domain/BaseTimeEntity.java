package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@MappedSuperclass   //Entity 클래스가 이걸 상속받을 경우 createdDate와 modifiedDate 도 컬럼으로 추가됨
@EntityListeners(AuditingEntityListener.class)  // Auditing 기능 추가
public abstract class BaseTimeEntity {

    @CreatedDate    // Entity 생성시 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate   //Entity 값 변경시 시간 자동 저장
    private LocalDateTime modifiedDate;
}
