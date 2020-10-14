package com.navkash.mongospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.navkash.mongospring.model.Book;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{
	

}
