package com.example.schoolproject.controller;

import com.example.schoolproject.dao.KelasDao;
import com.example.schoolproject.dao.MuridDao;
import com.example.schoolproject.entity.Murid;
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

@Controller
@RequestMapping("/murid")
public class MuridController {
    
    @Autowired
    private MuridDao md;
    
    @Autowired
    private KelasDao  kd;
    
    @GetMapping("/list")
    public String showList(ModelMap mm, @PageableDefault Pageable page){
        
        mm.addAttribute("data", md.findAll(page));
        return "murid/list";
        
    }
    
    @GetMapping("/form")
    public String showForm(@RequestParam (required = false) Optional<String> id, ModelMap mm ){
        
        if (id.isPresent()) {
            md.findById(id.get()).ifPresent(Murid -> mm.addAttribute("data", Murid));
        } else {
            mm.addAttribute("murid", new Murid());
        }
       
        mm.addAttribute("listKelas", kd.findAll());
        return "murid/form";
    }
    
    @PostMapping("/form")
    public String prosesForm(ModelMap mm, Murid data) {
       
        md.save(data);
        
        return "redirect:/murid/list";
    }
}
