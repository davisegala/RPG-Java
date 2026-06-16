package Control.Itens.Material;

import Control.Entity.Entity;
import Control.Itens.Item;
import Control.Itens.TypeItens.Weapon;
import Control.Itens.TypeItens.Armor;

public abstract class Material extends Item{
    private int durability;

    public Material(String nome, int durability) {
        super(nome);
        this.durability = durability;
    }
    
    public abstract void weaponProperty(Weapon weapon);
    
    public abstract void armorProperty(Armor armor);
    
    @Override
    public String display() {
        return "Durablity: "+ this.getDurability();
    }
    
    @Override
    public void use(Entity target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
