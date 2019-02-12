package com.example.schoolproject.controller;

import com.example.schoolproject.dao.GuruDao;
import com.example.schoolproject.dao.KelasDao;
import com.example.schoolproject.dao.MapelDao;
import com.example.schoolproject.entity.Guru;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author agung
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    
    @Autowired
    private GuruDao gd;
    
    @Autowired
    private MapelDao mapelDao;
    
    @Autowired
    private KelasDao KelasDao;
    
    @GetMapping("/list")
    public String showList(ModelMap mm, @PageableDefault Pageable pageable){
       
        mm.addAttribute("data", gd.findAll(pageable));
        return "guru/list";
    }
    
    @GetMapping("/form")
    public String showForm(ModelMap mm, @RequestParam(required = false) Optional<String> id){
        
        if(id.isPresent()){
            gd.findById(id.get()).ifPresent(Guru -> mm.addAttribute("data", Guru));
        } else {
            mm.addAttribute("guru", new Guru());
        }
        
        mm.addAttribute("listKelas", KelasDao.findAll());
        mm.addAttribute("listMapel", mapelDao.findAll());
        return "guru/form";
    }
    
    @PostMapping("/form")
    public String prossesForm(ModelMap mm, Guru data){
    
        gd.save(data);
        
        return "redirect:/guru/list";
    }
}
