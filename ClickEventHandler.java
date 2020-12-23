import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickEventHandler implements ActionListener {
    private Case source;

    public ClickEventHandler(Case c) {
        this.source = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        source.clicked();
    }
}
