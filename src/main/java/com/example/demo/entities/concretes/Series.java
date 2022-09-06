package com.example.demo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "series_name")
    private String seriesName;

    @Column(name = "series_episode")
    private int seriesEpisode;

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
