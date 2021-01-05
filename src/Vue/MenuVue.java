package Vue;

import Control.Lanceur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuVue extends JFrame {

    private ArrayList<JButton> buttons;
    private Lanceur l;

    public MenuVue(Lanceur l) {
        this.l = l;
        this.getContentPane().setLayout(new FlowLayout());
        initButtons();
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initButtons() {
        this.buttons = new ArrayList<>();
        JButton n1 = new JButton("Niveau 1");
        n1.addActionListener((e) -> {
            this.dispose();
            l.loadLevel(1);
        });
        JButton n2 = new JButton("Niveau 2");
        n2.addActionListener((e) -> {
            this.dispose();
            l.loadLevel(2);
        });
        JButton custom = new JButton("Custom");
        custom.addActionListener((e) -> {
            this.dispose();
            l.loadLevel(9);
        });
        JButton editor = new JButton("Editeur de Niveaux");
        editor.addActionListener((e) -> {
            this.dispose();
            l.levelEditor();
        });
        JButton close = new JButton("Fermer");
        close.addActionListener((e) -> {
            this.dispose();
        });
        this.buttons.add(n1);
        this.buttons.add(n2);
        this.buttons.add(custom);
        this.buttons.add(editor);
        this.buttons.add(close);
        for(JButton i : this.buttons) {
            this.getContentPane().add(i);
        }
    }

}
