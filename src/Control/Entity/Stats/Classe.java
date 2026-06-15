package Control.Entity.Stats;

import java.util.EnumMap;

public class Classe {
    private String name;
    private final EnumMap<StatType, Integer> bonusStats = new EnumMap<>(StatType.class);

    public Classe(String name) {
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
