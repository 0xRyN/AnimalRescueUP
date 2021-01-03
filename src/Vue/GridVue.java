package Vue;


import javax.swing.*;
import java.awt.*;


public class GridVue extends JPanel{

    private CaseGraphique cases [][];

    private int ligne, colonne;

    /**
     *
     */
    public GridVue (int ligne, int colonne) {
        this.colonne = colonne;
        this.ligne   = ligne;
        this.setLayout(new GridLayout(this.ligne, this.colonne));
    }

    /**
     *
     * @param cases les cases
     */
    public GridVue(CaseGraphique [][] cases, int ligne, int colonne) {
        this(ligne, colonne);
        this.cases = cases;
        this.addAllCase();
    }

    /**
     *
     */
    public void SetGrid (int x, int y, CaseGraphique caseGraphique) {
        this.cases[x][y] = caseGraphique;
        this.add(this.cases[x][y], x, y);
    }

    public void addAllCase() {
        for (int i = 0; i < this.ligne; i++)
            for (int j = 0; j < this.colonne; j++)
                this.add(this.cases[i][j], i, j);
    }


    public CaseGraphique[][] getCases() {
        return cases;
    }





}
