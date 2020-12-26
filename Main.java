import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length != 0 && args[0].equals("console")) {
            System.out.println("gey");
            Scanner sc = new Scanner(System.in);
            while(true) {
                System.out.println(Arrays.deepToString(Grid.getGrid().getCases()));
                System.out.println("Quelle case voulez vous cliquer ? Format : 0 0 ou 7 7 ou 1 5");
                String a = sc.nextLine();
                int x = Integer.parseInt(String.valueOf(a.charAt(0)));
                int y = Integer.parseInt(String.valueOf(a.charAt(2)));
                Grid.getGrid().getCase(x, y).clicked();
            }
        }
        else {
            setupMenu();
        }
    }

    public static void setupMenu() {
        JFrame menu = new JFrame();
        JPanel btns = new JPanel();
        btns.setLayout(new FlowLayout());
        btns.setBackground(Color.BLACK);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setSize(800,400);
        Button start = new Button("Start");
        start.addActionListener((a) -> {
            menu.dispose();
            Grid.getGrid().setVisible(true);
        });
        Button leaderboards = new Button("Leaderboards");
        Button close = new Button("Close");
        btns.add(start);
        btns.add(leaderboards);
        btns.add(close);
        btns.setAlignmentY(Component.CENTER_ALIGNMENT);
        menu.add(btns);
        menu.setVisible(true);
    }

}
