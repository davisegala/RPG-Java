package Itens;

public abstract class Item {
    private String name;
    
    public enum Type{
        MATERIAL
    }
    
    public Item(String name) {
        this.name = name;
    }
    
    public abstract String display();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void getItemType(){
        
    }
}
