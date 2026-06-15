package Control.Entity.Combat;

import Control.Entity.Entity;
import Control.Entity.Player;
import Control.Entity.Stats.StatType;
import Control.Itens.Equipment;
import java.util.Random;
import javax.swing.JOptionPane;

public class Combat {
    private final Random random = new Random();
    
    public void isPlayerDie(Entity entity){
        if (entity instanceof Player) {
            JOptionPane.showMessageDialog(null, "You die");
            System.exit(0);
        }
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
        int damage = (skill.getDamage(attacker)) - target.getArmorClass();
        if (damage < 0) damage = 0;
        if (attacker.getEquipment(Equipment.Slots.WEAPON) != null) {
            damage += attacker.getWeaponDamage();
        }
        return damage;
    }
    
    public boolean canRun(Entity entity, Entity attacker){
        return random.nextInt(entity.getStatsManager().getStat(StatType.AGILITY)) > random.nextInt(attacker.getStatsManager().getStat(StatType.AGILITY));
    }
    
    public void run(Entity entity, Entity enemy) {
        if (canRun(entity, enemy)) end(entity);
    }
    
    private void reward(Entity winner, Entity loser){
        int xp = loser.getStatsManager().getLevel() * 100;
        winner.getStatsManager().addXp(xp);
    }
    
    public void end(Entity entity1, Entity entity2) {
        int hp1 = entity1.getCombatManager().getHp();
        int hp2 = entity2.getCombatManager().getHp();
        
        if (hp1 > 0 && hp2 <= 0) {
            isPlayerDie(entity2);
            reward(entity1, entity2);
        } 
        else if (hp2 > 0 && hp1 <= 0) {
            isPlayerDie(entity1);
            reward(entity2, entity1);
        }
    }
    
    public void end(Entity entity) {
        isPlayerDie(entity);
        System.out.println("end");
    }
}