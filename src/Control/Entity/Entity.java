package Control.Entity;

import Control.Entity.Combat.CombatManager;
import Control.Entity.Inventory.InventoryManager;
import Control.Entity.Stats.StatsManager;

public class Entity {
    private final String name;
    private boolean isPlayer = false;
    private Class classe;
    private final InventoryManager inventoryManager = new InventoryManager();
    private final StatsManager statsManager = new StatsManager(this);
    private final CombatManager combatManager = new CombatManager(this);

    public Entity(String name){
        this.name = name;
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
}