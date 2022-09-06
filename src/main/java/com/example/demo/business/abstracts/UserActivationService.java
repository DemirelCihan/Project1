package com.example.demo.business.abstracts;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concretes.UserActivation;

public interface UserActivationService {

    Result add(UserActivation userActivation);

    Result update(UserActivation userActivation);
    DataResult<UserActivation> getByCode(String code);

    DataResult<UserActivation> getByUserId(int userId);

}
