package LR_6;

import java.util.*;

public class Shop {
    private final TreeSet<Item> soldItems = new TreeSet<>(
            Comparator.comparingInt(Item::getCost).thenComparing(Item::getName)
    );

    public void addItem(Item item) {
        soldItems.add(item);
    }

    public void showItems() {
        for (Item item : soldItems) {
            System.out.println(item);
        }
    }

    public int getTotalSales() {
        int sales = 0;
        for (Item item : soldItems) {
            sales += item.cost;
        }
        return sales;
    }

    public String getMostPopularItem() {
        Map<String, Integer> counts = new HashMap<>();
        for (Item item : soldItems) {
            counts.merge(item.getName(), 1, Integer::sum);
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    static void main() {
        Shop shop = new Shop();

        System.out.println("Общая сумма продаж: " + shop.getTotalSales());
        shop.addItem(new Item("5 за 200", 200));
        shop.addItem(new Item("Кофе", 100));
        shop.addItem(new Item("Tasty Coffee", 120));
        shop.addItem(new Item("Байкал", 100));
        System.out.println("Общая сумма продаж: " + shop.getTotalSales());
        System.out.println("Самый популярный предмет: " + shop.getMostPopularItem());
        shop.showItems();
    }
}