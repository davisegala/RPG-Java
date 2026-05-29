package Itens.TypeItens;

import Itens.Equipment;

public class Armor extends Equipment{
    private int armor;
    
    public Armor(String name, int armor, Slots slot) {       
        super(name, slot);
        this.armor = armor > 0 ? armor : 1; 
    }
    
    @Override
    public String display() {
        return "Armor class: " + this.armor + " | Armor slot: " + this.getSlot();
    }

    public int getArmor() {
        return armor;
    }
    
    public void addArmor(int value){
        this.armor += value;
    }
}