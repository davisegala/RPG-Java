package NPC.Types;

import Entity.Inventory;
import NPC.Npc;

public class Alquimista extends Npc {
    private Inventory inventory = new Inventory();

    public void CriarPocao(){

    }

    @Override
    public void falar() {
        System.out.println("Comerciante falar");
    }
}
