package com.example.demo.core.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private int id;


    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    @NotNull(message = "E-posta adresi boş geçilmez.")
    @NotBlank(message = "E-posta adresi boş geçilmez.")
    @Column(name = "email",unique = true)
    private String email;

    @NotNull(message = "Şifre alanı boş geçilmez")
    @NotBlank(message = "Şifre alanı boş geçilmez")
    @Column(name = "password")
    private String password;
}
