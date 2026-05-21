package Itens;

import Entity.Entity;
import Itens.Material.Material;

public class Craft {
    public Item Craft(Entity entity){
        Material[] materials = getMaterials(entity);
        
        
        
        return null;
    }
    
    private Material[] getMaterials(Entity entity){
        Material[] materialArray = new Material[5];
        
        for (int i = 0; i < 5; i++) {
            Material item = getMaterial(entity);
            
            if (item == null) {
                break;
            } else {
                materialArray[i] = item;
            }
        }
        
        for (Material i : materialArray) {
            if (i == null) return null;
        }

        return materialArray;
    }
    
    private Material getMaterial(Entity entity) {
        return entity.getInventory().openMaterial(entity);
    }
}
