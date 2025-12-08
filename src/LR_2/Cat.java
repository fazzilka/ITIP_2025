package LR_2;

public class Cat extends Animal {
    private String color;

    public Cat(String name, int age, double weight, String color) {
        super(name, age, weight);
        this.color = color;
    }


    public Cat() {
        this("Барсик", 1, 3.0, "Чёрный");
    }

    public String getColor() {return color; }
    public void setColor(String color) {this.color = color; }

    @Override
    public void type() {
        System.out.println("Тип животного -> Кот \uD83D\uDC31");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит -> Мяу!");
    }

    @Override
    public String toString() {
        return super.toString() + ", окрас -> " + color;
    }
}
