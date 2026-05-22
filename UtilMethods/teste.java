package UtilMethods;

import Entity.Skill;
import Entity.Class;
import Itens.TypeItens.Armor;
import Entity.Entity;
import Entity.Entity.ArmorSlot;
import Entity.StatType;
import Itens.Material.Iron;
import Itens.TypeItens.Potion;

public class teste {
    public static void main(String[] args) {
        Combat com = new Combat();
        
        // Skills
        Skill lunge = new Skill("Lunge", 5, StatType.STRENGHT);
        Skill manaBall = new Skill("Mana ball", 7, StatType.SOURCERY);
        Skill bite = new Skill("Bite", 4, StatType.STRENGHT);
        
        // Class
        Class paladin = new Class("Paladin");
        paladin.setStat(StatType.STRENGHT, 1);
        paladin.setStat(StatType.RESISTANCE, 1);
        
        // Entities        
        Entity player = new Entity("Davi");
        player.setLevel(1);
        player.setIsPlayer(true);
        player.setSkills(new Skill[] {lunge, manaBall});
        player.setClasse(paladin);
        
        Entity goblin = new Entity("Goblin");
        goblin.setLevel(1);
        goblin.setSkills(new Skill[] {lunge, manaBall});
        
        Entity wolf = new Entity("Wolf");
        wolf.setLevel(3);
        wolf.setSkills(new Skill[] {bite});
        
        // Itens
        Potion healingPotion = new Potion("Healing potion", 20);
        Armor leatherArmor = new Armor("Leather armor", 2, ArmorSlot.CHESTPLATE);
        Armor plateArmor = new Armor("Plate armor", 10, ArmorSlot.CHESTPLATE);
        
        player.addItem(healingPotion, 1);
        player.addItem(leatherArmor);
        player.addItem(plateArmor);

        player.addItem(new Iron());
        
        // Others
        com.battle(player, wolf);
    }
}
