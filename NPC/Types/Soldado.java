<<<<<<< HEAD
package NPC.Types;

import Entity.Inventory;
import Itens.TypeItens.Weapon;
import NPC.Npc;

public class Soldado extends Npc {
    private Weapon weapon;
    private Inventory inventory = new Inventory();

    @Override
    public void falar() {
        System.out.println("Comerciante falar");
    }
}
=======
package NPC.Types;

import Entity.Inventory;
import Itens.TypeItens.Weapon;
import NPC.Npc;

public class Soldado extends Npc {
    private Weapon weapon;
    private Inventory inventory = new Inventory();

    @Override
    public void falar() {
        System.out.println("Comerciante falar");
    }
}
>>>>>>> c39a2c1 (add NPCs)
