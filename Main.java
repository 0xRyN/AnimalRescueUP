import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args != null && args[0].equals("console")) {
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
            Grid.getGrid().setVisible(true);
        }
    }
}
