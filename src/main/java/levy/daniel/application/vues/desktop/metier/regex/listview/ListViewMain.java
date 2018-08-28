package levy.daniel.application.vues.desktop.metier.regex.listview;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.vues.desktop.metier.regex.model.MotifCellFactory;


/**
 * CLASSE ListViewMain :<br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 29 août 2018
 *
 */
public class ListViewMain extends Application {
	// ************************ATTRIBUTS************************************/

	/**
	 * Liste des motifs.<br/>
	 */
	private final transient ListView<IMotif> motifs 
		= new ListView<IMotif>();
	
	/**
	 * label pourla sélection dans la liste.<br/>
	 */
	private final transient Label motifLabel 
	= new Label("Sélectionnez un motif prédéfini : ");
	
	/**
	 * TextArea pour l'affichage de la sélection dans la liste.<br/>
	 */
	private final transient TextArea textArea = new TextArea();
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ListViewMain.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ListViewMain() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(
			final Stage pPrimaryStage) throws Exception {
		
		this.configurerListView();
		this.configurerTexteArea();
		
		// Create the Selection HBox 
		final HBox selection = new HBox();
		// Set Spacing to 20 pixels
		selection.setSpacing(20);
		// Add the Label and ListView to the HBox
		selection.getChildren().addAll(this.motifLabel, this.motifs);		

		// Create the VBox
		final VBox root = new VBox();
		// Set Spacing to 10 pixels
		root.setSpacing(10);
		// Add the HBox and the TextArea to the VBox
		root.getChildren().addAll(selection, this.textArea);
		
		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		
		// Create the Scene
		final Scene scene = new Scene(root);
		// Add the Scene to the Stage
		pPrimaryStage.setScene(scene);
		// Set the Title
		pPrimaryStage.setTitle("Exemple de ListView avec Cell Factory");
		// Display the Stage
		pPrimaryStage.show();	
	
	} // Fin de start(...).________________________________________________
	

	
	/**
	 * configure le ListView this.motifs.<br/>
	 */
	private void configurerListView() {
		
		// dimensionne la ListView.
		this.motifs.setPrefSize(800, 120);
		
		// ajoute les données au MODELE (base).
		this.motifs.getItems().addAll(createMotifsList());
	
		// Ajoute une CellFactory customisée pour afficher chaque motif.
		this.motifs.setCellFactory(new MotifCellFactory());
		
		// Update the message Label when the selected item changes
		this.motifs.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<IMotif>() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void changed(
					final ObservableValue<? extends IMotif> pMotif
						, final IMotif pOldvalue, final IMotif pNewvalue) {
				
				selectionChanged(pMotif, pOldvalue, pNewvalue);
				
			} // Fin de changed(...).______________
			
		}); // Fin de new ChangeListener<IMotif>().____________________

	} // Fin de configurerListView().______________________________________
	
	
	
	/**
	 * configure this.textArea.<br/>
	 */
	private void configurerTexteArea() {
		
		this.textArea.setPrefWidth(400);
		this.textArea.setPrefHeight(400);
		
//		this.textArea.setMaxWidth(350);
//		this.textArea.setMaxHeight(350);
		
	} // Fin de configurerTexteArea()._____________________________________


	
	/**
	 * Simulacre de base de données.<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @return : ArrayList&lt;IMotif&gt;.<br/>
	 */
	private List<IMotif> createMotifsList() {
		
		final ArrayList<IMotif> motifsMetier = new ArrayList<IMotif>();
		
		final IMotif motif1 
		= new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /");
		final IMotif motif2 
			= new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\d{1,3}? /");
		final IMotif motif3 
			= new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /");
		
		motifsMetier.add(motif1);
		motifsMetier.add(motif2);
		motifsMetier.add(motif3);

		return motifsMetier;
		
	} // Fin de createMotifsList().________________________________________
	
	

	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pMotif
	 * @param pOldValue
	 * @param pNewValue :  :  .<br/>
	 */
	public void selectionChanged(
			final ObservableValue<? extends IMotif> pMotif
				, final IMotif pOldValue
					, final IMotif pNewValue) {
		
		final String oldText = pOldValue == null ? "null" : pOldValue.toString();
		final String newText = pNewValue == null ? "null" : pNewValue.toString();
		
		this.textArea.appendText("ancienne valeur = " + oldText + '\n'); 
		this.textArea.appendText("nouvelle valeur = " + newText+ '\n');
		this.textArea.appendText("\n");
		
	} // Fin de selectionChanged(...)._____________________________________
	
	
	
	/**
	 * Point d'entrée de l'application.<br/>
	 *
	 * @param pArgs : String[].<br/>
	 */
	public static void main(
			final String[] pArgs) {
        Application.launch(pArgs);
    } // Fin de main(...)._________________________________________________



} // FIN DE LA CLASSE ListViewMain.------------------------------------------
