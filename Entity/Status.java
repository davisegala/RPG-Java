package Entity;

import java.util.HashMap;
import java.util.Map;

public class Status {
    public enum StatType {
        STRENGHT,
        SOURCERY,
        RESISTANCE,
        AGILITY
    }
    
    private Map<StatType, Integer> stats = new HashMap<>();
    private int hp = getMaxHp();
    
    public Status() {
        for (StatType stat : StatType.values()) {
            stats.put(stat, 1);
        }
    }

    
    public void print(){
        System.out.println("====== Status ======");
        System.out.println("Strength: " + getStat(StatType.STRENGHT));
        System.out.println("Sourcery: " + getStat(StatType.SOURCERY));
        System.out.println("Resistance: " + getStat(StatType.RESISTANCE));
        System.out.println("Agility: " + getStat(StatType.AGILITY));
    }
    
    private boolean canSet(int stat){
        if (stat <= 1){
            System.out.println("You can't set the status to 1 or less");
            return false;
        }
        return true;
    }
    
    public int getMaxHp(){
        return getStat(StatType.RESISTANCE) * 30;
    }
    
    
    // Getters and Setters
    
    
    public void setStat(StatType type, int value) {
        if (canSet(value)) stats.put(type, value);
    }

    public int getStat(StatType type) {
        return stats.getOrDefault(type, 0);
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int amont) {
        if (amont <= getMaxHp()) {
            this.hp = amont;
        } else {
            this.hp = getMaxHp();
        }
    }
}
