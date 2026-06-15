package Control.Entity;

import Control.Entity.Combat.CombatManager;
import Control.Entity.Inventory.InventoryManager;
import Control.Entity.Stats.StatsManager;

public class Entity {
    private final String name;
    protected int x, y;
    protected int speed;
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