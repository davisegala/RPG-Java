package NPC;

public abstract class Npc {
    private String name;
    private NpcType type;
    private int age;
    private Gender gender;
    private int money = 10;

    public void talk(){ }

    public enum Gender { MASCULINO, FEMININO }

    public Npc(String name, NpcType type, int age, Gender gender) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.gender = gender;
    }

    public String getName() { return name; }

    public NpcType getType() { return type; }

    public int getAge() { return age; }

    public Gender getGender() { return gender; }

    public int getMoney() { return money; }

    public void setName(String name) { this.name = name; }

    public void setType(NpcType type) { this.type = type; }

    public void setAge(int age) { this.age = age; }

    public void setGender(Gender gender) { this.gender = gender; }

    public void setMoney(int Money) { this.money = Money; }

}