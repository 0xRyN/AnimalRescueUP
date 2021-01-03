package Control;
import Vue.FenetrePrincipale;
import Vue.LevelEditor;
import Vue.MenuVue;

public class Lanceur {
	
	public static FenetrePrincipale vue;

	public void initialisation() {
		MenuVue m = new MenuVue(this);
	}

	public void loadLevel(int i) {
		this.vue = new FenetrePrincipale(ModeleVueCtrl.getInstance(i).getGridVue());
	}

	public void levelEditor() {
		LevelEditor l = new LevelEditor();
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

