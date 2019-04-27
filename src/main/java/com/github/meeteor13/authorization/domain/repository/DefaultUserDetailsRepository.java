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

    @Query(value = "select * from \"user\" where \"user\".u_username = ?1", nativeQuery = true)
    Optional<DefaultUserDetails> findOneByUsername(@Param("username") String username);
}
