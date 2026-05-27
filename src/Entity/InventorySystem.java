package Entity;

import Itens.Consumable;
import Itens.Equipment;
import Itens.Item;
import Itens.TypeItens.Armor;
import Itens.TypeItens.Weapon;
import UtilMethods.Input;
import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    private Inventory inventory = new Inventory();
    private Map<Equipment.Slots, Item> equipment = new HashMap<>();
    
    public int getArmorClass() {
        int armorClass = 0;
        for (Item item : equipment.values()) {
            if (item instanceof Armor i) {
                armorClass += i.getArmor();
            }
        }
        return armorClass;
    }
    
    public Item getItem(Equipment.Slots slot) {
        return equipment.get(slot);
    }
    
    public int getWeaponDamage() {
        if (equipment.get(Equipment.Slots.WEAPON) instanceof Weapon i) {
            return i.getDamage();
        }
        return 0;
    }

    public void equip(Item item) {
        if (item instanceof Equipment i) {
            addItem(equipment.get(i.getSlot()));
            equipment.put(i.getSlot(), i);
            removeItem(i);
        }
    }
    
    public void use(Item item, Entity target){
        item.use(target);
        removeItem(item);
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
    
    public void open(Entity target) {
        inventory.print();

        System.out.println("\n[0] To close");
        System.out.print("\nSelect an item: ");

        int num = Input.Choise(inventory.getlastDisplayedItems().size());
        Item item = inventory.getlastDisplayedItems().get(num - 1);

        item.use(target);
    }
}
