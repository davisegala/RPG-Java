package Itens.TypeItens;

import Entity.Slots.ArmorSlot;
import Itens.Item;

public class Armor extends Item{
    private int armor;
    private ArmorSlot slot;
    
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
        return "Armor class: " + this.armor + " | Armor slot: " + this.slot;
    }

    public int getArmor() {
        return armor;
    }
    
    public void addArmor(int value){
        this.armor += value;
    }

    public ArmorSlot getArmorType() {
        return slot;
    }

    public ArmorSlot getSlot() {
        return slot;
    }
}