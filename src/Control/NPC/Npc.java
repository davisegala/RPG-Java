package NPC;

public abstract class Npc {
    private final String name;

    public Npc(String name) {
        this.name = name;
    }

    public abstract void talk();

    public String getName() {
        return name;
    }
}