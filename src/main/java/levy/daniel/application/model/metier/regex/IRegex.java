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
	 * Détermine si un motif (pattern) pMotif <b>respecte la syntaxe</b> 
	 * des Expressions régulières (regex) en Java.<br/>
	 * <ul>
	 * <li>retourne true si pMotif respecte la syntaxe RegEx Java.</li>
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
	 * Détermine si le texte <code>this.chaineATester</code> 
	 * <b><i>commence par</i></b> 
	 * le motif (pattern) <code>this.motifJava</code>.<br/>
	 * Le texte vérifie alors <b>lookingAt()</b> avec le motif.<br/>
	 * <ul>
	 * <li>utilise <code>matcher.lookingAt();</code></li>
	 * <li>retourne true si le texte commence par le pattern.</li>
	 * </ul>
	 * - retourne false si <code>this.chaineATester</code> est blank.<br/>
	 * - retourne false si <code>this.motifJava</code> est blank.<br/>
	 * <br/>
	 *
	 * @return : boolean : true si le texte 
	 * <i>commence par</i> le pattern.<br/>
	 * 
	 * @throws Exception si le pattern <code>this.motifJava</code> 
	 * n'est pas conforme à la syntaxe des Regex Java.<br/>
	 */
	boolean texteCommenceParMotif() throws Exception;
	

	
	/**
	 * Détermine si le texte pTexte <b><i>commence par</i></b> 
	 * le motif (pattern) pMotif.<br/>
	 * Le texte vérifie alors <b>lookingAt()</b> avec le motif.<br/>
	 * <ul>
	 * <li>utilise <code>matcher.lookingAt();</code></li>
	 * <li>retourne true si le texte commence par le pattern.</li>
	 * </ul>
	 * - retourne false si pTexte est blank.<br/>
	 * - retourne false si pMotif est blank.<br/>
	 * <br/>
	 *
	 * @param pTexte : String : Le texte dont on veut savoir 
	 * si il <i>commence</i> par le pattern pMotif.<br/>
	 * @param pMotif : String : le pattern regex.<br/>
	 * 
	 * @return : boolean : true si le texte 
	 * <i>commence par</i> le pattern.<br/>
	 * 
	 * @throws Exception si le pattern pMotif n'est pas 
	 * conforme à la syntaxe des Regex Java.<br/>
	 */
	boolean texteCommenceParMotif(
			String pTexte
				, String pMotif) 
						throws Exception;
	
	
	
	/**
	 * Détermine si le texte <code>this.chaineATester</code> 
	 * <b>contient au moins une occurence</b> 
	 * du motif (pattern) <code>this.motifJava</code>.<br/>
	 * Utilise la méthode <code>find()</code> de Matcher.
	 * <ul>
	 * <li>retourne true si le texte contient 
	 * au moins une occurrence du motif.</li>
	 * <li>utilise : <br/>
	 * <code>Pattern pattern 
	 * = Pattern.compile(this.motifJava);</code><br/>
	 * <code>Matcher matcher 
	 * = pattern.matcher(this.chaineATester);</code><br/>
	 * <code>resultat = matcher.find();</code>
	 * </li>
	 * </ul>
	 * - return false si <code>this.chaineATester</code> est blank.<br/>
	 * - return false si <code>this.motifJava</code> est blank.<br/>
	 * <br/>
	 *
	 * @return : boolean : true si le texte contient 
	 * au moins une occurence du motif.<br/>
	 * 
	 * @throws Exception si le pattern <code>this.motifJava</code> 
	 * n'est pas conforme à la syntaxe des Regex Java.<br/>
	 */
	boolean texteContientMotif() throws Exception;


	
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
	 * conforme à la syntaxe des Regex Java.<br/>
	 */
	boolean texteContientMotif(
			String pTexte
				, String pMotif) 
						throws Exception;
	
	
	
	/**
	 * Détermine si le texte <code>this.chaineATester</code> 
	 * <b><i>respecte entièrement</i></b> 
	 * le motif (pattern) <code>this.motifJava</code>.<br/>
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
	 * conforme à la syntaxe des Regex Java.<br/>
	 */
	boolean texteCorrespondEntierementAMotif() 
			throws Exception;
	
	
	
	/**
	 * Détermine si le texte pTexte <b><i>respecte entièrement</i></b> 
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
	 * conforme à la syntaxe des Regex Java.<br/>
	 */
	boolean texteCorrespondEntierementAMotif(
			String pTexte
				, String pMotif) 
							throws Exception;
	
	
	
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
	* <ul>
	 * <li>alimente <code>this.motifJavaRespecteSyntaxe</code> à true 
	 * si <code>this.motifJava</code> respecte la syntaxe 
	 * des RegEx Java.</li>
	 * </ul>
	*
	* @param pMotifJava : String : 
	* valeur à passer à <code>this.motifJava</code>.<br/>
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
