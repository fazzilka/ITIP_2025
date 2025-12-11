package LR_6;

public class Item {
    String name;
    Integer cost;
    public Item(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + cost;
    }
}
