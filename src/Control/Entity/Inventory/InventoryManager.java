package Control.Entity.Inventory;

import Control.Entity.Entity;
import Control.Itens.Equipment;
import Control.Itens.Item;
import Control.Itens.TypeItens.Armor;
import Control.Itens.TypeItens.Weapon;
import java.util.HashMap;
import java.util.Map;

public interface InventoryManager{
    Inventory inventory = new Inventory();
    Map<Equipment.Slots, Item> equipment = new HashMap<>();

    default int getArmorClass() {
        int armorClass = 0;
        for (Item item : equipment.values()) {
            if (item instanceof Armor i) {
                armorClass += i.getArmor();
            }
        }
        return armorClass;
    }

    default void addItem(Item item) {
        inventory.addItem(item);
    }

    default void addItem(Item item, int quantity) {
        inventory.addItem(item, quantity);
    }

    default void removeItem(Item item) {
        inventory.removeItem(item);
    }

    default void removeItem(Item item, int quantity) {
        inventory.removeItem(item, quantity);
    }
    
    default Item getEquipment(Equipment.Slots slot) {
        return equipment.get(slot);
    }
    
    default int getWeaponDamage() {
        if (equipment.get(Equipment.Slots.WEAPON) instanceof Weapon i) {
            return i.getDamage();
        }
        return 0;
    }

    default void equip(Item item) {
        if (item instanceof Equipment i) {
            inventory.addItem(equipment.get(i.getSlot()));
            equipment.put(i.getSlot(), i);
            inventory.removeItem(i);
        }
    }

    default void useItem(Item item, Entity target) {
        item.use(target);
    }

    default void useItem(int index, Entity target) {
        inventory.getItem(index).use(target);
    }

    default Map<Item, Integer> getInventory() {
        return inventory.getInventory();
    }

    default Item getItem(int position) {
        return inventory.getItem(position);
    }
}
