package LR_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Сколько животных вы хотите создать? ");
        int n = sc.nextInt();
        Animal[] animals = new Animal[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nВыберите тип животного (1 - Кот, 2 - Попугай, 3 - Рыбка): -> ");
            int choice = sc.nextInt();

            System.out.print("Введите имя -> ");
            String name = sc.nextLine();
            System.out.print("Введите возраст -> ");
            int age = sc.nextInt();
            System.out.print("Введите вес -> ");
            double weight = sc.nextDouble();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите цвет кота -> ");
                    String color = sc.next();
                    animals[i] = new Cat(name, age, weight, color);
                }

                case 2 -> {
                    System.out.print("Введите вид попугая -> ");
                    String species = sc.next();
                    animals[i] = new Parrot(name, age, weight, species);
                }

                case 3 -> {
                    System.out.print("Введите тип воды (морская/пресная) -> ");
                    String waterType = sc.next();
                    animals[i] = new Fish(name, age, weight, waterType);
                }
            }
        }

        System.out.println("\n--- Список животных ---");
        for (Animal a: animals){
            a.type();
            System.out.println(a);
            a.makeSound();
            a.eat();
            System.out.println();
        }

        System.out.println("Всего животных создано -> " + Animal.getCount());
    }
}
