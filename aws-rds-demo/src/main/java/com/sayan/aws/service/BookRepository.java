package com.sayan.aws.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayan.aws.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
