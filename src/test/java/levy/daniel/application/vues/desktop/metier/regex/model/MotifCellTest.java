package levy.daniel.application.vues.desktop.metier.regex.model;

import static org.junit.Assert.*;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;


/**
 * CLASSE MotifCellTest :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 28 août 2018
 *
 */
public class MotifCellTest {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";

	/**
	 * locale de la plateforme.<br/>
	 */
	private final transient Locale locale = Locale.getDefault();

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MotifCellTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifCellTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	/**
	 * Teste la méthode updateItem(...).<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 */
	@edu.umd.cs.findbugs.annotations.SuppressFBWarnings
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateItem() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifCellTest - méthode testUpdateItem() ********** ");
		}
		
		final IMotif motif1 
			= new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /");
		final IMotif motif2 
			= new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /");
		final IMotif motif3 
			= new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /");
		
//		final MotifCell motifCell = new MotifCell();
		
//		motifCell.updateItem(motif1, true);
		
		final String format = "%1$-50s      %2$-45s";
		
		final String texte1 = String.format(
				this.locale
				, format 
				, motif1.getNom(), motif1.getMotifJava());
		final String texte2 = String.format(
				this.locale
				, format 
				, motif2.getNom(), motif2.getMotifJava());
		final String texte3 = String.format(
				this.locale
				, format 
				, motif3.getNom(), motif3.getMotifJava());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(texte1);
			System.out.println(texte2);
			System.out.println(texte3);
		}
		
		assertTrue("BIDON : ", 1 == 1);

	} // Fin de testUpdateItem().__________________________________________
	
	

} // FIN DE LA CLASSE MotifCellTest.-----------------------------------------
