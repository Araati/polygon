package com.araati.polygon.controller;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.entity.OwnerEntity;
import com.araati.polygon.facade.BlazonFacade;
import com.araati.polygon.model.BlazonPayload;
import com.araati.polygon.model.OwnerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
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

    @GetMapping("/blazon")
    List<BlazonEntity> all() {
        return facade.findAll();
    }

    @GetMapping("/blazon/{id}")
    BlazonEntity oneBlazon(@PathVariable Long id) {
        return facade.findBlazonByBlazonId(id);
    }

    @GetMapping("/blazon/{id}/owners")
    List<OwnerEntity> owners(@PathVariable Long id) {
        return facade.findOwnersByBlazonId(id);
    }
}
