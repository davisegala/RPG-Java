package Control.NPC;

import Control.Entity.Inventory.InventoryManager;

public abstract class Merchant{
    private final String name;

    public Merchant(String name) {
        this.name = name;
    }

    public abstract void talk();

    public String getName() {
        return name;
    }
}
