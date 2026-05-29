package Entity.Stats;

import Entity.Entity;

public class Level{
    private int xp;
    private int level;
    
    public void addXp(int amount, Entity entity){
        this.xp += amount;
        while (this.xp >= getNecessaryXp()) levelUp(entity);
        System.out.println(entity.getName() + " | xp: [" + xp + "/" + getNecessaryXp() + "]");
    } 
    
    private void levelUp(Entity entity){
        this.xp -= getNecessaryXp();
        level += 1;
        for (StatType type : StatType.values()) {

        }
    }
    
    private int getNecessaryXp(){
        return level + (level * 250);
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int quantity, Entity entity){
        if (quantity < 1) return;
        for (int i = 0; i < quantity; i++) {
            levelUp(entity);
        }
     }
}
