package levy.daniel.application.model.dto.regexdto.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.regexdto.IRegexResponseDto;
import levy.daniel.application.model.metier.regex.IOccurence;
import levy.daniel.application.model.metier.regex.impl.Regex;


/**
 * CLASSE RegexResponseDto :<br/>
 * DTO pour les réponses relatives à {@link Regex}.<br/>
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
public class RegexResponseDto implements IRegexResponseDto {
	
	// ************************ATTRIBUTS************************************/


	/**
	 * chaine de caractères (éventuellement multi-lignes) 
	 * dont on veut savoir si elle contient ou matche le motif 
	 * RegEx Java de l'expression régulière.<br/>
	 */
	private String texte;
	
	/**
	 * Motif de l'expression régulière applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre.<br/> 
	 */
	private String motifJava;
	
	/**
	 * Motif de l'expression régulière applicable en JavaScript.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * Par exemple : '/ \d /'.<br/> 
	 */
	private String motifJavaScript;
	
	/**
	 * Signification du motif de l'expression régulière.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * Par exemple : 'commence par 2 chiffres...'<br/>
	 */
	private String significationMotif;
	
	/**
	 * boolean qui stipule si <code>this.motifJava</code> 
	 * <b>respecte la syntaxe</b> des expressions régulières 
	 * (RegEx) Java.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 */
	private boolean motifJavaRespecteSyntaxe;
	
	/**
	 * boolean qui stipule si <code>this.texte</code> 
	 * <b>commence</b> par <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 */
	private boolean texteCommenceParMotif;
	
	/**
	 * boolean qui stipule si <code>this.texte</code> 
	 * <b>contient</b> <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 */
	private boolean texteContientMotif;
	
	/**
	 * Liste des occurences de <code>this.motifJava</code> 
	 * dans <code>this.texte</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 */
	private List<IOccurence> listeOccurencesMotif;
	
	/**
	 * boolean qui stipule si <code>this.texte</code> 
	 * <b>matche entièrement</b> avec <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 */
	private boolean texteMatcheMotif;
	
	/**
	 * Liste des occurences des <b>sous-groupes capturant</b> de 
	 * <code>this.motifJava</code> 
	 * dans <code>this.texte</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 */
	private List<IOccurence> listeOccurencesGroupesCapturant;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(RegexResponseDto.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public RegexResponseDto() {
		this(null, null
				, null, null, false, false, false, null, false, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pTexte : String : 
	 * chaine de caractères (éventuellement multi-lignes) 
	 * dont on veut savoir si elle contient ou matche le motif 
	 * RegEx Java de l'expression régulière.<br/>
	 * @param pMotifJava : String : 
	 * Motif de l'expression régulière applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre.<br/> 
	 * @param pMotifJavaScript : String : 
	 * Motif de l'expression régulière applicable en JavaScript.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * Par exemple : '/ \d /'.<br/> 
	 * @param pSignificationMotif : String : 
	 * Signification du motif de l'expression régulière.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * Par exemple : 'commence par 2 chiffres...'<br/>
	 * @param pMotifJavaRespecteSyntaxe boolean : 
	 * boolean qui stipule si <code>this.motifJava</code> 
	 * <b>respecte la syntaxe</b> des expressions régulières 
	 * (RegEx) Java.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * @param pTexteCommenceParMotif : boolean : 
	 * boolean qui stipule si <code>this.texte</code> 
	 * <b>commence</b> par <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * @param pTexteContientMotif : boolean : 
	 * boolean qui stipule si <code>this.texte</code> 
	 * <b>contient</b> <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * @param pListeOccurencesMotif : List&lt;IOccurence&gt; : 
	 * Liste des occurences de <code>this.motifJava</code> 
	 * dans <code>this.texte</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * @param pTexteMatcheMotif : boolean : 
	 * boolean qui stipule si <code>this.texte</code> 
	 * <b>matche entièrement</b> avec <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * @param pListeOccurencesGroupesCapturant : List&lt;IOccurence&gt; : 
	 * Liste des occurences des <b>sous-groupes capturant</b> de 
	 * <code>this.motifJava</code> 
	 * dans <code>this.texte</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 */
	public RegexResponseDto(
			final String pTexte, 
			final String pMotifJava, 
			final String pMotifJavaScript, 
			final String pSignificationMotif,
			final boolean pMotifJavaRespecteSyntaxe, 
			final boolean pTexteCommenceParMotif, 
			final boolean pTexteContientMotif,
			final List<IOccurence> pListeOccurencesMotif, 
			final boolean pTexteMatcheMotif,
			final List<IOccurence> pListeOccurencesGroupesCapturant) {
		
		super();
		
		this.texte = pTexte;
		this.motifJava = pMotifJava;
		this.motifJavaScript = pMotifJavaScript;
		this.significationMotif = pSignificationMotif;
		this.motifJavaRespecteSyntaxe = pMotifJavaRespecteSyntaxe;
		this.texteCommenceParMotif = pTexteCommenceParMotif;
		this.texteContientMotif = pTexteContientMotif;
		this.listeOccurencesMotif = pListeOccurencesMotif;
		this.texteMatcheMotif = pTexteMatcheMotif;
		this.listeOccurencesGroupesCapturant 
			= pListeOccurencesGroupesCapturant;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("RegexResponseDto [");
		
		/* texte. */
		if (this.texte != null) {
			builder.append(TEXTE);
			builder.append(this.texte);
		} else {
			builder.append(TEXTE);
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* motifJava. */
		if (this.motifJava != null) {
			builder.append(MOTIFJAVA);
			builder.append(this.motifJava);			
		} else {
			builder.append(MOTIFJAVA);
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* motifJavaScript. */
		if (this.motifJavaScript != null) {
			builder.append(MOTIFJAVASCRIPT);
			builder.append(this.motifJavaScript);			
		} else {
			builder.append(MOTIFJAVASCRIPT);
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* significationMotif. */
		if (this.significationMotif != null) {
			builder.append(SIGNIFICATIONMOTIF);
			builder.append(this.significationMotif);			
		} else {
			builder.append(SIGNIFICATIONMOTIF);
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* motifJavaRespecteSyntaxe. */
		builder.append(MOTIFJAVARESPECTESYNTAXE);
		builder.append(this.motifJavaRespecteSyntaxe);
		
		/* texteCommenceParMotif. */
		builder.append(", texteCommenceParMotif=");
		builder.append(this.texteCommenceParMotif);
		
		/* texteContientMotif. */
		builder.append(", texteContientMotif=");
		builder.append(this.texteContientMotif);
		builder.append(VIRGULE);
		
		/* listeOccurencesMotif. */
		if (this.listeOccurencesMotif != null) {
			builder.append(LISTEOCCURENCESMOTIF);
			builder.append(this.listeOccurencesMotif);
			
		} else {
			builder.append(LISTEOCCURENCESMOTIF);
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* texteMatcheMotif. */
		builder.append(TEXTEMATCHEMOTIF);
		builder.append(this.texteMatcheMotif);
		builder.append(VIRGULE);
		
		/* listeOccurencesGroupesCapturant. */
		if (this.listeOccurencesGroupesCapturant != null) {
			builder.append(LISTEOCCURENCESGROUPESCAPTURANT);
			builder.append(this.listeOccurencesGroupesCapturant);
		} else {
			builder.append(LISTEOCCURENCESGROUPESCAPTURANT);
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherLigneParLigne() {
				
		final StringBuilder builder = new StringBuilder();
				
		/* texte. */
		if (this.texte != null) {
			builder.append(TEXTE);
			builder.append(this.texte);
		} else {
			builder.append(TEXTE);
			builder.append(NULL);
		}
		builder.append(NEWLINE);
		
		/* motifJava. */
		if (this.motifJava != null) {
			builder.append(MOTIFJAVA);
			builder.append(this.motifJava);			
		} else {
			builder.append(MOTIFJAVA);
			builder.append(NULL);
		}
		builder.append(NEWLINE);
		
		/* motifJavaScript. */
		if (this.motifJavaScript != null) {
			builder.append(MOTIFJAVASCRIPT);
			builder.append(this.motifJavaScript);			
		} else {
			builder.append(MOTIFJAVASCRIPT);
			builder.append(NULL);
		}
		builder.append(NEWLINE);
		
		/* significationMotif. */
		if (this.significationMotif != null) {
			builder.append(SIGNIFICATIONMOTIF);
			builder.append(this.significationMotif);			
		} else {
			builder.append(SIGNIFICATIONMOTIF);
			builder.append(NULL);
		}
		builder.append(NEWLINE);
		
		/* motifJavaRespecteSyntaxe. */
		builder.append(MOTIFJAVARESPECTESYNTAXE);
		builder.append(this.motifJavaRespecteSyntaxe);
		builder.append(NEWLINE);
		
		/* texteCommenceParMotif. */
		builder.append(TEXTECOMMENCEPARMOTIF);
		builder.append(this.texteCommenceParMotif);
		builder.append(NEWLINE);
		
		/* texteContientMotif. */
		builder.append(TEXTECONTIENTMOTIF);
		builder.append(this.texteContientMotif);
		builder.append(NEWLINE);
		
		/* listeOccurencesMotif. */
		if (this.listeOccurencesMotif != null) {
			builder.append(LISTEOCCURENCESMOTIF);
			builder.append(this.listeOccurencesMotif);
			
		} else {
			builder.append(LISTEOCCURENCESMOTIF);
			builder.append(NULL);
		}
		builder.append(NEWLINE);
		
		/* texteMatcheMotif. */
		builder.append(TEXTEMATCHEMOTIF);
		builder.append(this.texteMatcheMotif);
		builder.append(NEWLINE);
		
		/* listeOccurencesGroupesCapturant. */
		if (this.listeOccurencesGroupesCapturant != null) {
			builder.append(LISTEOCCURENCESGROUPESCAPTURANT);
			builder.append(this.listeOccurencesGroupesCapturant);
		} else {
			builder.append(LISTEOCCURENCESGROUPESCAPTURANT);
			builder.append(NULL);
		}
		
		return builder.toString();
		
	} // Fin de afficherLigneParLigne().___________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTexte() {
		return this.texte;
	} // Fin de getTexte().________________________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTexte(
			final String pTexte) {
		this.texte = pTexte;
	} // Fin de setTexte(...)._____________________________________________
	

	
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
	 * {@inheritDoc}
	 */
	@Override
	public String getMotifJavaScript() {
		return this.motifJavaScript;
	} // Fin de getMotifJavaScript().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMotifJavaScript(
			final String pMotifJavaScript) {
		this.motifJavaScript = pMotifJavaScript;
	} // Fin de setMotifJavaScript(...).___________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSignificationMotif() {
		return this.significationMotif;
	} // Fin de getSignificationMotif().___________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSignificationMotif(
			final String pSignificationMotif) {
		this.significationMotif = pSignificationMotif;
	} // Fin de setSignificationMotif(...).________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isMotifJavaRespecteSyntaxe() {
		return this.motifJavaRespecteSyntaxe;
	} // Fin de isMotifJavaRespecteSyntaxe().______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMotifJavaRespecteSyntaxe(
			final boolean pMotifJavaRespecteSyntaxe) {
		this.motifJavaRespecteSyntaxe = pMotifJavaRespecteSyntaxe;
	} // Fin de setMotifJavaRespecteSyntaxe(...).__________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTexteCommenceParMotif() {
		return this.texteCommenceParMotif;
	} // Fin de isTexteCommenceParMotif()._________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTexteCommenceParMotif(
			final boolean pTexteCommenceParMotif) {
		this.texteCommenceParMotif = pTexteCommenceParMotif;
	} // Fin de setTexteCommenceParMotif(...)._____________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTexteContientMotif() {
		return this.texteContientMotif;
	} // Fin de isTexteContientMotif().____________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTexteContientMotif(
			final boolean pTexteContientMotif) {
		this.texteContientMotif = pTexteContientMotif;
	} // Fin de setTexteContientMotif(...).________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IOccurence> getListeOccurencesMotif() {
		return this.listeOccurencesMotif;
	} // Fin de getListeOccurencesMotif()._________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setListeOccurencesMotif(
			final List<IOccurence> pListeOccurencesMotif) {
		this.listeOccurencesMotif = pListeOccurencesMotif;
	} // Fin de setListeOccurencesMotif(...).______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTexteMatcheMotif() {
		return this.texteMatcheMotif;
	} // Fin de isTexteMatcheMotif().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTexteMatcheMotif(
			final boolean pTexteMatcheMotif) {
		this.texteMatcheMotif = pTexteMatcheMotif;
	} // Fin de setTexteMatcheMotif(...).__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IOccurence> getListeOccurencesGroupesCapturant() {
		return this.listeOccurencesGroupesCapturant;
	} // Fin de getListeOccurencesGroupesCapturant().______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setListeOccurencesGroupesCapturant(
			final List<IOccurence> pListeOccurencesGroupesCapturant) {
		this.listeOccurencesGroupesCapturant 
			= pListeOccurencesGroupesCapturant;
	} // Fin de setListeOccurencesGroupesCapturant(...).___________________
	

		
} // FIN DE LA CLASSE RegexResponseDto.--------------------------------------
