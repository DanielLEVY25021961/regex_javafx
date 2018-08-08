package levy.daniel.application.vues.desktop.metier.regex.saisietexte;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * CLASSE SaisieTexteVueFxml :<br/>
 * prépare la VUE AnchorPane <b>this.saisieTexteAnchorPane</b> 
 * modélisant le panneau de saisie d'un texte.<br/>
 * <ul>
 * <li>charge dans sa méthode dessiner() le FXML.</li>
 * <li></li>
 * <li></li>
 * <li></li>
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
	 * panneau AnchorPane (VUE) modélisant un 
	 * panneau de saisie d'un texte.<br/>
	 */
	private AnchorPane saisieTexteAnchorPane;
	
	/**
	 * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 */
	private SaisieTexteVueController saisieTexteVueController;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SaisieTexteVueFxml.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <ul>
	 * <li>instancie la VUE this.saisieTexteAnchorPane 
	 * via un FXMLLoader. </li>
	 * <li>Le chargement via le FXMLLoader provoque automatiquement 
	 * l'instanciation du CONTROLLER DE VUE 
	 * this.saisieTexteVueController 
	 * et l'exécution de sa méthode initialize().</li>
	 * </ul>
	 */
	public SaisieTexteVueFxml() {
		
		super();
		
		/* INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml. */
		this.dessiner();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method dessiner() :<br/>
	 * <ul>
	 * INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml.<br/>
	 * <li>instancie un FXMLLoader.</li>
	 * <li>positionne le FXMLLoader sur le bon fichier fxml.</li>
	 * <li>charge le fichier fxml et instancie le panneau 
	 * AnchorPane (VUE) modélisant un Panneau de saisie de texte.</li>
	 * <li>récupère le CONTROLLER de VUE auprès du FXMLLoader 
	 * et alimente l'attribut.</li>
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
	 * récupère le CONTROLLER DE VUE auprès du FXMLLoader.<br/>
	 * <br/>
	 *
	 * @param pLoader : FXMLLoader.<br/>
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
	 * @return this.saisieTexteAnchorPane : AnchorPane.<br/>
	 */
	public AnchorPane getSaisieTexteAnchorPane() {
		return this.saisieTexteAnchorPane;
	} // Fin de getSaisieTexteAnchorPane().________________________________


	
	/**
	* Setter du panneau AnchorPane (VUE) modélisant un 
	* panneau de saisie d'un texte.<br/>
	*
	* @param pSaisieTexteAnchorPane : AnchorPane : 
	* valeur à passer à saisieTexteAnchorPane.<br/>
	*/
	public void setSaisieTexteAnchorPane(
			final AnchorPane pSaisieTexteAnchorPane) {
		this.saisieTexteAnchorPane = pSaisieTexteAnchorPane;
	} // Fin de setSaisieTexteAnchorPane(...)._____________________________


	
	/**
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 *
	 * @return this.saisieTexteVueController : 
	 * SaisieTexteVueController.<br/>
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
	* @param pSaisieTexteVueController : SaisieTexteVueController : 
	* valeur à passer à this.saisieTexteVueController.<br/>
	*/
	public void setSaisieTexteVueController(
			final SaisieTexteVueController pSaisieTexteVueController) {
		this.saisieTexteVueController = pSaisieTexteVueController;
	} // Fin de setSaisieTexteVueController(...).__________________________

	

} // FIN DE LA CLASSE SaisieTexteVueFxml.------------------------------------
