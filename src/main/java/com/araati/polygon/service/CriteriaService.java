package com.araati.polygon.service;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.entity.OwnerEntity;
import com.araati.polygon.model.CriteriaDTO;
import com.araati.polygon.repository.CriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;
    @Autowired
    private BlazonService blazonService;
    @Autowired
    private OwnerService ownerService;

    public Page<BlazonEntity> findByCriteria(CriteriaDTO criteria, Pageable pageable)   {
            Specification<BlazonEntity> main = (root, query, criteriaBuilder) -> {

                if (criteria.getOwnerId() != 0) {
                    OwnerEntity owner = ownerService.findOwnerByOwnerId(criteria.getOwnerId());
                    BlazonEntity blazon = blazonService.findBlazonByBlazonId(owner.getBlazonId());
                    return root.get("id").in(blazon.getId());
                }

                if (!criteria.getHash().isEmpty()) {
                    return root.get("hash").in(criteria.getHash().get());
                }

                if (!criteria.getDescription().isEmpty()) {
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + criteria.getDescription().get() + "%"); // TODO: 26.06.2021 Можно сделать "мягкий поиск" с помощью %
                }
                return null;
            };
        return criteriaRepository.findAll(main, pageable);
    }
}
