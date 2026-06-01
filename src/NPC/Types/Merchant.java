package NPC.Types;

import Entity.Inventory.Inventory;
import NPC.Npc;
import NPC.NpcType;
import UtilMethods.Input;

public class Merchant extends Npc {
    private Inventory inventory = new Inventory();

    public Merchant(String name, NpcType type, int age, Gender gender) {
        super(name, type, age, gender);
    }

    @Override
    public void talk(){
        System.out.println("Hey, how can I help?");
        System.out.println("[1] Check out the store | [2] Talk to the merchant "+ getName() + " | [3] Exit");
        switch (Input.Choose(3)){
            case 1 -> System.out.println("Inventario");
            case 2 -> System.out.println("How's it going?");
            case 3 -> System.out.println("See you later.");
        }
    }
}
