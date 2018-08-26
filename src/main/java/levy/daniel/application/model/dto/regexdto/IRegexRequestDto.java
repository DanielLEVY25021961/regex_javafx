package levy.daniel.application.model.dto.regexdto;

import levy.daniel.application.model.dto.regexdto.impl.RegexRequestDto;

/**
 * INTERFACE <b>IRegexRequestDto</b> :<br/>
 * Interface factorisant les comportements des {@link RegexRequestDto}.<br/>
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
public interface IRegexRequestDto {

	
	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	String NULL = "null";

	
	
	/**
	 * ", ".<br/>
	 */
	String VIRGULE = ", ";
	
	

	/**
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	String NEWLINE 
		= System.getProperty("line.separator");


	
	/**
	 * "texte=".<br/>
	 */
	String TEXTE = "texte=";
	

	
	/**
	 * "motifJava=".<br/>
	 */
	String MOTIFJAVA = "motifJava=";
	
	

	/**
	 * retourne une String pour affichage ligne par ligne.<br/>
	 *
	 * @return : String : affichage ligne par ligne.<br/>
	 */
	String afficherLigneParLigne();
	

	
	/**
	 * Getter de la chaine de caractères (éventuellement multi-lignes) 
	 * dont on veut savoir si elle contient ou matche le motif 
	 * RegEx Java de l'expression régulière.<br/>
	 *
	 * @return this.texte : String.<br/>
	 */
	String getTexte();



	/**
	* Setter de la chaine de caractères (éventuellement multi-lignes) 
	* dont on veut savoir si elle contient ou matche le motif 
	* RegEx Java de l'expression régulière.<br/>
	*
	* @param pTexte : String : 
	* valeur à passer à <code>this.texte</code>.<br/>
	*/
	void setTexte(String pTexte);



	/**
	 * Getter du Motif de l'expression régulière applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre.
	 *
	 * @return this.motifJava : String.<br/>
	 */
	String getMotifJava();



	/**
	* Setter du Motif de l'expression régulière applicable en Java.<br/>
	* Par exemple : "[0-9]" ou "\\d" en java pour un chiffre.<br/>
	* 
	* @param pMotifJava : String : 
	* valeur à passer à <code>this.motifJava</code>.<br/>
	*/
	void setMotifJava(String pMotifJava);
	
	
	
} // FIN DE L'INTERFACE IRegexRequestDto.------------------------------------
