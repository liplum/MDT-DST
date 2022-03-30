package net.liplum.components;

import net.liplum.blocks.StatedWall;
import mindustry.gen.Building;

public class SharingHealth extends ComponentBase<StatedWall.StatedWallBuild> {
    @Override
    public void onUpdate(StatedWall.StatedWallBuild b) {
        for (Building other : b.proximity) {
            if (other.block != b.block)
                continue;
            float thisH = b.health;
            float otherH = other.health;
            if (thisH > otherH && thisH > 1 && otherH < other.maxHealth) {
                b.health -= 1;
                other.health += 1;
            }
        }
    }
}