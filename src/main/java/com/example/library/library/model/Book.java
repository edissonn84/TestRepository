package com.example.library.library.model;

public class Book {

    private Long pid;

    private String name;

    private String genre;

    private String author;

    private Long yearOfIssue;

    private Long totalOfSheets;

    private Long totalOfBooks;

    public Book(Long pid, String name, String genre, String author, Long yearOfIssue, Long totalOfSheets) {
        this.pid = pid;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
        this.totalOfSheets = totalOfSheets;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Long yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public Long getTotalOfSheets() {
        return totalOfSheets;
    }

    public void setTotalOfSheets(Long totalOfSheets) {
        this.totalOfSheets = totalOfSheets;
    }

    public Long getTotalOfBooks() {
        return totalOfBooks;
    }

    public void setTotalOfBooks(Long totalOfBooks) {
        this.totalOfBooks = totalOfBooks;
    }
}
