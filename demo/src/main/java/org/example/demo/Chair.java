package com.mycompany.newtaskm5zn;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bm
 */
public class Chair {
    private int code;
    private int size;
    private String color;

    public Chair(int code, int size, String color) {
        this.code = code;
        this.size = size;
        this.color = color;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    static public void chcksiz(int x, String color)
    {
        if(x<=0)
        {
            throw new IllegalArgumentException("please enter a valid size");
        }
    }
    
}
