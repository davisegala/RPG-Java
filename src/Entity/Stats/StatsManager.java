package Entity.Stats;

import Entity.Entity;

public class StatsManager {
    private Stats stats = new Stats();
    private Level level = new Level();
    private Entity entity;

    public StatsManager(Entity entity) {
        this.entity = entity;
    }
    
    private void baseStatsLevelCalc() {
        for (StatType type : StatType.values()) {
            stats.setBaseStat(type, level.getLevel());
        }
    }
    
    public void addBonusStat(StatType type, int amount) {
        stats.addBonusStat(type, amount);
    }
    
    public void addBaseStat(StatType type, int amount) {
        stats.addBaseStat(type, amount);
    }
    
    public void addXp(int amount) {
        level.addXp(amount, entity);
        baseStatsLevelCalc();
    }
    
    public void setLevel(int amount) {
        level.setLevel(amount, entity);
        baseStatsLevelCalc();
        entity.getCombatManager().updateHp();
    }
    
    public int getStat(StatType type) {
        return stats.getStat(type);
    }
    
    public int getLevel() {
        return level.getLevel();
    }
}