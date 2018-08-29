package levy.daniel.application.model.services.metier.regex;

import java.util.regex.Pattern;

import levy.daniel.application.model.dto.regexdto.IRegexRequestDto;
import levy.daniel.application.model.dto.regexdto.IRegexResponseDto;
import levy.daniel.application.model.metier.regex.IRegex;
import levy.daniel.application.model.services.metier.regex.impl.RegexServiceStateless;

/**
 * INTERFACE <b>IRegexServiceStateless</b> :<br/>
 * Interface factorisant les comportements 
 * des {@link RegexServiceStateless}.<br/>
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
public interface IRegexServiceStateless {

	
	
	/**
	 * <b>soumet au METIER un DTO request</b> et 
	 * <b>retourne le DTO response</b> fourni par le METIER.<br/>
	 * <ul>
	 * <li>lit les paramètres contenus dans le DTO Request.</li>
	 * <li>instancie un METIER Regex à chaque appel.</li>
	 * <li>passe les paramètres au METIER.</li>
	 * <li>lit la réponse du METIER.</li>
	 * <li>instancie et alimente un DTO response.</li>
	 * </ul>
	 *
	 * @param pRegexRequestDto : IRegexRequestDto : 
	 * encapsulation de la requête provenant de la VUE 
	 * contenant le texte et le motif Regex.<br/>
	 * 
	 * @return : IRegexResponseDto : 
	 * Encapsulation de la réponse du métier.<br/>
	 * 
	 * @throws Exception si le pattern (motif)
	 * n'est pas conforme à la syntaxe des Regex Java.<br/>
	 */
	IRegexResponseDto soumettre(IRegexRequestDto pRegexRequestDto) 
													throws Exception;


	
	/**
	 * Détermine si un motif (pattern) pMotif <b>respecte la syntaxe</b> 
	 * des Expressions régulières (regex) en Java.<br/>
	 * <ul>
	 * <li>retourne true si pMotif respecte la syntaxe RegEx Java.</li>
	 * <li>utilise {@link Pattern}</li>
	 * <li>utilise <code>Pattern.compile(pMotif);</code></li>
	 * <li>traite la <code>PatternSyntaxException</code> levée 
	 * si la syntaxe est incorrecte.</li>
	 * </ul>
	 * - retourne false si pMotif est blank.<br/>
	 * <br/>
	 *
	 * @param pMotif : String : le pattern regex Java dont on veut savoir 
	 * si la syntaxe est correcte.<br/>
	 * 
	 * @return : boolean : true si la syntaxe est régulière.<br/>
	 */
	boolean motifRespecteSyntaxeRegex(String pMotif);

	
	
	/**
	 * Getter du METIER Regex.
	 *
	 * @return this.regex : IRegex.<br/>
	 */
	IRegex getRegex();



	/**
	* Setter du METIER Regex.
	*
	* @param pRegex : IRegex : 
	* valeur à passer à this.regex.<br/>
	*/
	void setRegex(IRegex pRegex);
	
	
	
} // FIN DE L'INTERFACE IRegexServiceStateless.------------------------------
