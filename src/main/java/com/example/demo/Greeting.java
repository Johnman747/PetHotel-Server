package com.example.demo;

public class Greeting {

    private final int id;
    private final String content;

    public Greeting(int counter, String content) {
        this.id = counter;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}