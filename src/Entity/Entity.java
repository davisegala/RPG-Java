package Entity;

public class Entity {
    private String name;
    protected Status status = new Status();
    private Level level = new Level();
    private Skill[] skills;
    private boolean isPlayer = false;
    protected Class classe;
    public InventorySystem invSystem = new InventorySystem();

    public Entity(String name){
        this.name = name;
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

    public void setHp(int amount) {
        status.setHp(amount);
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
}