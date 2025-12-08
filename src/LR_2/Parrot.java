package LR_2;

public class Parrot extends Animal {
    private String species;

    public Parrot(String name, int age, double weight, String species) {
        super(name, age, weight);
        this.species = species;
    }

    public Parrot() {
        this("Кеша", 2, 2.5, "Радужный");
    }

    public String getSpecies() {return species; }
    public void setSpecies(String color) {this.species = species; }

    @Override
    public void type() {
        System.out.println("Тип животного -> Попугай \uD83E\uDD9C");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит -> Кар-кар!");
    }

    @Override
    public String toString() {
        return super.toString() + ", вид -> " + species;
    }
}
