package levy.daniel.application.vues.desktop.metier.regex.richtextarea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


/**
 * CLASSE RichTextAreaMain :<br/>
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
 * @since 12 août 2018
 *
 */
public class RichTextAreaMain extends Application {
	// ************************ATTRIBUTS************************************/

	/**
	 * TextArea.<br/>
	 */
	private final transient TextArea textArea = new TextArea();
	
	/**
	 * .<br/>
	 */
	private final transient TextFlow textFlow = new TextFlow();
	
	/**
	 * .<br/>
	 */
	private final transient ColorPicker colorPicker = new ColorPicker();
	
	/**
	 * .<br/>
	 */
	private final transient Label label = new Label();
	
	/**
	 * GridPane.<br/>
	 */
	private final transient GridPane gridPane = new GridPane();
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(RichTextAreaMain.class);


	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public RichTextAreaMain() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(
			final Stage pPrimaryStage) throws Exception {
		
		this.configurerColorPicker();
		this.configurerLabel();
		this.configurerGridPane();
		
		final BorderPane borderPaneRoot = new BorderPane();
		borderPaneRoot.setPrefSize(800d, 500d);
		borderPaneRoot.setCenter(this.gridPane);
//		borderPaneRoot.setStyle("-fx-background-color: #F0591E;");

        borderPaneRoot.setPadding(new Insets(20, 20, 20, 20));
 
        /* Titre du théâtre. */
        pPrimaryStage.setTitle("Afficheur de TextFlow");
        
        final Scene scene = new Scene(borderPaneRoot);
               
        pPrimaryStage.setScene(scene);
        
        pPrimaryStage.show();
        
	} // Fin de start(...).________________________________________________
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * :  :  .<br/>
	 */
	private void configurerColorPicker() {
		
		//Sets the split-menu-button
		this.colorPicker.getStyleClass().add("split-button");
		this.colorPicker.setPrefWidth(400);
		this.colorPicker.setPrefHeight(100);
		
		this.colorPicker.setOnAction(new EventHandler<ActionEvent>() {
		
            /**
             * {@inheritDoc}
             */
			@Override
			public void handle(final ActionEvent pEvent) {
				RichTextAreaMain.this.label.setText(
						RichTextAreaMain.this.colorPicker.getValue().toString());               
            }
        });
		
	} // Fin de configurerColorPicker().___________________________________
	
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * :  :  .<br/>
	 */
	private void configurerLabel() {
		
		this.label.setPrefWidth(400);
		this.label.setPrefHeight(100);
		this.label.setStyle("-fx-border-color: black;-fx-background-color: WHITE;");
		
	} // Fin de configurerLabel()._________________________________________
	
	
	
	/**
	 * configure le GridPane.<br/>
	 * <ul>
	 * <li>ajoute this.openButton au GridPane this.inputGridPane</li>
	 * </ul>
	 */
	private void configurerGridPane() {
		
		
		final String textString1 = "je suis le Texte 1\n";
		final Text text1 = new Text(textString1);
		text1.setStyle("-fx-fill: #4F8A10;-fx-font-weight:bold;");
		
		final String textString2 = "je suis le Texte 2";
		final Text text2 = new Text(textString2);
		text2.setStyle("-fx-fill: RED;-fx-font-weight:normal;");
		
		this.textFlow.setStyle("-fx-border-color: black");
		this.textFlow.getChildren().addAll(text1, text2);
		this.textFlow.setStyle("-fx-background-color: WHITE;");
		
		
		GridPane.setConstraints(
				this.textFlow
					, 0, 0
						, 1, 2
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
		
		GridPane.setConstraints(
				this.colorPicker
					, 1, 0
						, 1, 1
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
		
		GridPane.setConstraints(
				this.label
					, 1, 1
						, 1, 1
							, HPos.CENTER, VPos.CENTER
								, Priority.ALWAYS, Priority.ALWAYS
									, new Insets(12, 12, 12, 12));
     
        this.gridPane.getChildren().addAll(this.textFlow);
        this.gridPane.getChildren().addAll(this.colorPicker);
        this.gridPane.getChildren().addAll(this.label);
        
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

		
	
} // FIN DE LA CLASSE RichTextAreaMain.--------------------------------------
