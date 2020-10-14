package com.navkash.mongospring;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;


//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.navkash.mongospring.model.Book;
import com.navkash.mongospring.repository.BookRepository;
import com.navkash.mongospring.resource.BookService;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MockodsApplication.class)
@SpringBootTest
//@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	
	@Mock
	public BookRepository bookRepository;
	
	@InjectMocks
	public BookService bookservice;
	
//	  @Before
//	  public void init() {
//	      MockitoAnnotations.initMocks(this);
//	  }
//	Book book=new Book();
//	book.setId(1);
//	book.setAuthorName("java aurthorname");
//	book.setBookName("java bookname");
	
	@Test
	public void BookDeletetest() {
//		Book book=new Book();
//		book.setAuthorName("java help");
//		assertEquals("java",bookservice.authorFirstName(book));
		Book book=new Book();
		book.setId(1);
		book.setAuthorName("java aurthorname");
		book.setBookName("java bookname");
//		bookservice.addBook(book);
//		bookservice.deleteBook(1);
//		assertEquals(book,bookRepository.save(book));
		Mockito.when(bookRepository.findAll()).thenReturn(new ArrayList<Book>(Arrays.asList(book)));
//		assertEquals(bookservice.getListOfBooks(),new ArrayList<Book>(Arrays.asList(book)));
	}
	
	@Test
	public void Booktest2() {
		Book book=new Book();
		book.setId(1);
		book.setAuthorName("java aurthorname");
		book.setBookName("java bookname");
	 	assertEquals(null,bookRepository.save(book));
//		Mockito.when(bookRepository.findAll()).thenReturn(new ArrayList<Book>(Arrays.asList(book)));
//		assertEquals(bookRepository.findAll(),new ArrayList<Book>(Arrays.asList(book)));
		verify(bookservice, Mockito.times(1)).addBook(book);;
	}
}
