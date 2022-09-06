package com.example.demo.entities.concretes;

import com.example.demo.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viewers")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Viewer extends User {
    @Column(name = "first_name")
    private String viewerFirstName;

    @Column(name = "last_name")
    private String viewerLastName;

    @Column(name = "phone_number")
    private String phoneNumber;


    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private UserActivation userActivation;
}
