package com.example.demo.business.abstracts;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.entities.concretes.Viewer;

public interface ViewerService <T>{
    Result add(Viewer viewer);

    Result update(Viewer viewer);

    Result activate(String code);//code ile üyelik aktifleşmesi

    DataResult<T> getById(int id);
    }



