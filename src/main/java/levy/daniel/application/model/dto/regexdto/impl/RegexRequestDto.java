package levy.daniel.application.model.dto.regexdto.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.regexdto.IRegexRequestDto;
import levy.daniel.application.model.metier.regex.impl.Regex;


/**
 * CLASSE RegexRequestDto :<br/>
 * DTO pour les requêtes relatives à {@link Regex}.<br/>
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
public class RegexRequestDto implements IRegexRequestDto {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * chaine de caractères (éventuellement multi-lignes) 
	 * dont on veut savoir si elle contient ou matche le motif 
	 * RegEx Java de l'expression régulière.<br/>
	 */
	private String texte;
	
	/**
	 * Motif de l'expression régulière applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre. 
	 */
	private String motifJava;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(RegexRequestDto.class);
	
	
	// *************************METHODES************************************/
			
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public RegexRequestDto() {
		this(null, null);
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
	 */
	public RegexRequestDto(
			final String pTexte
				, final String pMotifJava) {
		
		super();
		
		this.texte = pTexte;
		this.motifJava = pMotifJava;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("RegexRequestDto [");
		
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
			final String pTexte){
		
		/* passe le paramètre à l'attribut. */
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
		
		/* passe le paramètre à l'attribut. */
		this.motifJava = pMotifJava;
		
	} // Fin de setMotifJava(...)._________________________________________


	
} // FIN DE LA CLASSE RegexRequestDto.---------------------------------------
