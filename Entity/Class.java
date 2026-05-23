<<<<<<< HEAD
package Entity;

public class Class {
    private String name;
    private Status status;

    public Class(String name) {
        this.name = name;
        this.status = new Status();
    }
    
    public void setStat(StatType type, int value) {
        status.setStat(type, value);
    }

    public int getStat(StatType type) {
        return status.getStat(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
=======
package Entity;

public class Class {
    private String name;
    private Status status;

    public Class(String name) {
        this.name = name;
        this.status = new Status();
    }
    
    public void setStat(StatType type, int value) {
        status.setStat(type, value);
    }

    public int getStat(StatType type) {
        return status.getStat(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
>>>>>>> c39a2c1 (add NPCs)
