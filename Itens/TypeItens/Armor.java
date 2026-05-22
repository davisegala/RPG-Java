package Itens.TypeItens;

import Entity.Entity.ArmorSlot;
import Itens.Item;

public class Armor extends Item{
    private int armor;
    private ArmorType armorType;
    private ArmorSlot slot;
    
    public enum ArmorType {
        HELMET, CHESTPLATE, LEGGINGS, BOOTS
    }
    
    public Armor(String name, int armor, ArmorSlot armorSlot) {
        super(name, Type.EQUIPMENT);
        if (armor > 0) {
            this.armor = armor;
        } else {
            this.armor = 1;
        }
        this.slot = armorSlot;
    }
    
    @Override
    public String display() {
        return "Armor class: " + this.armor + " | Armor type: " + this.armorType;
    }

    public int getArmor() {
        return armor;
    }
    
    public void addArmor(int value){
        this.armor += value;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public ArmorSlot getSlot() {
        return slot;
    }
}