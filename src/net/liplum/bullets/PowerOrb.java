package net.liplum.bullets;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Hitboxc;

public class PowerOrb extends BulletType {
    public TextureRegion orbTR;
    public float dmgIncrease = 0.05f / 60f;
    public String textureName = "";

    public PowerOrb(float speed, float damage) {
        super(speed, damage);
    }

    public PowerOrb() {
    }

    @Override
    public void update(Bullet b) {
        super.update(b);
        b.damage *= 1f + dmgIncrease;
    }

    @Override
    public void draw(Bullet b) {
        super.draw(b);
        Draw.rect(orbTR, b.x, b.y);
    }

    @Override
    public void hitTile(Bullet b, Building build, float initialHealth, boolean direct) {
        super.hitTile(b, build, initialHealth, direct);
    }

    @Override
    public void hitEntity(Bullet b, Hitboxc entity, float health) {
        super.hitEntity(b, entity, health);
    }

    @Override
    public void load() {
        super.load();
        orbTR = Core.atlas.find(textureName);
    }
}
