package levy.daniel.application.model.dto.regexdto;

import java.util.List;

import levy.daniel.application.model.dto.regexdto.impl.RegexResponseDto;
import levy.daniel.application.model.metier.regex.IOccurence;



/**
 * INTERFACE <b>IRegexResponseDto</b> :<br/>
 * Interface factorisant les comportements des {@link RegexResponseDto}.<br/>
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
public interface IRegexResponseDto {

	
		
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
	 * "motifJavaScript=".<br/>
	 */
	String MOTIFJAVASCRIPT = "motifJavaScript=";
	

	
	/**
	 * "significationMotif=".<br/>
	 */
	String SIGNIFICATIONMOTIF = "significationMotif=";


	
	/**
	 * "motifJavaRespecteSyntaxe=".<br/>
	 */
	String MOTIFJAVARESPECTESYNTAXE = "motifJavaRespecteSyntaxe=";
	
	
	
	/**
	 * "texteCommenceParMotif=".<br/>
	 */
	String TEXTECOMMENCEPARMOTIF = "texteCommenceParMotif=";
	

	
	/**
	 * "texteContientMotif=".<br/>
	 */
	String TEXTECONTIENTMOTIF = "texteContientMotif=";


	
	/**
	 * "listeOccurencesMotif=".<br/>
	 */
	String LISTEOCCURENCESMOTIF = "listeOccurencesMotif=";
	

	
	/**
	 * "texteMatcheMotif=".<br/>
	 */
	String TEXTEMATCHEMOTIF = "texteMatcheMotif=";
	

	
	/**
	 * "listeOccurencesGroupesCapturant=".<br/>
	 */
	String LISTEOCCURENCESGROUPESCAPTURANT 
		= "listeOccurencesGroupesCapturant=";
	
	
	
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
	* Par exemple : "[0-9]" ou "\\d" en java pour un chiffre.
	* 
	* @param pMotifJava : String : 
	* valeur à passer à <code>this.motifJava</code>.<br/>
	*/
	void setMotifJava(String pMotifJava);



	/**
	 * Getter du Motif de l'expression régulière 
	 * applicable en JavaScript.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * Par exemple : '/ \d /'.<br/> 
	 *
	 * @return this.motifJavaScript : String.<br/>
	 */
	String getMotifJavaScript();



	/**
	* Setter du Motif de l'expression régulière 
	* applicable en JavaScript.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	* Par exemple : '/ \d /'.<br/> 
	*
	* @param pMotifJavaScript : String : 
	* valeur à passer à <b>this.motifJavaScript</b>.<br/>
	*/
	void setMotifJavaScript(String pMotifJavaScript);



	/**
	 * Getter de la Signification du motif de l'expression régulière.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 * Par exemple : 'commence par 2 chiffres...'<br/>
	 *
	 * @return this.significationMotif : String.<br/>
	 */
	String getSignificationMotif();
	


	/**
	* Setter de la Signification du motif de l'expression régulière.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	* Par exemple : 'commence par 2 chiffres...'<br/>
	*
	* @param pSignificationMotif : String : 
	* valeur à passer à <b>this.significationMotif</b>.<br/>
	*/
	void setSignificationMotif(String pSignificationMotif);



	/**
	 * Getter du boolean qui stipule si <code>this.motifJava</code> 
	 * <b>respecte la syntaxe</b> des expressions régulières 
	 * (RegEx) Java.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 *
	 * @return this.motifJavaRespecteSyntaxe : boolean.<br/>
	 */
	boolean isMotifJavaRespecteSyntaxe();



	/**
	* Setter du boolean qui stipule si <code>this.motifJava</code> 
	* <b>respecte la syntaxe</b> des expressions régulières 
	* (RegEx) Java.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	*
	* @param pMotifJavaRespecteSyntaxe : boolean : 
	* valeur à passer à <b>this.motifJavaRespecteSyntaxe</b>.<br/>
	*/
	void setMotifJavaRespecteSyntaxe(boolean pMotifJavaRespecteSyntaxe);



	/**
	 * Getter du boolean qui stipule si <code>this.texte</code> 
	 * <b>commence</b> par <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 *
	 * @return this.texteCommenceParMotif : boolean.<br/>
	 */
	boolean isTexteCommenceParMotif();
	


	/**
	* Setter du boolean qui stipule si <code>this.texte</code> 
	* <b>commence</b> par <code>this.motifJava</code>.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	*
	* @param pTexteCommenceParMotif : boolean : 
	* valeur à passer à <b>this.texteCommenceParMotif</b>.<br/>
	*/
	void setTexteCommenceParMotif(boolean pTexteCommenceParMotif);



	/**
	 * Getter du boolean qui stipule si <code>this.texte</code> 
	 * <b>contient</b> <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 *
	 * @return this.texteContientMotif : boolean.<br/>
	 */
	boolean isTexteContientMotif();
	


	/**
	* Setter du boolean qui stipule si <code>this.texte</code> 
	* <b>contient</b> <code>this.motifJava</code>.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	*
	* @param pTexteContientMotif : boolean : 
	* valeur à passer à <b>this.texteContientMotif</b>.<br/>
	*/
	void setTexteContientMotif(boolean pTexteContientMotif);



	/**
	 * Getter de la Liste des occurences de <code>this.motifJava</code> 
	 * dans <code>this.texte</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 *
	 * @return this.listeOccurencesMotif : List&lt;IOccurence&gt;.<br/>
	 */
	List<IOccurence> getListeOccurencesMotif();



	/**
	* Setter de la Liste des occurences de <code>this.motifJava</code> 
	* dans <code>this.texte</code>.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	*
	* @param pListeOccurencesMotif : List&lt;IOccurence&gt; : 
	* valeur à passer à <b>this.listeOccurencesMotif</b>.<br/>
	*/
	void setListeOccurencesMotif(List<IOccurence> pListeOccurencesMotif);



	/**
	 * Getter du boolean qui stipule si <code>this.texte</code> 
	 * <b>matche entièrement</b> avec <code>this.motifJava</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 *
	 * @return this.texteMatcheMotif : boolean.<br/>
	 */
	boolean isTexteMatcheMotif();



	/**
	* Setter du boolean qui stipule si <code>this.texte</code> 
	* <b>matche entièrement</b> avec <code>this.motifJava</code>.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	*
	* @param pTexteMatcheMotif : boolean : 
	* valeur à passer à <b>this.texteMatcheMotif</b>.<br/>
	*/
	void setTexteMatcheMotif(boolean pTexteMatcheMotif);



	/**
	 * Getter de la Liste des occurences des 
	 * <b>sous-groupes capturant</b> de 
	 * <code>this.motifJava</code> 
	 * dans <code>this.texte</code>.<br/>
	 * <b>attribut calculé par le METIER</b>.<br/>
	 *
	 * @return this.listeOccurencesGroupesCapturant : 
	 * List&lt;IOccurence&gt;.<br/>
	 */
	List<IOccurence> getListeOccurencesGroupesCapturant();



	/**
	* Setter de la Liste des occurences des 
	* <b>sous-groupes capturant</b> de 
	* <code>this.motifJava</code> 
	* dans <code>this.texte</code>.<br/>
	* <b>attribut calculé par le METIER</b>.<br/>
	*
	* @param pListeOccurencesGroupesCapturant : List&lt;IOccurence&gt; : 
	* valeur à passer à <b>this.listeOccurencesGroupesCapturant</b>.<br/>
	*/
	void setListeOccurencesGroupesCapturant(
			List<IOccurence> pListeOccurencesGroupesCapturant);
	
	
	
} // FIN DE L'INTERFACE IRegexResponseDto.-----------------------------------
