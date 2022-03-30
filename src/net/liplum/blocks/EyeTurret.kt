package net.liplum.blocks

import arc.Core
import arc.graphics.g2d.Draw
import arc.graphics.g2d.TextureRegion
import arc.math.Angles
import arc.math.Mathf
import arc.math.geom.Vec2
import mindustry.entities.bullet.BulletType
import mindustry.graphics.Drawf
import mindustry.graphics.Layer
import mindustry.world.blocks.defense.turrets.ItemTurret

open class EyeTurret(name: String) : ItemTurret(name) {
    lateinit var bodyTR: TextureRegion
    lateinit var hotBodyTR: TextureRegion
    lateinit var eyeBallTR: TextureRegion
    lateinit var eyeTR: TextureRegion

    init {
        hasShadow = false
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
        override fun bullet(type: BulletType, angle: Float) {
            val lifeScl = if (type.scaleVelocity) Mathf.clamp(
                Mathf.dst(
                    x + tr.x,
                    y + tr.y,
                    targetPos.x,
                    targetPos.y
                ) / type.range(), minRange / type.range(), range / type.range()
            ) else 1f
            val realAngle = if (isControlled) {
                val player = unit()
                val aimX = player.aimX
                val aimY = player.aimY
                Angles.angle(eyeBallX, eyeBallY, aimX, aimY)
            } else {
                rotation
            }

            type.create(
                this, team,
                eyeBallX,
                eyeBallY,
                realAngle, 1f + Mathf.range(velocityInaccuracy), lifeScl
            )
        }

        open val eyeBallX: Float
            get() = x + tr2.x
        open val eyeBallY: Float
            get() = y + 28f + tr2.x

        override fun draw() {
            Drawf.shadow(x, y - 12f, 40f)
            Draw.z(Layer.overlayUI - 2f)
            Draw.rect(bodyTR, x, y)
            Draw.alpha(heat)
            Draw.rect(hotBodyTR, x, y)
            Draw.color()
            Draw.z(Layer.overlayUI - 1f)
            tr2.trns(rotation, -recoil)
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
            } else {
                movement.setAngle(rotation)
            }
            Draw.rect(
                eyeTR,
                eyeBallX + movement.x,
                eyeBallY + movement.y
            )
        }
    }
}