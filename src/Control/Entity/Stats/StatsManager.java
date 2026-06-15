package Control.Entity.Stats;

import Control.Entity.Entity;

public interface StatsManager {
    Stats stats = new Stats();
    Level level = new Level();
    Entity entity = null;
    Classe classe = null;
    
    private void baseStatsLevelCalc() {
        for (StatType type : StatType.values()) {
            stats.setBaseStat(type, level.getLevel());
        }
    }

    default Classe getClasse() {
        return classe;
    }

    /*

    default void setClasse(Classe classe) {
        this.classe = classe;
    }
     */

    default void addBonusStat(StatType type, int amount) {
        stats.addBonusStat(type, amount);
    }

    default void addBaseStat(StatType type, int amount) {
        stats.addBaseStat(type, amount);
    }

    default void addXp(int amount) {
        level.addXp(amount, entity);
        baseStatsLevelCalc();
    }

    default void setLevel(int amount) {
        level.setLevel(amount, entity);
        baseStatsLevelCalc();
        entity.getCombatManager().updateHp();
    }

    default int getStat(StatType type) {
        return stats.getStat(type);
    }

    default int getLevel() {
        return level.getLevel();
    }
}