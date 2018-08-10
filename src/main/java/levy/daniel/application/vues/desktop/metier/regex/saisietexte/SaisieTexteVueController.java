package levy.daniel.application.vues.desktop.metier.regex.saisietexte;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import levy.daniel.application.vues.desktop.metier.regex.selecteurfichier.ISelecteurFichier;
import levy.daniel.application.vues.desktop.metier.regex.selecteurfichier.SelecteurFichier;


/**
 * CLASSE SaisieTexteVueController :<br/>
 * CONTROLLER de la VUE <b>SaisieTexteVue.fxml</b>.<br/>
 * <ul>
 * <li>Permet d'accéder en JAVA aux objets graphiques de la VUE 
 * générée par le fxml.</li>
 * <li>la VUE générée par <b>SaisieTexteVue.fxml</b> est l'AnchorPane 
 * <b>this.saisieTexteAnchorPane</b></li>
 * <li>L'annotation FXML permet de lier les objets graphiques crées 
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
 * @since 8 août 2018
 *
 */
public class SaisieTexteVueController {
	// ************************ATTRIBUTS************************************/

	/**
	 * AnchorPane contenant l'ensemble du 
	 * panneau de saisie du texte (racine).<br/>
	 */
	@FXML
	private AnchorPane saisieTexteAnchorPane;
	
	/**
	 * bouton pour afficher le browser de sélection de fichier.<br/>
	 */
	@FXML
	private Button lireFichierButton;
		
	/**
	 * zone de texte pour écrire ou afficher du texte.<br/>
	 */
	@FXML
	private TextArea textArea;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SaisieTexteVueController.class);

	
	// *************************METHODES************************************/

	
	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Automatiquement appelé en premier 
	 * lors du chargement du FXMLLoader.<br/>
	 * <br/>
	 */
	public SaisieTexteVueController() {		
		super();		
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method initialize() :<br/>
	 * <ul>
	 * <li>Initialise le présent CONTROLLER DE VUE.</li>
	 * <li>Méthode automatiquement appelée après que 
	 * le FXML ait été chargé (juste après le constructeur).</li>
	 * </ul>
	 */
	@FXML
    private void initialize() {
		
		/**/
		
	} // Fin de initialize().______________________________________________


	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * :  :  .<br/>
	 */
	@FXML
	public final void lireFichier() {

		final File repertoirePrefere = new File("D:/Donnees/eclipse/eclipseworkspace_oxygen/regex_javafx/ressources_externes");
		final ISelecteurFichier selecteurFichier = new SelecteurFichier("Sélectionnez le fichier à lire", repertoirePrefere);
		final FileChooser fileChooser = selecteurFichier.getFileChooser();
		
		/* récupération du File sélectionné par l'utilisateur. */
		final File fichierChoisi = fileChooser.showOpenDialog(null);
		
		System.out.println("Fichier choisi : " + fichierChoisi.getAbsolutePath());
	}
	
	
	
	/**
	 * Getter de l'AnchorPane contenant l'ensemble du 
	 * panneau de saisie du texte (racine).<br/>
	 *
	 * @return this.saisieTexteAnchorPane : AnchorPane.<br/>
	 */
	public AnchorPane getSaisieTexteAnchorPane() {
		return this.saisieTexteAnchorPane;
	} // Fin de getSaisieTexteAnchorPane().________________________________


	
	/**
	* Setter de l'AnchorPane contenant l'ensemble du 
	* panneau de saisie du texte (racine).<br/>
	*
	* @param pSaisieTexteAnchorPane : AnchorPane : 
	* valeur à passer à this.saisieTexteAnchorPane.<br/>
	*/
	public void setSaisieTexteAnchorPane(
			final AnchorPane pSaisieTexteAnchorPane) {
		this.saisieTexteAnchorPane = pSaisieTexteAnchorPane;
	} // Fin de setSaisieTexteAnchorPane(...)._____________________________

	
	
	/**
	 * Getter du bouton pour afficher 
	 * le browser de sélection de fichier.<br/>
	 *
	 * @return lireFichierButton : Button.<br/>
	 */
	public Button getLireFichierButton() {
		return this.lireFichierButton;
	} // Fin de getLireFichierButton().____________________________________


	
	/**
	* Setter du bouton pour afficher 
	* le browser de sélection de fichier.<br/>
	*
	* @param pLireFichierButton : Button : 
	* valeur à passer à lireFichierButton.<br/>
	*/
	public void setLireFichierButton(
			final Button pLireFichierButton) {
		this.lireFichierButton = pLireFichierButton;
	} // Fin de setLireFichierButton(...)._________________________________


	
	/**
	 * Getter de la zone de texte pour 
	 * écrire ou afficher du texte.<br/>
	 *
	 * @return textArea : TextArea.<br/>
	 */
	public TextArea getTextArea() {
		return this.textArea;
	} // Fin de getTextArea()._____________________________________________


	
	/**
	* Setter de la zone de texte pour 
	* écrire ou afficher du texte.<br/>
	*
	* @param pTextArea : TextArea : 
	* valeur à passer à textArea.<br/>
	*/
	public void setTextArea(
			final TextArea pTextArea) {
		this.textArea = pTextArea;
	} // Fin de setTextArea(...).__________________________________________

	
	
} // FIN DE LA CLASSE SaisieTexteVueController.------------------------------
