package UtilMethods;

import Class.Entity;
import Class.EntityClass;
import Class.Inventory;
import Class.Item;
import Class.Skill;
import Class.TypeStatus;
import Itens.Potion;

public class teste {
    public static void main(String[] args) {
        Combat com = new Combat();
        
        // Skills
        Skill lunge = new Skill("Lunge", 5, TypeStatus.STRENGHT);
        Skill manaBall = new Skill("Mana ball", 7, TypeStatus.SOURCERY);
        
        // Class
        EntityClass paladin = new EntityClass("Paladin");
        paladin.setStrength(1);
        paladin.setResistance(1);
        
        // Entities        
        Entity player = new Entity("Davi");
        player.setLevel(2);
        player.setIsPlayer(true);
        player.setSkills(new Skill[] {lunge, manaBall});
        player.setClasse(paladin);
        
        Entity goblin = new Entity("Goblin");
        goblin.setLevel(1);
        goblin.setSkills(new Skill[] {lunge, manaBall});
        
        // Itens
        Potion healingPotion = new Potion("Healing potion", 20);
        
        player.addItem(healingPotion, 100);
        
        // Others        
        com.battle(player, goblin);
    }
}
