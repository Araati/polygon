package com.araati.polygon.controllers;

import com.araati.polygon.models.Blazon;
import com.araati.polygon.repo.BlazonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    public String search(@RequestParam String owner, @RequestParam String descr, @RequestParam String hash, Model model) {
        ArrayList<Blazon> blazons = blazonRepo.findBlazonsByOwnerOrDescrContainsOrHash(owner, descr, hash);
        model.addAttribute("blazons", blazons);
        return "view";
    }

    @GetMapping("/add")
    public String blazonAdd(Model model)   {
        return "blazon-add";
    }

    @PostMapping("/add")
    public String blazonAdd(@RequestParam String owner, @RequestParam String descr, @RequestParam String hash, Model model) {
        Blazon blazon = new Blazon(owner, descr, hash);
        blazonRepo.save(blazon);
        return "redirect:/";
    }

    @RequestMapping(value="/data", method=RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public String saveBlazon(@RequestBody Blazon blazon) {
        blazonRepo.save(blazon);
        return "Saved blazon: " + blazon.getDescr();
    }

    @GetMapping("/{id}")
    public String blazonView(@PathVariable(value = "id") long id, Model model)   {
        Optional<Blazon> blazon = blazonRepo.findById(id);
        model.addAttribute("blazons", blazon);
        return "view";
    }
}
