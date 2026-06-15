package Control.Itens.TypeItens;

import Control.Entity.Entity;
import Control.Itens.Consumable;

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
        target.getCombatManager().setHp(
            Math.min(target.getCombatManager().getHp() + healAmount, target.getCombatManager().getMaxHp())
        );
    }
}
