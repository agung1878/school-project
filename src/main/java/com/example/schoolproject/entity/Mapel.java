/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.schoolproject.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "t_mapel")
public class Mapel extends BaseEntity{
    
    @NotEmpty
    private @Getter @Setter String nama;
    
    @JoinColumn(name = "id_kelas")
    @ManyToOne
    private @Getter @Setter Kelas kelas;
}
