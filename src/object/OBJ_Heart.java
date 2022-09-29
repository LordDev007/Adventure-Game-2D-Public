package object;

import com.Main.GamePanel;
import entity.Entity;

public class OBJ_Heart extends Entity {
    GamePanel gp;
    public OBJ_Heart(GamePanel gp){
        super(gp);
        this.gp = gp;

        type = type_pickUpOnly;
        name = "Heart";
        value = 2;
        down1 = setup("/objects/heart_full", gp.tileSize, gp.tileSize);

        image = setup("/objects/heart_full", gp.tileSize, gp.tileSize);
        image1 = setup("/objects/heart_half", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/heart_blank", gp.tileSize, gp.tileSize);

    }
    public void use(Entity entity){
        gp.playSoundEffect(2);
        gp.ui.addMessage("Life +" + value);
        entity.life += value;
    }
}
