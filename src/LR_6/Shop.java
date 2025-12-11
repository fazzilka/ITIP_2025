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
        shop.addItem(new Item("6 за 269", 269));
        shop.addItem(new Item("Огурец", 100));
        shop.addItem(new Item("Огурец", 120));
        shop.addItem(new Item("Святой источник", 100));
        System.out.println("Общая сумма продаж: " + shop.getTotalSales());
        System.out.println("Самый популярный предмет: " + shop.getMostPopularItem());
        shop.showItems();
    }
}