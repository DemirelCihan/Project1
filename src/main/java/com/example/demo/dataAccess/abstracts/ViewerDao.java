package com.example.demo.dataAccess.abstracts;

import com.example.demo.entities.concretes.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewerDao extends JpaRepository<Viewer,Integer> {

}
