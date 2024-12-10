package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;


@MappedSuperclass
@EnableJpaAuditing
public class BaseModel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpadtedAt() {
        return upadtedAt;
    }

    public void setUpadtedAt(Date upadtedAt) {
        this.upadtedAt = upadtedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date createdAt;


    @LastModifiedDate
    protected Date upadtedAt;
}
