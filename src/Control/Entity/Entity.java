package Control.Entity;

import Control.Entity.Combat.CombatManager;
import Control.Entity.Combat.Skill;
import Control.Entity.Inventory.InventoryManager;
import Control.Entity.Stats.Classe;
import Control.Entity.Stats.StatsManager;

public class Entity implements InventoryManager, StatsManager, CombatManager{
    private final String name;
    protected Classe classe;
    protected int hp;
    protected Skill[] skills;
    protected int x, y;
    protected int speed;

    public int getMaxHp() {
        return getMaxHp(this);
    }

    public void setSkills(Skill[] skills) {
        if (skills.length > 4) return;
        this.skills = skills;
    }

    public Skill[] getSkills() {
        return this.skills;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) hp = 0;
        if (hp > getMaxHp(this)) hp = getMaxHp(this);
        this.hp = hp;
    }

    public void setLevel(int amount) {
        setLevel(amount, this);
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Entity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}