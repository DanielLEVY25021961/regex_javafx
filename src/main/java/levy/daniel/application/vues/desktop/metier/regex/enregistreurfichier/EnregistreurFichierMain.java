package levy.daniel.application.vues.desktop.metier.regex.enregistreurfichier;

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
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.utilitaires.gestionnairepreferencesselecteur.GestionnairePreferencesSelecteur;


/**
 * <b>CLASSE EnregistreurFichierMain</b> :<br/>
 * Classe <i>applicative</i> permettant d'afficher un bouton ouvrant 
 * un {@link FileChooser} (encapsulé dans un 
 * {@link EnregistreurFichier}) pour 
 * <b>enregistrer un contenu dans un fichier</b>.<br/>
 * Affiche également une {@link TextArea} pour saisir un contenu.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/panneau_enregistrer_fichier.png" 
 * alt="fenêtre lanceur de FileChooser d'enregistrement" border="1" align="center" />
 * <br/><br/>
 * Après avoir inséré du texte dans la TextArea et 
 * appui sur le bouton "Enregistrer un fichier"
 * , le FileChooser s'ouvre pour permettre de définir 
 * un fichier simple :
 * <br/><br/>
 * <img src="../../../../../../../../../../../javadoc/images/FileChooser_enregistrer_fichier.png" 
 * alt="FileChooser d'enregistrement de fichier" border="1" align="center" />
 * <br/><br/>
 * > Enregistrer > Le Desktop ouvre alors le fichier enregistré 
 * avec l'application adaptée au type MIME sur la machine.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/resultat_enregistrer_fichier.png" 
 * alt="Résultat de l'enregistrement" border="1" align="center" />
 * <br/><br/>
 * <br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * se lance comme une application Java.<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * bouton, Button, évènementiel, FileChooser, <br/>
 * java.awt.Desktop, emulateur Windows, ouvrir un fichier type MIME, <br/>
 * Enregistrer Fichier, enregistrer fichier sur disque, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 11 août 2018
 *
 */
public class EnregistreurFichierMain extends Application {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * Emulateur de bureau Windows.<br/>
	 * permet d'ouvrir un fichier comme dans Windows 
	 * avec l'application adaptée au type MIME d'un fichier
	 */
	private final transient Desktop desktop = Desktop.getDesktop();

	/**
	 * bouton d'enregistrement d'un fichier.<br/>
	 * ouvre un FileChooser.<br/>
	 */
	private final transient Button recordButton 
		= new Button("Enregistrer un fichier");
	
	/**
	 * GridPane.<br/>
	 */
	private final transient GridPane inputGridPane = new GridPane();
	
	/**
	 * contenu à enregistrer.<br/>
	 */
	private transient String contenu;
	
	/**
	 * Zone de texte.<br/>
	 */
	private final transient TextArea textArea = new TextArea();
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(EnregistreurFichierMain.class);

	
	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public EnregistreurFichierMain() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(
			final Stage pPrimaryStage) throws Exception {
		
		this.configurerButtonRecord(pPrimaryStage);
		this.configurerGridPane();
		
		final BorderPane rootGroup = new BorderPane();
		rootGroup.setPrefSize(800d, 200d);
		rootGroup.setCenter(this.inputGridPane);

        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        /* Titre du théâtre. */
        pPrimaryStage.setTitle("Lanceur de FileChooser");
        
        final Scene scene = new Scene(rootGroup);
        
        pPrimaryStage.setScene(scene);
        
        pPrimaryStage.show();

	} // Fin de start(...).________________________________________________


	
	/**
	 * Configure le Button recordButton pour qu'il ouvre le FileChooser 
	 * sur un click.<br/>
	 * <ul>
	 * <li>récupère le répertoire mémorisé auprès du 
	 * GestionnairePreferencesSelecteur.</li>
	 * <li>instancie un EnregistreurFichier en 
	 * configurant son FileChooser.</li>
	 * <li>ouvre le FileChooser, permet la sélection 
	 * d'un fichier et y enregistre le contenu this.contenu.</li>
	 * <li>récupère le fichier sélectionné.</li>
	 * <li>ouvre le fichier sélectionné avec l'application 
	 * correspondant à son type MIME.</li>
	 * </ul>
	 *
	 * @param pPrimaryStage : Stage.<br/>
	 */
	private void configurerButtonRecord(
			final Stage pPrimaryStage) {
		
		this.recordButton.setOnAction(
	            new EventHandler<ActionEvent>() {
	            	
            @Override
            public void handle(final ActionEvent pEvent) {
                
            	final String titre = "Enregistrer un fichier";
            	File repertoirePrefere;
            	
            	/* récupère le contenu de la TextArea dans this.contenu. */
            	EnregistreurFichierMain.this.contenu 
            		= EnregistreurFichierMain.this.textArea.getText();
            	
				try {
					
					/* récupère le répertoire mémorisé auprès du 
					 * GestionnairePreferencesSelecteur. */
					repertoirePrefere = GestionnairePreferencesSelecteur
            			.getRepertoirePrefereFileChooser();
					
					/* instancie un EnregistreurFichier en configurant 
					 * son FileChooser.*/
					final IEnregistreurFichier enregistreur 
            			= new EnregistreurFichier(
            					titre, repertoirePrefere);
					
					/* ouvre le FileChooser, permet la sélection 
					 * d'un fichier et y enregistre le contenu. */
                    enregistreur.selectionnerEtEnregistrer(
                    		pPrimaryStage, EnregistreurFichierMain.this.contenu);
                    
                    /* récupère le fichier sélectionné. */
                    final File file = enregistreur.getFichierSelectionne();
                    
                    if (file != null) {
                    	try {
                    		
                    		/* Ouvre le fichier avec le lecteur 
                    		 * MIME adapté sous Windows. */
                    		EnregistreurFichierMain.this.desktop.open(file);
							
						} catch (IOException e) {
							e.printStackTrace();
						}
                    }
                    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
	            	
	    });
		
	} // Fin de configurerButtonRecord(...)._______________________________
	
	
	
	/**
	 * configure le GridPane.<br/>
	 * <ul>
	 * <li>ajoute this.recordButton au GridPane this.inputGridPane</li>
	 * <li>ajoute this.textArea au GridPane this.inputGridPane</li>
	 * </ul>
	 */
	private void configurerGridPane() {
		
		GridPane.setConstraints(
				this.recordButton
					, 0, 0
						, 1, 1
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
		
		GridPane.setConstraints(
				this.textArea
					, 1, 0
						, 4, 4
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
     
        this.inputGridPane.getChildren().addAll(this.recordButton);
        this.inputGridPane.getChildren().addAll(this.textArea);
        
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

			

} // FIN DE LA CLASSE EnregistreurFichierMain.-------------------------------
