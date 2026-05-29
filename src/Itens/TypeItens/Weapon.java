package Itens.TypeItens;

import Itens.Equipment;
import Itens.Equipment.Slots;

public class Weapon extends Equipment{
    private int damage;
    
    public Weapon(String name, int damage) {
        super(name, Slots.WEAPON);
        if (damage >= 1) {
            this.damage = damage;
        } else {
            this.damage = 1;
        }
    }
    
    @Override
    public String display() {
        return "Damage: +" + this.damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public void addDamage(int damage){
        this.damage += damage;
    }
}