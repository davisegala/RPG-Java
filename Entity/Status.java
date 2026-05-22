package Entity;

public class Status {
    private int strength = 1;
    private int sourcery = 1;
    private int resistance = 1;
    private int agility = 1;
    private int hp = getMaxHp();
    
    public void print(){
        System.out.println("====== Status ======");
        System.out.println("strength: "+strength);
        System.out.println("sourcery: "+sourcery);
        System.out.println("resistance: "+resistance);
        System.out.println("agility: "+agility);        
    }
    
    private boolean canSet(int stat){
        if (stat <= 1){
            System.out.println("You can't set the status to 1 or less");
            return false;
        }
        return true;
    }
    
    public int getMaxHp(){
        return this.resistance * 30;
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
