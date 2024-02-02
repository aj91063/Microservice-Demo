package com.QueryDslDemo.queryDSldemo.repository.Impl;

import com.QueryDslDemo.queryDSldemo.entity.QAuthor;
import com.QueryDslDemo.queryDSldemo.entity.QBook;
import com.QueryDslDemo.queryDSldemo.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;


public abstract class BaseRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    protected  final QAuthor author=QAuthor.author;
    protected  final QBook book=QBook.book;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em=em;
        this.jpaQueryFactory=new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id)
                .orElseThrow(()->new IllegalArgumentException("entity not found with id "+id));
    }
}
