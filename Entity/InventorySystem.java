package Entity;

import Itens.Item;
import Itens.TypeItens.Armor;
import Itens.TypeItens.Weapon;

public class InventorySystem {
    private Inventory inventory = new Inventory();
    private Slots slots = new Slots();

    public int getArmorClass() {
        return slots.getArmorClass();
    }

    public void equip(Item item) {
        slots.equip(item);
    }

    public void addItem(Item item){
        this.inventory.addItem(item);
    }

    public void addItem(Item item, int quantity){
        this.inventory.addItem(item, quantity);
    }

    public void useItem(Item item, Entity target){
        this.inventory.useItem(item, target);
    }

    public Inventory getInventory() {
        return inventory;
    }

}
