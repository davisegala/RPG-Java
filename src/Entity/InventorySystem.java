package Entity;

import Itens.Consumable;
import Itens.Equipment;
import Itens.Item;
import UtilMethods.Input;
import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    private Inventory inventory = new Inventory();
    private Map<Equipment.Slots, Item> equipment = new HashMap<>();

    public void equip(Item item) {
        if (item instanceof Equipment i) {
            addItem(equipment.get(i.getSlot()));
            equipment.put(i.getSlot(), i);
            removeItem(i);
        }
    }
    
    public void use(Item item, Entity target){
        if (item instanceof Consumable i) {
            i.use(target);
            removeItem(i);
        }
    }

    public void addItem(Item item){
        this.inventory.addItem(item);
    }

    public void addItem(Item item, int quantity){
        this.inventory.addItem(item, quantity);
    }
    
    public void removeItem(Item item) {
        this.inventory.removeItem(item);
    }
    
    /*
    public void open(Entity target){
        inventory.print();

        System.out.println("\n[0] To close");
        System.out.print("\nSelect an item: ");

        int num = Input.Int();
        if (num == 0) return;

        if (num > 0 && num <= lastDisplayedItems.size()){
            Item item = lastDisplayedItems.get(num - 1);

            if (item.getIsEquipment() && target.isPlayer()) {
                item.equip(target);
                this.inventory.remove(item);
            } else if (item instanceof Consumable){
                useItem(item, target);
            }
        } else {
            System.out.println("Invalid selection!");
        }
    }
    */
}
