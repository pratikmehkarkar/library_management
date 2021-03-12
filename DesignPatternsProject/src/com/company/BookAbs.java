package com.company;

public abstract class BookAbs implements BookIF {

    String name;
    String author;
    int price;
    String type;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType()
    {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void displayBook() {

    }
}
