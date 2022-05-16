package net.liplum

import arc.graphics.Color
import mindustry.type.Item

object DstItems : ContentList {
    @JvmStatic lateinit var thulium: Item
    @JvmStatic lateinit var thuliumBar: Item
    override fun load() {
        thulium = Item("thulium", Color.valueOf("#f7ae08")).apply {
            hardness = 0
            radioactivity = 0.25f
            cost = 3.5f
        }
        thuliumBar = Item("thulium-bar", Color.valueOf("#ce7508")).apply {
            radioactivity = 0.25f
        }
    }
}