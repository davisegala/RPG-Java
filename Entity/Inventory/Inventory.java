package Entity.Inventory;

import Itens.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
    private Map<Item, Integer> inventory = new LinkedHashMap<>();

    public void print() {
        System.out.println("\n============= Entity.Inventory =============");

        int x = 0;
        for (Item item : inventory.keySet()) {
            try {
                System.out.println(
                        "--> [" + (x + 1) + "] " + item.getName() +
                                " - " + inventory.get(item) + "x - " + item.display()
                );
                x++;
            } catch (Exception _) {}
        }
    }

    public void addItem(Item item){
        inventory.merge(item, 1, Integer::sum);
    }

    public void addItem(Item item, int quantity){
        if (quantity < 1) return;
        inventory.merge(item, quantity, Integer::sum);
    }

    public void removeItem(Item item) {
        int num = inventory.getOrDefault(item, 0);

        if (num > 1) {
            inventory.put(item, num - 1);
        } else {
            inventory.remove(item);
        }
    }

    public void removeItem(Item item, int quantity) {
        int num = inventory.getOrDefault(item, 0);
        if (quantity > num) quantity = num;

        if (num > 1) {
            inventory.put(item, num - quantity);
        } else {
            inventory.remove(item);
        }
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }

    public Item getItem(int position) {
        if (position < 0 || position >= inventory.size()) return null;
        return (Item) inventory.keySet().toArray()[position];
    }
}