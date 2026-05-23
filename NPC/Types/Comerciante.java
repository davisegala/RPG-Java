package NPC.Types;

import Entity.Inventory;
import NPC.Npc;

public class Comerciante extends Npc {
    private Inventory inventario = new Inventory();

    @Override
    public void falar() {
        System.out.println("Comerciante falar");
    }
}
