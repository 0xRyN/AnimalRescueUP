package Control;
import Vue.FenetrePrincipale;
import Vue.LevelEditor;
import Vue.MenuVue;

import java.awt.*;

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
//		System.out.println(Color.RED.getRGB());
//		System.out.println(Color.BLUE.getRGB());
//		System.out.println(Color.MAGENTA.getRGB());
//		System.out.println(Color.GREEN.getRGB());
//		System.out.println(Color.WHITE.getRGB());
	}
}

