package Itens;

import Entity.Entity;

public class Consumable extends Item{
    public Consumable(String name) {
        super(name);
    }

    @Override
    public String display() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void use(Entity target) {
        
    }
    
}
