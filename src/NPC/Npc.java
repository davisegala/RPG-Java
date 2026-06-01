package NPC;

public abstract class Npc {
    private String name;
    private NpcType type;
    private int age;

    public Npc(String name, NpcType type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public void talk() {

    }
}