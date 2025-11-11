package LR_2;

public class Fish extends Animal {
    private String waterType;

    public Fish(String name, int age, double weight, String waterType) {
        super(name, age, weight);
        this.waterType = waterType;
    }


    public Fish() {
        this("Немо", 2, 2.5, "Пресноводная");
    }

    public String getWaterType() {return waterType; }
    public void setWaterType(String waterType) {this.waterType = waterType; }

    @Override
    public void type() {
        System.out.println("Тип животного -> Рыбка \uD83D\uDC1F");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит -> молчит (рыбы не умеёт разговаривать\uD83D\uDE2D)!");
    }

    @Override
    public String toString() {
        return super.toString() + ", вид -> " + waterType;
    }
}
