package levy.daniel.application.vues.desktop.metier.regex.saisietexte;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import levy.daniel.application.MainApplication;
import levy.daniel.application.vues.desktop.metier.regex.enregistreurfichier.EnregistreurFichier;
import levy.daniel.application.vues.desktop.metier.regex.enregistreurfichier.IEnregistreurFichier;
import levy.daniel.application.vues.desktop.metier.regex.selecteurfichier.ISelecteurFichier;
import levy.daniel.application.vues.desktop.metier.regex.selecteurfichier.SelecteurFichier;
import levy.daniel.application.vues.desktop.utilitaires.gestionnairepreferencesselecteur.GestionnairePreferencesSelecteur;


/**
 * CLASSE <b>SaisieTexteVueController</b> :<br/>
 * CONTROLLER de la VUE <b>{@link SaisieTexteVueFxml}</b> 
 * créée par le chargement du fichier XML <b>SaisieTexteVue.fxml</b>.<br/>
 * <ul>
 * <li><b>Permet d'accéder en JAVA aux objets graphiques de la VUE 
 * générée par le fxml</b>.</li>
 * <li>la VUE générée par <b>SaisieTexteVue.fxml</b> est 
 * l' {@link AnchorPane} 
 * <b>this.saisieTexteAnchorPane</b></li>
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
	 * bouton pour effacer le contenu de la zone de texte 
	 * <code>this.textArea</code>.<br/>
	 */
	@FXML
	private Button effacerButton;

	/**
	 * bouton pour enregistrer le contenu 
	 * de la zone de texte dans un fichier.<br/>
	 */
	@FXML
	private Button enregistrerFichierButton;

	/**
	 * zone de texte pour écrire ou afficher du texte.<br/>
	 */
	@FXML
	private TextArea textArea;
	
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
	 * répertoire d'ouverture des FileChooser stocké 
	 * dans un fichier properties de préférences.<br/>
	 */
	private transient File repertoirePrefere;
	
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
	 * <li>Méthode <b>automatiquement appelée après que 
	 * le FXML ait été chargé (juste après le constructeur)</b>.</li>
	 * <li><b>permet d'instancier des modèles (contenu de JTable par exemple) 
	 * et de préparer les composants à afficher dans la VUE.</b></li>
	 * <li>récupère le répertoire d'ouverture des FileChooser 
	 * <code>this.repertoirePrefere</code> dans les préférences.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@FXML
    private void initialize() throws Exception {
		
		/* récupère le répertoire d'ouverture des FileChooser 
		 * dans les préférences. */
		this.repertoirePrefere 
			= GestionnairePreferencesSelecteur
				.getRepertoirePrefereFileChooser();
		
	} // Fin de initialize().______________________________________________


	
	/**
	 * OnClick sur bouton <code>this.lireFichierButton</code> : 
	 * Ouvre un FileChooser, permet de sélectionner un fichier textuel 
	 * et d'injecter son contenu dans <code>this.textArea</code>.<br/>
	 * <ul>
	 * <li><b>méthode évènementielle.</b></li>
	 * <li>instancie un {@link SelecteurFichier} et 
	 * configure son FileChooser.</li>
	 * <li>affiche le FileChooser, permet la sélection d'un fichier 
	 * et retourne son contenu.</li>
	 * <li>met à jour <code>this.repertoirePrefere</code> avec le 
	 * dernier répertoire sélectionné.</li>
	 * <li>remplit <code>this.textArea</code> avec le contenu.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@FXML
	public final void lireFichier() throws Exception {
		
		/* instancie un SelecteurFichier et configure son FileChooser. */
		final ISelecteurFichier selecteurFichier 
			= new SelecteurFichier(
					"Sélectionnez le fichier à lire"
						, this.repertoirePrefere);
		
		/* affiche le FileChooser, permet la sélection 
		 * d'un fichier et retourne son contenu. */
		final String contenu 
			= selecteurFichier.selectionnerEtLire(this.stage);
		
		/* met à jour this.repertoirePrefere avec le 
		 * dernier répertoire sélectionné. */
		this.repertoirePrefere = selecteurFichier.getRepertoirePrefere();
		
		/* remplit this.textArea avec le contenu. */
		this.remplirTextArea(contenu);
		
	} // Fin de lireFichier()._____________________________________________
	

	
	/**
	 * OnClick sur bouton <code>this.enregistrerFichierButton</code> : 
	 * Ouvre un FileChooser, permet de définir ou sélectionner un fichier 
	 * et d'y injecter le contenu de <code>this.textArea</code>.<br/>
	 * <ul>
	 * <li><b>méthode évènementielle.</b></li>
	 * <li>instancie un {@link EnregistreurFichier} et 
	 * configure son FileChooser.</li>
	 * <li>récupère le contenu textuel dans this.textArea.</li>
	 * <li>affiche le FileChooser, permet la définition ou 
	 * sélection d'un fichier et y écrit le contenu 
	 * de <code>this.textArea</code>.</li>
	 * <li>met à jour <code>this.repertoirePrefere</code> avec le 
	 * dernier répertoire sélectionné.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	public final void enregistrerFichier() throws Exception {
		
		/* instancie un EnregistreurFichier et configure son FileChooser. */
		final String titre 
			= "Définissez ou Sélectionnez un fichier "
					+ "dans lequel enregistrer";
		
		final IEnregistreurFichier enregistreur 
			= new EnregistreurFichier(titre, this.repertoirePrefere);
		
		/* récupère le contenu textuel dans this.textArea. */
		final String contenu = this.recupererContenuTextArea();
		
		/* affiche le FileChooser, permet la définition ou 
		 * sélection d'un fichier et y écrit le contenu 
		 * de this.textArea.*/
		enregistreur.selectionnerEtEnregistrer(this.stage, contenu);
		
		/* met à jour this.repertoirePrefere avec le 
		 * dernier répertoire sélectionné. */
		this.repertoirePrefere = enregistreur.getRepertoirePrefere();
		
	} // Fin de enregistrerFichier().______________________________________
	
	
	
	/**
	 * retourne le contenu de <code>this.textArea</code>.<br/>
	 *
	 * @return : String  : <code>this.textArea.getText();</code>.<br/>
	 */
	private String recupererContenuTextArea() {
		return this.textArea.getText();
	} // Fin de recupererContenuTextArea().________________________________
	
	
	
	/**
	 * Injecte le texte pString dans this.textArea.<br/>
	 * <ul>
	 * <li>ne fait rien si pString == null.</li>
	 * </ul>
	 *
	 * @param pString : String.<br/>
	 */
	private void remplirTextArea(
			final String pString) {
		
		/* ne fait rien si pString == null. */
		if (pString != null) {
			this.textArea.setText(pString);
		}
		
	} // Fin de remplirTextArea(...).______________________________________
	

	
	/**
	 * OnClick sur bouton <code>this.effacerButton</code> : 
	 * <b>vide <code>this.textArea</code></b>.<br/>
	 * <ul>
	 * <li><b>méthode évènementielle.</b></li>
	 * </ul>
	 */
	@FXML
	public final void  effacerTextArea() {
		this.textArea.setText("");
	} // Fin de effacerTextArea().________________________________________
	
	
	
	/**
	 * Getter de l' {@link AnchorPane} contenant l'ensemble du 
	 * panneau de saisie du texte (racine).<br/>
	 *
	 * @return this.saisieTexteAnchorPane : AnchorPane.<br/>
	 */
	public AnchorPane getSaisieTexteAnchorPane() {
		return this.saisieTexteAnchorPane;
	} // Fin de getSaisieTexteAnchorPane().________________________________


	
	/**
	* Setter de l' {@link AnchorPane} contenant l'ensemble du 
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
	 * @return this.lireFichierButton : {@link Button}.<br/>
	 */
	public Button getLireFichierButton() {
		return this.lireFichierButton;
	} // Fin de getLireFichierButton().____________________________________


	
	/**
	* Setter du bouton pour afficher 
	* le browser de sélection de fichier.<br/>
	*
	* @param pLireFichierButton : {@link Button} : 
	* valeur à passer à this.lireFichierButton.<br/>
	*/
	public void setLireFichierButton(
			final Button pLireFichierButton) {
		this.lireFichierButton = pLireFichierButton;
	} // Fin de setLireFichierButton(...)._________________________________



	/**
	 * Getter du bouton pour effacer 
	 * le contenu de la zone de texte <code>this.textArea</code>.<br/>
	 *
	 * @return this.effacerButton : {@link Button}.<br/>
	 */
	public Button getEffacerButton() {
		return this.effacerButton;
	} // Fin de getEffacerButton().________________________________________


	
	/**
	* Setter du bouton pour effacer 
	* le contenu de la zone de texte <code>this.textArea</code>.<br/>
	*
	* @param pEffacerButton : {@link Button} : 
	* valeur à passer à this.effacerButton.<br/>
	*/
	public void setEffacerButton(
			final Button pEffacerButton) {
		this.effacerButton = pEffacerButton;
	} // Fin de setEffacerButton(...)._____________________________________


	
	/**
	 * Getter du bouton pour enregistrer le 
	 * contenu de la zone de texte dans un fichier.<br/>
	 *
	 * @return this.enregistrerFichierButton : {@link Button}.<br/>
	 */
	public Button getEnregistrerFichierButton() {
		return this.enregistrerFichierButton;
	} // Fin de getEnregistrerFichierButton()._____________________________


	
	/**
	* Setter du bouton pour enregistrer le 
	* contenu de la zone de texte dans un fichier.<br/>
	*
	* @param pEnregistrerFichierButton : {@link Button} : 
	* valeur à passer à this.enregistrerFichierButton.<br/>
	*/
	public void setEnregistrerFichierButton(
			final Button pEnregistrerFichierButton) {
		this.enregistrerFichierButton = pEnregistrerFichierButton;
	} // Fin de setEnregistrerFichierButton(...).__________________________



	/**
	 * Getter de la zone de texte pour 
	 * écrire ou afficher du texte.<br/>
	 *
	 * @return this.textArea : {@link TextArea}.<br/>
	 */
	public TextArea getTextArea() {
		return this.textArea;
	} // Fin de getTextArea()._____________________________________________


	
	/**
	* Setter de la zone de texte pour 
	* écrire ou afficher du texte.<br/>
	*
	* @param pTextArea : {@link TextArea} : 
	* valeur à passer à this.textArea.<br/>
	*/
	public void setTextArea(
			final TextArea pTextArea) {
		this.textArea = pTextArea;
	} // Fin de setTextArea(...).__________________________________________

	
	
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
		if (this.applicationMain != null) {
			this.stage = this.applicationMain.getPrimaryStage();
		}

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


	
	/**
	 * Getter répertoire d'ouverture des FileChooser stocké 
	 * dans un fichier properties de préférences.<br/>
	 *
	 * @return this.repertoirePrefere : {@link File}.<br/>
	 */
	public File getRepertoirePrefere() {
		return this.repertoirePrefere;
	} // Fin de getRepertoirePrefere().____________________________________

	
	
} // FIN DE LA CLASSE SaisieTexteVueController.------------------------------
