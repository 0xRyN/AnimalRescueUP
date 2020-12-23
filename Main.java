import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame main = new JFrame();
        main.setLayout(new GridLayout(8,8));
        Case[][] cases = new Case[8][8];
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                cases[i][j] = new Case();
                main.add(cases[i][j]);
            }
        }
        main.setSize(800, 800);
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
