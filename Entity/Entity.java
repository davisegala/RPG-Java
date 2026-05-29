package Entity;

import Entity.Inventory.InventoryManager;
import Entity.Stats.Level;
import Entity.Stats.StatType;
import Entity.Stats.Stats;

public class Entity {
    private final String name;
    protected Stats stats = new Stats();
    private Level level = new Level();
    private Skill[] skills;
    private boolean isPlayer = false;
    protected Class classe;
    private InventoryManager invSystem = new InventoryManager();

    public Entity(String name){
        this.name = name;
    }
    
    public void openInventory() {
        invSystem.open(this);
    }

    public String getName() {
        return name;
    }
    
    public void setStat(StatType type, int value) {
        stats.setStat(type, value);
    }

    public int getStat(StatType type) {
        return stats.getStat(type);
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        if (skills.length > 4) return;
        this.skills = skills;
    }
    
    public void setIsPlayer(boolean type) {
        this.isPlayer = type;
    }
    
    public boolean isPlayer(){
        return this.isPlayer;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }

    public int getHp() {
        return stats.getHp();
    }

    public void setHp(int amount) {
        stats.setHp(amount);
    }
    
    public int getMaxHp(){
        return this.getStat(StatType.RESISTANCE) * 30;
    }
    
    public int getXp() {
        return level.getXp();
    }
    
    public void addXp(int amount) {
        this.level.addXp(amount, this);
    }
    
    public void setLevel(int amount) {
        this.level.setLevel(amount, this);
    }
    
    public int getLevel() {
        return this.level.getLevel();
    }

    public InventoryManager getInvSystem() {
        return invSystem;
    }
}