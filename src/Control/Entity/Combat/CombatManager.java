package Control.Entity.Combat;

import Control.Entity.Entity;
import Control.Entity.Stats.StatType;
import Vision.CombatScreen;

public interface CombatManager {
    CombatScreen combatScreen = new CombatScreen();

    default void startCombat(Entity attacker, Entity target) {
        combatScreen.startBattle(attacker, target);
    }

    default int getMaxHp(Entity entity) {
        return 30 + ( entity.getStat(StatType.RESISTANCE) * 20 );
    }

    default void setHp(Entity entity, int hp) {
        if (hp < 0) hp = 0;
        if (hp > getMaxHp(entity)) hp = getMaxHp(entity);
        entity.setHp(hp);
    }

    default void updateHp(Entity entity) {
        entity.setHp(getMaxHp(entity));
    }
}
