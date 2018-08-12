package levy.daniel.application.vues.desktop.metier.regex.saisietexte;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import levy.daniel.application.MainApplication;

/**
 * <b>CLASSE SaisieTexteVueFxml</b> :<br/>
 * prépare et retourne la VUE {@link AnchorPane} 
 * <b><code>this.saisieTexteAnchorPane</code></b> 
 * modélisant le panneau de <b>saisie d'un texte</b>.<br/>
 * <b><code>this.saisieTexteAnchorPane</code></b> 
 * permet de <b>saisir un texte</b> 
 * ou d'importer le contenu d'un fichier textuel dans une 
 * {@link TextArea}.<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 8 août 2018
 *
 */
public class SaisieTexteVueFxml {

	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe SaisieTexteVueFxml".<br/>
	 */
	public static final String CLASSE_SAISIETEXTEVUEXML 
		= "Classe SaisieTexteVueFxml";
	
	/**
	 * "Méthode dessiner()".<br/>
	 */
	public static final String METHODE_DESSINER 
		= "Méthode dessiner()";
	
	/**
	 * " - ".<br/>
	 */
	public static final String TIRET = " - ";
	
	/**
	 * panneau {@link AnchorPane} (VUE) modélisant un 
	 * panneau de saisie d'un texte.<br/>
	 */
	private AnchorPane saisieTexteAnchorPane;
	
	/**
	 * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * <b>Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML et 
     * de paramétrer l'évènementiel</b>.<br/>
	 */
	private SaisieTexteVueController saisieTexteVueController;

	/**
	 * classe applicative 
	 * (hérite de {@link javafx.application.Application}).<br/>
	 */
	private MainApplication applicationMain;
	
	/**
	 * Zone de texte de la VUE.<br/>
	 */
	private TextArea textArea;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SaisieTexteVueFxml.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>instancie la VUE <b><code>this.saisieTexteAnchorPane</code></b> 
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
	public SaisieTexteVueFxml(
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
	 * <b><code>this.saisieTexteAnchorPane</code></b> (VUE) 
	 * modélisant un Panneau de saisie de texte.</li>
	 * <li>récupère le CONTROLLER de VUE auprès du FXMLLoader 
	 * et alimente l'attribut.</li>
	 * <li>passe la classe applicative au Controller de VUE 
	 * (Call Back).</li>
	 * <li>alimente <b><code>this.textArea</code></b> avec l'attribut 
	 * du CONTROLLER DE VUE.</li>
	 * </ul>
	 */
	private void dessiner() {

		try {

			/* instancie un FXMLLoader. */
			final FXMLLoader loader = new FXMLLoader();
			
			final URL url = SaisieTexteVueFxml.class
					.getResource("SaisieTexteVue.fxml");
			
			/* positionne le FXMLLoader sur le bon fichier fxml. */
			loader.setLocation(url);

			/* charge le fichier fxml et instancie le panneau 
			 * AnchorPane (VUE) modélisant une Panneau 
			 * de saisie de texte.*/
			this.saisieTexteAnchorPane = (AnchorPane) loader.load();
			
			/* LOAD PROVOQUE UN APPEL AUTOMATIQUE DU CONSTRUCTEUR
			 * , PUIS DE LA METHODE initialize() 
			 * du CONTROLLER DE VUE. */
			
			/* récupère le CONTROLLER de VUE auprès du FXMLLoader. */
            this.recupererControllerDeVue(loader);
            
            /* passe la classe applicative au Controller (Call Back). */
            this.saisieTexteVueController
            	.setApplicationMain(this.applicationMain);
            
            /* alimente this.textArea avec l'attribut 
             * du CONTROLLER DE VUE. */
            this.textArea = this.saisieTexteVueController.getTextArea();
            						
		}
		catch (IOException e) {
			
			final String message 
				= CLASSE_SAISIETEXTEVUEXML 
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
	 * <b><code>this.saisieTexteVueController</code></b> 
	 * auprès du FXMLLoader.<br/>
	 * <br/>
	 *
	 * @param pLoader : {@link FXMLLoader}.<br/>
	 */
	private void recupererControllerDeVue(
			final FXMLLoader pLoader) {
		
		this.saisieTexteVueController 
    		= (SaisieTexteVueController) pLoader.getController();
		
	} // Fin de recupererControllerDeVue(...)._____________________________
	

	
	/**
	 * Getter du panneau AnchorPane (VUE) modélisant un 
	 * panneau de saisie d'un texte.<br/>
	 *
	 * @return this.saisieTexteAnchorPane : {@link AnchorPane}.<br/>
	 */
	public AnchorPane getSaisieTexteAnchorPane() {
		return this.saisieTexteAnchorPane;
	} // Fin de getSaisieTexteAnchorPane().________________________________


	
	/**
	* Setter du panneau AnchorPane (VUE) modélisant un 
	* panneau de saisie d'un texte.<br/>
	*
	* @param pSaisieTexteAnchorPane : {@link AnchorPane} : 
	* valeur à passer à saisieTexteAnchorPane.<br/>
	*/
	public void setSaisieTexteAnchorPane(
			final AnchorPane pSaisieTexteAnchorPane) {
		this.saisieTexteAnchorPane = pSaisieTexteAnchorPane;
	} // Fin de setSaisieTexteAnchorPane(...)._____________________________


	
	/**
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * <b>Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML et de paramétrer l'évènementiel</b>.<br/>
	 *
	 * @return this.saisieTexteVueController : 
	 * {@link SaisieTexteVueController}.<br/>
	 */
	public SaisieTexteVueController getSaisieTexteVueController() {
		return this.saisieTexteVueController;
	} // Fin de getSaisieTexteVueController()._____________________________


	
	/**
	* Setter du CONTROLLER DE VUE fabriqué automatiquement lors du 
    * chargement du FXML par le FXMLLoader.<br/>
    * Permet d'accéder aux objets graphiques de 
    * la VUE générés par le FXML.<br/>
	*
	* @param pSaisieTexteVueController : {@link SaisieTexteVueController} : 
	* valeur à passer à this.saisieTexteVueController.<br/>
	*/
	public void setSaisieTexteVueController(
			final SaisieTexteVueController pSaisieTexteVueController) {
		this.saisieTexteVueController = pSaisieTexteVueController;
	} // Fin de setSaisieTexteVueController(...).__________________________


	
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
	 * Getter de la Zone de texte de la VUE.<br/>
	 *
	 * @return this.textArea : {@link TextArea}.<br/>
	 */
	public TextArea getTextArea() {
		return this.textArea;
	} // Fin de getTextArea()._____________________________________________


	
	/**
	* Setter de la Zone de texte de la VUE.<br/>
	*
	* @param pTextArea : {@link TextArea} : 
	* valeur à passer à this.textArea.<br/>
	*/
	public void setTextArea(
			final TextArea pTextArea) {
		this.textArea = pTextArea;
	} // Fin de setTextArea(...).__________________________________________

		

} // FIN DE LA CLASSE SaisieTexteVueFxml.------------------------------------
