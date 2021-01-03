package Control;
import Vue.FenetrePrincipale;

public class Lanceur {
	
	public static FenetrePrincipale vue;

	public void initialisation() {

		this.vue = new FenetrePrincipale(ModeleVueCtrl.getInstance().getGridVue());
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String [] args) {
		Lanceur L = new Lanceur();
		L.initialisation();
	}

}
