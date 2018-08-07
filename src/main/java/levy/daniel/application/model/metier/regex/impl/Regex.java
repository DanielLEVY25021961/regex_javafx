package levy.daniel.application.model.metier.regex.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
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
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE 
		= System.getProperty("line.separator");
	
	/**
	 * Map&lt;String, String&gt; des méta-caractères 
	 * (symboles remplaçant d'autres caractères).<br/>
	 * <ul>
	 * <li>String : méta-caractère.</li>
	 * <li>String : signification du méta-caractère.</li>
	 * </ul>
	 * Par exemple : . signifie "n'importe quel caractère".<br/>
	 * <br/>
	 */
	private static Map<String, String> metaCaracteresMap 
		= new ConcurrentHashMap<String, String>();
	
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
	
	
	/**
	 * Map&lt;String, String&gt; des caractères 
	 * opérateurs (ou, ...).<br/>
	 * <ul>
	 * <li>String : opérateur.</li>
	 * <li>String : signification de l'opérateur.</li>
	 * </ul>
	 * Par exemple : | entre 2 motifs signifie "un motif ou l'autre".
	 */
	private static Map<String, String> operateursMap 
		= new ConcurrentHashMap<String, String>();
	
	static {
		
		metaCaracteresMap.put(".", "tout caractère");
		metaCaracteresMap.put("*", "toute chaine de caractères");
		
		ancragesMap.put("¨", "début de chaîne");
		ancragesMap.put("$", "fin de chaîne");
		
		operateursMap.put("|", "ou");
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
	public String expliquerMotif(
			final String pMotif) {
		
		/* return null si pMotif est blank. */
		if (StringUtils.isBlank(pMotif)) {
			return null;
		}
		
		String resultat = null;
		
		final StringBuilder stb = new StringBuilder();
		
		System.out.println("MOTIF : " + pMotif);
		
//		final String motifRegex = "^(\\^?)(.*)$";
		final String motifRegex = "^(\\^?)(\\[0-9\\]|.*)(\\+?)$";
		
		final Pattern pattern = Pattern.compile(motifRegex);
		
		final Matcher matcher = pattern.matcher(pMotif);
		
		final boolean caColle = matcher.matches();
		
		if (caColle) {
			
			for (int j = 0; j <= matcher.groupCount(); j++) {
				System.out.println("Groupe (" + j + ") = " + matcher.group(j));
				System.out.println("Le texte \"" + matcher.group(j) + "\" débute à " + matcher.start(j) + " et se termine à " + matcher.end(j));
			}
			
			if (StringUtils.isNotBlank(matcher.group(1))) {
				stb.append("^ au début du motif signifie : ");
				stb.append("commence par");
				stb.append(NEWLINE);
			}
					
		}
		
		resultat = stb.toString();
		
		this.significationMotif = resultat;
		
		return resultat;
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean motifFind(
			final String pString) {
		
		/* return false si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return false;
		}
		
		boolean resultat = false;
		
		final Pattern pattern = Pattern.compile(this.motifJava);
		
		final Matcher matcher = pattern.matcher(pString);
		
		if (matcher.find()) {
			resultat = true;
		}
		
		return resultat;
		
	} // Fin de motifFind(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean motifMatche(
			final String pString) {
		
		/* return false si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return false;
		}
		
		boolean resultat = false;
		
		final Pattern pattern = Pattern.compile(this.motifJava);
		
		final Matcher matcher = pattern.matcher(pString);
		
		if (matcher.matches()) {
			resultat = true;
		}
		
		return resultat;
		
	} // Fin de motifMatche(...).__________________________________________


		
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
		
		if (!StringUtils.equals(pMotifJava, this.motifJava)) {
			
			this.motifJava = pMotifJava;
			
			this.expliquerMotif(this.motifJava);
		}
				
	} // Fin de setMotifJava(...)._________________________________________


	
	/**
	 * Getter de la Map&lt;String, String&gt; des méta-caractères 
	 * (symboles remplaçant d'autres caractères).<br/>
	 * <ul>
	 * <li>String : méta-caractère.</li>
	 * <li>String : signification du méta-caractère.</li>
	 * </ul>
	 * Par exemple : . signifie "n'importe quel caractère".<br/>
	 * <br/>
	 *
	 * @return metaCaracteresMap : Map&lt;String, String&gt;.<br/>
	 */
	public static Map<String, String> getMetaCaracteresMap() {
		return metaCaracteresMap;
	} // Fin de getMetaCaracteresMap().____________________________________



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
	 * Getter de la Map&lt;String, String&gt; des caractères 
	 * opérateurs (ou, ...).<br/>
	 * <ul>
	 * <li>String : opérateur.</li>
	 * <li>String : signification de l'opérateur.</li>
	 * </ul>
	 * Par exemple : | entre 2 motifs signifie "un motif ou l'autre".<br/>
	 * <br/>
	 *
	 * @return operateursMap : Map&lt;String, String&gt;.<br/>
	 */
	public static Map<String, String> getOperateursMap() {
		return operateursMap;
	} // Fin de getOperateursMap().________________________________________



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
