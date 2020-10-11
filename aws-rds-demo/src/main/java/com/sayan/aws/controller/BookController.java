package com.sayan.aws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.aws.model.Book;
import com.sayan.aws.service.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		Book newBook= bookRepository.save(book);
		return new ResponseEntity<Book>(newBook,HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Book>> findBooks() {
		return new ResponseEntity<List<Book>>(bookRepository.findAll(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findBook(@PathVariable int id)
	{
		Optional<Book> book =bookRepository.findById(id);
		if(!book.isPresent())
			System.out.println("Book not found"+id);
		return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
	}

}
