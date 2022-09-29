package object;

import com.Main.GamePanel;
import entity.Entity;

public class OBJ_Potion_Red extends Entity {

    GamePanel gp;

    public OBJ_Potion_Red(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = type_consumable;
        name = "Healing Potion";
        value = 5;
        down1 = setup("/objects/potion_red",gp.tileSize, gp.tileSize);
        description = "[" + name + "] \n Healing your HP by " + value + ".";

    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You just drink the " + name + "!\n" +
                                "Your life has been recovered by " + value + ".";
        entity.life += value;
        gp.playSoundEffect(2);

    }
}
