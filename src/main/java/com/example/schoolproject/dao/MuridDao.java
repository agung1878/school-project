package com.example.schoolproject.dao;

import com.example.schoolproject.entity.Murid;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MuridDao extends PagingAndSortingRepository<Murid, String>{
  
}
