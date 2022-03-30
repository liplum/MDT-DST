package net.liplum;

import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.ctype.ContentList;
import net.liplum.bullets.PowerOrb;

public class DstBullets implements ContentList {
    public static PowerOrb powerOrb;
    public static PowerOrb powerOrbLarge;

    @Override
    public void load() {
        powerOrb = new PowerOrb(5f, 240f) {{
            textureName = Vars.content.transformName("power-orb");
            lifetime = 130;
            hitEffect = Fx.none;
            despawnEffect = Fx.none;
            shootEffect = Fx.none;
            smokeEffect = Fx.none;
            absorbable = false;
            reflectable = false;
            hitSize = 35f;
            pierce = true;
            pierceCap = 3;
        }};
        powerOrbLarge = (PowerOrb) powerOrb.copy();
        powerOrbLarge.pierceCap = Integer.MAX_VALUE;
        powerOrbLarge.hitSize = 40f;
        powerOrbLarge.damage = 400f;
    }
}
