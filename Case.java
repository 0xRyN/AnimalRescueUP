import utils.RandomGen;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Case extends JPanel {
    private JButton btn;
    private Color color;

    public Case() {
        this.initColor();
        this.initButton();
        this.initPanel();
    }

    public void clicked() {
        this.setVisible(false);
    }

    private void initColor() {
        int i = RandomGen.get(0,4);
        switch(i) {
            case 0 -> this.color = new Color(255,0,0);
            case 1 -> this.color = new Color(0,0, 255);
            case 2 -> this.color = new Color(136, 0, 255);
            case 3 -> this.color = new Color(27, 255, 0);
            default -> this.color = new Color(0, 0, 0);
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
        this.setBackground(this.color);
        this.add(btn);
        this.setLayout(new CardLayout());
        this.setVisible(true);
    }
}
