package levy.daniel.application.vues.desktop.metier.regex.selecteurfichier;



import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.metier.regex.selecteurfichier.utils.GestionnairePreferencesSelecteur;

/**
 * CLASSE SelecteurFichierMain :<br/>
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
 * @since 10 août 2018
 *
 */
public class SelecteurFichierMain extends Application {

	// ************************ATTRIBUTS************************************/

	/**
	 * Emulateur de bureau Windows.<br/>
	 * permet d'ouvrir un fichier comme dans Windows
	 */
	private final transient Desktop desktop = Desktop.getDesktop();
	
	/**
	 * bouton d'ouverture du FileChooser.<br/>
	 */
	private final transient Button openButton 
		= new Button("Sélectionner un fichier");
	
	/**
	 * GridPane.<br/>
	 */
	private final transient GridPane inputGridPane = new GridPane();
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SelecteurFichierMain.class);
	
	
	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public SelecteurFichierMain() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(
			final Stage pPrimaryStage) throws Exception {
		
		this.configurerButton(pPrimaryStage);
		this.configurerGridPane();
		
		final Pane rootGroup = new VBox(12);		
        rootGroup.getChildren().addAll(this.inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        pPrimaryStage.setScene(new Scene(rootGroup));
        
        pPrimaryStage.show();

	} // Fin de start(...).________________________________________________


	

	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pPrimaryStage : Stage :  .<br/>
	 */
	private void configurerButton(
			final Stage pPrimaryStage) {
		
		this.openButton.setOnAction(
	            new EventHandler<ActionEvent>() {
	            	
	                @Override
	                public void handle(final ActionEvent pEvent) {
	                    
	                	final String titre = "Sélectionnez un fichier";
	                	File repertoirePrefere;
	                	
						try {
							
							repertoirePrefere = GestionnairePreferencesSelecteur
	                			.getRepertoirePrefereFileChooser();
							
							final ISelecteurFichier selecteur 
	                			= new SelecteurFichier(
	                					titre, repertoirePrefere);
	                	
		                    selecteur.selectionnerEtLire(pPrimaryStage);
		                    
		                    final File file = selecteur.getFichierSelectionne();
		                    
		                    if (file != null) {
		                    	try {
		                    		
		                    		/* Ouvre le fichier avec le lecteur 
		                    		 * MIME adapté sous Windows. */
									SelecteurFichierMain.this.desktop.open(file);
									
								} catch (IOException e) {
									e.printStackTrace();
								}
		                    }
		                    
						} catch (Exception e1) {
							e1.printStackTrace();
						}
	                }
	            });
	}
	
	
	
	/**
	 * configure le GridPane.<br/>
	 * <ul>
	 * <li>ajoute this.openButton au GridPane this.inputGridPane</li>
	 * </ul>
	 */
	private void configurerGridPane() {
		
		GridPane.setConstraints(this.openButton, 0, 1);

        this.inputGridPane.setHgap(6);
        this.inputGridPane.setVgap(6);
        
        this.inputGridPane.getChildren().addAll(this.openButton);
        
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

		
	
} // FIN DE LA CLASSE SelecteurFichierMain.----------------------------------
