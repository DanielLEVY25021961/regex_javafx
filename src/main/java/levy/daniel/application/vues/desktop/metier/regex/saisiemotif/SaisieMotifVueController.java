package levy.daniel.application.vues.desktop.metier.regex.saisiemotif;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import levy.daniel.application.MainApplication;
import levy.daniel.application.model.services.metier.regex.IRegexServiceStateless;
import levy.daniel.application.model.services.metier.regex.impl.RegexServiceStateless;


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
	 * label contenant une icône spécifiant si le motif est correct.<br/>
	 */
	@FXML
	private Label labelIcone;
	
	/**
	 * button pour effacer le contenu du Textfield.<br/>
	 */
	@FXML
	private Button buttonEffacerTextField;
	
	/**
	 * button pour enregistrer le contenu du Textfield dans.<br/>
	 */
	@FXML
	private Button buttonEnregistrerMotif;
	
	
	/**
	 * IRegexServiceStateless chargé de sélectionner 
	 * l'image à afficher dans labelIcone.<br/>
	 */
	private final transient IRegexServiceStateless service;
	
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
	 * <ul>
	 * <li>instancie</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	public SaisieMotifVueController() throws Exception {
		
		super();		
		
		this.service = new RegexServiceStateless();
		
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method initialize() :<br/>
	 * <ul>
	 * <li>Initialise le présent CONTROLLER DE VUE.</li>
	 * <li>Méthode <b>automatiquement appelée après que 
	 * le FXML ait été chargé (juste après le constructeur)</b>.</li>
	 * <li><b>permet d'instancier des modèles (contenu de JTable par exemple) 
	 * et de préparer les composants à afficher dans la VUE.</b></li>
	 * <li>permet de préparer les listeners (évènementiel).</li>
	 * </ul>
	 * @throws Exception 
	 */
	@FXML
    private void initialize() throws Exception {
		
		/* suit les changements dans this.textField. */
		this.ajouterPropertyChangeListenenerATextField();
		
		this.choisirIcone(false);
		
	} // Fin de initialize().______________________________________________


	
	/**
	 * <b>suit les changements dans this.textField</b>.<br/>
	 * <ul>
	 * <li>ajoute un ChangeListener à la textProperty 
	 * de this.textField.</li>
	 * <li>interroge le SERVICE pour connaitre l'image 
	 * à attribuer à this.labelIcone.</li>
	 * <li>sélectionne l'image en fonction de la réponse du SERVICE.</li>
	 * </ul>
	 */
	private void ajouterPropertyChangeListenenerATextField() {
		
		/* ajoute un ChangeListener à la textProperty de this.textField. */
		this.textField.textProperty().addListener(
				new ChangeListener<String>() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void changed(
					final ObservableValue<? extends String> pObservable
						, final String pOldValue
							, final String pNewValue) {
				
				/* interroge le SERVICE pour connaitre l'image 
				 * à attribuer à this.labelIcone. */
				final boolean motifRespecte 
					= SaisieMotifVueController
						.this.service.motifRespecteSyntaxeRegex(pNewValue);
				
				/* sélectionne l'image en fonction de la 
				 * réponse du SERVICE. */
				SaisieMotifVueController
					.this.choisirIcone(motifRespecte);
				
			} // Fin de changed(...)._____________________________
			
		}); // Fin de new ChangeListener<String>()._________________
		
	} // Fin de ajouterPropertyChangeListenenerATextField()._______________
	

	
	/**
	 * Sélectionne l'icône à afficher dans this.labelIcone 
	 * en fonction d'un boolean passé en paramètre.<br/>
	 * <ul>
	 * <li>affiche l'imageOK si pAfficherOK vaut true.</li>
	 * </ul>
	 *
	 * @param pAfficherOK : boolean.<br/>
	 */
	private void choisirIcone(
			final boolean pAfficherOK) {
		
		if (pAfficherOK) {
			this.labelIcone.setText("OK");
			this.labelIcone.setGraphic(this.fournirImageOK());
		} else {
			this.labelIcone.setText("KO");
			this.labelIcone.setGraphic(this.fournirImageKO());
		}
		
	} // Fin de choisirIcone(...)._________________________________________

	
	
	/**
	 * <b>crée et retourne l'image à afficher dans this.label 
	 * si this.afficherOK vaut true</b>.<br/>
	 * <ul>
	 * <li>crée un Stream vers l'image.</li>
	 * <li>crée une image redimensionnée.</li>
	 * <li>crée un ImageView.</li>
	 * <li>retourne l'ImageView.</li>
	 * </ul>
	 *
	 * @return : ImageView : imageViewOK.<br/>
	 */
	private ImageView fournirImageOK() {
		
		/* crée un Stream vers l'image. */
		final InputStream inputStreamOK 
			= getClass().getResourceAsStream(
					"/static/icones/check_ok_accept_apply_256_256.png");
		
		/* crée une image redimensionnée. */
		final Image imageOK 
			= new Image(inputStreamOK, 100d, 50d, true, true);
		
		/* crée un ImageView. */
		final ImageView imageViewOK 
			= new ImageView(imageOK);
		
		/* retourne l'ImageView. */
		return imageViewOK;
		
	} // Fin de fournirImageOK().__________________________________________
	

	
	/**
	 * <b>crée et retourne l'image à afficher dans this.label 
	 * si this.afficherOK vaut false</b>.<br/>
	 * <ul>
	 * <li>crée un Stream vers l'image.</li>
	 * <li>crée une image redimensionnée.</li>
	 * <li>crée un ImageView.</li>
	 * <li>retourne l'ImageView.</li>
	 * </ul>
	 *
	 * @return : ImageView : imageViewKO.<br/>
	 */
	private ImageView fournirImageKO() {
		
		/* crée un Stream vers l'image. */
		final InputStream inputStreamKO 
			= getClass().getResourceAsStream(
					"/static/icones/dialog-error-3_256_256.png");
		
		/* crée une image redimensionnée. */
		final Image imageKO 
			= new Image(inputStreamKO, 100d, 50d, true, true);
		
		/* crée un ImageView. */
		final ImageView imageViewKO
			= new ImageView(imageKO);
		
		/* retourne l'ImageView. */
		return imageViewKO;
		
	} // Fin de fournirImageKO().__________________________________________
	
	
	
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
	 * <b>efface le contenu de this.textField</b>.<br/>
	 */
	@FXML
	public void effacerTextField() {
		this.remplirTextField("");
	} // Fin de effacerTextField().________________________________________
	
	
	
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
	 * Getter du label contenant une icône spécifiant 
	 * si le motif est correct.<br/>
	 *
	 * @return this.labelIcone : Label.<br/>
	 */
	public Label getLabelIcone() {
		return this.labelIcone;
	} // Fin de getLabelIcone().___________________________________________


	
	/**
	* Setter du label contenant une icône spécifiant 
	* si le motif est correct.<br/>
	*
	* @param pLabelIcone : Label : 
	* valeur à passer à this.labelIcone.<br/>
	*/
	public void setLabelIcone(
			final Label pLabelIcone) {
		this.labelIcone = pLabelIcone;
	} // Fin de setLabelIcone(...).________________________________________



	/**
	 * Getter du button pour effacer le contenu du Textfield.<br/>
	 *
	 * @return this.buttonEffacerTextField : Button.<br/>
	 */
	public Button getButtonEffacerTextField() {
		return this.buttonEffacerTextField;
	} // Fin de getButtonEffacerTextField()._______________________________



	
	/**
	* Setter du button pour effacer le contenu du Textfield.<br/>
	*
	* @param pButtonEffacerTextField : Button : 
	* valeur à passer à this.buttonEffacerTextField.<br/>
	*/
	public void setButtonEffacerTextField(
			final Button pButtonEffacerTextField) {
		this.buttonEffacerTextField = pButtonEffacerTextField;
	} // Fin de setButtonEffacerTextField(...).____________________________



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
