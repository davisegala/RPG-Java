package NPC;

import Entity.Entity;
import Entity.Inventory;
import Itens.Item;

public class Merchant extends Npc{
    private String name;
    private Inventory inventory = new Inventory();

    public Merchant(String name) {
        this.name = name;
    }

    public void openStore(Entity entity) {
        inventory.openStore(this, entity);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void addItem(Item item) {
        this.inventory.addItem(item);
    }

    public void addItem(Item item, int amont) {
        this.inventory.addItem(item, amont);
    }
}
