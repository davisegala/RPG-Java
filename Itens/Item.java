package Itens;

import Entity.Entity;

public abstract class Item {
    private String name;
    private Type type;
    private int price = 100;
    
    public enum Type{
        EQUIPMENT,
        CONSUMABLE,
        MATERIAL
    }
    
    public Item(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Item(String name, Type type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
    public abstract String display();
    
    public void use(Entity target){
        
    };

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getIsEquipment() {
        return this.type == this.type.EQUIPMENT;
    }
    
    public boolean getIsMaterial(){
        return this.type == this.type.MATERIAL;
    }
}
