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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public Case getCase(int i, int j) {
        return this.cases[i][j];
    }

    public static Grid getGrid() {
        if(main == null) main = new Grid();
        return main;
    }

    public Case[][] getCases() {
        return cases;
    }

    public void swap(int x1, int y1, int x2, int y2) {
        cases[x1][y1].setBackground(cases[x2][y2].getBackground());
        cases[x1][y1].setActive(true);
        cases[x2][y2].setBackground(Color.WHITE);
        cases[x2][y2].setActive(false);
    }

    public void startTimer() {
        Timer t = new Timer(300, e -> rebuild());
        t.start();
    }

    public void rebuild() {
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = cases.length-1; i > 0; i--) {
                for (int j = cases[i].length-1; j >= 0; j--) {
                    if(!this.cases[i][j].isActive() && this.cases[i-1][j].isActive()) {
                        swap(i, j, i - 1, j);
                        System.out.println("Swapped " + i + " " + j + " with " + (i-1) + " " + j + " !");
                        //isSorted = false; IF WANT INSTANT REPLACE
                        return;
                    }
                }
            }
        } while(!isSorted);
    }
}
