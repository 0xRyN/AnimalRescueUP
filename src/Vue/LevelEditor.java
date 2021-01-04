package Vue;

import Modele.Grid;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        export.addActionListener((e) -> {
            export();
        });
        last.add(export);
        this.setVisible(true);
    }

    public void export() {
        try {
            File custom = new File("custom.txt");
            if (custom.createNewFile()) {
                System.out.println("Fichier custom crée: " + custom.getName());
            } else {
                System.out.println("Fichier custom existe.");
            }

            PrintWriter writer = new PrintWriter("custom.txt");
            writer.println("8 8");
            for (int i = 7; i >= 0; i--) {
                for (int j = 7; j >= 0; j--) {
                    String s;
                    switch(grid[i][j].getBackground().getRGB()) { //1 bleu, 2 violet, 3 vert
                        case (-65536) -> s = "0";
                        case (-16776961) -> s = "1";
                        case (-65281) -> s = "2";
                        case (-16711936) -> s = "3";
                        case (-1) -> s = "4";
                        default -> s = "9";
                    }
                    writer.print(s + " ");
                }
                writer.println();
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
