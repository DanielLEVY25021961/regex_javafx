package levy.daniel.application.vues.desktop.metier.regex.saisiemotif;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import levy.daniel.application.MainApplication;
import levy.daniel.application.vues.desktop.metier.regex.saisietexte.SaisieTexteVueController;


/**
 * CLASSE SaisieMotifVueFxml :<br/>
 * prépare et retourne la VUE {@link AnchorPane} 
 * <b><code>this.saisieMotifAnchorPane</code></b> 
 * modélisant le panneau de <b>saisie d'un motif Regex Java</b>.<br/>
 * <b><code>this.saisieMotifAnchorPane</code></b> 
 * permet de <b>saisir un motif Regex Java</b> 
 * ou d'en créer un à l'aide d'un générateur dans un 
 * {@link TextField}.<br/>
 * <b><code>this.saisieTexteAnchorPane</code></b> permet d'enregistrer 
 * le contenu de la {@link TextArea} dans un fichier 
 * pour une utilisation ultérieure.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/saisie_texte_vue.png" 
 * alt="AnchorPane SaisieTexteVueFxml" border="1" align="center" />
 * <br/><br/>
 * <ul>
 * <li>charge dans sa méthode dessiner() le FXML.</li>
 * <li>fabrique la vue {@link AnchorPane} 
 * <b><code>this.saisieTexteAnchorPane</code></b></li>
 * <li>fabrique le CONTROLLER DE VUE {@link SaisieTexteVueController} 
 * <b><code>this.saisieTexteVueController</code></b></li>
 * <li>retourne la {@link TextArea} <b><code>this.textArea</code></b> 
 * encapsulée dans la VUE.</li>
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
public class SaisieMotifVueFxml {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * "Classe SaisieMotifVueFxml".<br/>
	 */
	public static final String CLASSE_SAISIEMOTIFVUEXML 
		= "Classe SaisieMotifVueFxml";
	
	/**
	 * "Méthode dessiner()".<br/>
	 */
	public static final String METHODE_DESSINER 
		= "Méthode dessiner()";
	
	/**
	 * panneau {@link AnchorPane} (VUE) modélisant un 
	 * panneau de saisie d'un motif Regex Java.<br/>
	 */
	private AnchorPane saisieMotifAnchorPane;
	
	/**
	 * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * <b>Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML et 
     * de paramétrer l'évènementiel</b>.<br/>
	 */
	private SaisieMotifVueController saisieMotifVueController;

	/**
	 * classe applicative 
	 * (hérite de {@link javafx.application.Application}).<br/>
	 */
	private MainApplication applicationMain;
	
	/**
	 * champ texte de la VUE.<br/>
	 */
	private TextField textField;
	
	/**
	 * " - ".<br/>
	 */
	public static final String TIRET = " - ";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SaisieMotifVueFxml.class);
	
	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>instancie la VUE <b><code>this.saisieMotifAnchorPane</code></b> 
	 * via un FXMLLoader. </li>
	 * <li>Le chargement via le FXMLLoader provoque automatiquement 
	 * l'instanciation du CONTROLLER DE VUE 
	 * <b><code>this.saisieTexteVueController</code></b> 
	 * et l'exécution de sa méthode <code>initialize()</code>.</li>
	 * <li>appelle this.dessiner()</li>
	 * </ul>
	 * 
	 * @param pApplicationMain : {@link javafx.application.Application}.<br/>
	 */
	public SaisieMotifVueFxml(
			final MainApplication pApplicationMain) {
		
		super();
		
		this.applicationMain = pApplicationMain;
		
		/* INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml. */
		this.dessiner();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method dessiner() :<br/>
	 * <ul>
	 * INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml.<br/>
	 * <li>instancie un {@link FXMLLoader}.</li>
	 * <li>positionne le FXMLLoader sur le bon fichier fxml.</li>
	 * <li>charge le fichier fxml et instancie le panneau 
	 * {@link AnchorPane} 
	 * <b><code>this.saisieMotifAnchorPane</code></b> (VUE) 
	 * modélisant un Panneau de saisie de motif.</li>
	 * <li>récupère le CONTROLLER de VUE auprès du FXMLLoader 
	 * et alimente l'attribut.</li>
	 * <li>passe la classe applicative au Controller de VUE 
	 * (Call Back).</li>
	 * <li>alimente <b><code>this.textField</code></b> avec l'attribut 
	 * du CONTROLLER DE VUE.</li>
	 * </ul>
	 */
	private void dessiner() {

		try {

			/* instancie un FXMLLoader. */
			final FXMLLoader loader = new FXMLLoader();
			
			final URL url = SaisieMotifVueFxml.class
					.getResource("SaisieMotifVue.fxml");
			
			/* positionne le FXMLLoader sur le bon fichier fxml. */
			loader.setLocation(url);

			/* charge le fichier fxml et instancie le panneau 
			 * AnchorPane (VUE) modélisant une Panneau 
			 * de saisie de texte.*/
			this.saisieMotifAnchorPane = (AnchorPane) loader.load();
			
			/* LOAD PROVOQUE UN APPEL AUTOMATIQUE DU CONSTRUCTEUR
			 * , PUIS DE LA METHODE initialize() 
			 * du CONTROLLER DE VUE. */
			
			/* récupère le CONTROLLER de VUE auprès du FXMLLoader. */
            this.recupererControllerDeVue(loader);
            
            /* passe la classe applicative au Controller (Call Back). */
            this.saisieMotifVueController
            	.setApplicationMain(this.applicationMain);
            
            /* alimente this.textArea avec l'attribut 
             * du CONTROLLER DE VUE. */
            this.textField = this.saisieMotifVueController.getTextField();
            						
		}
		catch (IOException e) {
			
			final String message 
				= CLASSE_SAISIEMOTIFVUEXML 
				+ TIRET 
				+ METHODE_DESSINER 
				+ TIRET 
				+ "Impossible de créer le AnchorPane (VUE) " 
						+ "à partir des fichiers XML";

			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, e);
			}

		}

	} // Fin de dessiner().________________________________________________
	

	
	/**
	 * récupère le CONTROLLER DE VUE {@link SaisieTexteVueController}
	 * <b><code>this.saisieMotifVueController</code></b> 
	 * auprès du FXMLLoader.<br/>
	 * <br/>
	 *
	 * @param pLoader : {@link FXMLLoader}.<br/>
	 */
	private void recupererControllerDeVue(
			final FXMLLoader pLoader) {
		
		this.saisieMotifVueController 
    		= (SaisieMotifVueController) pLoader.getController();
		
	} // Fin de recupererControllerDeVue(...)._____________________________
	

	
	/**
	 * Getter du panneau AnchorPane (VUE) modélisant un 
	 * panneau de saisie d'un motif.<br/>
	 *
	 * @return this.saisieMotifAnchorPane : {@link AnchorPane}.<br/>
	 */
	public AnchorPane getSaisieMotifAnchorPane() {
		return this.saisieMotifAnchorPane;
	} // Fin de getSaisieMotifAnchorPane().________________________________


	
	/**
	* Setter du panneau AnchorPane (VUE) modélisant un 
	* panneau de saisie d'un motif.<br/>
	*
	* @param pSaisieMotifAnchorPane : {@link AnchorPane} : 
	* valeur à passer à saisieMotifAnchorPane.<br/>
	*/
	public void setSaisieMotifAnchorPane(
			final AnchorPane pSaisieMotifAnchorPane) {
		this.saisieMotifAnchorPane = pSaisieMotifAnchorPane;
	} // Fin de setSaisieMotifAnchorPane(...)._____________________________


	
	/**
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * <b>Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML et de paramétrer l'évènementiel</b>.<br/>
	 *
	 * @return this.saisieMotifVueController : 
	 * {@link SaisieMotifVueController}.<br/>
	 */
	public SaisieMotifVueController getSaisieMotifVueController() {
		return this.saisieMotifVueController;
	} // Fin de getSaisieMotifVueController()._____________________________


	
	/**
	* Setter du CONTROLLER DE VUE fabriqué automatiquement lors du 
    * chargement du FXML par le FXMLLoader.<br/>
    * Permet d'accéder aux objets graphiques de 
    * la VUE générés par le FXML.<br/>
	*
	* @param pSaisieMotifVueController : {@link SaisieMotifVueController} : 
	* valeur à passer à this.saisieMotifVueController.<br/>
	*/
	public void setSaisieMotifVueController(
			final SaisieMotifVueController pSaisieMotifVueController) {
		this.saisieMotifVueController = pSaisieMotifVueController;
	} // Fin de setSaisieMotifVueController(...).__________________________


	
	/**
	 * Getter de la classe applicative.<br/>
	 *
	 * @return this.applicationMain : {@link MainApplication}.<br/>
	 */
	public MainApplication getApplicationMain() {
		return this.applicationMain;
	} // Fin de getApplicationMain().______________________________________


	
	/**
	* Setter de la classe applicative.<br/>
	*
	* @param pApplicationMain : {@link MainApplication} : 
	* valeur à passer à this.applicationMain.<br/>
	*/
	public void setApplicationMain(
			final MainApplication pApplicationMain) {
		this.applicationMain = pApplicationMain;
	} // Fin de setApplicationMain(...).___________________________________


	
	/**
	 * Getter du champ de texte de la VUE.<br/>
	 *
	 * @return this.textField : {@link TextField}.<br/>
	 */
	public TextField getTextField() {
		return this.textField;
	} // Fin de getTextField().____________________________________________


	
	/**
	* Setter du champ de texte de la VUE.<br/>
	*
	* @param pTextField : {@link TextField} : 
	* valeur à passer à this.textField.<br/>
	*/
	public void setTextField(
			final TextField pTextField) {
		this.textField = pTextField;
	} // Fin de setTextField(...)._________________________________________

	
	
} // FIN DE LA CLASSE SaisieMotifVueFxml.------------------------------------
