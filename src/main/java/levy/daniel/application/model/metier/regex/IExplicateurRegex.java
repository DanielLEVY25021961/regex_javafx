package levy.daniel.application.model.metier.regex;

import java.util.List;

/**
 * INTERFACE IExplicateurRegex :<br/>
 * Interface factorisant les comportements des ExplicateurRegex.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Pattern, Matcher, Expressions régulières, Regex, 
 * expression reguliere, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 17 août 2018
 *
 */
public interface IExplicateurRegex {

	
	
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
	String extraireSousMotif(String pMotif, int pI);

	
	
	/**
	 * <b>Détecte le groupe capturant ZERO</b>, 
	 * c'est à dire le <b>motif complet lui-même</b> 
	 * et le retourne sous forme de List&lt;{@link IOccurence}&gt;.<br/>
	 * <ul>
	 * <li>utilise le pattern Regex 
	 * <code>"^(\\^{0,1})(\\({0,1})(.*)(\\){0,1})(\\${0,1})$"</code>
	 * </li>
	 * <ul>
	 * <li>1 accent optionnel en début de motif pour exprimer le début de motif -------------> ^(\\^{0,1})</li>
	 * <li>1 parenthèse de début optionnelle pour grouper la totalité du motif ---------------> (\\({0,1})</li>
	 * <li>n'importe quels caractères décrivant le motif -----------------------------------------> (.*)</li>
	 * <li>1 parenthèse de fin optionnelle pour grouper la totalité du motif -------------------> (\\){0,1})</li>
	 * <li>1 dollar optionnel en fin de motif pour exprimer la fin du motif ---------------------> (\\${0,1})$</li>
	 * </ul>
	 * </ul>
	 * - retourne null si pMotif est blank.<br/>
	 * <br/>
	 *
	 * @param pMotif : String : 
	 * pattern RegEx dont on veut connaitre le 
	 * groupe capturant ZERO.<br/>
	 * 
	 * @return : List&lt;IOccurence&gt; : 
	 * liste contenant le motif lui-même.<br/>
	 */
	List<IOccurence> trouverGroupeCapturantZero(String pMotif);
	
	
	
	/**
	 * <b>Détecte les groupes capturants internes</b> 
	 * (hors groupe capturant 0) dans un motif Regex Java et 
	 * les retourne sous forme de List&lt;{@link IOccurence}&gt;.<br/>
	 * <ul>
	 * <li>retourne une liste vide si il n'y a 
	 * aucun groupe capturant interne.</li>
	 * <li>utilise le pattern Regex 
	 * <code>"(\\({1})([^\\(\\)]*)(\\){1})"</code></li>
	 * <li>DEFINITION D'UN GROUPE CAPTURANT
	 * <ul>
	 * <li> 1 parenthèse obligatoire de début '(' -------------------------------> (\\({1})</li>
	 * <li> n'importe quoi sauf une parenthèse de début '(' ou de fin ')' -----> ([^\\(\\)]*)</li>
	 * <li> 1 parenthèse obligatoire de fin ')' ----------------------------------> (\\){1})</li>
	 * </ul></li>
	 * </ul>
	 * - retourne null si pMotif est blank.<br/>
	 * <br/>
	 *
	 * @param pMotif : String : 
	 * pattern RegEx dont on veut connaitre les 
	 * groupes capturants internes.<br/>
	 * 
	 * @return : List&lt;IOccurence&gt; : 
	 * liste des occurences de groupe capturant interne.<br/>
	 */
	List<IOccurence> trouverGroupesCapturantsInternes(String pMotif);
	
	

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
	 * retourne une String pour l'affichage 
	 * d'une List&lt;IOccurence&gt;.<br/>
	 * <ul>
	 * <li>retourne une String vide si pList est vide.</li>
	 * </ul>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IOccurence&gt; : 
	 * Liste {@link IOccurence}.
	 * 
	 * @return : String : String pour affichage.<br/>
	 */
	String afficherListOccurences(List<IOccurence> pList);
	
	

	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return significationMotif : String.<br/>
	 */
	String getSignificationMotif();
	
	

} // FIN DE L'INTERFACE IExplicateurRegex.-----------------------------------