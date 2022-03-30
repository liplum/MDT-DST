package net.liplum.components

import mindustry.gen.Building

abstract class ComponentBase<Build : Building> {
    open fun onUpdate(b: Build) {}
}
