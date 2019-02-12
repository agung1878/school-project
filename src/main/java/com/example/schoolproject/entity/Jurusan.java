/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.schoolproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author agung
 */
@Entity
@Table(name = ("t_jurusan"))
public class Jurusan extends BaseEntity{
    
    @NotEmpty
    private @Getter @Setter String nama;
}
