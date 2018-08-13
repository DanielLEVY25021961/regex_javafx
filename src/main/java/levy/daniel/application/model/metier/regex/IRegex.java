package levy.daniel.application.model.metier.regex;



/**
 * INTERFACE <b>IRegex</b> :<br/>
 * Interface factorisant les comportements des RegEx.<br/>
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
public interface IRegex {
	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pMotif
	 * @return : String :  .<br/>
	 */
	String expliquerMotif(String pMotif);


	
	/**
	 * Détermine si un motif (pattern) pMotif respecte la <b>syntaxe</b> 
	 * des Expressions régulières (regex).<br/>
	 * <ul>
	 * <li>utilise <code>Pattern.compile(pMotif);</code></li>
	 * <li>traite la <code>PatternSyntaxException</code> levée 
	 * si la syntaxe est incorrecte.</li>
	 * </ul>
	 * - retourne false si pMotif est blank.<br/>
	 * <br/>
	 *
	 * @param pMotif : String : le pattern regex dont on veut savoir 
	 * si la syntaxe est correcte.<br/>
	 * 
	 * @return : boolean : true si la syntaxe est régulière.<br/>
	 */
	boolean motifRespecteSyntaxeRegex(String pMotif);
	
	
	
	/**
	 * Détermine si le texte this.chaineATester respecte <i>entièrement</i> 
	 * le motif (pattern) this.motifJava.<br/>
	 * Le texte <b>matches</b> alors le motif.<br/>
	 * <ul>
	 * <li>utilise <code>Pattern.matches(pMotif, pTexte);</code></li>
	 * <li>retourne true si le texte respecte entièrement le pattern.</li>
	 * </ul>
	 * - retourne false si this.chaineATester est blank.<br/>
	 * - retourne false si this.motifJava est blank.<br/>
	 * <br/>
	 *	 
	 * @return : boolean : true si le texte respecte 
	 * <i>entièrement</i> le pattern.<br/>
	 * 
	 * @throws Exception si le pattern this.motifJava n'est pas 
	 * conforme à la syntaxe des Regex.<br/>
	 */
	boolean texteCorrespondEntierementAMotif() 
			throws Exception;
	
	
	
	/**
	 * Détermine si le texte pTexte respecte <i>entièrement</i> 
	 * le motif (pattern) pMotif.<br/>
	 * Le texte <b>matches</b> alors le motif.<br/>
	 * <ul>
	 * <li>utilise <code>Pattern.matches(pMotif, pTexte);</code></li>
	 * <li>retourne true si le texte respecte entièrement le pattern.</li>
	 * </ul>
	 * - retourne false si pTexte est blank.<br/>
	 * - retourne false si pMotif est blank.<br/>
	 * <br/>
	 *
	 * @param pTexte : String : Le texte dont on veut savoir 
	 * si il respecte <i>entièrement</i> le pattern pMotif.<br/>
	 * @param pMotif : String : le pattern regex.<br/>
	 * 
	 * @return : boolean : true si le texte respecte 
	 * <i>entièrement</i> le pattern.<br/>
	 * 
	 * @throws Exception si le pattern pMotif n'est pas 
	 * conforme à la syntaxe des Regex.<br/>
	 */
	boolean texteCorrespondEntierementAMotif(
			String pTexte
				, String pMotif) 
							throws Exception;
	
	
	
	/**
	 * Détermine si le texte pTexte 
	 * <b>contient au moins une occurence</b> 
	 * du motif (pattern) this.motifJava.<br/>
	 * Utilise la méthode <code>find()</code> de Matcher.
	 * <ul>
	 * <li>retourne true si le texte contient 
	 * au moins une occurrence du motif.</li>
	 * <li>utilise : <br/>
	 * <code>Pattern pattern = Pattern.compile(this.motifJava);</code><br/>
	 * <code>Matcher matcher = pattern.matcher(pTexte);</code><br/>
	 * <code>resultat = matcher.find();</code>
	 * </li>
	 * </ul>
	 * - return false si pTexte est blank.<br/>
	 * - return false si this.motifJava est blank.<br/>
	 * <br/>
	 *
	 * @param pTexte : String : texte dont on veut savoir 
	 * si il contient le motif (pattern) this.motifJava.<br/>
	 * 
	 * @return : boolean : true si le texte contient 
	 * au moins une occurence du motif.<br/>
	 * 
	 * @throws Exception si le pattern this.motifJava n'est pas 
	 * conforme à la syntaxe des Regex.<br/>
	 */
	boolean texteContientMotif(String pTexte) throws Exception;


	
	/**
	 * Détermine si le texte pTexte 
	 * <b>contient au moins une occurence</b> 
	 * du motif (pattern) pMotif.<br/>
	 * Utilise la méthode <code>find()</code> de Matcher.
	 * <ul>
	 * <li>retourne true si le texte contient 
	 * au moins une occurrence du motif.</li>
	 * <li>utilise : <br/>
	 * <code>Pattern pattern = Pattern.compile(pMotif);</code><br/>
	 * <code>Matcher matcher = pattern.matcher(pTexte);</code><br/>
	 * <code>resultat = matcher.find();</code>
	 * </li>
	 * </ul>
	 * - return false si pTexte est blank.<br/>
	 * - return false si pMotif est blank.<br/>
	 * <br/>
	 *
	 * @param pTexte : String : texte dont on veut savoir 
	 * si il contient le motif (pattern) pMotif.<br/>
	 * @param pMotif : String : le pattern regex.<br/>
	 * 
	 * @return : boolean : true si le texte contient 
	 * au moins une occurence du motif.<br/>
	 * 
	 * @throws Exception si le pattern pMotif n'est pas 
	 * conforme à la syntaxe des Regex.<br/>
	 */
	boolean texteContientMotif(
			String pTexte
				, String pMotif) 
						throws Exception;
	
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * return false si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString
	 * @return :  :  .<br/>
	 */
	boolean motifMatche(String pString);


	
	/**
	 * Getter de la chaine de caractères dont on veut savoir 
	 * si elle contient ou matche le motif 
	 * de l'expression régulière.<br/>
	 *
	 * @return this.chaineATester : String.<br/>
	 */
	String getChaineATester();
	

	
	/**
	* Setter de la chaine de caractères dont on veut savoir 
	* si elle contient ou matche le motif 
	* de l'expression régulière.<br/>
	*
	* @param pChaineATester : String : 
	* valeur à passer à this.chaineATester.<br/>
	*/
	void setChaineATester(String pChaineATester);
	
	
	
	/**
	 * Getter du Motif de l'expression régulière 
	 * applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre. 
	 *
	 * @return motifJava : String.<br/>
	 */
	String getMotifJava();



	/**
	* Setter du Motif de l'expression régulière 
	* applicable en Java.<br/>
	* Par exemple : "[0-9]" ou "\\d" en java pour un chiffre. 
	*
	* @param pMotifJava : String : 
	* valeur à passer à motifJava.<br/>
	*/
	void setMotifJava(String pMotifJava);



	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return motifJavaScript : String.<br/>
	 */
	String getMotifJavaScript();



	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return significationMotif : String.<br/>
	 */
	String getSignificationMotif();

	
	
} // FIN DE L'INTERFACE IRegex.----------------------------------------------
