package com.example.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@MappedSuperclass // JPAエンティティの親クラスに必要
@Data
public abstract class TimestampEntity {
    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column(name = "create_time", updatable = false)
    private Timestamp createTime;

    @PrePersist
    public void prePersist() {
        Timestamp ts = Timestamp.from(Instant.now());
        this.createTime = ts;
        this.updateTime = ts;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateTime = Timestamp.from(Instant.now());
    }
}