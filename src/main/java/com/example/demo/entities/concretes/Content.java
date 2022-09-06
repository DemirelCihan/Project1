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
@Table(name = "contents")
public class Content {//dizi/film açıklamaları,kısa bilgi
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "content_id")
    private int id;

    @Column(name = "content")
    private String content;
}
