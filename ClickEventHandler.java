import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

public class ClickEventHandler implements ActionListener {
    private Case source;

    public ClickEventHandler(Case c) {
        this.source = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        source.clicked();
        System.out.println(source.getPosX() + " " + source.getPosY());
        Scanner sc = new Scanner(System.in);
        //sc.nextInt();
        Grid.getGrid().startTimer();
    }
}
