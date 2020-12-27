import utils.RandomGen;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Case extends JPanel {

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private JButton btn;
    private int color;
    private int posX;
    private int posY;
    private boolean isActive;

    public Case(int x, int y) {
        //Init Members
        this.posX = x;
        this.posY = y;

        //Init Components
        this.initColor();
        this.initButton();
        this.initPanel();
    }


    public void clicked() {
        this.isActive = false;
        checkAdjacent();
    }

    private void initColor() {
        int i = RandomGen.get(0,4);
        switch(i) {
            case 0 -> this.color = new Color(255,0,0).getRGB();
            case 1 -> this.color = new Color(0,0, 255).getRGB();
            case 2 -> this.color = new Color(136, 0, 255).getRGB();
            case 3 -> this.color = new Color(239, 115, 6).getRGB();
            default -> this.color = new Color(0, 0, 0).getRGB();
        }
    }

    private void initButton() {
        this.btn = new JButton();
        this.btn.setOpaque(false);
        this.btn.setContentAreaFilled(false);
        this.btn.setBorderPainted(false);
        this.btn.addActionListener(new ClickEventHandler(this));
    }

    private void initPanel() {
        this.setBorder(new LineBorder(new Color(0,0,0)));
        this.setBackground(new Color(color));
        this.add(btn);
        this.setLayout(new CardLayout());
        this.isActive = true;
        this.setVisible(true);
    }

    private void checkAdjacent() {
        //CLEAR DOWN
        if(this.posX != 7 && Grid.getGrid().getCase(this.posX+1, this.posY).isActive && Grid.getGrid().getCase(this.posX+1, this.posY).getBackground().getRGB() == this.getBackground().getRGB()) {
            Grid.getGrid().getCase(this.posX + 1, this.posY).clicked();
        }
        //CLEAR UP
        if(this.posX != 0 && Grid.getGrid().getCase(this.posX-1, this.posY).isActive && Grid.getGrid().getCase(this.posX-1, this.posY).getBackground().getRGB() == this.getBackground().getRGB()) {
            Grid.getGrid().getCase(this.posX - 1, this.posY).clicked();
        }
        //CLEAR RIGHT
        if(this.posY != 7 && Grid.getGrid().getCase(this.posX, this.posY+1).isActive && Grid.getGrid().getCase(this.posX, this.posY+1).getBackground().getRGB() == this.getBackground().getRGB()) {
            Grid.getGrid().getCase(this.posX, this.posY + 1).clicked();
        }
        //CLEAR LEFT
        if(this.posY != 0 && Grid.getGrid().getCase(this.posX, this.posY-1).isActive && Grid.getGrid().getCase(this.posX, this.posY-1).getBackground().getRGB() == this.getBackground().getRGB()) {
            Grid.getGrid().getCase(this.posX, this.posY - 1).clicked();
        }
        this.setColor(Color.WHITE.getRGB());
        this.setBackground(Color.WHITE);
    }

    public String toString() {
        switch(this.color) {
            case 0 -> {
                return "r";
            }

            case 1 -> {
                return "b";
            }

            case 2 -> {
                return "v";
            }

            case 3 -> {
                return "o";
            }

        }
        return "x";
    }
}
