package net.liplum.components

import net.liplum.blocks.StatedWall.StatedWallBuild

object SharingHealth : ComponentBase<StatedWallBuild>() {
    override fun onUpdate(b: StatedWallBuild) {
        for (other in b.proximity) {
            if (other.block !== b.block) continue
            val thisH = b.health
            val otherH = other.health
            if (thisH > otherH && thisH > 1 && otherH < other.maxHealth) {
                b.health -= 1f
                other.health += 1f
            }
        }
    }
}