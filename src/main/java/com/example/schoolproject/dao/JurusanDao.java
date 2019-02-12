/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.schoolproject.dao;

import com.example.schoolproject.entity.Jurusan;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author agung
 */
public interface JurusanDao extends PagingAndSortingRepository<Jurusan, String>{
    
}
