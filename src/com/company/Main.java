package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Injector injector=new Injector();
        injector.injector(new SomeBean());
        SomeBean ab=(new Injector()).injector(new SomeBean());
        ab.foo();
    }
}
