package net.liplum

import mindustry.Vars
import mindustry.content.Fx
import net.liplum.bullets.PowerOrb

object DstBullets : ContentList {
    @JvmStatic lateinit var powerOrb: PowerOrb
    @JvmStatic lateinit var powerOrbLarge: PowerOrb
    override fun load() {
        powerOrb = PowerOrb(5f, 240f).apply {
            textureName = Vars.content.transformName("power-orb")
            lifetime = 130f
            hitEffect = Fx.none
            despawnEffect = Fx.none
            shootEffect = Fx.none
            smokeEffect = Fx.none
            absorbable = false
            reflectable = false
            hitSize = 35f
            pierce = true
            pierceCap = 3
        }
        powerOrbLarge = (powerOrb.copy() as PowerOrb).apply {
            pierceCap = Int.MAX_VALUE
            hitSize = 40f
            damage = 400f
        }
    }
}