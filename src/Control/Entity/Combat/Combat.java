package Control.Entity.Combat;

import Entity.Combat.Skill;
import Entity.Entity;
import Entity.Stats.StatType;
import Itens.Equipment;
import java.util.Random;

public class Combat {
    private final Random random = new Random();
    
    public void isPlayerDie(Entity entity){
        if (entity.isPlayer()) System.exit(0);
    }
    
    public Skill randomSkill(Entity entity){
        int index = random.nextInt(entity.getCombatManager().getSkills().length);
        return entity.getCombatManager().getSkills()[index];
    }
    
    public void useSkill(Entity attacker, Skill skill, Entity target){
        int damage = getDamage(attacker, skill, target);
        target.getCombatManager().setHp(target.getCombatManager().getHp() - damage);
        System.out.println(attacker.getName()+" used "+skill.getName()+" and dealt "+damage+" damage");
    }
    
    public int getDamage(Entity attacker, Skill skill, Entity target){
        int damage = calcDamage(attacker, skill, target);

        int dodgeChance = target.getStatsManager().getStat(StatType.AGILITY);
        if (dodgeChance > 50) dodgeChance = 50;
        int dodgeRoll = random.nextInt(100);

        if (dodgeRoll < dodgeChance) {
            System.out.println("--- Dodge");
            return 0;
        }

        int critChance = attacker.getStatsManager().getStat(StatType.AGILITY);
        if (critChance > 50) critChance = 50;
        int critRoll = random.nextInt(100);
        
        if (critRoll < critChance) {
            damage *= 2;
            System.out.println("--- Critical attack");
        }

        return damage;
    }
    
    public int calcDamage(Entity attacker, Skill skill, Entity target){
        int damage = (skill.getDamage(attacker)) - target.getInventoryManager().getArmorClass();
        if (damage < 0) damage = 0;
        if (attacker.getInventoryManager().getEquipment(Equipment.Slots.WEAPON) != null) {
            damage += attacker.getInventoryManager().getWeaponDamage();
        }
        return damage;
    }
    
    public boolean canRun(Entity entity, Entity attacker){
        return random.nextInt(entity.getStatsManager().getStat(StatType.AGILITY)) > random.nextInt(attacker.getStatsManager().getStat(StatType.AGILITY));
    }
    
    public void reward(Entity winner, Entity loser){
        int xp = loser.getStatsManager().getLevel() * 100;
        winner.getStatsManager().addXp(xp);
    }
    
    public void openInventory(Entity entity){
        entity.openInventory();
    }
}