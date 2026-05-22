package Entity;

import Entity.Status.StatType;

public class Skill {
    private String name;
    private int baseDamage;
    private StatType type;

    public Skill(String name, int baseDamage, StatType type) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.type = type;
    }
    
    public int getDamage(Entity entity) {
        return this.baseDamage * entity.getStat(this.type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public StatType getType() {
        return type;
    }

    public void setType(StatType type) {
        this.type = type;
    }
}
