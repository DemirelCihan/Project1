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
@Table(name = "sort_with_calender")
public class SortWithCalender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sort_with_calender_id")
    private int id;

}
