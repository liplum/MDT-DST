package net.liplum.bullets

import arc.Core
import arc.graphics.g2d.Draw
import arc.graphics.g2d.TextureRegion
import mindustry.entities.bullet.BulletType
import mindustry.gen.Bullet

open class PowerOrb : BulletType {
    lateinit var orbTR: TextureRegion
    @JvmField var dmgIncrease = 0.05f / 60f
    @JvmField var textureName = ""

    constructor(speed: Float, damage: Float) : super(speed, damage)
    constructor()

    override fun load() {
        super.load()
        orbTR = Core.atlas.find(textureName)
    }

    override fun update(b: Bullet) {
        super.update(b)
        b.damage *= 1f + dmgIncrease
    }

    override fun draw(b: Bullet) {
        super.draw(b)
        Draw.rect(orbTR, b.x, b.y)
    }
}