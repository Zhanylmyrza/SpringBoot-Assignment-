package com.bkrva.UniProject.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Publisher {
  @Id @GeneratedValue
  private Long id;
  
  @Column(name = "created_year")
    private Long year;
  
  @OneToMany(mappedBy = "publisher")
  private Set <Book> books;
  
}
