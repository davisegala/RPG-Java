package Entity;

import Entity.Status.StatType;

public class Level {
    public static void setLevel(int quantity, Entity entity){
        if (quantity < 1) return;
        entity.level = quantity;
        
        int temp = entity.getXp() - getNecessaryXp(entity);
        if (temp > 0) {
            entity.setXp(temp);
        } else {
            entity.setXp(0);
        }
        statusUp(quantity, entity);
    }
    
    public static void gainXp(int xp, Entity entity){
        entity.setXp(entity.getXp() + xp);
        
        while (canUp(entity)) {
            levelUp(entity);
        }
        
        System.out.println(entity.getName()+" | xp: ["+entity.getXp()+"/"+Level.getNecessaryXp(entity)+"]");
    } 
    
    private static void levelUp(Entity entity){
        entity.setXp(entity.getXp() - getNecessaryXp(entity));
        setLevel(entity.getLevel() + 1, entity);
        System.out.println("You leveled up");
    }
    
    private static void statusUp(int quantity, Entity entity){
        if (entity.getClasse() != null) {
            entity.setStat(
                StatType.STRENGHT,
                entity.getStat(StatType.STRENGHT) + (entity.classe.getStrength() + 1) * quantity
            );
            entity.setStat(
                StatType.SOURCERY,
                entity.getStat(StatType.SOURCERY) + (entity.classe.getSourcery() + 1) * quantity
            );
            entity.setStat(
                StatType.RESISTANCE,
                entity.getStat(StatType.RESISTANCE) + (entity.classe.getResistance() + 1) * quantity
            );
            entity.setStat(
                StatType.AGILITY,
                entity.getStat(StatType.AGILITY) + (entity.classe.getAgility() + 1) * quantity
            );
        } else {
            entity.setStat(StatType.STRENGHT, (entity.getStat(StatType.STRENGHT) + 1 * quantity));
            entity.setStat(StatType.SOURCERY, (entity.getStat(StatType.SOURCERY) + 1 * quantity));
            entity.setStat(StatType.RESISTANCE, (entity.getStat(StatType.RESISTANCE) + 1 * quantity));
            entity.setStat(StatType.AGILITY, (entity.getStat(StatType.AGILITY) + 1 * quantity));
            
        }
        entity.setHp(entity.getMaxHp());
    }
    
    private static int getNecessaryXp(Entity entity){
        return entity.level*entity.level*2 + 250;
    }
    
    private static boolean canUp(Entity entity){
        return entity.getXp() >= getNecessaryXp(entity);
    }
}
