package com.araati.polygon.controller;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.facade.BlazonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private BlazonFacade facade;

    @GetMapping("/blazonByOwner")
    public BlazonEntity searchBlazonByOwner(@RequestParam int ownerId)  {
        return(facade.findBlazonByOwnerId(ownerId));
    }

    @GetMapping("/blazonByHash")
    public BlazonEntity searchBlazonByHash(@RequestParam String hash)  {
        return(facade.findBlazonByHash(hash));
    }

    @GetMapping("/blazonByDescription")
    public List<BlazonEntity> searchBlazonByDescription(@RequestParam String description)   {
        return(facade.findBlazonByDescription(description));
    }
}
