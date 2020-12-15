package com.company;

public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface fiels2;

    public void foo(){
        field1.doSomething();
        fiels2.doSomeOther();
    }
}
