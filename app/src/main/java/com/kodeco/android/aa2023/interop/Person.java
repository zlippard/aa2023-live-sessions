package com.kodeco.android.aa2023.interop;

import androidx.annotation.NonNull;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @NonNull
    public String toString() {
        String s = "Name: " + this.name + "\n";
        s += "Age: " + this.age + "\n";
        return s;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
