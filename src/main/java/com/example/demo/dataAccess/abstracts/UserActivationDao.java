package com.example.demo.dataAccess.abstracts;

import com.example.demo.entities.concretes.UserActivation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivationDao extends JpaRepository<UserActivation, Integer> {
    UserActivation getByCode(String code);

    UserActivation getByUser_Id(int userId);

}

