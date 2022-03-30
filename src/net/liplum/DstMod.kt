package net.liplum

import arc.util.Log
import mindustry.mod.Mod

@Suppress("FunctionName", "MemberVisibilityCanBePrivate")
class DstMod : Mod() {
    val modContents = arrayOf(
        DstItems,
        DstBullets,
        DstBlocks
    )

    init {
        Log.info("Loaded Don't Starve constructor.")
    }

    override fun loadContent() {
        Log.info("Loading some Don't Starve content.")
        for (content in modContents) {
            content.load()
        }
    }
}