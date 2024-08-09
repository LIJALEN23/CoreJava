package com.corejava.inheritance;

import java.util.Objects;

public class EqualsDemo {

    private static void example1() {

        Animal dog1 = new Animal("Dog");
        Animal cat = new Animal("Cat");
        Animal dog2 = new Animal("Dog");

        if (dog1.equals(cat)) {
            System.out.println("dog1 和 cat相等：错误");
        } else {
            System.out.println("dog1 和 cat 不是同一种类的动物");
        }

        if (dog1.equals(dog2)) {
            System.out.println("dog1 和 dog2是同一种类的动物");
        }
    }

    private static void example2() {
        Dog dog1 = new Dog("Woof");
        Dog dog2 = new Dog("Wang");
        Dog dog3 = new Dog("Woof");

        if (dog1.equals(dog2)) {
            System.out.println("dog1 和 dog2的叫声相同");
        } else {
            System.out.println("dog1 和 dog2的叫声不同");
        }

        if (dog1.equals(dog3)) {
            System.out.println("dog1 和 dog3的叫声相同");
        } else {
            System.out.println("dog1 和 dog3的叫声不同");
        }
    }

    public static void main(String[] args) {

       //example1();
        example2();
    }
}

class Animal {
    private String kind;

    public Animal(String kind) {
        this.kind = kind;
    }

    public void printKind() {
        System.out.println(this.kind);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Animal object = (Animal) obj;

        return kind.equals(object.kind);
    }
}

class Dog extends Animal {
    private String voice;

    public Dog(String voice) {
        super("Dog");
        this.voice = voice;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        if (getClass() != obj.getClass()) return false;

        Dog object = (Dog) obj;

        return this.voice.equals(object.voice);
    }
}

class Cat extends Animal {
    private String voice;

    public Cat() {
        super("Cat");
        this.voice = "Meme";
    }
}