package com.araati.polygon.controller;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.entity.OwnerEntity;
import com.araati.polygon.facade.BlazonFacade;
import com.araati.polygon.model.BlazonPayload;
import com.araati.polygon.model.OwnerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private BlazonFacade facade;

    @PostMapping("/blazonAdd")
    public void addBlazon(@RequestBody final BlazonPayload payload) {
        facade.create(payload);
    }

    @PostMapping("/ownerAdd")
    public void assignOwner(@RequestBody final OwnerPayload payload)    {
        facade.addOwner(payload);
    }

    @GetMapping("/")
    public String home(Model model) {
        return "main";
    }

    @GetMapping("/blazon")
    public String findBlazon(@RequestParam(required = false) String ownerId,
                             @RequestParam(required = false) String hash, Model model) {
        //todo: Костыль с парсингом строки
        if(ownerId != "") {
            long ownerIdNumeric = Integer.parseInt(ownerId);
            //todo: facade.findBlazonByOwnerId содержит в себе findOwnerByOwnerId, можно оптимизировать
            BlazonEntity blazon = facade.findBlazonByOwnerId(ownerIdNumeric);
            OwnerEntity owner = facade.findOwnerByOwnerId(ownerIdNumeric);
            model.addAttribute("blazon", blazon);
            model.addAttribute("owner", owner);
            return "blazon-view";
        }
        else if(hash != "") {
            BlazonEntity blazon = facade.findBlazonByHash(hash);
            OwnerEntity owner = facade.findOwnerByBlazonId(blazon.getId());
            model.addAttribute("blazon", blazon);
            model.addAttribute("owner", owner);
            return "blazon-view";
        }
        else
            return "redirect:/";
    }

    /*@GetMapping("/list")
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
    }*/

    /*@GetMapping("/add")
    public String blazonAdd(Model model)   {
        return "blazon-add";
    }*/

    /*@PostMapping("/add")
    public String blazonAdd(@RequestParam String owner, @RequestParam String descr, @RequestParam String hash, Model model) {
        Blazon blazon = new Blazon(owner, descr, hash);
        blazonRepo.save(blazon);
        return "redirect:/";
    }*/

    /*@RequestMapping(value="/data", method=RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public String saveBlazon(@RequestBody Blazon blazon) {
        blazonRepo.save(blazon);
        return "Saved blazon: " + blazon.getDescr();
    }*/

    /*@GetMapping("/{id}")
    public String blazonView(@PathVariable(value = "id") long id, Model model)   {
        Optional<Blazon> blazon = blazonRepo.findById(id);
        model.addAttribute("blazons", blazon);
        return "view";
    }Не работает, нужен отдельный вид без пагинации*/
}
