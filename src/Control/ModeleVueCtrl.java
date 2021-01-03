package Control;

import Modele.Case;

import Modele.Grid;
import Vue.CaseGraphique;
import Vue.GridVue;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeleVueCtrl {

    public static ModeleVueCtrl instance;

    public static ModeleVueCtrl getInstance(int i) {
        if(instance == null) {
            instance = new ModeleVueCtrl(i);
        }
        return instance;
    }

    public static ModeleVueCtrl getInstance() {
        return instance;
    }


    private GridVue gridVue;
    private Grid    grid   ;
    private  int ligne;
    private  int colonne;

    public ModeleVueCtrl(int i) {
        this.initialisation(i);
    }

    public void initialisation(int i) {
        String path = "partie_0" + String.valueOf(i) + ".txt";
        this.getFromFiles(path);
    }

    public void getFromFiles(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            this.ligne  = Integer.parseInt(line.split(" ")[0]);
            this.colonne  = Integer.parseInt(line.split(" ")[1]);

            Case[][]          cases   = new Case[this.ligne][this.colonne];
            CaseGraphique[][] caseGraphiques = new CaseGraphique[this.ligne][this.colonne];

            for (int i = 0; i < cases.length; i++) {
                line = br.readLine();
                String [] cols = line.split(" ");
                for (int j = 0; j < cases[i].length; j++) {
                    cases[i][j]           = new Case(i, j, Integer.parseInt(cols[j]));
                    caseGraphiques[i][j]  = new CaseGraphique(setColor(cases[i][j].getCouleurVal()),i, j);
                }
            }
            this.gridVue = new GridVue(caseGraphiques, this.ligne, this.colonne);
            this.grid    = new Grid(cases);

        }catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas / Svp rexecuter le programme avec un fichier existant!");
            System.exit(0);
        }catch (IOException  e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }




    public Color setColor(int couleur){
        Color color;
        switch(couleur) {
            case 0  -> color  = new Color(255,0,0);
            case 1  -> color  = new Color(0,0,255);
            case 2  -> color  = new Color(136,0,255);
            case 3  -> color  = new Color(27,255,0);
            default -> color  = new Color(255,255,255);
        }
        return color;
    }


    public GridVue getGridVue() {
        return gridVue;
    }

    public int getColonne() {
        return colonne;
    }

    public Grid getGrid() {
        return grid;
    }

    public void deleteIfCan(int i, int j) {

        ArrayList <Case> caseList = new ArrayList<>();
        caseList.add(this.grid.getCase()[i][j]);
        caseAdjacentes(caseList, i, j, this.grid.getCase()[i][j].getCouleurVal());

        if (caseList.size() >= 2) {
            for (Case aCase : caseList) {
                this.gridVue.getCases()[aCase.getPosX()][aCase.getPosY()].setColor(Color.WHITE);
            }

            miseAjour(caseList);
        }
    }

    private void caseAdjacentes(ArrayList <Case> list, int i, int j, int coleur) {

        this.grid.getCase()[i][j].setCouleurVal(-1);
        if (verif(i+1 , j, coleur)) {
            list.add(this.grid.getCase()[i+1][j]);
            this.caseAdjacentes(list, i+1, j, coleur);
        }
        if (verif(i, j+1, coleur)) {
        	
            list.add(this.grid.getCase()[i][j+1]);
            this.caseAdjacentes(list, i, j+1, coleur);
        }
        if (verif(i-1, j, coleur)){
            list.add(this.grid.getCase()[i-1][j]);
            this.caseAdjacentes(list, i-1, j, coleur);

        }
        if (verif(i, j-1, coleur)){
            list.add(this.grid.getCase()[i][j-1]);
            this.caseAdjacentes(list, i, j-1, coleur);
        }
    }

    Scanner scanner = new Scanner(System.in);

    void miseAjour(ArrayList <Case> cases) {


        for (int line = this.ligne - 1; line >= 0; line--) {
            for (int colonne = 0 ; colonne < this.colonne; colonne++) {
                Case c = this.grid.getCase()[line][colonne];
                if (c.getCouleurVal() == -1) {
                    int col = c.getPosY();
                    int lig = c.getPosX();

                    for (int i = lig; i < this.ligne - 1; i++) {
                        this.copy(i, col, i + 1, col);
                    }
                }
            }
        }

        for (int i = 0; i < this.colonne -1 ; i++) {
            if (this.grid.getCase()[0][i].getCouleurVal() == -1) {
                System.out.println("GAUCHE");
                for (int l = 0; l < this.ligne; l++) {
                    for (int col = i; col < this.colonne-1; col++) {
                        this.copy(l, col, l, col+1);
                    }
                }
                if (this.grid.getCase()[0][i].getCouleurVal() == -1)
                    i = i-1;
                this.colonne--;
            }
        }
        int cpt = majVue();

        if (cpt == 0) {
            Lanceur.vue.getPanWin().setVisible(true);
            System.out.println("You Win");
        } else
            this.grid.print();

    }

    private int  majVue() {
        int cpt = 0;
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.grid.getColonne(); j++) {
                this.getGridVue().getCases()[i][j].setColor(setColor(this.grid.getCase()[i][j].getCouleurVal()));
                if (this.grid.getCase()[i][j].getCouleurVal() != -1)
                    cpt++;
            }
        }
        return cpt;
    }
    public boolean verif (int x, int y, int color) {
        if (x < 0 || x >= this.ligne)
            return false;
        if (y < 0 || y >= this.colonne)
            return false;
        return this.grid.getCase()[x][y].getCouleurVal() == color && this.grid.getCase()[x][y].getCouleurVal() != -1;
    }

    public void copy (int x1, int y1, int x2, int y2) {
        Case.copy(this.grid.getCase()[x1][y1],this.grid.getCase()[x2][y2]);

    }




}
