package com.wisely.ch8_2.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.wisely.ch8_2.specs.CustomerSpecs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


public class CustomRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID>
{

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager)
    {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findByAuto(T example, Pageable pageable)
    {

        return findAll(CustomerSpecs.byAuto(entityManager, example), pageable);
    }

}
