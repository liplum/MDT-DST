package net.liplum.blocks

import arc.graphics.g2d.Draw
import mindustry.graphics.Drawf
import mindustry.graphics.Layer
import mindustry.world.blocks.production.GenericCrafter

open class AncientAltar(name: String) : GenericCrafter(name) {
    @JvmField var shadowRadius = 40f
    @JvmField var xOffset = 0f
    @JvmField var yOffset = 22.5f

    inner class AltarBuild : GenericCrafterBuild() {
        override fun drawCracks() {}
        override fun draw() {
            Drawf.shadow(x, y, shadowRadius)
            Draw.z(Layer.overlayUI - 2f)
            Draw.rect(block.region, x + xOffset, y + yOffset)
            Draw.reset()
        }
    }
}