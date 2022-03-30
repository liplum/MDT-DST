package net.liplum;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.GenericCrafter;
import net.liplum.blocks.AncientAltar;
import net.liplum.blocks.EyeTurret;
import net.liplum.blocks.StatedWall;
import net.liplum.components.SharingHealth;

public class DstBlocks implements ContentList {
    public static StatedWall thuliumWall;
    public static SharingHealth sharingHealth = new SharingHealth();
    public static GenericCrafter ancientAltar;
    public static EyeTurret eyeTurret;

    @Override
    public void load() {
        thuliumWall = new StatedWall("thulium-wall") {{
            requirements(Category.defense, new ItemStack[]{
                    new ItemStack(DstItems.thuliumBar, 2)
            });
            health = 2500;
            hasShadow = false;
            size = 2;
            buildCostMultiplier = 2f;
            stateNumber = 4;
            update = true;
            components.add(sharingHealth);
        }};

        ancientAltar = new AncientAltar("ancient-altar") {{
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(DstItems.thulium, 30),
                    new ItemStack(Items.copper, 30),
                    new ItemStack(Items.lead, 25)
            });
            outputItem = new ItemStack(DstItems.thuliumBar, 1);
            craftTime = 80f;
            size = 3;
            hasItems = true;
            hasShadow = false;
            consumes.item(DstItems.thulium, 6);
        }};

        eyeTurret = new EyeTurret("eye-turret") {{
            requirements(Category.turret, new ItemStack[]{
                    new ItemStack(DstItems.thuliumBar, 5)
            });
            health = 1200;
            ammo(
                    DstItems.thulium, DstBullets.powerOrb,
                    DstItems.thuliumBar, DstBullets.powerOrbLarge
            );
            maxAmmo = 20;
            size = 3;
            reloadTime = 60f;
            range = 500f;
            recoilAmount = 3f;
        }};
    }
}