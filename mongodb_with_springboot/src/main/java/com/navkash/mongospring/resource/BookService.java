package com.navkash.mongospring.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navkash.mongospring.model.Book;
import com.navkash.mongospring.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> getListOfBooks() {
		List<Book> books=  new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}
	
	public String authorFirstName(Book book) {
		String[] st= book.toString().split(" ");
		return st[0];
	}

	public Optional<Book> getBookById(int id) {
		return bookRepository.findById(id);
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
		
	}
	

}
