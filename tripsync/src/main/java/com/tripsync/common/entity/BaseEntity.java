package com.tripsync.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDateTime createAt;
    @Column(name="updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        LocalDateTime now=LocalDateTime.now();
        createAt=now;
        updatedAt=now;
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt=LocalDateTime.now();

    }

    public LocalDateTime getCreateAt(){
        return createAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
}
