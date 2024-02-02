package com.QueryDslDemo.queryDSldemo.repository.Impl;

import com.QueryDslDemo.queryDSldemo.entity.Book;
import com.QueryDslDemo.queryDSldemo.repository.BookRepository;

import javax.persistence.EntityManager;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book,Integer> implements BookRepository {
    public BookRepositoryImpl(EntityManager em) {
        super(Book.class, em);
    }
}
