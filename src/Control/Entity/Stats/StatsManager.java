package Control.Entity.Stats;

import Control.Entity.Entity;

public interface StatsManager {
    Stats stats = new Stats();
    Level level = new Level();

    private void baseStatsLevelCalc() {
        for (StatType type : StatType.values()) {
            stats.setBaseStat(type, level.getLevel());
        }
    }

    default void addBonusStat(StatType type, int amount) {
        stats.addBonusStat(type, amount);
    }

    default void addBaseStat(StatType type, int amount) {
        stats.addBaseStat(type, amount);
    }

    default void addXp(int amount) {
        level.addXp(amount);
        baseStatsLevelCalc();
    }

    default void setLevel(int amount, Entity entity) {
        level.setLevel(amount);
        baseStatsLevelCalc();
        entity.updateHp(entity);
    }

    default int getStat(StatType type) {
        return stats.getStat(type);
    }

    default int getLevel() {
        return level.getLevel();
    }
}