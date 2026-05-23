package Entity;

import Itens.TypeItens.Armor;
import Itens.Item;
import Itens.TypeItens.Weapon;

public class Entity {
    private String name;
    protected Status status;
    private Level level;
    private Skill[] skills;
    private boolean isPlayer = false;
    protected Class classe;
    private Inventory inventory;
    private Slots slots;

    public Entity(String name){
        this.name = name;
        this.status = new Status();
        this.inventory = new Inventory();
        this.level = new Level();
        this.slots = new Slots();
    }

    public void addItem(Item item) {
        this.inventory.addItem(item);
    }

    public void addItem(Item item, int amont) {
        this.inventory.addItem(item, amont);
    }
    
    public int getArmorClass() {
        return slots.getArmorClass();
    }
    
    public void equipArmor(Armor armor) {
        slots.equipArmor(armor);
    }

    public String getName() {
        return name;
    }
    
    public void setStat(StatType type, int value) {
        status.setStat(type, value);
    }

    public int getStat(StatType type) {
        return status.getStat(type);
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
        return status.getHp();
    }

    public void setHp(int amont) {
        status.setHp(amont);
    }
    
    public int getMaxHp(){
        return this.getStat(StatType.RESISTANCE) * 30;
    }

    public Weapon getWeapon() {
        return slots.getWeapon();
    }

    public void setWeapon(Weapon weapon) {
        this.slots.setWeapon(weapon);
    }
    
    public int getXp() {
        return level.getXp();
    }
    
    public void addXp(int amont) {
        this.level.addXp(amont, this);
    }
    
    public void setLevel(int amont) {
        this.level.setLevel(amont, this);
    }
    
    public int getLevel() {
        return this.level.getLevel();
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}