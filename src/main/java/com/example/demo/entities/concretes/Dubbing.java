package com.example.demo.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "dubbings")
public class Dubbing {//dublajlama
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "dubbing_id")
    private int id;


}
