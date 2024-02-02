package com.QueryDslDemo.queryDSldemo.repository;

import com.QueryDslDemo.queryDSldemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends BaseRepository<Book,Integer> {
}
