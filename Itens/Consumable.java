package Itens;

import Entity.Entity;

public abstract class Consumable extends Item{
    public Consumable(String name) {
        super(name);
    }

    @Override
    public void use(Entity target) {
        applyEffect(target);
        target.getInvSystem().removeItem(this);
    }

    protected abstract void applyEffect(Entity target);
}
