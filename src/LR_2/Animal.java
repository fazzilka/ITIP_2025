package LR_2;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;
    private static int count = 0;

    public Animal(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
        count++;
    }

    public Animal() {
        this("Безымянный", 0, 0.0);
    }

    public String getName() {return name; }
    public void setName(String name) {this.name = name; }

    public int getAge() {return age; }
    public void setAge(int age) {this.age = age; }

    public double getWeight() {return weight; }
    public void setWeight(double weight) {this.weight = weight; }

    public abstract void type();

    public static int getCount() {return count; }

    public abstract void makeSound();

    public void eat() {
        System.out.println(name + " ест корм.");
    }

    public String toString() {
        return "Кличка -> " + name + ", возраст -> " + age + ", вес -> " + weight;
    }
}
