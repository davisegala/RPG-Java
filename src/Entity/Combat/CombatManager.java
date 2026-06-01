package Entity.Combat;

import Entity.Entity;
import Entity.Stats.StatType;

public class CombatManager {
    private int hp;
    private final Entity entity;
    private final Combat combat = new Combat();

    public CombatManager(Entity entity) {
        this.entity = entity;
    }
    
    public void statCombat(Entity target) {
        combat.battle(entity, target);
    }
    
    public int getMaxHp() {
        return 30 + ( entity.getStatsManager().getStat(StatType.RESISTANCE) * 20 );
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) hp = 0;
        if (hp > getMaxHp()) hp = getMaxHp();
        this.hp = hp;
    }
    
    public void updateHp() {
        this.hp = getMaxHp();
    }
}
