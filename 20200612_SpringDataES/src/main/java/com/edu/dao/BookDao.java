package com.edu.dao;

import com.edu.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface BookDao extends ElasticsearchRepository<Book,Long> {
}
