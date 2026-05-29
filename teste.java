import Entity.Skill;
import Entity.Class;
import Itens.TypeItens.Armor;
import Entity.Entity;
import Entity.Stats.StatType;
import Itens.Equipment.Slots;
import Itens.Item;
import Itens.TypeItens.Potion;
import UtilMethods.Combat;

public class teste {
    public static void main(String[] args) {
        Combat com = new Combat();
        
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
        Item healingPotion = new Potion("Healing potion", 20);
        Item leatherArmor = new Armor("Leather armor", 2, Slots.CHESTPLATE);
        Item plateArmor = new Armor("Plate armor", 10, Slots.CHESTPLATE);
        
        player.getInvSystem().addItem(healingPotion, 1);
        player.getInvSystem().addItem(leatherArmor);
        player.getInvSystem().addItem(plateArmor);

        //player.addItem(new Iron());
        
        // Others
        com.battle(player, goblin);
    }
}