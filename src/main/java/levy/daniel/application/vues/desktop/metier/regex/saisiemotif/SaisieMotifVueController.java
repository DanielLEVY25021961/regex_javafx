package levy.daniel.application.vues.desktop.metier.regex.saisiemotif;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import levy.daniel.application.MainApplication;


/**
 * CLASSE <b>SaisieMotifVueController</b> :<br/>
 *  CONTROLLER de la VUE <b>{@link SaisieMotifVueFxml}</b> 
 * créée par le chargement du fichier XML <b>SaisieMotifVue.fxml</b>.<br/>
 * <ul>
 * <li><b>Permet d'accéder en JAVA aux objets graphiques de la VUE 
 * générée par le fxml</b>.</li>
 * <li>la VUE générée par <b>SaisieMotifVue.fxml</b> est 
 * l' {@link AnchorPane} 
 * <b>this.saisieMotifAnchorPane</b></li>
 * <li>L' <b>annotation FXML</b> permet de lier 
 * les objets graphiques crées 
 * dans le fxml aux attributs du présent CONTROLLER DE VUE.</li>
 * <li>Ce CONTROLLER DE VUE est <b>AUTOMATIQUEMENT ALIMENTE</b> 
 * LORS DU CHARGEMENT du FXML et sa méthode initialize() 
 * est AUTOMATIQUEMENT EXECUTEE.</li>
 * <li>Ce controlleur de vue est automatiquement instancié 
 * lors du chargement du FXML via son <b>constructeur d'arité nulle</b>. 
 * En conséquence, seuls ses objets graphiques annotés FXML 
 * sont alimentés par le FXML. Des éléments comme un MODEL 
 * pour alimenter par exemple une table doivent donc être 
 * passés par CallBack après l'instanciation du présent 
 * CONTROLLER DE VUE.</li>
 * <li><b>permet d'instancier des modèles 
 * (contenu de JTable par exemple) 
 * et de préparer les composants à afficher dans la VUE 
 * (méthode initialize).</b></li>
* <li><b>permet d'implémenter les méthodes évènementielles.</b></li>
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
 * @since 22 août 2018
 *
 */
public class SaisieMotifVueController {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * AnchorPane contenant l'ensemble du 
	 * panneau de saisie du motif (racine).<br/>
	 */
	@FXML
	private AnchorPane saisieMotifAnchorPane;
	
	/**
	 * champ de texte pour écrire ou afficher un motif Regex.<br/>
	 */
	@FXML
	private TextField textField;
		
	/**
	 * classe applicative.<br/>
	 * fournie par la Vue par Callback.
	 */
	private transient MainApplication applicationMain;

	/**
	 * fenêtre (théatre) créée par la classe applicative applicationMain 
	 * possédant les composants à afficher.<br/>
	 */
	private transient Stage stage;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SaisieMotifVueController.class);
	
	// *************************METHODES************************************/
	
	
	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Automatiquement appelé en premier 
	 * lors du chargement du FXMLLoader.<br/>
	 * <br/>
	 */
	public SaisieMotifVueController() {		
		super();		
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method initialize() :<br/>
	 * <ul>
	 * <li>Initialise le présent CONTROLLER DE VUE.</li>
	 * <li>Méthode <b>automatiquement appelée après que 
	 * le FXML ait été chargé (juste après le constructeur)</b>.</li>
	 * <li><b>permet d'instancier des modèles (contenu de JTable par exemple) 
	 * et de préparer les composants à afficher dans la VUE.</b></li>
	 * </ul>
	 * @throws Exception 
	 */
	@FXML
    private void initialize() throws Exception {
		
		/**/
		
	} // Fin de initialize().______________________________________________


	
	/**
	 * retourne le contenu de <code>this.textField</code>.<br/>
	 *
	 * @return : String  : <code>this.textField.getText();</code>.<br/>
	 */
	private String recupererContenuTextField() {
		return this.textField.getText();
	} // Fin de recupererContenuTextField()._______________________________
	
	
	
	/**
	 * Injecte le texte pString dans this.textField.<br/>
	 * <ul>
	 * <li>ne fait rien si pString == null.</li>
	 * </ul>
	 *
	 * @param pString : String.<br/>
	 */
	private void remplirTextField(
			final String pString) {
		
		/* ne fait rien si pString == null. */
		if (pString != null) {
			this.textField.setText(pString);
		}
		
	} // Fin de remplirTextField(...)._____________________________________
	


	/**
	 * Getter du champ texte pour 
	 * écrire ou afficher un motif Regex Java.<br/>
	 *
	 * @return this.textField : {@link TextField}.<br/>
	 */
	public TextField getTextField() {
		return this.textField;
	} // Fin de getTextField().____________________________________________


	
	/**
	* Setter du champ texte pour 
	* écrire ou afficher un motif Regex Java.<br/>
	*
	* @param pTextField : {@link TextField} : 
	* valeur à passer à this.textField.<br/>
	*/
	public void setTextField(
			final TextField pTextField) {
		this.textField = pTextField;
	} // Fin de setTextField(...)._________________________________________

	
	
	/**
	 * Getter de la classe applicative.<br/>
	 * <br/>
	 *
	 * @return this.applicationMain : {@link MainApplication}.<br/>
	 */
	public MainApplication getApplicationMain() {
		return this.applicationMain;
	} // Fin de getApplicationMain().______________________________________


	
	/**
	* Setter de la classe applicative.<br/>
	* <ul>
	* <li>récupère le théatre <code>this.stage</code> 
	* auprès de la classe applicative.</li>
	* </ul>
	*
	* @param pApplicationMain : {@link MainApplication} : 
	* valeur à passer à this.applicationMain.<br/>
	*/
	public void setApplicationMain(
			final MainApplication pApplicationMain) {
		
		this.applicationMain = pApplicationMain;
		
		/* récupère le théatre this.stage auprès 
		 * de la classe applicative. */
		this.stage = this.applicationMain.getPrimaryStage();

	} // Fin de setApplicationMain(...).___________________________________


	
	/**
	 * Getter de la fenêtre (théatre) créée par 
	 * la classe applicative applicationMain 
	 * possédant les composants à afficher.<br/>
	 *
	 * @return this.stage : {@link Stage}.<br/>
	 */
	public Stage getStage() {
		return this.stage;
	} // Fin de getStage().________________________________________________


	
} // FIN DE LA CLASSE SaisieMotifVueController.------------------------------
