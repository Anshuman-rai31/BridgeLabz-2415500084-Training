import java.util.*;
public class AnimalHierarchyDemo {
    static class Animal {
        private String name;
        Animal(String name){ this.name = name; }
        public String getName(){ return name; }
        public String toString(){ return getClass().getSimpleName() + ":" + name; }
    }
    static class Dog extends Animal { Dog(String name){ super(name); } }
    static class Cat extends Animal { Cat(String name){ super(name); } }
    public static void printAnimals(List<? extends Animal> animals){
        for(Animal a : animals) System.out.println(a);
    }
    public static void main(String[] args){
        List<Dog> dogs = Arrays.asList(new Dog("Rex"), new Dog("Bruno"));
        List<Cat> cats = Arrays.asList(new Cat("Mittens"), new Cat("Luna"));
        printAnimals(dogs);
        printAnimals(cats);
    }
}

