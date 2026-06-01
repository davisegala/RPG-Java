package NPC;

import Entity.Inventory.InventoryManager;

public abstract class Merchant{
    private final String name;
    private final InventoryManager inventorySystem = new InventoryManager();

    public Merchant(String name) {
        this.name = name;
    }

    public abstract void talk();

    public InventoryManager getInventorySystem() {
        return inventorySystem;
    }

    public String getName() {
        return name;
    }
}
