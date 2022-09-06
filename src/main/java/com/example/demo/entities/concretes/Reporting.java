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
@Table(name = "reportings")
public class Reporting { //raporlama
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportings_id")
    private int id;

}
