package com.araati.polygon.controllers;

import com.araati.polygon.models.Blazon;
import com.araati.polygon.repo.BlazonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private BlazonRepo blazonRepo;

    @GetMapping("/")
    public String home(Model model) {
        return "main";
    }

    @PostMapping("/")
    public String search(@RequestParam String owner, @RequestParam String descr, @RequestParam String longDesc, @RequestParam String hash, @RequestParam String base64, Model model) {
        Blazon blazon = blazonRepo.findBlazonByOwnerOrDescrOrLongDescOrHashOrBase64(owner, descr, longDesc, hash, base64);
        long id = blazon.getId();
        if(!blazonRepo.existsById(id))   {
            return "redirect:/";
        }
        Optional<Blazon> blazon1 = blazonRepo.findById(id); //rewrite
        ArrayList<Blazon> res = new ArrayList<>();
        blazon1.ifPresent(res::add);
        model.addAttribute("blazon", res);
        return "view";
    }

    @GetMapping("/add")
    public String blazonAdd(Model model)   {
        return "blazon-add";
    }
    @PostMapping("/add")
    public String blazonAdd(@RequestParam String owner, @RequestParam String descr, @RequestParam String longDesc, @RequestParam String hash, @RequestParam String base64, Model model) {
        Blazon blazon = new Blazon(owner, descr, longDesc, hash, base64);
        blazonRepo.save(blazon);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String blazonView(@PathVariable(value = "id") long id, Model model)   {
        if(!blazonRepo.existsById(id))   {
            return "redirect:/";
        }
        Optional<Blazon> blazon = blazonRepo.findById(id);
        ArrayList<Blazon> res = new ArrayList<>();
        blazon.ifPresent(res::add);
        model.addAttribute("blazon", res);
        return "view";
    }

}
