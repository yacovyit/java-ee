package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("BOOK")
public class Book extends Item  {
    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "author", length = 100)  // assuming author's name is 100 characters or less.
    private String author;

    @Column(name = "publication_date")  // assuming publication date is a date.  Use java.time.LocalDate.
    private LocalDate publicationDate;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
