import Control.Entity.Combat.Skill;
import Control.Entity.Stats.Classe;
import Control.Itens.TypeItens.Armor;
import Control.Entity.Entity;
import Control.Entity.Stats.StatType;
import Control.Itens.Equipment.Slots;
import Control.Itens.Item;
import Control.Itens.TypeItens.Potion;

public class teste {
    public static void main(String[] args) {
        
        // Skills
        Skill lunge = new Skill("Lunge", 5, StatType.STRENGTH);
        Skill manaBall = new Skill("Mana ball", 7, StatType.SORCERY);
        Skill bite = new Skill("Bite", 4, StatType.STRENGTH);
        
        // Class
        Classe paladin = new Classe("Paladin");
        paladin.setStat(StatType.STRENGTH, 1);
        paladin.setStat(StatType.RESISTANCE, 1);
        
        // Entities        
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

        // Others
    }
}