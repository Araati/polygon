package com.araati.polygon.controllers;

import com.araati.polygon.models.Blazon;
import com.araati.polygon.repo.BlazonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {

    @Autowired
    private BlazonRepo blazonRepo;

    @GetMapping("/")
    public String home(Model model) {
        return "main";
    }

    @GetMapping("/list")
    public String search(@RequestParam String owner, @RequestParam String descr, @RequestParam String hash,
                         Model model, @PageableDefault Pageable pageable) {
        Page<Blazon> page = blazonRepo.findBlazonsByOwnerOrDescrContainsOrHash(owner, descr, hash, pageable);
        model.addAttribute("blazonPage", page);
        model.addAttribute("owner", owner);
        model.addAttribute("descr", descr);
        model.addAttribute("hash", hash);
        int totalPages = page.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "view";
    }
//АААААААААААААААААААААААААААААААААААААААААААААААААААААААААа
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
    } //РАБОТАЙ ПОЖАЛУЙСТА

    /*@GetMapping("/{id}")
    public String blazonView(@PathVariable(value = "id") long id, Model model)   {
        Optional<Blazon> blazon = blazonRepo.findById(id);
        model.addAttribute("blazons", blazon);
        return "view";
    }Не работает, нужен отдельный вид без пагинации*/
}
