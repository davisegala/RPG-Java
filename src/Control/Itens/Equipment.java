package Control.Itens;

import Control.Entity.Entity;

public class Equipment extends Item{
    public enum Slots{HELMET, CHESTPLATE, LEGGINGS, BOOTS, WEAPON}    
    private final Slots slot;
    
    public Equipment(String name, Slots slot) {
        super(name);
        this.slot = slot;
    }

    public Slots getSlot() {
        return slot;
    }    

    @Override
    public String display() {
        return "Display not avaliable";
    }
    
    @Override
    public void use(Entity target) {
        target.getInventoryManager().equip(this);
    }
}
