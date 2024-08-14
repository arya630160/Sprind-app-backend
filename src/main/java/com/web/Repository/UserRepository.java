package com.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
