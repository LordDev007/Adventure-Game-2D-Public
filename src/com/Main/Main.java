package com.Main;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {

    public static JFrame window;

    public Main() throws IOException {
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.d3d", "false");
	    window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        String versionType = "Stable";
        String version = "v" + "0.1.173.1";
        window.setTitle("Dungeon Adventure 2D" + " " + version + " " + versionType);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.config.loadConfig();
        if(gamePanel.fullScreenOn == true){
            window.setUndecorated(true);
        }

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();

        ImageIcon icon;
        icon = new ImageIcon("/icon/icon.ico");
        window.setIconImage(icon.getImage());
    }
}
//Build_On_Java_SDK18//version:0.1.1217.1001//BasedOn:FlatEngine4.0&IntellijIDEA2022.1.4//Dawn.AllCopyrightsReserved
//opensourceGame//PleaseReportBugsAt:"hoangbinhminh2508@gmail.com"
/*
* Version type: ʙᴇᴛᴀ 🇩🇪🇻🇪🇱🇴🇵🇪🇷 ᴘʀᴇᴠɪᴇᴡ sᴛᴀʙʟᴇ
* deadlineStartOn:1/5/2022
* deadlineEndOn:1/7/2022
* 40% DONE + 0% DLC (May not have)
* 40 - 11 add to 42 later
*/
