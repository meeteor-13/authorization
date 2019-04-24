package com.github.meeteor13.authorization.domain.repository;

import com.github.meeteor13.authorization.domain.entity.DefaultUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DefaultUserDetailsRepository extends JpaRepository<DefaultUserDetails, UUID> {

    @Query("select distinct user from DefaultUserDetails user "
        + "inner join fetch user.authorities as authorities "
        + "where user.username = :username")
    Optional<DefaultUserDetails> findOneByUsername(@Param("username") String username);
}
