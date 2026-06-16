package Control.Itens;

import Control.Entity.Entity;

public abstract class Consumable extends Item{
    public Consumable(String name) {
        super(name);
    }

    @Override
    public void use(Entity target) {
        applyEffect(target);
        target.removeItem(this);
    }

    protected abstract void applyEffect(Entity target);
}
