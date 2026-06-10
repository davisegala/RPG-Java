package Entity.Combat;

import Entity.Entity;
import Entity.Stats.StatType;
import Vision.CombatScreen;

public class CombatManager {
    private final Entity entity;
    private int hp;
    private Skill[] skills;

    public CombatManager(Entity entity) {
        this.entity = entity;
    }
    
    public void startCombat(Entity target) {
        new CombatScreen().startBattle(entity, target);
    }
    
    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        if (skills.length > 4) return;
        this.skills = skills;
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
