package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.UserActivationService;
import com.example.demo.business.abstracts.UserService;
import com.example.demo.business.abstracts.ViewerService;
import com.example.demo.business.adapters.UserCheckService;
import com.example.demo.core.results.*;
import com.example.demo.dataAccess.abstracts.ViewerDao;
import com.example.demo.entities.concretes.UserActivation;
import com.example.demo.entities.concretes.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ViewerManager implements ViewerService {
     private ViewerDao viewerDao;
     private UserService userService;
     private UserCheckService userCheckService;
     private UserActivationService userActivationService;

     @Autowired
    public ViewerManager(ViewerDao viewerDao, UserService userService, UserCheckService userCheckService,UserActivationService userActivationService){
         this.viewerDao = viewerDao;
         this.userService = userService;
         this.userCheckService = userCheckService;
         this.userActivationService = userActivationService;

     }


    @Override
    public Result add(Viewer viewer) {
         if(validateViewer(viewer) != null){
             return validateViewer(viewer);
         }
         this.viewerDao.save(viewer);
        return userActivationService.add(new UserActivation(viewer));
    }

    @Override
    public Result update(Viewer viewer) {
         Viewer v = getById(viewer.getId()).getData();
         viewer.setEmail(viewer.getEmail() == null || viewer.getEmail() == ""
         ? v.getEmail()
                 :viewer.getEmail());
         viewer.setPassword(viewer.getPassword() == null || viewer.getPassword() ==""
         ? v.getPassword()
                 : viewer.getPassword());
         viewer.setViewerFirstName(viewer.getViewerFirstName() == null || viewer.getViewerFirstName() == ""
         ? v.getViewerFirstName()
                 : viewer.getViewerFirstName());
         viewer.setViewerLastName(viewer.getViewerLastName() == null || viewer.getViewerLastName() == ""
         ? v.getViewerLastName()
                 : viewer.getViewerLastName());
         viewer.setPhoneNumber(viewer.getPhoneNumber() == null ||viewer.getPhoneNumber() ==""
         ? v.getPhoneNumber()
                 : viewer.getPhoneNumber());

         if(validateViewer(viewer) != null){
             return validateViewer(viewer);
         }
         this.viewerDao.save(viewer);
        return new SuccessResult();
    }

    @Override
    public Result activate(String code) {//mail adresinin onaylanabilmesi için kullanıcıya code gönderilecektir.
         //ardından code doğrulama işlemi gerçekleşirse üyelik işlemi tamamlanacaktır.
        UserActivation userActivation = userActivationService.getByCode(code).getData();
        if(userActivation == null){
            return new ErrorResult("Geçersiz bir kod girdiniz.");
        }
        Viewer viewer = getById(userActivation.getUser().getId()).getData();
        //izleyicinin kaydının ne zaman alındığını tutacak
        userActivation.setActivated(true);
        userActivation.setIsActivatedDate(LocalDateTime.now());

        viewerDao.save(viewer);
        userActivationService.update(userActivation);

        return new SuccessResult("Üyelik işlemleri tamamlandı.");
    }

    @Override
    public DataResult<Viewer> getById(int id) {
        return new SuccessDataResult<Viewer>
                (viewerDao.getById(id));
    }


    private boolean checkIfEmailExists(String email) {

        boolean result = false;

        if (userService.getByEmail(email).getData()== null) {
            result = true;
        }

        return result;
    }


    private Result validateViewer(Viewer viewer){
        if (!checkIfEmailExists(viewer.getEmail())) {
            return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
        }

        if(!userCheckService.checkIfRealPerson(viewer.getViewerFirstName(),viewer.getViewerLastName(),viewer.getPhoneNumber())){
            return new ErrorResult("Lütfen bilgileri doğru giriniz");

        }



        return null;


    }
}
