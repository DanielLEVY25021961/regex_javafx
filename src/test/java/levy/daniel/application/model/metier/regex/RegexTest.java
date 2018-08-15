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
		
		/* Instanciation d'un Regex. */
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
	 * teste la méthode texteCommenceParMotif(...).<br/>
	 * <ul>
	 * <li>garantit que texteCommenceParMotif
	 * (chaine qui commence par le motif, motif) retourne true.</li>
	 * <li>garantit que texteCommenceParMotif
	 * (chaine qui ne commence pas par le motif, motif) retourne false.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTexteCommenceParMotif() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testTexteCommenceParMotif() ********** ");
		}
		
		// **********************************
		/* commence par un ou plusieurs chiffres. */
		final String motifValable = "^\\d+";
		final String motifNonValable = "*abc";
		
		final String chaineValable = "1 pain tous les matins ça fait du bien";
		final String chaineNonValable = "Bravo, 1 pain tous les matins ça fait du bien";
		// **********************************
		
		/* Instanciation d'un Regex. */
		final IRegex regex = new Regex();
		
		final boolean resultatValable 
			= regex.texteCommenceParMotif(chaineValable, motifValable);
		
		final boolean resultatNonValable 
			= regex.texteCommenceParMotif(chaineNonValable, motifValable);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println("la String : '" + chaineValable 
					+ "' commence-t-elle par un chiffre et respecte-t-elle le motif " 
					+ motifValable + " ? : " + resultatValable);
			
			System.out.println("la String : '" + chaineNonValable 
					+ "' commence-t-elle par un chiffre et respecte-t-elle le motif " 
					+ motifValable + " ? : " + resultatNonValable);
		}

		/* garantit que texteCommenceParMotif(chaine qui 
		 * commence par le motif, motif) retourne true. */
		assertTrue(
				"la chaine valable commence par le motif : "
					, resultatValable);
		
		/* garantit que texteCommenceParMotif(chaine qui 
		 * ne commence pas par le motif, motif) retourne false. */
		assertFalse(
				"la chaine non valable ne commence pas par le motif : "
					, resultatNonValable);

	} // Fin de testTexteCommenceParMotif()._______________________________
	
	
	
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
	 * Teste la méthode trouverOccurences(...).<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @throws Exception :  :  .<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTrouverOccurences() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testTrouverOccurences() ********** ");
		}
		
		// **********************************
		final String motifValable = "avec";
		
		final String chaineValable = "avec le temps et avec l'argent tout s'en va\nles roses aavec leur pétales m'ennuient";
		// **********************************

		/* Instanciation d'un Regex. */
		final Regex regex = new Regex();
		
		regex.trouverOccurences(chaineValable, motifValable);

		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testTrouverOccurences().___________________________________
	
	
} // FIN DE LA CLASSE RegexTest.---------------------------------------------
