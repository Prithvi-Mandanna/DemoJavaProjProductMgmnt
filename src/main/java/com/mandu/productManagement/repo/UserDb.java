package com.mandu.productManagement.repo;

import com.mandu.productManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDb extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
