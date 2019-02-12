package com.example.schoolproject.controller;

import com.example.schoolproject.dao.JurusanDao;
import com.example.schoolproject.dao.KelasDao;
import com.example.schoolproject.entity.Kelas;
import java.util.Optional;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/kelas")
public class KelasController {

    @Autowired
    private KelasDao kd;

    @Autowired
    private JurusanDao jd;

    private static final Logger logger = LoggerFactory.getLogger(KelasController.class);

    @GetMapping("/list")
    public String showList(ModelMap mm, @PageableDefault Pageable pageable) {

        mm.addAttribute("data", kd.findAll(pageable));
        return "kelas/list";
    }

    @GetMapping("/form")
    public String showForm(ModelMap mm, @RequestParam(required = false) Optional<String> id) throws Exception {
      
        if (id.isPresent()) {
            kd.findById(id.get()).ifPresent(Kelas -> mm.addAttribute("kelas", Kelas));
        } else {
            mm.addAttribute("kelas", new Kelas());
        }

        mm.addAttribute("listJurusan", jd.findAll());
        return "kelas/form";
    }

    @PostMapping("/form")
    public String prossesForm(Kelas data) {

        kd.save(data);

        return "redirect:/kelas/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id, ModelMap mm) {
        if (StringUtils.hasText(id)) {
            Optional<Kelas> op = kd.findById(id);
            if (op.isPresent()) {
                Kelas kelas = op.get();
                if (kelas != null) {
                    kd.deleteById(id);
                }
            }
        }
        return "redirect:/kelas/list";
    }
}
