package Class;

import java.util.ArrayList;
import UtilMethods.Input;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Input input = new Input();
    
    private void print() {
        System.out.println("\n ============= Inventory =============");

        Map<Item, Integer> count = new HashMap<>();

        for (Item item : inventory) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        int i = 1;
        for (Map.Entry<Item, Integer> entry : count.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            System.out.println("--> [" + i + "] " + item.getName() + " - " + 
            quantity + "x - " + item.display());
            i++;
        }
    }
    
    public void open(Entity target){
        print();
        
        System.out.println("\n[0] to end turn");
        System.out.print("\nSelect an item: ");
        
        int num = input.inputInt();
        if (num == 0) return;
        
        if (input.choiseInRange(num, this.inventory.size())){
            Item item = this.inventory.get(num - 1);
            if (item.getIsEquipment() && target.isPlayer()) {
                equipItem(target, item);
            } else {
                useItem(item, target);
            }
        }
    }
    
    private void equipItem(Entity target, Item item){
        
    }
    
    public void addItem(Item item){
        this.inventory.add(item);
    }
    
    public void addItem(Item item, int quantity){
        for (int i = 0; i < quantity; i++) {
            this.inventory.add(item);
        }
    }
    
    public void useItem(Item item, Entity target){
        item.use(target);
        this.inventory.remove(item);
    }

    public ArrayList getInventory() {
        return inventory;
    }
}