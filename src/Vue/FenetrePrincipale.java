package Vue;



import javax.swing.*;


import java.awt.*;

public class FenetrePrincipale extends JFrame {

	private JPanel  panneauPrin;
	private JPanel  panneauCase;

	private GridVue gridVue;
	private JPanel panneauScor;
	private JPanel panWin;

	private Label score;
	private Label win;


	public FenetrePrincipale(GridVue gridVue) {

		this.setTitle("Animal Rescue");
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.panneauPrin = new JPanel();
		this.panneauScor = new JPanel();

		this.score = new Label("SCORE :");
		this.panneauScor.add(this.score);

		this.panneauPrin.setLayout(new BorderLayout());

		this.getContentPane().add(this.panneauPrin);

		this.gridVue = gridVue;
		this.panneauPrin.add(this.gridVue, BorderLayout.CENTER);
		this.panneauPrin.add(this.panneauScor, BorderLayout.NORTH);

		this.win = new Label("**************** YOU WIN *******************");
		this.panWin = new JPanel();
		this.panWin.add(this.win);

		this.panneauPrin.add(this.panWin, BorderLayout.SOUTH);
		this.panWin.setVisible(false);
		this.setVisible(true);

	}

	public JPanel getPanWin() {
		return panWin;
	}
}
