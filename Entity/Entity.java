package Entity;

import Entity.Status.StatType;
import Itens.TypeItens.Armor;
import Itens.Item;
import Itens.TypeItens.Weapon;
import java.util.HashMap;
import java.util.Map;

public class Entity {
    private String name;
    private Status status;
    private Skill[] skills;
    private boolean isPlayer = false;
    private int xp;
    protected int level;
    protected Class classe;
    private Inventory inventory;
    private Weapon weapon;
    
    public enum ArmorSlot{HELMET, CHESTPLATE, LEGGINGS, BOOTS}
    private Map<ArmorSlot, Armor> armors = new HashMap<>();

    public Entity(String name){
        this.name = name;
        this.status = new Status();
        this.inventory = new Inventory();
    }
    
    public int getArmorClass() {
        int armorClass = 0;
        for (Armor armor : armors.values()) {
            if (armor == null) continue;
            armorClass += armor.getArmor();
        }
        return armorClass;
    }
    
    public void equipArmor(Armor armor) {
        armors.put(armor.getSlot(), armor);
    }
    
    public void addItem(Item item){
        this.inventory.addItem(item);
    }
    
    public void addItem(Item item, int quantity){
        this.inventory.addItem(item, quantity);
    }
    
    public void useItem(Item item, Entity target){
        this.inventory.useItem(item, target);
    }
    
    public void setLevel(int quantity){
        Level.setLevel(quantity, this);
    }
    
    public void gainXp(int xp){
        Level.gainXp(xp, this);
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

    public int getLevel() {
        return level;
    }
    
    public void setIsPlayer(boolean type) {
        this.isPlayer = type;
    }
    
    public boolean isPlayer(){
        return this.isPlayer;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        if (xp < 0) return;
        this.xp = xp;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}