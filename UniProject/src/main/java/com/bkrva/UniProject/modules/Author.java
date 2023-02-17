package com.bkrva.UniProject.modules;
import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Author {
  
  @Id @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;

  @ManyToMany(mappedBy="authors")
  private Set<Book> books;
  
  public Author(){
    
  }

  public Author( String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public Author addBook(Book newBook){
    if(books == null)
      books= new HashSet<>();
    books.add(newBook);
    return this;
  } 

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Book> getBooks() {
    return this.books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return id == author.id;
  }
    
  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, books);
  }
  
  
}
