package Entity.Inventory;

import Entity.Entity;
import Itens.Equipment;
import Itens.Item;
import Itens.TypeItens.Armor;
import Itens.TypeItens.Weapon;
import UtilMethods.Input;
import java.util.HashMap;
import java.util.Map;

public class InventoryManager{
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

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public void addItem(Item item, int quantity) {
        inventory.addItem(item, quantity);
    }

    public void removeItem(Item item) {
        inventory.removeItem(item);
    }

    public void removeItem(Item item, int quantity) {
        inventory.removeItem(item, quantity);
    }
    
    public Item getEquipment(Equipment.Slots slot) {
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
            inventory.addItem(equipment.get(i.getSlot()));
            equipment.put(i.getSlot(), i);
            inventory.removeItem(i);
        }
    }
    
    public void open(Entity target) {
        inventory.print();

        System.out.println("\n[0] To close");
        System.out.print("\nSelect an item: ");

        int num = Input.Choose(0, inventory.getInventorySize());
        if (num == 0) {
            return;
        } else {
            Item item = inventory.getItem(num - 1);
            item.use(target);
        }
    }
}
