package com.github.meeteor13.authorization.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "authority")
@EntityListeners(AuditingEntityListener.class)
public class UserGrantedAuthority implements GrantedAuthority {

    @Id
    @GeneratedValue
    @Column(name = "a_id")
    private UUID id;

    @Column(name = "a_name")
    private String authority;

    @EqualsAndHashCode.Exclude
    @CreatedDate
    @Column(name = "a_created", nullable = false)
    private LocalDateTime created;

    @EqualsAndHashCode.Exclude
    @LastModifiedDate
    @Column(name = "a_modified", nullable = false)
    private LocalDateTime modified;

    @EqualsAndHashCode.Exclude
    @Column(name = "a_deactivated")
    private LocalDateTime deactivated;
}
