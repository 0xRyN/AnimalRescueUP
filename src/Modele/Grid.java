package Modele;

import java.util.ArrayList;

public class Grid {

	private Case[][] cases;

	private int ligne =8;
	private int colonne=8 ;


	public Grid(Case [][] cases){
		this.cases = cases;
		}


	public void CasesAdjacentes(int x, int y) {

	}
	public boolean SiDecalage(ArrayList liste) {
		if (liste.size()>1) return true;
		else return false;
	}
	public void Decalage(ArrayList liste) {
		
	}
	public Case[][] getCase(){
		return cases;
	}

	/*public void affichage() {
		for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                System.out.print(cases[i][j].getCouleurVal()+" | ");
                if (j==7) System.out.print("\n");
            }
		}
	}*/

	boolean check(int x, int y) {
		return  !((x >= this.colonne || x < 0)  || (y >= this.colonne || y < 0));
	}

	public int getColonne() {
		return colonne;
	}

	public void decaleCase(int i, int c) {

		this.cases[i][c] = this.cases[i+1][c];
	}

	public void print() {
		System.out.println("-------------------------");
		for (int i = 0; i < this.ligne; i++) {
			for (int j = 0; j < this.colonne; j++) {
				System.out.print("\t" + this.cases[i][j].getCouleurVal());
			}
			System.out.println();


		}
	}
}