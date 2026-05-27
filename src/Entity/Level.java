package Entity;

public class Level {
    private int xp;
    private int level;
    
    public void addXp(int amount, Entity entity){
        this.xp += amount;
        
        while (canUp()) levelUp(entity);
        
        System.out.println(entity.getName() + " | xp: [" + xp + "/" + getNecessaryXp() + "]");
    } 
    
    private void levelUp(Entity entity){
        xp -= getNecessaryXp();
        level += 1;
        entity.status.up(entity);
    }
    
    private int getNecessaryXp(){
        return level*level*2 + 250;
    }
    
    private boolean canUp(){
        return xp >= getNecessaryXp();
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
