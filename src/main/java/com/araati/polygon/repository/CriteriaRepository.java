package com.araati.polygon.repository;

import com.araati.polygon.entity.BlazonEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CriteriaRepository extends CrudRepository<BlazonEntity, Long>, JpaSpecificationExecutor<BlazonEntity>{}
