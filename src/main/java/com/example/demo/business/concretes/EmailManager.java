package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.EmailService;
import com.example.demo.core.entities.User;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {
    @Override
    public Result sendEmail(User user) {
        return new SuccessDataResult(user.getEmail() + "adresine e-posta gönderildi.");

    }
}
