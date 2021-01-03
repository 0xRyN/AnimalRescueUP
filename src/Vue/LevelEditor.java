package Vue;

import Modele.Grid;

import javax.swing.*;
import java.awt.*;

public class LevelEditor extends JFrame {

    private JButton[][] grid;
    private JButton export;
    private JButton red;
    private JButton blue;
    private JButton violet;
    private JButton vert;
    private JButton obs;
    private Color lastColor;
    private JPanel colors;
    private JPanel container;
    private JPanel last;

    public LevelEditor() {
        this.grid = new JButton[8][8];
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,800);
        lastColor = new Color(0,0,0);
        colors = new JPanel();
        container = new JPanel();
        container.setLayout(new GridLayout(8,8));
        last = new JPanel();
        this.getContentPane().setLayout(new GridLayout(3,0));
        this.getContentPane().add(colors);
        red = new JButton("Red");
        red.addActionListener((e) -> lastColor = Color.RED);
        blue = new JButton("Blue");
        blue.addActionListener((e) -> lastColor = Color.BLUE);
        violet = new JButton("Violet");
        violet.addActionListener((e) -> lastColor = Color.MAGENTA);
        vert = new JButton("Vert");
        vert.addActionListener((e) -> lastColor = Color.GREEN);
        obs = new JButton("Obstacle");
        obs.addActionListener((e) -> lastColor = Color.BLACK);
        colors.add(red);
        colors.add(blue);
        colors.add(violet);
        colors.add(vert);
        colors.add(obs);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new JButton();
                grid[i][j].setOpaque(true);
                grid[i][j].addActionListener((e) -> {
                    if(e.getSource() instanceof JButton) {
                        ((JButton) e.getSource()).setBackground(lastColor);
                    }
                });
                this.container.add(grid[i][j]);
            }
        }
        this.getContentPane().add(container);
        this.getContentPane().add(last);
        export = new JButton("Exporter");
        last.add(export);
        this.setVisible(true);
    }

}
