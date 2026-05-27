package Itens;

import Entity.Entity;
import Entity.InventorySystem;

public abstract class Item {
    private String name;
    
    public Item(String name) {
        this.name = name;
    }
    
    public abstract void use(Entity target);
    
    public abstract String display();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Item item = (Item) obj;

        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
