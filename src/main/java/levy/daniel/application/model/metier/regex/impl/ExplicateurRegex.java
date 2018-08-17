package levy.daniel.application.model.metier.regex.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * CLASSE <b>ExplicateurRegex</b> :<br/>
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
 * @since 14 août 2018
 *
 */
public class ExplicateurRegex {
	
	
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
	 * Signification du motif de l'expression régulière.<br/>
	 * Par exemple : 
	 */
	private transient String significationMotif;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ExplicateurRegex.class);
	
	
	// *************************METHODES************************************/

	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pMotif
	 * @param pI
	 * @return :  :  .<br/>
	 */
	public String extraireSousMotif(String pMotif, int pI) {
		
		String resultat = null;
		
		if (pI == 0) {
			resultat = pMotif;
		} else {
			
			if (pI == 1) {
				
				final String motifRegGroupeComplet = "^(\\^{0,1})(\\({1})(\\(.*\\)*)(\\){1})(\\${0,1})$";
				final Pattern pattern = Pattern.compile(motifRegGroupeComplet);
				final Matcher matcher = pattern.matcher(pMotif);
				
				if (matcher.matches()) {
					System.out.println("MATCHE");
					resultat = pMotif;
				} else {
					System.out.println("NE MATCHE PAS");
				}
				
				
			} else {
				System.out.println("i supérieur à 1");
			}
			
		}
		
		return resultat;
	}
	
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pMotif
	 * @return : String :  .<br/>
	 */
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
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return significationMotif : String.<br/>
	 */
	public String getSignificationMotif() {
		return this.significationMotif;
	} // Fin de getSignificationMotif().___________________________________
	
		


} // FIN DE LA CLASSE ExplicateurRegex.--------------------------------------
