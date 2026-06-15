package Control.Entity;

import Control.Entity.Combat.CombatManager;
import Control.Entity.Inventory.InventoryManager;
import Control.Entity.Stats.StatsManager;

public class Entity implements InventoryManager, StatsManager{
    private final String name;
    protected int x, y;
    protected int speed;
    private final CombatManager combatManager = new CombatManager(this);

    public Entity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }
}