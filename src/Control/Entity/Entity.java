package Control.Entity;
import Control.Entity.Inventory.InventoryManager;
import Control.Entity.Stats.Classe;
import Control.Entity.Stats.StatType;
import Control.Entity.Stats.StatsManager;

import java.awt.image.BufferedImage;

public class Entity implements InventoryManager, StatsManager {
    private final String name;
    protected Classe classe;
    protected int hp;

    // Var for 2D game
    protected int x, y;
    protected int speed;

    protected BufferedImage idle1, up1, up2, down1, down2, left1, left2, right1, right2;

    public enum Actions { IDLE, UP, DOWN, LEFT, RIGHT }
    protected Actions action = Actions.IDLE;

    protected int spriteCounter = 0;
    protected int spriteNum = 1;

    // Constructor

    public Entity(String name){
        this.name = name;
    }

    // Methods

    public void updateHp() {
        setHp(getMaxHp());
    }

    public int getMaxHp() {
        return 30 + ( getStat(StatType.RESISTANCE) * 20 );
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) hp = 0;
        if (hp > getMaxHp()) hp = getMaxHp();
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

    public String getName() {
        return name;
    }
}