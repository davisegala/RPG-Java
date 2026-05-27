package Entity;

import Itens.Consumable;
import Itens.Item;
import java.util.ArrayList;
import UtilMethods.Input;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Input input = new Input();

    private ArrayList<Item> lastDisplayedItems = new ArrayList<>();

    public void print() {
        System.out.println("\n============= Inventory =============");
        Map<Item, Integer> count = getInventory();

        for (int i = 0; i < lastDisplayedItems.size(); i++) {
            Item item = lastDisplayedItems.get(i);

            int quantity = count.getOrDefault(item, 0);

            if (quantity > 0) {
                System.out.println("--> [" + (i + 1) + "] " + item.getName() + " - " + quantity + "x - " + item.display());
            }
        }
    }

    private Map<Item, Integer> getInventory() {
        Map<Item, Integer> count = new HashMap<>();
        lastDisplayedItems.clear();

        for (Item item : inventory) {
            if (!count.containsKey(item)) {
                lastDisplayedItems.add(item);
            }
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        return count;
    }
    
    public void removeItem(Item item) {
        this.inventory.remove(item);
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }

    public void addItem(Item item, int quantity){
        for (int i = 0; i < quantity; i++) {
            this.inventory.add(item);
        }
    }
}