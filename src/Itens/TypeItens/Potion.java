package Itens.TypeItens;

import Entity.Entity;
import Itens.Consumable;

public class Potion extends Consumable {
    private final int healAmount;
    
    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    public int getHealing() {
        return healAmount;
    }
    
    @Override
    public String display() {
        return "Heal: +" + healAmount + " HP";
    }

    @Override
    protected void applyEffect(Entity target) {
        target.setHp(
            Math.min(target.getHp() + healAmount, target.getMaxHp())
        );
    }
}
