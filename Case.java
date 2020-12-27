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

    public int getIntColor() {
        return intColor;
    }

    public void setIntColor(int intColor) {
        this.intColor = intColor;
    }

    public Color getColor() {
        return color;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setColor(Color color) {
        this.color = color;
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
    private Color color;
    private int intColor;
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
        this.intColor = i;
        switch(i) {
            case 0 -> this.color = new Color(255,0,0);
            case 1 -> this.color = new Color(0,0, 255);
            case 2 -> this.color = new Color(136, 0, 255);
            case 3 -> this.color = new Color(239, 115, 6);
            default -> this.color = new Color(0, 0, 0);
        }
    }

    private void initButton() {
        this.btn = new JButton();
        this.btn.setOpaque(false);
        this.btn.setContentAreaFilled(false);
        this.btn.setBorderPainted(false);
        this.btn.addActionListener(new ClickEventHandler(this));
        this.btn.setText(this.color.toString().substring(15));
    }

    private void initPanel() {
        this.setBorder(new LineBorder(new Color(0,0,0)));
        this.setBackground(this.color);
        this.add(btn);
        this.setLayout(new CardLayout());
        this.isActive = true;
        this.setVisible(true);
    }

    private void checkAdjacent() {
        //CLEAR DOWN
        if(this.posX != 7 && Grid.getGrid().getCase(this.posX+1, this.posY).isActive && Grid.getGrid().getCase(this.posX+1, this.posY).getColor().getRGB() == this.color.getRGB()) {
            Grid.getGrid().getCase(this.posX + 1, this.posY).clicked();
        }
        //CLEAR UP
        if(this.posX != 0 && Grid.getGrid().getCase(this.posX-1, this.posY).isActive && Grid.getGrid().getCase(this.posX-1, this.posY).getColor().getRGB() == this.color.getRGB()) {
            Grid.getGrid().getCase(this.posX - 1, this.posY).clicked();
        }
        //CLEAR RIGHT
        if(this.posY != 7 && Grid.getGrid().getCase(this.posX, this.posY+1).isActive && Grid.getGrid().getCase(this.posX, this.posY+1).getColor().getRGB() == this.color.getRGB()) {
            Grid.getGrid().getCase(this.posX, this.posY + 1).clicked();
        }
        //CLEAR LEFT
        if(this.posY != 0 && Grid.getGrid().getCase(this.posX, this.posY-1).isActive && Grid.getGrid().getCase(this.posX, this.posY-1).getColor().getRGB() == this.color.getRGB()) {
            Grid.getGrid().getCase(this.posX, this.posY - 1).clicked();
        }
        this.setColor(Color.WHITE);
        this.setBackground(Color.WHITE);
        this.intColor = 9;
        this.btn.setText(this.color.toString().substring(15));
    }

    public String toString() {
        switch(this.intColor) {
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
