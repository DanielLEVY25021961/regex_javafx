package levy.daniel.application.vues.desktop.metier.regex.saisiemotif;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * CLASSE <b>SaisieMotifMain</b> :<br/>
 * .<br/>
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
 * @since 27 août 2018
 *
 */
public class SaisieMotifMain extends Application {

	// ************************ATTRIBUTS************************************/

	/**
	 * GridPane.<br/>
	 */
	private final transient GridPane inputGridPane = new GridPane();
	
	
	/**
	 * SaisieMotifVueFxml.<br/>
	 */
	private final transient SaisieMotifVueFxml saisie = new SaisieMotifVueFxml(null);
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SaisieMotifMain.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public SaisieMotifMain() {
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
		rootGroup.setPrefSize(900d, 700d);
		rootGroup.setCenter(this.inputGridPane);

        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        /* Titre du théâtre. */
        pPrimaryStage.setTitle("Saisie de Motif");
        
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
				this.saisie.getSaisieMotifAnchorPane()
					, 0, 0
						, 1, 1
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
     
        this.inputGridPane.getChildren().addAll(
        		this.saisie.getSaisieMotifAnchorPane());
        
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


	
} // FIN DE LA CLASSE SaisieMotifMain.---------------------------------------
