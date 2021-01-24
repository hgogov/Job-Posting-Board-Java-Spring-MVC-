package com.company.jobs.repository.impl;

import com.company.jobs.dto.SearchDTO;
import com.company.jobs.entity.Job;
import com.company.jobs.repository.JobCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class JobCustomRepositoryImpl implements JobCustomRepository {

    private final EntityManager entityManager;

    @Autowired
    public JobCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Job> findByCriteria(SearchDTO searchDTO) {
        List<Predicate> predicates = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Job> criteriaQuery = criteriaBuilder.createQuery(Job.class);
        Root<Job> root = criteriaQuery.from(Job.class);
        criteriaQuery.select(root);

        if (!searchDTO.getName().equals("") && searchDTO.getName() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchDTO.getName().toLowerCase() + "%"));
        }
        if (!searchDTO.getCategory().equals("")) {
            predicates.add(criteriaBuilder.equal(root.get("category").get("id"), searchDTO.getCategory()));
        }
        if (!searchDTO.getLocation().equals("")) {
            predicates.add(criteriaBuilder.equal(root.get("location").get("id"), searchDTO.getLocation()));
        }
        if (!searchDTO.getExperienceLevel().equals("")) {
            predicates.add(criteriaBuilder.equal(root.get("experienceLevel").get("id"), searchDTO.getExperienceLevel()));
        }
        if (!searchDTO.getType().equals("")) {
            predicates.add(criteriaBuilder.equal(root.get("type").get("id"), searchDTO.getType()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
