<<<<<<< HEAD
package NPC;

public abstract class Npc {
    private String name;
    private NpcType type;
    private int age;
    private Genero gender;
    private int money = 10;

    public void falar(){ }

    public String getName() { return name; }
    public NpcType getType() { return type; }
    public int getAge() { return age; }
    public Genero getGenero() { return gender; }
    public int getMoney() { return money; }

    public void setName(String name) { this.name = name; }
    public void setType(NpcType type) { this.type = type; }
    public void setAge(int age) { this.age = age; }
    public void setGender(Genero genero) { this.gender = genero; }
    public void setMoney(int Money) { this.money = Money; }

    public enum Genero{ MASCULINO, FEMININO }
=======
package NPC;

public abstract class Npc {
    private String name;
    private NpcType type;
    private int age;
    private Genero gender;
    private int money = 10;

    public void falar(){ }

    public String getName() { return name; }
    public NpcType getType() { return type; }
    public int getAge() { return age; }
    public Genero getGenero() { return gender; }
    public int getMoney() { return money; }

    public void setName(String name) { this.name = name; }
    public void setType(NpcType type) { this.type = type; }
    public void setAge(int age) { this.age = age; }
    public void setGender(Genero genero) { this.gender = genero; }
    public void setMoney(int Money) { this.money = Money; }

    public enum Genero{ MASCULINO, FEMININO }
>>>>>>> c39a2c1 (add NPCs)
}