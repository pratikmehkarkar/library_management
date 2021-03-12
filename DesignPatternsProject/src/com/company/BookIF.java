package com.company;

public interface BookIF {

    String getName();

    String getAuthor();

    int getPrice();

    String getType();

    void setName(String name);

    void setAuthor(String author);

    void setPrice(int price);

    void setType(String type);
    void displayBook();
}
