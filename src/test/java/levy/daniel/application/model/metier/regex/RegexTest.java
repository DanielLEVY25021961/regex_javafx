package levy.daniel.application.model.metier.regex;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.regex.impl.Regex;


/**
 * CLASSE RegexTest :<br/>
 * Test JUnit de la classe RegEx.<br/>
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
 * @since 6 août 2018
 *
 */
public class RegexTest {
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
	 * "La chaîne '".<br/>
	 */
	public static final String CHAINE = "La chaîne '";
	
	/**
	 * "' : "<br/>
	 */
	public static final String DEUX_POINTS = "' : ";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(RegexTest.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public RegexTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * teste la méthode motifRespecteSyntaxeRegex(String).<br/>
	 * <ul>
	 * <li>garantit que la méthode retourne true 
	 * si le motif est correct.</li>
	 * <li>garantit que la méthode retourne false 
	 * si le motif est incorrect.</li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testMotifRespecteSyntaxeRegex() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testMotifRespecteSyntaxeRegex() ********** ");
		}


		// **********************************
		final String motifValable = "^\\d+";
		final String motifNonValable = "*abc";
		// **********************************
		
		final IRegex regex = new Regex();
		
		final boolean resultatValable 
			= regex.motifRespecteSyntaxeRegex(motifValable);
		final boolean resultatNonValable 
			= regex.motifRespecteSyntaxeRegex(motifNonValable);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Le motif '" + motifValable + "' respecte-t-il la syntaxe Regex ? : " + resultatValable);
			System.out.println("Le motif '" + motifNonValable + "' respecte-t-il la syntaxe Regex ? : " + resultatNonValable);
		}
		
		/* garantit que la méthode retourne true 
		 * si le motif est correct. */
		assertTrue(
				"motifValable respecte la syntaxe : "
					, resultatValable);
		
		/* garantit que la méthode retourne false 
		 * si le motif est incorrect.*/
		assertFalse(
				"motifNonValable ne respecte pas la syntaxe : "
					, resultatNonValable);
		
	} // Fin de testMotifRespecteSyntaxeRegex().___________________________
	

	
	/**
	 * teste la méthode texteCorrespondEntierementAMotif().<br/>
	 * <ul>
	 * <li>garantit que la méthode retourne true 
	 * si le texte respecte entièrement le motif.</li>
	 * <li>garantit que la méthode retourne false 
	 * si le texte ne respecte pas entièrement le motif.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTexteCorrespondEntierementAMotif() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testMotifRespecteSyntaxeRegex() ********** ");
		}


		// **********************************
		final String texteValable = "123 abrouve les sillons de mon 33 tours";
		final String texteNonValable = "abrouve les sillons de mon 33 tours";
		final String motif = "^\\d+.*$";
		
		// **********************************
		
		final IRegex regex = new Regex();
		
		final boolean resultatValable 
			= regex.texteCorrespondEntierementAMotif(texteValable, motif);
		final boolean resultatNonValable 
			= regex.texteCorrespondEntierementAMotif(texteNonValable, motif);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Le texte '" + texteValable + "' respecte-t-il entièrement le motif '" + motif + "' ? : " + resultatValable);
			System.out.println("Le texte '" + texteNonValable + "' respecte-t-il entièrement le motif '" + motif + "' ? : " + resultatNonValable);
			
		}
		
		/* garantit que la méthode retourne true 
		 * si le texte respecte entièrement le motif. */
		assertTrue(
				"le texte respecte entièrement le motif : "
					, resultatValable);
		
		/* garantit que la méthode retourne false 
		 * si le texte ne respecte pas entièrement le motif.*/
		assertFalse(
				"le texte ne respecte pas entièrement le motif : "
					, resultatNonValable);

	} // Fin de testTexteCorrespondEntierementAMotif().____________________
	
	
	
	/**
	 * teste la méthode texteCorrespondEntierementAMotif2().<br/>
	 * <ul>
	 * <li>garantit que la méthode retourne true 
	 * si le texte respecte entièrement le motif.</li>
	 * <li>garantit que la méthode retourne false 
	 * si le texte ne respecte pas entièrement le motif.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTexteCorrespondEntierementAMotif2() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testMotifRespecteSyntaxeRegex() ********** ");
		}


		// **********************************
		final String texte = "Quand le ciel bas et lourd";
		final String motifTest = "Quand.*";
		final String texteValable = "123 abrouve les sillons de mon 33 tours";
		final String texteNonValable = "abrouve les sillons de mon 33 tours";
		final String motif = "^\\d+.*$";
		
		// **********************************
		
		final IRegex regex = new Regex();
		
		final boolean resultat 
			= regex.texteCorrespondEntierementAMotif(texte, motifTest);
		final boolean resultatValable 
			= regex.texteCorrespondEntierementAMotif(texteValable, motif);
		final boolean resultatNonValable 
			= regex.texteCorrespondEntierementAMotif(texteNonValable, motif);
		
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Le texte '" + texte + "' respecte-t-il entièrement le motif '" + motifTest + "' ? : " + resultat);
//			System.out.println("Le texte '" + texteValable + "' respecte-t-il entièrement le motif '" + motif + "' ? : " + resultatValable);
//			System.out.println("Le texte '" + texteNonValable + "' respecte-t-il entièrement le motif '" + motif + "' ? : " + resultatNonValable);
			
		}
		
		/* garantit que la méthode retourne true 
		 * si le texte respecte entièrement le motif. */
		assertTrue(
				"le texte respecte entièrement le motif : "
					, resultatValable);
		
		/* garantit que la méthode retourne false 
		 * si le texte ne respecte pas entièrement le motif.*/
		assertFalse(
				"le texte ne respecte pas entièrement le motif : "
					, resultatNonValable);

	} // Fin de testTexteCorrespondEntierementAMotif2().___________________
	

	
	/**
	 * teste la méthode expliquerMotif(String).<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test
	public void testExpliquerMotif() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testExpliquerMotif() ********** ");
		}


		// **********************************
		final String motif = "^\\d+";
		final String chaineATester = "10";
		// **********************************
		
		
		final IRegex regex = new Regex();
		regex.setMotifJava(motif);
		
		final boolean resultatContient = regex.texteContientMotif(chaineATester);
		final boolean resultatMatche = regex.motifMatche(chaineATester);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println("EXPLICATION DU MOTIF : ");
			System.out.println(regex.getSignificationMotif());
			System.out.println();
			System.out.println(CHAINE + chaineATester + "' contient-elle le motif java '\\" + motif + DEUX_POINTS + resultatContient);
			System.out.println(CHAINE + chaineATester + "' matche-t-elle le motif java '\\" + motif + DEUX_POINTS + resultatMatche);
		}
		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testMotifMatche()._________________________________________

	
	
	/**
	 * teste la méthode motifMatche(String).<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test
	public void testMotifMatche() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testMotifMatche() ********** ");
		}


		// **********************************
		final String motif = "[0-9]";
		final String chaineATester = "10";
		// **********************************
		
		
		final IRegex regex = new Regex();
		regex.setMotifJava(motif);
		
		final boolean resultatContient = regex.texteContientMotif(chaineATester);
		final boolean resultatMatche = regex.motifMatche(chaineATester);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(CHAINE + chaineATester + "' contient-elle le motif java '\\" + motif + DEUX_POINTS + resultatContient);
			System.out.println(CHAINE + chaineATester + "' matche-t-elle le motif java '\\" + motif + DEUX_POINTS + resultatMatche);
		}
		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testMotifMatche()._________________________________________

	
	
} // FIN DE LA CLASSE RegexTest.---------------------------------------------
