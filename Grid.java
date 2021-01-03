import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    private static Grid main;
    private Case[][] cases;


    public Grid() {
        this.cases = new Case[8][8];
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                this.cases[i][j] = new Case(i, j);
                this.add(cases[i][j]);
            }
        }
        this.setSize(800, 800);
        this.setLayout(new GridLayout(8,8));
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("manissa");
    }

    public Case getCase(int i, int j) {
        return this.cases[i][j];
    }

    public static Grid getGrid() {
        if(main == null) main = new Grid();
        return main;
    }
}
