package net.liplum;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class DstItems implements ContentList {
    public static Item thulium;
    public static Item thuliumBar;

    @Override
    public void load() {
        thulium = new Item("thulium", Color.valueOf("#f7ae08")) {{
            hardness = 0;
            radioactivity = 0.25f;
            cost = 3.5f;
        }};
        thuliumBar = new Item("thulium-bar", Color.valueOf("#ce7508")) {{
            radioactivity = 0.25f;
        }};
    }
}