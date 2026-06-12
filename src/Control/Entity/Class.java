package Control.Entity;

import Control.Entity.Stats.StatType;

import java.util.EnumMap;

public class Class {
    private String name;
    private final EnumMap<StatType, Integer> bonusStats = new EnumMap<>(StatType.class);

    public Class(String name) {
        this.name = name;
    }
    
    public void setStat(StatType type, int value) {
        bonusStats.put(type, value);
    }

    public int getStat(StatType type) {
        return bonusStats.get(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
