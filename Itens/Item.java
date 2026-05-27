package Itens;

import Entity.Entity;

public abstract class Item {
    private String name;
    private Type type;
    
    public enum Type{
        EQUIPMENT,
        CONSUMABLE,
        MATERIAL
    }
    
    public Item(String name, Type type) {
        this.name = name;
        this.type = type;
    }
    
    public abstract String display();

    public void equip(Entity target){
        System.out.println("This item cannot be equipped");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void getItemType(){
        
    }

    public boolean getIsEquipment() {
        return this.type == type.EQUIPMENT;
    }
    
    public boolean getIsMaterial(){
        return this.type == type.MATERIAL;
    }
}
