package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Person person1 = new Person("이름1", new ArrayList<>(Arrays.asList("FR1", "FR2", "FR3")));
        Person person2 = new Person("이름1",null);

        List<String> person1Friends = CheckEmptyClass.collection(person1.getFriends(), () -> (Arrays.asList("new FR1", "new FR2")));
        for (String person1Friend : person1Friends) {
            System.out.println("person1Friend = " + person1Friend);
        }

        List<String> person2Friends = CheckEmptyClass.collection(person2.getFriends(), () -> (Arrays.asList("new FR1", "new FR2")));
        for (String person2Friend : person2Friends) {
            System.out.println("person2Friend = " + person2Friend);
        }
    }
}

@FunctionalInterface
interface MySupplier<T>{
    T get();
}

class CheckEmptyClass{
    public static <T extends Collection<?>> T collection(T collection, MySupplier<T> defaultCollectionSupplier){
        return collection == null || collection.size()==0 ? defaultCollectionSupplier.get() : collection;
    }
}

class Person{

    private String name;
    private List<String> friends = new ArrayList<>();

    public Person(String name, List<String> friends) {
        this.name = name;
        this.friends = friends;
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getName() {
        return name;
    }
}

