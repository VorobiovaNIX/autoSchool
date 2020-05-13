package com.welcome;

public class Hello {
    private String userName;

    public void setupName(String name) {
        userName = name;
    }

    public void welcome() {
        System.out.printf("Hello, " + userName + "!");
    }

    public void byeBay() {
        System.out.println("Bye, " + userName + "!");
    }
}
