package Itens.Material;

import Entity.Entity;
import Itens.TypeItens.Weapon;
import Itens.TypeItens.Armor;

public class Iron extends Material{
    public Iron() {
        super("Iron", 64);
    }

    @Override 
    public void weaponProperty(Weapon weapon) {
        weapon.addDamage(5);
    }

    @Override
    public void armorProperty(Armor armor) {
        armor.addArmor(3);
    }    

    @Override
    public void use(Entity target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
