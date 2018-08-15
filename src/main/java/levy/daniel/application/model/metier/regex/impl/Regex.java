package levy.daniel.application.model.metier.regex.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IRegex;


/**
 * CLASSE <b>Regex</b> :<br/>
 * .<br/>
 * <br/>
 * <ul>
 * <li>la méthode <code>expliquerMotif(String pMotif)</code> 
 * permet de savoir si un Pattern Regex est conforme 
 * à la syntaxe des Regex.</li>
 * </ul>
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
	 * boolean qui détermine si <code>this.motifJava</code> 
	 * respecte la syntaxe des expressions régulières (RegEx).<br/>
	 */
	private transient boolean motifJavaRespecteSyntaxe;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Regex.class);
	
	
	// *************************METHODES************************************/

	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public Regex() {
		this(null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>alimente <code>this.motifJavaRespecteSyntaxe</code> à true 
	 * si <code>this.motifJava</code> respecte la syntaxe 
	 * des RegEx Java.</li>
	 * </ul>
	 *
	 * @param pChaineATester : String : 
	 * chaine de caractères dont on veut savoir 
	 * si elle contient ou matche le motif 
	 * de l'expression régulière.<br/>
	 * @param pMotifJava : String : 
	 * Motif de l'expression régulière applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre. 
	 */
	public Regex(
			final String pChaineATester
				, final String pMotifJava) {
		
		super();
		
		this.chaineATester = pChaineATester;
		this.motifJava = pMotifJava;
		
		/* alimente this.motifJavaRespecteSyntaxe à true si 
		 * this.motifJava respecte la syntaxe des RegEx Java. */
		this.determinerSiMotifConforme();
		
	} // Fin du  CONSTRUCTEUR COMPLET._____________________________________
	

	
	/**
	 * Détermine si <code>this.motifJava</code> respecte la syntaxe 
	 * des expressions régulières Java (RegEx).<br/>
	 * <ul>
	 * <li>alimente le boolean 
	 * <code>this.motifJavaRespecteSyntaxe</code>.</li>
	 * <li>passe <code>this.motifJavaRespecteSyntaxe</code> 
	 * à true si <code>this.motifJava</code> respecte 
	 * la syntaxe RegEx Java.</li>
	 * </ul>
	 *  - ne fait rien si <code>this.motifJava</code> est null.<br/>
	 *  <br/>
	 */
	private void determinerSiMotifConforme() {
		
		/* ne fait rien si this.motifJava est null. */
		if (!StringUtils.isBlank(this.motifJava)) {
			
			/* alimente this.motifJavaRespecteSyntaxe. */
			this.motifJavaRespecteSyntaxe 
				= this.motifRespecteSyntaxeRegex(this.motifJava);
		}
		
	} // Fin de determinerSiMotifConforme()._______________________________
	

	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pTexte
	 * @param pMotif
	 * 
	 * @return List&lt;Occurence&gt; : 
	 * 
	 * @throws Exception
	 */
	public List<Occurence> trouverOccurences(
			final String pTexte, final String pMotif) throws Exception {
		
		/* return null si pTexte est blank. */
		if (StringUtils.isBlank(pTexte)) {
			return null;
		}
		
		/* return null si pMotif est blank. */
		if (StringUtils.isBlank(pMotif)) {
			return null;
		}
		
		final Pattern pattern = Pattern.compile(pMotif);
		final Matcher matcher = pattern.matcher(pTexte);
		
		int i = 0;
		
		final List<Occurence> resultat = new LinkedList<Occurence>();
		
		while (matcher.find()) {
			
			i++;
			
			final String trouve = matcher.group();
			System.out.println("occurence trouvée (" + i + ") : " + trouve);
			
			final int positionDebut = matcher.start();
			System.out.println("position de début (0-based) de l'occurence(" + i + ") : " + positionDebut);
			
			final int positionFin = matcher.end();
			System.out.println("position de fin (0-based) de l'occurence(" + i + ") : " + positionFin);
			
			final Occurence occurence = new Occurence(i, trouve, positionDebut, positionFin);
			
			resultat.add(occurence);
		}
		
		return resultat;

	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean motifRespecteSyntaxeRegex(
			final String pMotif) {
		
		/* retourne false si pMotif est blank. */
		if (StringUtils.isBlank(pMotif)) {
			return false;
		}
		
		boolean resultat = false;
		
		try {
			
			Pattern.compile(pMotif);
			
			resultat = true;
			
		} catch (PatternSyntaxException e) {
			
			resultat = false;
		}
		
		return resultat;
		
	} // Fin de motifRespecteSyntaxeRegex(...).____________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean texteCommenceParMotif() throws Exception {
		
		return this.texteCommenceParMotif(
				this.chaineATester, this.motifJava);
		
	} // Fin de texteCommenceParMotif().___________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean texteCommenceParMotif(
			final String pTexte
				, final String pMotif) 
						throws Exception {
		
		/* return false si pTexte est blank. */
		if (StringUtils.isBlank(pTexte)) {
			return false;
		}
		
		/* return false si pMotif est blank. */
		if (StringUtils.isBlank(pMotif)) {
			return false;
		}
		
		boolean resultat = false;
		
		final Pattern pattern = Pattern.compile(pMotif);
		final Matcher matcher = pattern.matcher(pTexte);
		
		resultat = matcher.lookingAt();
		
		return resultat;
		
	} // Fin de texteCommenceParMotif(...).________________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean texteContientMotif() throws Exception {
		
		return this.texteContientMotif(
				this.chaineATester, this.motifJava);
		
	} // Fin de texteContientMotif(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean texteContientMotif(
			final String pTexte
				, final String pMotif) 
						throws Exception {
		
		/* return false si pTexte est blank. */
		if (StringUtils.isBlank(pTexte)) {
			return false;
		}
		
		/* return false si pMotif est blank. */
		if (StringUtils.isBlank(pMotif)) {
			return false;
		}
		
		boolean resultat = false;
		
		final Pattern pattern = Pattern.compile(pMotif);
		final Matcher matcher = pattern.matcher(pTexte);

		resultat = matcher.find();
		
		return resultat;
		
	} // Fin de texteContientMotif(...).___________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean texteCorrespondEntierementAMotif() 
			throws Exception {
		return this.texteCorrespondEntierementAMotif(
				this.chaineATester, this.motifJava);
	} // Fin de texteCorrespondEntierementAMotif().________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean texteCorrespondEntierementAMotif(
			final String pTexte
				, final String pMotif) 
							throws Exception {
		
		/* retourne false si pTexte est blank. */
		if (StringUtils.isBlank(pTexte)) {
			return false;
		}
		
		/* retourne false si pMotif est blank. */
		if (StringUtils.isBlank(pMotif)) {
			return false;
		}
		
		boolean resultat = false;
		
		resultat = Pattern.matches(pMotif, pTexte);
		
		return resultat;
		
	} // Fin de texteCorrespondEntierementAMotif(...)._____________________
	

			
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getChaineATester() {
		return this.chaineATester;
	} // Fin de getChaineATester().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setChaineATester(
			final String pChaineATester) {
		this.chaineATester = pChaineATester;
	} // Fin de setChaineATester(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMotifJava() {
		return this.motifJava;
	} // Fin de getMotifJava().____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMotifJava(
			final String pMotifJava) {
		
		if (!StringUtils.equals(pMotifJava, this.motifJava)) {
			
			this.motifJava = pMotifJava;
			
			/* alimente this.motifJavaRespecteSyntaxe à true si 
			 * this.motifJava respecte la syntaxe des RegEx Java. */
			this.determinerSiMotifConforme();
			
		}
				
	} // Fin de setMotifJava(...)._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMotifJavaScript() {
		return this.motifJavaScript;
	} // Fin de getMotifJavaScript().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSignificationMotif() {
		return this.significationMotif;
	} // Fin de getSignificationMotif().___________________________________
	
		
	
} // FIN DE LA CLASSE Regex.-------------------------------------------------
