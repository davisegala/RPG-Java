package Entity;

import Entity.Combat.CombatManager;
import Entity.Inventory.InventoryManager;
import Entity.Stats.StatsManager;
import java.awt.Image;

public class Entity {
    private final String name;
    private boolean isPlayer = false;
    private Class classe;
    private final InventoryManager inventoryManager = new InventoryManager();
    private final StatsManager statsManager = new StatsManager(this);
    private final CombatManager combatManager = new CombatManager(this);
    private Image model;

    public Entity(String name, Image model){
        this.name = name;
        this.model = model;
    }
    
    public void openInventory() {
        inventoryManager.open(this);
    }

    public String getName() {
        return name;
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

    public InventoryManager getInventoryManager() {
        return this.inventoryManager;
    }

    public StatsManager getStatsManager() {
        return statsManager;
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }

    public Image getModel() {
        return model;
    }

    public void setModel(Image model) {
        this.model = model;
    }
}