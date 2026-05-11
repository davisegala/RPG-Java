package Class;

public abstract class Item {
    private String name;
    private boolean isEquipment = false;

    public Item(String name) {
        this.name = name;
    }
    
    public Item(String name, boolean isEquipment) {
        this.name = name;
        this.isEquipment = isEquipment;
    }
    
    public abstract String display();
    
    public void use(Entity target){
        
    };
    
        
    public void equip(Entity target){
        System.out.println("This item cannot be equipped");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsEquipment() {
        return isEquipment;
    }
}
