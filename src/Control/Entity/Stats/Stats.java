package Control.Entity.Stats;

import java.util.EnumMap;

public class Stats {
    private EnumMap<StatType, Integer> baseStats = new EnumMap<>(StatType.class);
    private EnumMap<StatType, Integer> bonusStats = new EnumMap<>(StatType.class);

    public void print() {
        System.out.println("====== Status ======");
        System.out.println("Strength: " + getStat(StatType.STRENGTH));
        System.out.println("Sorcery: " + getStat(StatType.SORCERY));
        System.out.println("Resistance: " + getStat(StatType.RESISTANCE));
        System.out.println("Agility: " + getStat(StatType.AGILITY));
    }

    public void addBonusStat(StatType type, int value) {
        if (value < 1) return;
        bonusStats.merge(type, value, Integer::sum);
    }

    public void addBaseStat(StatType type, int value) {
        if (value < 1) return;
        baseStats.merge(type, value, Integer::sum);
    }

    public void setBaseStat(StatType type, int value) {
        if (value >= 1) baseStats.put(type, value);
    }

    public void setBonusStat(StatType type, int value) {
        if (value >= 1) bonusStats.put(type, value);
    }

    public int getStat(StatType type) {
        return baseStats.getOrDefault(type, 0) + bonusStats.getOrDefault(type, 0);
    }
}