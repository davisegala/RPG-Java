package NPC.Types;

import Entity.Inventory;
import NPC.Npc;

public class Ferreiro extends Npc {
    private Inventory inventory = new Inventory();

    public void CriarArma(){

    }

    @Override
    public void falar() {
        System.out.println("Comerciante falar");
    }
}