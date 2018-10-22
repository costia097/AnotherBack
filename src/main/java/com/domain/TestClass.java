package com.domain;

public class TestClass implements TestInterface{

    public void methodOne() {
        System.out.println("1");
    }

    public void mehtodTwo() {
        System.out.println("2");
    }

    @Override
    public void method() {
        System.out.println("Do some");
    }
}
