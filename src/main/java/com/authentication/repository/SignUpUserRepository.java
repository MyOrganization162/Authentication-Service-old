package com.authentication.repository;

import com.authentication.model.Signuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpUserRepository extends JpaRepository<Signuser, Long> {
}
