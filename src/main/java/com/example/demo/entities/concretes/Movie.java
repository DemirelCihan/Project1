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
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "movie_name")
    private String movieName;

    @OneToOne
    @JoinColumn(name = "imdb_id")
    private Imdb imdb;

    @OneToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
