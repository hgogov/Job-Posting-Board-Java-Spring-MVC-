package com.company.jobs.mapper;

import com.company.jobs.entity.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Mapper(componentModel = "spring")
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    public ReferenceMapper() {
    }

    public <T extends BaseEntity> T toEntity(Long id, @TargetType Class<T> entityClass) {
        return id != null ? entityManager.find(entityClass, id) : null;
    }

    public Long toReference(BaseEntity entity) {
        return entity != null ? entity.getId() : null;
    }
}
