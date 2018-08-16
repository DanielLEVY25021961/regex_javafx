package levy.daniel.application.model.metier.regex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	 * "la String : '".<br/>
	 */
	public static final String LA_STRING = "la String : '";
	
	/**
	 * " ? : ".<br/>
	 */
	public static final String INTERROGATION = " ? : ";
	
	/**
	 * "' commence-t-elle par un chiffre et respecte-t-elle le motif ".<br/>
	 */
	public static final String COMMENCE_PAR_MOTIF 
		= "' commence-t-elle par un chiffre et respecte-t-elle le motif ";
	
	/**
	 * "Le texte contient-il le motif : ".<br/>
	 */
	public static final String CONTIENT_MOTIF 
		= "Le texte contient-il le motif : ";
	
	/**
	 * "la liste d'occurences est-elle vide ? : ".<br/>
	 */
	public static final String LISTE_OCCURENCES_VIDE 
		= "la liste d'occurences est-elle vide ? : ";
	
	/**
	 * "liste d'occurences : \n".<br/>
	 */
	public static final String LISTE_OCCURENCES 
		= "liste d'occurences : \n";
	
	/**
	 * "la liste d'occurences ne doit pas être null : ".<br/>
	 */
	public static final String LISTE_OCCURENCES_PAS_NULL 
		= "la liste d'occurences ne doit pas être null : ";
	
	/**
	 * "le constructeur complet et le constructeur d'arité nulle avec Setters doivent avoir le même comportement : ".<br/>
	 */
	public static final String CONSTRUCTEUR_SIMILAIRES 
		= "le constructeur complet et le constructeur d'arité nulle avec Setters doivent avoir le même comportement : ";
	
	/**
	 * "Texte : ".<br/>
	 */
	public static final String TEXTE = "Texte : ";
	
	/**
	 * "Motif Regex : ".<br/>
	 */
	public static final String MOTIF = "Motif Regex : ";
	
	
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
			System.out.println();
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
	 * teste la méthode texteCommenceParMotif().<br/>
	 * <ul>
	 * <li>garantit que texteCommenceParMotif
	 * (chaine qui commence par le motif, motif) retourne true.</li>
	 * <li>garantit que texteCommenceParMotif
	 * (chaine qui ne commence pas par le motif, motif) retourne false.</li>
	 * <li>garantit que le constructeur complet et le constructeur 
	 * d'arité nulle avec Setters ont le même comportement.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTexteCommenceParMotifNu() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE RegexTest - méthode testTexteCommenceParMotifNu() ********** ");
		}
		
		// **********************************
		/* commence par un ou plusieurs chiffres. */
		final String motifValable = "^\\d+";
		
		final String chaineValable = "1 pain tous les matins ça fait du bien";
		final String chaineNonValable = "Bravo, 1 pain tous les matins ça fait du bien";
		// **********************************
		
		/* Instanciation d'un Regex. */
		final IRegex regexValable = new Regex(chaineValable, motifValable);
		final IRegex regexValableNu = new Regex();
		regexValableNu.setChaineATester(chaineValable);
		regexValableNu.setMotifJava(motifValable);
		final IRegex regexNonValable = new Regex(chaineNonValable, motifValable);
		final IRegex regexNonValableNu = new Regex();
		regexNonValableNu.setChaineATester(chaineNonValable);
		regexNonValableNu.setMotifJava(motifValable);
		
		final boolean resultatValable 
			= regexValable.texteCommenceParMotif();
		final boolean resultatValableNu 
		= regexValableNu.texteCommenceParMotif();
		
		final boolean resultatNonValable 
			= regexNonValable.texteCommenceParMotif();
		final boolean resultatNonValableNu 
			= regexNonValableNu.texteCommenceParMotif();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'UNE STRING COMMENCANT PAR LE MOTIF  -----------------");
			System.out.println(TEXTE + chaineValable);
			System.out.println(MOTIF + motifValable);
			System.out.println();
			System.out.println(LA_STRING + chaineValable 
					+ COMMENCE_PAR_MOTIF 
					+ motifValable + INTERROGATION + resultatValable);
			System.out.println(LA_STRING + chaineValable 
					+ COMMENCE_PAR_MOTIF 
					+ motifValable + INTERROGATION + resultatValableNu);
			System.out.println("Occurences : " + regexValable.afficherListOccurences(regexValable.getListeOccurencesMotif()));
			System.out.println("Occurences avec le Constructeur nu : " + regexValableNu.afficherListOccurences(regexValableNu.getListeOccurencesMotif()));
			
			System.out.println();
			System.out.println("CAS D'UNE STRING COMMENCANT NE COMMENCANT PAS PAR LE MOTIF  -----------------");
			System.out.println(TEXTE + chaineNonValable);
			System.out.println(MOTIF + motifValable);
			System.out.println();
			System.out.println(LA_STRING + chaineNonValable 
					+ COMMENCE_PAR_MOTIF 
					+ motifValable + INTERROGATION + resultatNonValable);
			System.out.println(LA_STRING + chaineNonValable 
					+ COMMENCE_PAR_MOTIF 
					+ motifValable + INTERROGATION + resultatNonValableNu);
			System.out.println("Occurences : " + regexNonValable.afficherListOccurences(regexNonValable.getListeOccurencesMotif()));
			System.out.println("Occurences avec le Constructeur nu : " + regexNonValableNu.afficherListOccurences(regexNonValableNu.getListeOccurencesMotif()));
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
		
		/* garantit que le constructeur complet et le constructeur d'arité nulle avec Setters ont le même comportement. */
		assertEquals(
				CONSTRUCTEUR_SIMILAIRES
				, regexValable.getListeOccurencesMotif()
					, regexValableNu.getListeOccurencesMotif());
		
		assertEquals(
				CONSTRUCTEUR_SIMILAIRES
				, regexNonValable.getListeOccurencesMotif()
					, regexNonValableNu.getListeOccurencesMotif());

	} // Fin de testTexteCommenceParMotifNu()._____________________________
	

	
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
			System.out.println();
			System.out.println("********** CLASSE RegexTest - méthode testTexteCommenceParMotif() ********** ");
		}
		
		// **********************************
		/* commence par un ou plusieurs chiffres. */
		final String motifValable = "^\\d+";
		
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
			
			System.out.println(LA_STRING + chaineValable 
					+ COMMENCE_PAR_MOTIF 
					+ motifValable + INTERROGATION + resultatValable);
			
			System.out.println(LA_STRING + chaineNonValable 
					+ COMMENCE_PAR_MOTIF 
					+ motifValable + INTERROGATION + resultatNonValable);
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
	 * Teste la méthode trouverOccurences().<br/>
	 * <ul>
	 * <li>garantit que trouverOccurences(motifNonValable) 
	 * retourne une liste vide mais non null.</li>
	 * <li>garantit que trouverOccurences(motifNonValable) 
	 * retourne une liste vide.</li>
	 * <li>garantit que trouverOccurences(motif existant) 
	 * retourne une liste non null.</li>
	 * <li>garantit que trouverOccurences(motif existant) 
	 * retourne une liste non vide.</li>
	 * <li>garantit que le constructeur complet et le constructeur 
	 * d'arité nulle avec Setters ont le même comportement.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTrouverOccurencesNu() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE RegexTest - méthode testTrouverOccurencesNu() ********** ");
		}
		
		// **********************************
		final String motifValable = "avec";
		final String motifNonValable = "toto";
		
		final String chaineValable = "avec le temps et avec l'argent tout s'en va\nles roses aavec leur pétales m'ennuient";
		// **********************************

		/* Instanciation d'un Regex. */
		final IRegex regexValable = new Regex(chaineValable, motifValable);
		final IRegex regexValableNu = new Regex();
		regexValableNu.setChaineATester(chaineValable);
		regexValableNu.setMotifJava(motifValable);
		
		final IRegex regexNonValable = new Regex(chaineValable, motifNonValable);
		final IRegex regexNonValableNu = new Regex();
		regexNonValableNu.setChaineATester(chaineValable);
		regexNonValableNu.setMotifJava(motifNonValable);
		
		
		final List<IOccurence> occurencesListValable 
			= regexValable.trouverOccurences();
		final List<IOccurence> occurencesListValableNu 
			= regexValableNu.trouverOccurences();
		
		final List<IOccurence> occurencesListNonValable 
			= regexNonValable.trouverOccurences();
		final List<IOccurence> occurencesListNonValableNu 
			= regexNonValableNu.trouverOccurences();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'UN MOTIF NON VALABLE --------------------");
			System.out.println(TEXTE + chaineValable);
			System.out.println(MOTIF + motifNonValable);
			System.out.println();
			System.out.println(CONTIENT_MOTIF + regexNonValable.texteContientMotif());
			System.out.println(CONTIENT_MOTIF + regexNonValableNu.texteContientMotif());
			System.out.println(LISTE_OCCURENCES_VIDE + occurencesListNonValable.isEmpty());
			System.out.println(LISTE_OCCURENCES_VIDE + occurencesListNonValableNu.isEmpty());
			System.out.println(LISTE_OCCURENCES + regexNonValable.afficherListOccurences(occurencesListNonValable));
			System.out.println(LISTE_OCCURENCES + regexNonValableNu.afficherListOccurences(occurencesListNonValable));
		}

		/* garantit que trouverOccurences() 
		 * retourne une liste vide mais non null. */
		assertNotNull(
				LISTE_OCCURENCES_PAS_NULL
					, occurencesListNonValable);
		
		/* garantit que trouverOccurences() 
		 * retourne une liste vide.*/
		assertTrue(
				"la liste d'occurences doit être vide : "
					, occurencesListNonValable.isEmpty());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'UN MOTIF VALABLE ---------------------------------");
			System.out.println(TEXTE + chaineValable);
			System.out.println(MOTIF + motifValable);
			System.out.println();
			System.out.println(CONTIENT_MOTIF + regexValable.texteContientMotif());
			System.out.println(CONTIENT_MOTIF + regexValableNu.texteContientMotif());
			System.out.println(LISTE_OCCURENCES_VIDE + occurencesListValable.isEmpty());
			System.out.println(LISTE_OCCURENCES_VIDE + occurencesListValableNu.isEmpty());
			System.out.println(LISTE_OCCURENCES + regexValable.afficherListOccurences(occurencesListValable));
			System.out.println(LISTE_OCCURENCES + regexValableNu.afficherListOccurences(occurencesListValableNu));
		}
		
		/* garantit que trouverOccurences(motif existant) 
		 * retourne une liste non null. */
		assertNotNull(
				LISTE_OCCURENCES_PAS_NULL
					, occurencesListValable);
		
		assertNotNull(
				LISTE_OCCURENCES_PAS_NULL
					, occurencesListValableNu);
		
		/* garantit que trouverOccurences() 
		 * retourne une liste non vide.*/
		assertFalse(
				"la liste d'occurences ne doit pas être vide : "
					, occurencesListValable.isEmpty());
		
		assertFalse(
				"la liste d'occurences ne doit pas être vide : "
					, occurencesListValableNu.isEmpty());
		
		/* garantit que le constructeur complet et le constructeur d'arité nulle avec Setters ont le même comportement. */
		assertEquals(
				CONSTRUCTEUR_SIMILAIRES
				, regexValable.getListeOccurencesMotif()
					, regexValableNu.getListeOccurencesMotif());
		
		assertEquals(
				CONSTRUCTEUR_SIMILAIRES
				, regexNonValable.getListeOccurencesMotif()
					, regexNonValableNu.getListeOccurencesMotif());

	} // Fin de testTrouverOccurencesNu()._________________________________
	

	
	/**
	 * Teste la méthode trouverOccurences(...).<br/>
	 * <ul>
	 * <li>garantit que trouverOccurences(texte, motifNonValable) 
	 * retourne une liste vide mais non null.</li>
	 * <li>garantit que trouverOccurences(texte, motifNonValable) 
	 * retourne une liste vide.</li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTrouverOccurences() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE RegexTest - méthode testTrouverOccurences() ********** ");
		}
		
		// **********************************
		final String motifValable = "avec";
		final String motifNonValable = "toto";
		
		final String chaineValable = "avec le temps et avec l'argent tout s'en va\nles roses aavec leur pétales m'ennuient";
		// **********************************

		/* Instanciation d'un Regex. */
		final IRegex regex = new Regex();
		
		final List<IOccurence> occurencesListValable 
			= regex.trouverOccurences(chaineValable, motifValable);
		
		final List<IOccurence> occurencesListNonValable 
			= regex.trouverOccurences(chaineValable, motifNonValable);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'UN MOTIF NON VALABLE --------------------");
			System.out.println(TEXTE + chaineValable);
			System.out.println(MOTIF + motifNonValable);
			System.out.println();
			System.out.println(CONTIENT_MOTIF + regex.texteContientMotif(chaineValable, motifNonValable));
			System.out.println(LISTE_OCCURENCES_VIDE + occurencesListNonValable.isEmpty());
			System.out.println(LISTE_OCCURENCES + regex.afficherListOccurences(occurencesListNonValable));
		}

		/* garantit que trouverOccurences(texte, motifNonValable) 
		 * retourne une liste vide mais non null. */
		assertNotNull(
				LISTE_OCCURENCES_PAS_NULL
					, occurencesListNonValable);
		
		/* garantit que trouverOccurences(texte, motifNonValable) 
		 * retourne une liste vide.*/
		assertTrue(
				"la liste d'occurences doit être vide : "
					, occurencesListNonValable.isEmpty());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'UN MOTIF VALABLE ---------------------------------");
			System.out.println(TEXTE + chaineValable);
			System.out.println(MOTIF + motifValable);
			System.out.println();
			System.out.println(CONTIENT_MOTIF + regex.texteContientMotif(chaineValable, motifValable));
			System.out.println(LISTE_OCCURENCES_VIDE + occurencesListValable.isEmpty());
			System.out.println(LISTE_OCCURENCES + regex.afficherListOccurences(occurencesListValable));
		}
		
	} // Fin de testTrouverOccurences().___________________________________
	

	
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
			System.out.println();
			System.out.println("********** CLASSE RegexTest - méthode testTexteCorrespondEntierementAMotif()() ********** ");
		}


		// **********************************
		final String texteValable = "123 abrouve les sillons de mon 33 tours";
		final String texteNonValable = "abrouve les sillons de mon 33 tours";
		final String motif = "^\\d+.*$";
		
		// **********************************
		
		/* Instanciation d'un Regex. */
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
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE RegexTest - méthode testTexteCorrespondEntierementAMotif2() ********** ");
		}


		// **********************************
		final String texte = "Quand le ciel bas et lourd";
		final String motifTest = "Quand.*";
		final String texteValable = "123 abrouve les sillons de mon 33 tours";
		final String texteNonValable = "abrouve les sillons de mon 33 tours";
		final String motif = "^\\d+.*$";
		
		// **********************************
		
		/* Instanciation d'un Regex. */
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

	
	
} // FIN DE LA CLASSE RegexTest.---------------------------------------------
