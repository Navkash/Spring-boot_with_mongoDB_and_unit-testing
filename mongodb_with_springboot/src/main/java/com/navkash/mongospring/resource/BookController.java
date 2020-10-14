package com.navkash.mongospring.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.navkash.mongospring.model.Book;
import com.navkash.mongospring.repository.BookRepository;



@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookService.addBook(book);
		return "book added with id : " + book.getId();
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return bookService.getListOfBooks();
	}

	@GetMapping("/findBook/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return "book deleted with id : " + id;
	}

}