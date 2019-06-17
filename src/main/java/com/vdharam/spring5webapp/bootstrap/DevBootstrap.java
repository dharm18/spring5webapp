package com.vdharam.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.vdharam.spring5webapp.model.Author;
import com.vdharam.spring5webapp.model.Book;
import com.vdharam.spring5webapp.model.Publisher;
import com.vdharam.spring5webapp.repositories.AuthorRepository;
import com.vdharam.spring5webapp.repositories.BookRepository;
import com.vdharam.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	
	public DevBootstrap() {
		super();
	}

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		Author author1 = new Author("ABC","Test 1");
		Publisher publisher = new Publisher("name1","aav");
		Book book1 = new Book("Book1", "1232", publisher);
		author1.getBooks().add(book1);
		
		authorRepository.save(author1);
		publisherRepository.save(publisher);
		bookRepository.save(book1);
	}

}
