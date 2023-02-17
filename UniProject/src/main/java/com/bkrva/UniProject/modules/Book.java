package com.bkrva.UniProject.modules;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Book {
  
  
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotBlank(message = "Title is mandatory")
  private String title;  
  private String isbn;
  private int publishedYear;
  private String lang;
  
  
  
  @ManyToOne
  private Publisher publisher;
  
  @ManyToMany
  private Set<Author> authors;
  
  

  public Book() {
  }

  public Book( String title, String isbn, int publishedYear, String lang) {
    this.title = title;
    this.isbn = isbn;
    this.publishedYear=publishedYear;
    this.lang = lang;
    
  }
  

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getPublishedYear() {
    return this.publishedYear;
  }

  public void setPublishedYear(int publishedYear) {
    this.publishedYear = publishedYear;
  }

  public String getLang() {
    return this.lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public Publisher getPublisher() {
    return this.publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  public Set<Author> getAuthors() {
    return this.authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }  

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Book book = (Book) o;
      return id == book.id;
  }
  @Override
  public int hashCode() {
      return Objects.hash(id);
  }

  @Override
  public String toString() {
      return "Book{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", isbn='" + isbn + '\'' +
              '}';
  }
  
  public Book addAuthor(Author author) {
    if (authors == null)
        authors = new HashSet<>();

    authors.add(author);
    return this;
  }

}
