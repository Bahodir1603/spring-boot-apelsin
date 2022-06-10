package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.springbootapelsin.entity.Detail;
import uz.pdp.springbootapelsin.service.DetailService;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    DetailService detailService;

    @GetMapping
    public String getAll(Model model){
        detailService.getAll(model);
        return "detail/list";
    }

    @GetMapping("/add")
    public String getAddPage(){
        return "detail/add";
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Detail detail,Model model){
        detailService.add(model,detail);
        return "detail/list";
    }
}
