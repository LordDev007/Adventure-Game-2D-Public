package com.Main.DLC;

import com.Main.GamePanel;
import entity.Entity;

public class DLC_Sword_Flame extends Entity {
    public DLC_Sword_Flame(GamePanel gp) {
        super(gp);

        //DLC: FLAME SWORD - 1$
        type = type_sword;
        name = "Flame Sword";
        down1 = setup("/objects/sword_flame", gp.tileSize, gp.tileSize);
        attackValue = 10;
        attackArea.width = 38;
        attackArea.height = 38;
        description = "[" + name + "] \n A sword surrounded by \n flame.";
    }
}
