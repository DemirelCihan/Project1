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
@Table(name = "imdbs")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Imdb { //dizi veya filmlerin imdb puanları
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imdb_id")
    private int id;

    @Column(name = "imdb")
    private float Imdb;




}
