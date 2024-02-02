package com.QueryDslDemo.queryDSldemo.repository;

import com.QueryDslDemo.queryDSldemo.dto.AuthorStatistic;
import com.QueryDslDemo.queryDSldemo.entity.Author;


import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository<Author,Integer> {

    public Optional<Author> findAuthorByEmail(String email);

    public List<AuthorStatistic> getAuthorStatistic();

    public List<Author> getAuthors();
}
