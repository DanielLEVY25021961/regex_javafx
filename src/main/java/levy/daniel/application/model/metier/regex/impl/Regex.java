package levy.daniel.application.model.metier.regex.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IRegex;


/**
 * CLASSE Regex :<br/>
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
 * @since 6 août 2018
 *
 */
public class Regex implements IRegex {
	// ************************ATTRIBUTS************************************/

	/**
	 * Map&lt;String, String&gt; des méta-caractères 
	 * de positionnement (ancrages).<br/>
	 * <ul>
	 * <li>String : méta-caractère de positionnement (ancrage).</li>
	 * <li>String : signification de l'ancrage.</li>
	 * </ul>
	 * Par exemple : $ en fin de motif signifie "fin de chaîne".
	 */
	private static Map<String, String> ancragesMap 
		= new ConcurrentHashMap<String, String>();
	
	
	
	static {
		ancragesMap.put("¨", "début de chaîne");
		ancragesMap.put("$", "fin de chaîne");
	}
	
	/**
	 * chaine de caractères dont on veut savoir 
	 * si elle contient ou matche le motif 
	 * de l'expression régulière.<br/>
	 */
	private String chaineATester;
	
	/**
	 * Motif de l'expression régulière applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre. 
	 */
	private String motifJava;
	
	/**
	 * Motif de l'expression régulière applicable en JavaScript.<br/>
	 * Par exemple : 
	 */
	private transient String motifJavaScript;
	
	/**
	 * Signification du motif de l'expression régulière.<br/>
	 * Par exemple : 
	 */
	private transient String significationMotif;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Regex.class);
	
	// *************************METHODES************************************/
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean motifFind(
			final String pString) {
		
		boolean resultat = false;
		
		final Pattern pattern = Pattern.compile(this.motifJava);
		
		final Matcher matcher = pattern.matcher(pString);
		
		if (matcher.find()) {
			resultat = true;
		}
		
		return resultat;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean motifMatche(
			final String pString) {
		
		boolean resultat = false;
		
		final Pattern pattern = Pattern.compile(this.motifJava);
		
		final Matcher matcher = pattern.matcher(pString);
		
		if (matcher.matches()) {
			resultat = true;
		}
		
		return resultat;
	}


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getChaineATester() {
		return this.chaineATester;
	} // Fin de getChaineATester().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setChaineATester(
			final String pChaineATester) {
		this.chaineATester = pChaineATester;
	} // Fin de setChaineATester(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMotifJava() {
		return this.motifJava;
	} // Fin de getMotifJava().____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMotifJava(
			final String pMotifJava) {
		this.motifJava = pMotifJava;
	} // Fin de setMotifJava(...)._________________________________________



	
	/**
	 * Getter de la Map&lt;String, String&gt; des méta-caractères 
	 * de positionnement (ancrages).<br/>
	 * <ul>
	 * <li>String : méta-caractère de positionnement (ancrage).</li>
	 * <li>String : signification de l'ancrage.</li>
	 * </ul>
	 * Par exemple : $ en fin de motif signifie "fin de chaîne".
	 *
	 * @return ancragesMap : Map&lt;String, String&gt;.<br/>
	 */
	public static Map<String, String> getAncragesMap() {
		return ancragesMap;
	} // Fin de getAncragesMap().__________________________________________



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMotifJavaScript() {
		return this.motifJavaScript;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSignificationMotif() {
		return this.significationMotif;
	}
	
	
	
	
	
} // FIN DE LA CLASSE Regex.-------------------------------------------------
