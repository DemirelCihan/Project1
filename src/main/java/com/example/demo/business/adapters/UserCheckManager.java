package com.example.demo.business.adapters;

import org.springframework.stereotype.Service;

@Service
public class UserCheckManager implements  UserCheckService {
    @Override
    public boolean checkIfRealPerson(String viewerFirstName, String viewerLastName, String phoneNumber) {
        return true;
    }
}
