package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SomeBean ab=(new Injector()).inject(new SomeBean());
        ab.foo();
    }
}
