package com.example.schoolproject.controller;

import com.example.schoolproject.dao.KelasDao;
import com.example.schoolproject.dao.MapelDao;
import com.example.schoolproject.entity.Mapel;
import java.util.Optional;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author agung
 */
@Controller
@RequestMapping("/mapel")
public class MapelController {
    
    @Autowired
    private MapelDao mapelDao;
    
    @Autowired
    private KelasDao kelasDao;
    
    @GetMapping("/list")
    public String showList(ModelMap mm, @PageableDefault Pageable page){
        
        mm.addAttribute("data", mapelDao.findAll(page));
        return "mapel/list";
    }
    
    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) Optional<String> id, ModelMap mm){
        
        if(id.isPresent()){
            mapelDao.findById(id.get()).ifPresent(Mapel -> mm.addAttribute("data", Mapel));
        } else {
            mm.addAttribute("mapel", new Mapel());
        }
        
        mm.addAttribute("listKelas", kelasDao.findAll());
        return "mapel/form";
    }
    
    @PostMapping("/form")
    public String prossesForm(ModelMap mm, Mapel data){
        mapelDao.save(data);
        
        return "redirect:/mapel/list";
    }

    @GetMapping("/delete")
    public String mapel(@RequestParam String id, ModelMap mm) {
        if (StringUtils.hasText(id)) {
            Optional<Mapel> op =  mapelDao.findById(id);
            if (op.isPresent()) {
                Mapel mapel = op.get();
                if (mapel != null) {
                    mapelDao.deleteById(id);
                }
            }
        }
        return "redirect:/mapel/list";
    }
}
