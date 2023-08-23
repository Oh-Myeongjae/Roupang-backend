package com.teamsupercat.roupangbackend.repository;

import com.teamsupercat.roupangbackend.entity.LoginFail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginFailRepository extends JpaRepository<LoginFail, Integer> {
    Optional<LoginFail> findByDomain(String domain);
}
