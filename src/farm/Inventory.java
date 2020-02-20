package farm;

import MyMap.MyMap;

import java.util.*;

/**
 * Represents farms inventory
 *
 */
public class Inventory {
    private int quantity;

    public static Map<String, Integer> itemMap;
    public static List<Double> itemsPrice = new ArrayList<>();
    public Inventory() {
        itemMap = new MyMap<String, Integer>();
    }
    public void addItems (String item, int quantity) {
        itemMap.putIfAbsent(item, 0);
        this.quantity = quantity + itemMap.get(item);
        itemMap.put(item, this.quantity);

    }
    public void buyItems (String item, int quantity, double overallPrice) {
        itemsPrice.add(overallPrice);
        addItems(item, quantity);
    }
    public void printMap() {
        Iterator iterator = itemMap.keySet().iterator();
        System.out.println("\nFermos inventorizacija: ");
        while(iterator.hasNext()) {
            String key = iterator.next().toString();
            Integer value = itemMap.get(key);
            System.out.println(key + " - " + value);
        }
    }
}
