package com.araati.polygon.controller;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.facade.BlazonFacade;
import com.araati.polygon.model.CriteriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriteriaController {

    @Autowired
    private BlazonFacade facade;

    @GetMapping("/criteria")
    public Page<BlazonEntity> findByCriteria(
            @RequestParam long ownerId,
            @RequestParam String hash,
            @RequestParam String description,
            //@RequestBody CriteriaDTO criteria,
            Pageable pageable)   {
        CriteriaDTO criteria = new CriteriaDTO(ownerId, hash, description);
        return facade.findByCriteria(criteria, pageable);
    }
}
