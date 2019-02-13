/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.schoolproject.entity;

import com.example.schoolproject.constant.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "t_user_guru")
public class UserGuru extends BaseEntity{
    
    @OneToOne(orphanRemoval = true)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;
    
    @Column(nullable = false, unique = true)
    private @Getter @Setter String nip;
    
    @NotEmpty
    private @Getter @Setter String nama;
    
    @JoinColumn(name = ("id_mapel"))
    @ManyToOne
    private @Getter @Setter Mapel mapel;
    
    @JoinColumn(name = ("id_kelas"))
    @ManyToOne
    private @Getter @Setter Kelas kelas;
    
    @NotEmpty
    private @Getter @Setter String alamat;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
