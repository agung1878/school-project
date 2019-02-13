package com.example.schoolproject.controller;

import com.example.schoolproject.dao.JurusanDao;
import com.example.schoolproject.entity.Jurusan;
import java.util.Optional;
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
@RequestMapping("/jurusan")
public class JurusanController {
    
    @Autowired
    private JurusanDao jd;
    
    @GetMapping("/list")
    public String showList(ModelMap mm, @PageableDefault Pageable pageable){
        
        mm.addAttribute("datas", jd.findAll(pageable));
        return "jurusan/list";
    }
    
    @GetMapping("/form")
    public String showForm(ModelMap mm, @RequestParam (required = false) Optional<String> id){
        
        if (id.isPresent()){
            jd.findById(id.get()).ifPresent(Jurusan -> mm.addAttribute("datas", Jurusan));
        } else {
            mm.addAttribute("jurusan", new Jurusan());
        }
        
        return "jurusan/form";
    }
    
    @PostMapping("/form")
    public String prossesForm(ModelMap mm, Jurusan data){
    
        jd.save(data);
        
        return "redirect:/jurusan/list";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam String id, ModelMap mm) {
        if (StringUtils.hasText(id)) {
            Optional<Jurusan> op = jd.findById(id);
            if (op.isPresent()) {
                Jurusan jurusan = op.get();
                if (jurusan != null) {
                    jd.deleteById(id);
                }
            }
        }
        return "redirect:/jurusan/list";
    }
}
