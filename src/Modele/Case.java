package Modele;

import Vue.CaseGraphique;

public class Case {
	
	private int posX;
    private int posY;
    private boolean isActive;
	private int couleurVal;

	
	public Case(int x, int y, int  col) {
        //Init Members
        this.posX = x;
        this.posY = y;
        this.isActive=true;
        this.couleurVal= col; //generer pour chaque case une valeur representatif de la couleur
    }
	public int getCouleurVal() {
		return couleurVal;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}

	public void setCouleurVal(int couleurVal) {
		this.couleurVal = couleurVal;
	}

	public void setEntryGraphique(CaseGraphique caseGraphiqueGraphique) {
	}

	public static void copy(Case c1,  Case c2) {
		c1.couleurVal = c2.couleurVal;
		c2.couleurVal = -1;
	}
}
