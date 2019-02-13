package com.example.schoolproject.dao;

import com.example.schoolproject.entity.UserMurid;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MuridDao extends PagingAndSortingRepository<UserMurid, String>{
  
}
