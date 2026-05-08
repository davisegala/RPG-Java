package Class;

public abstract class Item {
    private String name;
    private int durability;
    private boolean isEquipment = false;

    public Item(String name) {
        this.name = name;
    }
    
    public Item(String name, boolean isEquipment) {
        this.name = name;
        this.isEquipment = isEquipment;
    }
    
    public abstract String display();
    
    public abstract void use(Entity target);
    
    public void equip(Entity target){
        if (!this.isEquipment) return;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean getIsEquipment() {
        return isEquipment;
    }
}
