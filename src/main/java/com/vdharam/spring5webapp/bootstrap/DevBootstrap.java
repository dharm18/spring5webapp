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
		Author author1 = new Author("Carlows","Mathew");
		Publisher publisher = new Publisher("Dublouse printing press","25 Markvenue Digite");
		Book book1 = new Book("Advanced Data Structures", "15521232", publisher);
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		
		authorRepository.save(author1);
		publisherRepository.save(publisher);
		bookRepository.save(book1);
		
		Author author2 = new Author("Nathan","Machlumm");
		Publisher publisher2 = new Publisher("Introducting Frameworks","45 aav marklane");
		Book book2 = new Book("Introduction to Java", "25551232", publisher2);
		author2.getBooks().add(book2);
		book2.getAuthors().add(author2);
		
		authorRepository.save(author2);
		publisherRepository.save(publisher2);
		bookRepository.save(book2);
	}

}
