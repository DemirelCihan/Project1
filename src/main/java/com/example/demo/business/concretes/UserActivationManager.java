package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.EmailService;
import com.example.demo.business.abstracts.UserActivationService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.UserActivationDao;
import com.example.demo.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserActivationManager implements UserActivationService {
private UserActivationDao userActivationDao;
private EmailService emailService;
@Autowired
public UserActivationManager(UserActivationDao userActivationDao, EmailService emailService){
    this.emailService = emailService;
    this.userActivationDao = userActivationDao;
}

    @Override
    public Result add(UserActivation userActivation) {

    userActivation.setActivated(false);
    userActivation.setCode(generateCode());
    userActivation.setIsActivatedDate(LocalDateTime.now());

    this.userActivationDao.save(userActivation);
        return emailService.sendEmail(userActivation.getUser());
    }

    @Override
    public Result update(UserActivation userActivation) {
    this.userActivationDao.save(userActivation);
    return new SuccessResult();
    }

    @Override
    public DataResult<UserActivation> getByCode(String code) {
        return new SuccessDataResult<UserActivation>
                (this.userActivationDao.getByCode(code));
    }

    @Override
    public DataResult<UserActivation> getByUserId(int userId) {
        return new SuccessDataResult<UserActivation>
                (this.userActivationDao.getByUser_Id(userId));
    }

    private String generateCode(){
        UUID code = UUID.randomUUID();

        return code.toString();
    }

}
