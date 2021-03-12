package com.company;

import java.util.Date;

public class Bill
{
    private int price;


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Bill(int price){
        this.price = price;
    }


}
