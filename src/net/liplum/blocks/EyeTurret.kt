package net.liplum.blocks

import arc.Core
import arc.graphics.g2d.Draw
import arc.graphics.g2d.TextureRegion
import arc.math.Angles
import arc.math.geom.Vec2
import mindustry.Vars
import mindustry.graphics.Drawf
import mindustry.graphics.Layer
import mindustry.world.blocks.defense.turrets.ItemTurret
import mindustry.world.draw.DrawDefault

open class EyeTurret(name: String) : ItemTurret(name) {
    lateinit var bodyTR: TextureRegion
    lateinit var hotBodyTR: TextureRegion
    lateinit var eyeBallTR: TextureRegion
    lateinit var eyeTR: TextureRegion

    init {
        hasShadow = false
        drawer = DrawDefault()
    }

    override fun load() {
        super.load()
        bodyTR = Core.atlas.find("$name-body")
        hotBodyTR = Core.atlas.find("$name-body-hot")
        eyeBallTR = Core.atlas.find("$name-eye-ball")
        eyeTR = Core.atlas.find("$name-eye")
    }

    override fun icons(): Array<TextureRegion> {
        return arrayOf(region)
    }

    open inner class EyeBuild : ItemTurretBuild() {
        var movement = Vec2(3f, 0f)
        override fun drawCracks() {}
        open val eyeBallX: Float
            get() = x + recoilOffset.x
        open val eyeBallY: Float
            get() = y + 28f + recoilOffset.x

        override fun draw() {
            Drawf.shadow(x, y - 12f, 40f)
            Draw.z(Layer.overlayUI - 2f)
            Draw.rect(bodyTR, x, y)
            Draw.alpha(heat)
            Draw.rect(hotBodyTR, x, y)
            Draw.color()
            Draw.z(Layer.overlayUI - 1f)
            val eyeBallX = eyeBallX
            val eyeBallY = eyeBallY
            Draw.rect(eyeBallTR, eyeBallX, eyeBallY)
            if (isControlled) {
                val player = unit()
                val aimX = player.aimX
                val aimY = player.aimY
                movement.setAngle(
                    Angles.angle(eyeBallX, eyeBallY, aimX, aimY)
                )
            } else if (isShooting) {
                movement.setAngle(rotation)
            } else {
                movement.setAngle(this.angleTo(Vars.player))
            }
            Draw.rect(
                eyeTR,
                eyeBallX + movement.x,
                eyeBallY + movement.y
            )
        }
    }
}