package levy.daniel.application.vues.desktop.metier.regex.saisietexte;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * CLASSE <b>SaisieTexteMain</b> :<br/>
 * Classe <i>applicative</i> permettant d'afficher une {@link TextArea} 
 * (encapsulée dans un {@link SaisieTexteVueFxml}) pour 
 * <b>écrire un texte</b>.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/saisie_texte.png" 
 * alt="fenêtre Saisie de Texte" border="1" align="center" />
 * <br/><br/>
 * <ul>
 * <li></li>
 * <li></li>
 * <li></li>
 * <li></li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * se lance comme une application Java.<br/>
 * <br/>
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
 * @since 27 août 2018
 *
 */
public class SaisieTexteMain extends Application {

	// ************************ATTRIBUTS************************************/

	/**
	 * GridPane.<br/>
	 */
	private final transient GridPane inputGridPane = new GridPane();
	
	
	/**
	 * SaisieTexteVueFxml.<br/>
	 */
	private final transient SaisieTexteVueFxml saisie = new SaisieTexteVueFxml(null);
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SaisieTexteMain.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public SaisieTexteMain() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(
			final Stage pPrimaryStage) throws Exception {
		
		this.configurerGridPane();
		
		final BorderPane rootGroup = new BorderPane();
		rootGroup.setPrefSize(800d, 300d);
		rootGroup.setCenter(this.inputGridPane);

        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        /* Titre du théâtre. */
        pPrimaryStage.setTitle("Saisie de Texte");
        
        final Scene scene = new Scene(rootGroup);
        
        pPrimaryStage.setScene(scene);
        
        pPrimaryStage.show();

	} // Fin de start(...).________________________________________________


	
	/**
	 * configure le GridPane.<br/>
	 * <ul>
	 * <li>ajoute this.openButton au GridPane this.inputGridPane</li>
	 * </ul>
	 */
	private void configurerGridPane() {
		
		GridPane.setConstraints(
				this.saisie.getSaisieTexteAnchorPane()
					, 0, 0
						, 1, 1
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
     
        this.inputGridPane.getChildren().addAll(
        		this.saisie.getSaisieTexteAnchorPane());
        
	} // Fin de configurerGridPane().______________________________________
	

	
	/**
	 * Point d'entrée de l'application.<br/>
	 *
	 * @param pArgs : String[].<br/>
	 */
	public static void main(
			final String[] pArgs) {
        Application.launch(pArgs);
    } // Fin de main(...)._________________________________________________

		
	
} // FIN DE LA CLASSE SaisieTexteMain.---------------------------------------
