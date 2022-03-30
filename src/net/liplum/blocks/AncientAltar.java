package net.liplum.blocks;

import arc.graphics.g2d.Draw;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.world.blocks.production.GenericCrafter;

public class AncientAltar extends GenericCrafter {
    public float shadowRadius = 40f;
    public float xOffset = 0f;
    public float yOffset = 22.5f;

    public AncientAltar(String name) {
        super(name);
    }

    public class AltarBuild extends GenericCrafterBuild {
        @Override
        public void drawCracks() {
        }

        @Override
        public void draw() {
            Drawf.shadow(x, y, shadowRadius);
            Draw.z(Layer.overlayUI - 2f);
            Draw.rect(block.region, x + xOffset, y + yOffset);
            Draw.reset();
        }
    }
}
