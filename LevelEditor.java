import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.concurrent.Flow;

public class LevelEditor {

    private JFrame main;
    private JPanel gridContainer;
    private JPanel up;
    private JPanel down;
    private JLabel text;
    private JButton red, blue, violet, orange;
    private JButton[][] grid;
    private JButton lastClicked;

    public LevelEditor() {

        main = new JFrame();
        gridContainer = new JPanel();
        up = new JPanel();
        down = new JPanel();
        text = new JLabel("Éditeur de niveaux : Choisissez une case et sa couleur");
        red = new JButton("Rouge");
        blue = new JButton("Bleu");
        violet = new JButton("Violet");
        orange = new JButton("Orange");

        gridContainer.setLayout(new GridLayout(8,8));
        grid = new JButton[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new JButton();
                grid[i][j].addActionListener(e -> {
                    if(this.lastClicked != null) this.lastClicked.setText("");
                    this.lastClicked = (JButton) e.getSource();
                    this.lastClicked.setText("Clicked !");
                });
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                gridContainer.add(grid[i][j]);
            }
        }

        main.getContentPane().setLayout(null);
        main.setSize(800,800);
        main.setTitle("Éditeur de niveaux");
        main.getContentPane().add(gridContainer);
        gridContainer.setBounds(100,50,600,600);
        main.getContentPane().add(up);
        up.setBounds(150,0,600,100);
        main.getContentPane().add(down);
        down.setBounds(150,700,500,100);

        up.add(text);


        down.setLayout(new FlowLayout());
        down.add(red);
        red.addActionListener(e -> {
            if(this.lastClicked != null) {
                lastClicked.setBackground(Color.RED);
            }
        });
        down.add(blue);
        blue.addActionListener(e -> {
            if(this.lastClicked != null) {
                lastClicked.setBackground(Color.BLUE);
            }
        });
        down.add(violet);
        violet.addActionListener(e -> {
            if(this.lastClicked != null) {
                lastClicked.setBackground(Color.MAGENTA);
            }
        });
        down.add(orange);
        orange.addActionListener(e -> {
            if(this.lastClicked != null) {
                lastClicked.setBackground(Color.ORANGE);
            }
        });

        main.setVisible(true);


    }

}
