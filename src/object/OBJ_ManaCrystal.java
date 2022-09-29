package object;

import com.Main.GamePanel;
import entity.Entity;

public class OBJ_ManaCrystal extends Entity {

    GamePanel gp;

    public OBJ_ManaCrystal(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickUpOnly;
        name = "Mana Crystal";
        value = 1;
        down1 = setup("/objects/manacrystal_full", gp.tileSize, gp.tileSize);

        image = setup("/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image1 = setup("/objects/manacrystal_blank", gp.tileSize, gp.tileSize);

    }
    public void use(Entity entity){
        gp.playSoundEffect(2);
        gp.ui.addMessage("Mana +" + value);
        entity.mana += value;
    }
}
