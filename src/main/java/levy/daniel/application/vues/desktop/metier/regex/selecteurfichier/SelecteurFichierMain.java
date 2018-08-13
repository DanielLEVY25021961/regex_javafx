package levy.daniel.application.vues.desktop.metier.regex.selecteurfichier;



import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.utilitaires.gestionnairepreferencesselecteur.GestionnairePreferencesSelecteur;

/**
 * <b>CLASSE SelecteurFichierMain</b> :<br/>
 * Classe <i>applicative</i> permettant d'afficher un bouton ouvrant 
 * un {@link FileChooser} (encapsulé dans un {@link SelecteurFichier}) pour 
 * <b>lire le contenu d'un fichier</b>.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/Lanceur de FileChooser.png" 
 * alt="fenêtre lanceur de FileChooser de sélection" border="1" align="center" />
 * <br/><br/>
 * Après appui sur le bouton "Sélectionner un fichier"
 * , le FileChooser s'ouvre pour permettre de sélectionner 
 * un fichier simple :
 * <br/><br/>
 * <img src="../../../../../../../../../../../javadoc/images/FileChooser-Sélectionnez un fichier.png" 
 * alt="FileChooser de sélection de fichier" border="1" align="center" />
 * <br/><br/>
 * > Ouvrir > Le Desktop ouvre alors le fichier sélectionné 
 * avec l'application adaptée au type MIME sur la machine.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/SelectionnerFichier_Resultat.png" 
 * alt="Résultat de la sélection" border="1" align="center" />
 * <br/><br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * se lance comme une application Java.<br/>
 * <br/>
 * 
 * - Mots-clé :<br/>
 * bouton, Button, évènementiel, FileChooser, <br/>
 * java.awt.Desktop, emulateur Windows, ouvrir un fichier type MIME, <br/>
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
	 * avec l'application adaptée au type MIME d'un fichier
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
		
		final BorderPane rootGroup = new BorderPane();
		rootGroup.setPrefSize(400d, 100d);
		rootGroup.setCenter(this.inputGridPane);

        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        /* Titre du théâtre. */
        pPrimaryStage.setTitle("Lanceur de FileChooser");
        
        final Scene scene = new Scene(rootGroup);
        
        pPrimaryStage.setScene(scene);
        
        pPrimaryStage.show();

	} // Fin de start(...).________________________________________________


	

	/**
	 * Configure le Button pour qu'il ouvre le FileChooser 
	 * sur un click.<br/>
	 * <ul>
	 * <li>récupère le répertoire mémorisé auprès du 
	 * GestionnairePreferencesSelecteur.</li>
	 * <li>instancie un SelecteurFichier en 
	 * configurant son FileChooser.</li>
	 * <li>ouvre le FileChooser, permet la sélection 
	 * d'un fichier et lit son contenu.</li>
	 * <li>récupère le fichier sélectionné.</li>
	 * <li>ouvre le fichier sélectionné avec l'application 
	 * correspondant à son type MIME.</li>
	 * </ul>
	 *
	 * @param pPrimaryStage : Stage.<br/>
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
							
							/* récupère le répertoire mémorisé auprès du 
							 * GestionnairePreferencesSelecteur. */
							repertoirePrefere = GestionnairePreferencesSelecteur
	                			.getRepertoirePrefereFileChooser();
							
							/* instancie un SelecteurFichier en configurant 
							 * son FileChooser.*/
							final ISelecteurFichier selecteur 
	                			= new SelecteurFichier(
	                					titre, repertoirePrefere);
							
							/* ouvre le FileChooser, permet la sélection 
							 * d'un fichier et lit son contenu. */
		                    selecteur.selectionnerEtLire(pPrimaryStage);
		                    
		                    /* récupère le fichier sélectionné. */
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
		
	} // Fin de configurerButton(...)._____________________________________
	
	
	
	/**
	 * configure le GridPane.<br/>
	 * <ul>
	 * <li>ajoute this.openButton au GridPane this.inputGridPane</li>
	 * </ul>
	 */
	private void configurerGridPane() {
		
		GridPane.setConstraints(
				this.openButton
					, 0, 0
						, 1, 1
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
     
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
