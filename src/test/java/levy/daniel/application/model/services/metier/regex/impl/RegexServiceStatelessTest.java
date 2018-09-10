package levy.daniel.application.model.services.metier.regex.impl;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.dto.regexdto.IRegexRequestDto;
import levy.daniel.application.model.dto.regexdto.IRegexResponseDto;
import levy.daniel.application.model.dto.regexdto.impl.RegexRequestDto;
import levy.daniel.application.model.services.metier.regex.IRegexServiceStateless;


/**
 * CLASSE RegexServiceStatelessTest :<br/>
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
 * @since 24 août 2018
 *
 */
public class RegexServiceStatelessTest {
	
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
	 * "Texte : ".<br/>
	 */
	public static final String TEXTE = "Texte : ";
	
	/**
	 * "Le Texte '".<br/>
	 */
	public static final String LE_TEXTE = "Le Texte '";
	
	/**
	 * "Motif Regex : ".<br/>
	 */
	public static final String MOTIF = "Motif Regex : ";
	
	/**
	 * "Le motif '".<br/>
	 */
	public static final String LE_MOTIF = "Le motif '";
	
	/**
	 * "' respecte-t-il la syntaxe Regex ? : ".<br/>
	 */
	public static final String RESPECTE_SYNTAXE_REGEX 
		= "' respecte-t-il la syntaxe Regex ? : ";

	/**
	 * "' ? : ".<br/>
	 */
	public static final String INTERROGATION = "' ? : ";
	
	/**
	 * "' commence-t-il par le motif '".<br/>
	 */
	public static final String COMMENCE_PAR_MOTIF 
		= "' commence-t-il par le motif '";
	
	/**
	 * "' contient-il le motif '".<br/>
	 */
	public static final String CONTIENT_MOTIF 
		= "' contient-il le motif '";
	
	/**
	 * "' matche-t-il entièrement avec le motif '".<br/>
	 */
	public static final String MATCHE_MOTIF 
		= "' matche-t-il entièrement avec le motif '";
	
	/**
	 * "liste des occurences du motif : \n".<br/>
	 */
	public static final String LISTE_OCCURENCES 
		= "liste des occurences du motif : \n";
	
	/**
	 * "liste des occurences des groupes capturants du motif : \n".<br/>
	 */
	public static final String LISTE_GROUPES 
		= "liste des occurences des groupes capturants du motif : \n";

	/**
	 * "la liste d'occurences est-elle vide ? : ".<br/>
	 */
	public static final String LISTE_OCCURENCES_VIDE 
		= "la liste d'occurences est-elle vide ? : ";
	
	/**
	 * "la liste d'occurences ne doit pas être null : ".<br/>
	 */
	public static final String LISTE_OCCURENCES_PAS_NULL 
		= "la liste d'occurences ne doit pas être null : ";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(RegexServiceStatelessTest.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public RegexServiceStatelessTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * teste le fonctionnement global d'un Regex.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFonctionnementSetters() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE RegexServiceStatelessTest - méthode testFonctionnementSetters() ********** ");
		}
		
		final IRegexServiceStateless service = new RegexServiceStateless();
		
		/* *********************************************************** */
		final String texte = "27 ans et 23 piges d'âge mental !";
		final String motif = "(\\d{1,3} \\D*)+?";
		/* *********************************************************** */
		
		final IRegexRequestDto requestDto 
			= new RegexRequestDto(texte, motif);
		
		final IRegexResponseDto responseDto 
			= service.soumettre(requestDto);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("REQUETE : \n" + requestDto.afficherLigneParLigne());
			System.out.println();
			System.out.println("REPONSE : \n" + responseDto.afficherLigneParLigne());
		}
		
		assertNotNull(
				"la requête ne doit pas être null : "
					, requestDto);
		
		assertNotNull(
				"la réponse ne doit pas être null : "
					, responseDto);
		
	} // Fin de testFonctionnementSetters()._______________________________
	
	

} // FIN DE LA CLASSE RegexServiceStatelessTest.-----------------------------
