package com.github.meeteor13.authorization.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class DefaultUserDetails implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "u_id")
    private UUID id;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;

    @EqualsAndHashCode.Exclude
    @Column(name = "u_account_non_expired")
    private boolean accountNonExpired;

    @EqualsAndHashCode.Exclude
    @Column(name = "u_account_non_locked")
    private boolean accountNonLocked;

    @EqualsAndHashCode.Exclude
    @Column(name = "u_credentials_non_expired")
    private boolean credentialsNonExpired;

    @EqualsAndHashCode.Exclude
    @Column(name = "u_enabled")
    private boolean enabled;

    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_authorities",
        joinColumns = {
            @JoinColumn(name = "u_id", referencedColumnName = "u_id", table = "user")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "a_id", referencedColumnName = "a_id", table = "authority")
        }
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @Fetch(value = FetchMode.JOIN)
    private Set<UserGrantedAuthority> authorities;

    @EqualsAndHashCode.Exclude
    @CreatedDate
    @Column(name = "u_created", nullable = false)
    private LocalDateTime created;

    @EqualsAndHashCode.Exclude
    @LastModifiedDate
    @Column(name = "u_modified", nullable = false)
    private LocalDateTime modified;

    @EqualsAndHashCode.Exclude
    @Column(name = "u_deactivated")
    private LocalDateTime deactivated;
}
