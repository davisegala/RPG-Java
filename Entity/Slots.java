package Entity;

import Itens.Item;
import Itens.TypeItens.Armor;
import Itens.TypeItens.Weapon;
import java.util.HashMap;
import java.util.Map;

public class Slots {
    private Weapon weapon;
    public enum ArmorSlot{HELMET, CHESTPLATE, LEGGINGS, BOOTS}
    private Map<ArmorSlot, Armor> armors = new HashMap<>();
    
    public int getArmorClass() {
        int armorClass = 0;
        for (Armor armor : armors.values()) {
            if (armor == null) continue;
            armorClass += armor.getArmor();
        }
        return armorClass;
    }

    public void equip(Item item) {
        if (item instanceof Armor armor) armors.put(armor.getSlot(), armor);
    }
    
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
