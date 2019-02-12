/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.schoolproject.dao;

import com.example.schoolproject.entity.Mapel;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author agung
 */
public interface MapelDao extends PagingAndSortingRepository<Mapel, String>{
    
}
