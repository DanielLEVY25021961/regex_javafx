package levy.daniel.application.model.services.metier.regex.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.regexdto.IRegexRequestDto;
import levy.daniel.application.model.dto.regexdto.IRegexResponseDto;
import levy.daniel.application.model.dto.regexdto.impl.RegexResponseDto;
import levy.daniel.application.model.metier.regex.IOccurence;
import levy.daniel.application.model.metier.regex.IRegex;
import levy.daniel.application.model.metier.regex.impl.Regex;
import levy.daniel.application.model.services.metier.regex.IRegexServiceStateless;


/**
 * CLASSE RegexServiceStateless :<br/>
 * Classe fournissant les <b>services</b> des 
 * Expressions Régulières (RegEx) en Java.<br/>
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
public class RegexServiceStateless implements IRegexServiceStateless {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * METIER Regex.<br/>
	 */
	private IRegex regex;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(RegexServiceStateless.class);
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * 
	 * @throws Exception 
	 */
	public RegexServiceStateless() throws Exception {
		
		super();
		
		/* instancie un METIER Regex à chaque appel. */
		this.regex = new Regex();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IRegexResponseDto soumettre(
			final IRegexRequestDto pRegexRequestDto) throws Exception {
		
		/* retourne null si pRegexRequestDto == null. */
		if (pRegexRequestDto == null) {
			return null;
		}
		
		/* lit les paramètres contenus dans le DTO Request. */
		final String texte = pRegexRequestDto.getTexte();
		final String motifJava = pRegexRequestDto.getMotifJava();
		
		/* instancie un METIER Regex à chaque appel. */
//		this.regex = new Regex();
		
		/* passe les paramètres au METIER. */
		this.regex.setChaineATester(texte);
		this.regex.setMotifJava(motifJava);
		
		/* lit la réponse du METIER. */
		final String motifJavaScript 
			= this.regex.getMotifJavaScript();
		final String significationMotif 
			= this.regex.getSignificationMotif();
		final boolean motifJavaRespecteSyntaxe 
			= this.regex.motifRespecteSyntaxeRegex(motifJava);
		final boolean texteCommenceParMotif 
			= this.regex.texteCommenceParMotif(texte, motifJava);
		final boolean texteContientMotif 
			= this.regex.texteContientMotif(texte, motifJava);
		final List<IOccurence> listeOccurencesMotif 
			= this.regex.trouverOccurences(texte, motifJava);
		final boolean texteMatcheMotif 
			= this.regex.texteCorrespondEntierementAMotif(
												texte, motifJava);
		final List<IOccurence> listeOccurencesGroupeCapturant 
			= this.regex.texteMatcheMotif(texte, motifJava);
		
		/* instancie et alimente un DTO response. */
		final IRegexResponseDto response 
			= new RegexResponseDto(texte, motifJava
					, motifJavaScript, significationMotif
					, motifJavaRespecteSyntaxe
					, texteCommenceParMotif
					, texteContientMotif, listeOccurencesMotif
					, texteMatcheMotif, listeOccurencesGroupeCapturant);
		
		return response;
		
	} // Fin de soumettre(...).____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRegex getRegex() {
		return this.regex;
	} // Fin de getRegex().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRegex(
			final IRegex pRegex) {
		this.regex = pRegex;
	} // Fin de setRegex(...)._____________________________________________
	

	
} // FIN DE LA CLASSE RegexServiceStateless.---------------------------------
