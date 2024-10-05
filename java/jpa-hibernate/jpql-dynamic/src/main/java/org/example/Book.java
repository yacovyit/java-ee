package org.example;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String isbn;
    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;
    @Column(name = "publication_date")
    private LocalDate publishDate;
    @Column(name = "number_of_pages")
    private Integer numberOfPages;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String title, String isbn, BigDecimal unitPrice, LocalDate publishDate, Integer numberOfPages, Genre genre) {
        this.title = title;
        this.isbn = isbn;
        this.unitPrice = unitPrice;
        this.publishDate = publishDate;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Author> getAuthors() {
        return Collections.unmodifiableSet(authors);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}
