package org.javaboy.threadlocal;

public class Demo1 {
    public static void main(String[] args) {

        ThreadLocal<String> local = new ThreadLocal(){
            @Override
            protected String initialValue() {
                return "hello";
            }
        };

    }
}
