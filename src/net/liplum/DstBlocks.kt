package net.liplum

import mindustry.content.Items
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.blocks.production.GenericCrafter
import net.liplum.blocks.AncientAltar
import net.liplum.blocks.EyeTurret
import net.liplum.blocks.StatedWall
import net.liplum.components.SharingHealth

object DstBlocks : ContentList {
    @JvmStatic lateinit var thuliumWall: StatedWall
    @JvmStatic lateinit var ancientAltar: GenericCrafter
    @JvmStatic lateinit var eyeTurret: EyeTurret
    override fun load() {
        thuliumWall = StatedWall("thulium-wall").apply {
            requirements(
                Category.defense, arrayOf(
                    ItemStack(DstItems.thuliumBar, 2)
                )
            )
            health = 2500
            hasShadow = false
            size = 1
            buildCostMultiplier = 2f
            stateNumber = 4
            drawSize = 0.8f
            update = true
            components.add(SharingHealth)
        }
        ancientAltar = AncientAltar("ancient-altar").apply {
            requirements(
                Category.crafting, arrayOf(
                    ItemStack(DstItems.thulium, 30),
                    ItemStack(Items.copper, 30),
                    ItemStack(Items.lead, 25)
                )
            )
            outputItem = ItemStack(DstItems.thuliumBar, 1)
            craftTime = 100f
            size = 3
            hasItems = true
            hasShadow = false
            consumeItem(DstItems.thulium, 6)
        }
        eyeTurret = EyeTurret("eye-turret").apply {
            requirements(
                Category.turret, arrayOf(
                    ItemStack(DstItems.thuliumBar, 5)
                )
            )
            health = 1200
            ammo(
                DstItems.thulium, DstBullets.powerOrb,
                DstItems.thuliumBar, DstBullets.powerOrbLarge
            )
            maxAmmo = 20
            size = 3
            reload = 60f
            range = 500f
            recoil = 3f
        }
    }
}