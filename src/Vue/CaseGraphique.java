package Vue;


import Control.LisnnerCntrl;

import javax.swing.*;
import java.awt.*;

public class CaseGraphique extends JButton {

    private int gridPosX;
    private int gridPosY;
    private Color color;
    public CaseGraphique(Color color, int posX, int posY) {
        this.color = color;
//        this.setOpaque(true);
//        this.setBorderPainted(false);
        this.setBackground(color);
        this.addActionListener(new LisnnerCntrl(this));
        this.gridPosX = posX;
        this.gridPosY = posY;
    }

    public int getGridPosX() {
        return gridPosX;
    }

    public void setGridPosX(int gridPosX) {
        this.gridPosX = gridPosX;
    }

    public int getGridPosY() {
        return gridPosY;
    }

    public void setGridPosY(int gridPosY) {
        this.gridPosY = gridPosY;
    }

    public void setColor(Color color) {
        this.setBackground(color);
    }




}
