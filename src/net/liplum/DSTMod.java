package net.liplum;

import arc.util.Log;
import mindustry.ctype.ContentList;
import mindustry.mod.Mod;

public class DSTMod extends Mod {
    public static DstItems dstItems;
    public static DstBullets dstBullets;
    public static DstBlocks dstBlocks;
    public static final ContentList[] modContents = {
            dstItems = new DstItems(),
            dstBullets = new DstBullets(),
            dstBlocks = new DstBlocks(),
    };

    public DSTMod() {
        Log.info("Loaded Don't Starve constructor.");
    }

    @Override
    public void loadContent() {
        Log.info("Loading some Don't Starve content.");
        for (ContentList content : modContents) {
            content.load();
        }
    }
}
