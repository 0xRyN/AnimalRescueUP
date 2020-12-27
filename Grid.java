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

        int tPosX = this.cases[x1][y1].getPosX();
        int tPosY = this.cases[x1][y1].getPosY();
        int color = this.cases[x2][y2].getColor().getRGB();
        System.out.println("TEMP X : " + tPosX);

        this.cases[x1][y1].setColor(new Color(color));
        this.cases[x1][y1].setActive(true);
        this.cases[x1][y1].setPosX(this.cases[x2][y2].getPosX());
        //System.out.println("Set the new colored case X to : " + this.cases[x2][y2].getPosX());
        this.cases[x1][y1].setPosY(this.cases[x2][y2].getPosY());
        this.cases[x1][y1].setIntColor(this.cases[x2][y2].getIntColor());
        this.cases[x1][y1].setBackground(this.cases[x1][y1].getColor());

        System.out.println("TEMP X : " + tPosX);

        this.cases[x2][y2].setActive(false);
        this.cases[x2][y2].setPosX(tPosX);
        //System.out.println("Set the new blank case X to : " + tPosX);
        this.cases[x2][y2].setPosY(tPosY);
        this.cases[x2][y2].setIntColor(9);
        this.cases[x2][y2].setBackground(Color.WHITE);
        this.cases[x2][y2].setColor(Color.WHITE);
    }

    public void startTimer() {
        Timer t = new Timer(1000, e -> rebuild());
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
