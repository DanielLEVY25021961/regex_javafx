package levy.daniel.application.vues.desktop.metier.regex.listview;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.vues.desktop.metier.regex.model.MotifCellFactory;
import levy.daniel.application.vues.desktop.metier.regex.model.observables.IMotifObservable;
import levy.daniel.application.vues.desktop.metier.regex.model.observables.impl.MotifCellFactoryObservable;
import levy.daniel.application.vues.desktop.metier.regex.model.observables.impl.MotifObservable;


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
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	
	/**
	 * ListView (VUE) des motifs objets métier.<br/>
	 */
	private final transient ListView<IMotif> motifsListView 
		= new ListView<IMotif>();
	
	/**
	 * ListView (VUE) des motifs observables.<br/>
	 */
	private final transient ListView<IMotifObservable> motifsObservableListView 
		= new ListView<IMotifObservable>();
	
	/**
	 * label pourla sélection dans la liste.<br/>
	 */
	private final transient Label motifLabel 
	= new Label("Sélectionnez un motif prédéfini : ");
	
	/**
	 * label pourla sélection dans la liste.<br/>
	 */
	private final transient Label motifLabelObservable 
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
		this.configurerListViewObservable();
		this.configurerTexteArea();
		
		// Create the Selection HBox 
		final HBox selection = new HBox();
		// Set Spacing to 20 pixels
		selection.setSpacing(20);
		// Add the Label and ListView to the HBox
		selection.getChildren().addAll(
				this.motifLabel, this.motifsListView);
		
		// Create the Selection HBox 
		final HBox selectionObservable = new HBox();
		// Set Spacing to 20 pixels
		selectionObservable.setSpacing(20);
		// Add the Label and ListView to the HBox
		selectionObservable.getChildren().addAll(
				this.motifLabelObservable, this.motifsObservableListView);
		
		
		// Create the VBox
		final VBox root = new VBox();
		// Set Spacing to 10 pixels
		root.setSpacing(10);
		// Add the HBox and the TextArea to the VBox
		root.getChildren().addAll(selection, selectionObservable, this.textArea);
		
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
	 * configure le ListView this.motifsListView.<br/>
	 */
	private void configurerListView() {
		
		// dimensionne la ListView.
		this.motifsListView.setPrefSize(800, 120);
		
		/* orientation verticale pour le ListView. */
		this.motifsListView.setOrientation(Orientation.VERTICAL);
		
		// ajoute les données au MODELE (base).
		this.motifsListView.getItems().addAll(createMotifsList());
	
		// Ajoute une CellFactory customisée pour afficher chaque ligne du ListView.
		this.motifsListView.setCellFactory(new MotifCellFactory());
		
		// limite la sélection dans le ListView à 1 seul élément. 
		this.motifsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		// LISTENER SUR LA SELECTION DANS LA LISTEVIEW.
		this.ajouterListenerSelectionMotifs();

	} // Fin de configurerListView().______________________________________
	

	
	/**
	 * ajoute un listener sur la selection dans le ListView.<br/>
	 */
	private void ajouterListenerSelectionMotifs() {
		
		this.motifsListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<IMotif>() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void changed(
					final ObservableValue<? extends IMotif> pMotif
						, final IMotif pOldvalue
							, final IMotif pNewvalue) {
				
				selectionChanged(pMotif, pOldvalue, pNewvalue);
				
			} // Fin de changed(...).______________
			
		}); // Fin de new ChangeListener<IMotif>().____________________
		
	} // Fin de ajouterListenerSelectionMotifs().__________________________
	

	
	/**
	 * configure le ListView this.motifsObservable.<br/>
	 */
	private void configurerListViewObservable() {
		
		// dimensionne la ListView.
		this.motifsObservableListView.setPrefSize(800, 120);
		
		/* orientation verticale pour le ListView. */
		this.motifsObservableListView.setOrientation(Orientation.VERTICAL);
		
		// ajoute les données au MODELE (base).
		this.motifsObservableListView.getItems().addAll(
				this.convertirListModeleEnObservable(this.createMotifsList()));
	
		// rend la listView Editable. 
		this.motifsObservableListView.setEditable(true);
		
		// Ajoute une CellFactory customisée pour afficher chaque ligne du ListView.
		this.motifsObservableListView.setCellFactory(new MotifCellFactoryObservable());
		
		// limite la sélection dans le ListView à 1 seul élément. 
		this.motifsObservableListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				
		
		// LISTENER SUR LA SELECTION DANS LA LISTEVIEW.
		this.ajouterListenerSelectionMotifsObservable();

	} // Fin de configurerListView().______________________________________
	

	
	/**
	 * ajoute un listener sur la selection dans le ListView.<br/>
	 */
	private void ajouterListenerSelectionMotifsObservable() {
		
		this.motifsObservableListView.getSelectionModel().selectedItemProperty()
			.addListener(
				new ChangeListener<IMotifObservable>() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void changed(
					final ObservableValue<? extends IMotifObservable> pMotif
						, final IMotifObservable pOldvalue
							, final IMotifObservable pNewvalue) {
				
				selectionChangedObservable(pMotif, pOldvalue, pNewvalue);
				
			} // Fin de changed(...).______________
			
		}); // Fin de new ChangeListener<IMotif>().____________________
		
	} // Fin de ajouterListenerSelectionMotifsObservable().________________
	
	
	
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
	 * <b>convertit une liste d'objets métier 
	 * en liste observable</b>.<br/>
	 *
	 * @param pList : List&lt;IMotif&gt; : 
	 * liste d'objets métier.<br/>
	 * 
	 * @return : ObservableList&lt;IMotifObservable&gt; : 
	 * liste observable.<br/>
	 */
	public final ObservableList<IMotifObservable> 
					convertirListModeleEnObservable(
								final List<IMotif> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final ObservableList<IMotifObservable> resultat 
			= FXCollections.<IMotifObservable>observableArrayList();
		
		for (final IMotif objetMetier : pList) {
			
			if (objetMetier != null) {
				
				final IMotifObservable observable 
					= new MotifObservable(objetMetier);
				
				resultat.add(observable);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelenObservable(...)._______________________


	
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
		
		final String oldText = pOldValue == null ? NULL : pOldValue.toString();
		final String newText = pNewValue == null ? NULL : pNewValue.toString();
		
		this.textArea.appendText("ancienne valeur = " + oldText + '\n'); 
		this.textArea.appendText("nouvelle valeur = " + newText+ '\n');
		this.textArea.appendText("\n");
		
	} // Fin de selectionChanged(...)._____________________________________
	

	
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
	public void selectionChangedObservable(
			final ObservableValue<? extends IMotifObservable> pMotif
				, final IMotifObservable pOldValue
					, final IMotifObservable pNewValue) {
		
		final String oldText = pOldValue == null ? NULL : pOldValue.toString();
		final String newText = pNewValue == null ? NULL : pNewValue.toString();
		
		this.textArea.appendText("ancienne valeur = " + oldText + '\n'); 
		this.textArea.appendText("nouvelle valeur = " + newText+ '\n');
		this.textArea.appendText("\n");
		
	} // Fin de selectionChangedObservable(...).___________________________
	
	
	
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
