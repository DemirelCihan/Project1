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
@Table(name = "top_one_hundred")
public class Top100 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "top_one_hunderd_id")
    private int id;
}
