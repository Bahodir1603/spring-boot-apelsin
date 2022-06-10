package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.entity.Detail;
import uz.pdp.springbootapelsin.repository.DetailRepository;

import javax.persistence.SecondaryTable;
import java.util.List;

@Service
public class DetailService {

    @Autowired
    DetailRepository detailRepository;

    public void getAll(Model model){
//        List<Detail> detailList = detailRepository.findAll();
        model.addAttribute("list",detailRepository.findAll()); // detailList
    }

    public void add(Model model,Detail detail){
        detailRepository.save(detail);
        model.addAttribute("list",detailRepository.findAll());
    }
}
