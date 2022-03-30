package net.liplum.blocks;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.graphics.Drawf;
import mindustry.world.blocks.defense.Wall;
import net.liplum.components.ComponentBase;

import java.util.ArrayList;

public class StatedWall extends Wall {
    public TextureRegion[] states;
    public float shadowRadius = 20f;
    public int stateNumber;
    public ArrayList<ComponentBase<StatedWallBuild>> components =
            new ArrayList<>();

    public StatedWall(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();
        states = new TextureRegion[stateNumber];
        for (int i = 0; i < stateNumber; i++) {
            states[i] = Core.atlas.find(name + "-" + i);
        }
    }

    public class StatedWallBuild extends WallBuild {
        @Override
        public void updateTile() {
            for (ComponentBase<StatedWallBuild> component : components) {
                component.onUpdate(this);
            }
        }

        @Override
        public void drawCracks() {
        }

        @Override
        public void draw() {
            if (shadowRadius > 0f) {
                Drawf.shadow(x, y, shadowRadius);
            }
            int curIndex = (int) (lostHealthPct() * stateNumber);
            curIndex = Math.min(curIndex, stateNumber - 1);
            Draw.rect(states[curIndex], x, y);
            this.drawTeamTop();
        }

        public float lostHealthPct() {
            return 1f - health / maxHealth;
        }
    }
}
