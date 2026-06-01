import Entity.Combat.Skill;
import Entity.Class;
import Itens.TypeItens.Armor;
import Entity.Entity;
import Entity.Stats.StatType;
import Itens.Equipment.Slots;
import Itens.Item;
import Itens.TypeItens.Potion;

public class teste {
    public static void main(String[] args) {        
        // Skills
        Skill lunge = new Skill("Lunge", 5, StatType.STRENGTH);
        Skill manaBall = new Skill("Mana ball", 7, StatType.SORCERY);
        Skill bite = new Skill("Bite", 4, StatType.STRENGTH);
        
        // Class
        Class paladin = new Class("Paladin");
        paladin.setStat(StatType.STRENGTH, 1);
        paladin.setStat(StatType.RESISTANCE, 1);
        
        // Entities        
        Entity player = new Entity("Davi");
        player.getStatsManager().setLevel(1);
        player.setIsPlayer(true);
        player.getCombatManager().setSkills(new Skill[] {lunge, manaBall});
        player.setClasse(paladin);
        
        Entity goblin = new Entity("Goblin");
        goblin.getStatsManager().setLevel(1);
        goblin.getCombatManager().setSkills(new Skill[] {lunge, manaBall});
        
        Entity wolf = new Entity("Wolf");
        wolf.getStatsManager().setLevel(3);
        wolf.getCombatManager().setSkills(new Skill[] {bite});
        
        // Itens
        Item healingPotion = new Potion("Healing potion", 20);
        Item leatherArmor = new Armor("Leather armor", 2, Slots.CHESTPLATE);
        Item plateArmor = new Armor("Plate armor", 10, Slots.CHESTPLATE);
        
        player.getInventoryManager().addItem(healingPotion);
        player.getInventoryManager().addItem(leatherArmor);
        player.getInventoryManager().addItem(plateArmor);
        
        // Others
        player.getCombatManager().startCombat(goblin);
    }
}