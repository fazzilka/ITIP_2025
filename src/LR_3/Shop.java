package LR_3;

import java.util.Date;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Класс Item — товар в заказе
 */
class Item {
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

/**
 * Класс Order — заказ интернет-магазина
 */
class Order {
    private static int globalId = 0; // уникальный номер заказа
    int id;
    int totalPrice;
    Date date;
    Item[] items;
    String status;

    public Order(Date date, Item[] items, String status) {
        this.id = globalId++;
        this.date = date;
        this.items = items;
        this.status = status;

        int price = 0;
        for (Item item : items) {
            price += item.price;
        }
        this.totalPrice = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Заказ №%s:\n дата - %s,\n общая стоимость - %s,\n товары - %s,\n статус - %s",
                id, date.toString(), totalPrice, Arrays.toString(items), status
        );
    }
}

/**
 * Хэш-таблица для хранения заказов с методом цепочек
 */
class OrderHashTable {
    private static class Node {
        int key; // номер заказа
        Order value;

        Node(int key, Order value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity = 100;
    private LinkedList<Node>[] table;

    @SuppressWarnings("unchecked")
    public OrderHashTable() {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    // Добавление или обновление заказа
    public void put(Order order) {
        int index = hash(order.id);
        LinkedList<Node> list = table[index];

        for (Node node : list) {
            if (node.key == order.id) {
                node.value = order; // обновление существующего
                return;
            }
        }
        list.add(new Node(order.id, order));
    }

    // Получение заказа по номеру
    public Order get(int orderId) {
        int index = hash(orderId);
        for (Node node : table[index]) {
            if (node.key == orderId) {
                return node.value;
            }
        }
        return null;
    }

    // Удаление заказа по номеру
    public void remove(int orderId) {
        int index = hash(orderId);
        LinkedList<Node> list = table[index];
        Node toRemove = null;
        for (Node node : list) {
            if (node.key == orderId) {
                toRemove = node;
                break;
            }
        }
        if (toRemove != null) {
            list.remove(toRemove);
        }
    }

    // Изменение статуса заказа
    public boolean updateStatus(int orderId, String newStatus) {
        Order order = get(orderId);
        if (order != null) {
            order.status = newStatus;
            return true;
        }
        return false;
    }
}

/**
 * Тестирование OrderHashTable
 */
public class Shop {
    public static void main(String[] args) {
        OrderHashTable store = new OrderHashTable();

        // Создаём товары
        Item laptop = new Item("Ноутбук", 50000);
        Item mouse = new Item("Мышь", 1500);
        Item phone = new Item("Телефон", 30000);

        // Добавляем заказы
        Order order1 = new Order(new Date(), new Item[]{laptop, mouse}, "Processing");
        Order order2 = new Order(new Date(), new Item[]{phone, mouse}, "Pending");

        store.put(order1);
        store.put(order2);

        // Получаем заказ 1
        System.out.println("Заказ 1:\n" + store.get(order1.id));

        // Обновляем статус заказа 1
        store.updateStatus(order1.id, "Shipped");
        System.out.println("После обновления статуса:\n" + store.get(order1.id));
        // Добавляем новый заказ и обновляем существующий
        Order order3 = new Order(new Date(), new Item[]{phone}, "Processing");
        store.put(order2); // обновление order2
        store.put(order3); // новый заказ

        System.out.println("Заказ 2:\n" + store.get(order2.id));
        System.out.println("Заказ 3:\n" + store.get(order3.id));

        // Удаляем заказ 1
        store.remove(order1.id);
        System.out.println("После удаления заказа 1:\n" + store.get(order1.id)); // null
    }
}