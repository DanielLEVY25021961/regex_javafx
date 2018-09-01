package levy.daniel.application.vues.desktop.metier.regex.controllers.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.vues.desktop.metier.regex.controllers.IMotifController;


/**
 * CLASSE MotifController :<br/>
 * CONTROLLER réagissant aux évènements de la VUE.<br/>
 * <ul>
 * <li>utilise des <b>Property JavaFx</b> pour tracker 
 * les modifications des valeurs dans la VUE.</li>
 * <li>lien entre un <b>objet métier</b> 
 * et le présent CONTROLLER.</li>
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
 * @author adminLocal Lévy
 * @version 1.0
 * @since 29 août 2018
 *
 */
public class MotifController implements IMotifController {

	// ************************ATTRIBUTS************************************/
	/**
	 * identifiant en base.<br/>
	 */
	private LongProperty id;
	
	/**
	 * nom du motif Regex Java.<br/>
	 */
	private StringProperty nom;
	
	/**
	 * motif Regex Java.<br/>
	 */
	private StringProperty motifJava;
	
	/**
	 * signification du motif Java.<br/>
	 */
	private StringProperty signification;
	
	/**
	 * autre façon d'écrire le motif Regex Java.<br/>
	 */
	private StringProperty alias;
	
	/**
	 * motif Regex JavaScript.<br/>
	 */
	private StringProperty motifJavaScript;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MotifController.class);

	// *************************METHODES************************************/

	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifController() {
		this(null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pNom : StringProperty : 
	 * nom du motif Regex Java.<br/> 
	 * @param pMotifJava : StringProperty : 
	 * motif Regex Java.<br/>
	 * @param pSignification : StringProperty : 
	 * signification du motif Java.<br/>
	 * @param pAlias : StringProperty : 
	 * autre façon d'écrire le motif Regex Java.<br/>
	 * @param pMotifJavaScript : StringProperty : 
	 * motif Regex JavaScript.<br/>
	 */
	public MotifController(
			final StringProperty pNom, 
			final StringProperty pMotifJava,
			final StringProperty pSignification, 
			final StringProperty pAlias, 
			final StringProperty pMotifJavaScript) {
		
		this(null
				, pNom
				, pMotifJava
				, pSignification, pAlias, pMotifJavaScript);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId : LongProperty : 
	 * identifiant en base.<br/>
	 * @param pNom : StringProperty : 
	 * nom du motif Regex Java.<br/> 
	 * @param pMotifJava : StringProperty : 
	 * motif Regex Java.<br/>
	 * @param pSignification : StringProperty : 
	 * signification du motif Java.<br/>
	 * @param pAlias : StringProperty : 
	 * autre façon d'écrire le motif Regex Java.<br/>
	 * @param pMotifJavaScript : StringProperty : 
	 * motif Regex JavaScript.<br/>
	 */
	public MotifController(
			final LongProperty pId, 
			final StringProperty pNom, 
			final StringProperty pMotifJava,
			final StringProperty pSignification, 
			final StringProperty pAlias, 
			final StringProperty pMotifJavaScript) {
		
		super();
		
		this.id = pId;
		this.nom = pNom;
		this.motifJava = pMotifJava;
		this.signification = pSignification;
		this.alias = pAlias;
		this.motifJavaScript = pMotifJavaScript;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________
	

	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <ul>
	 * transforme un <b>objet métier</b> 
	 * en <b>CONTROLLER DE VUE Observable</b>.<br/>
	 * </ul>
	 *
	 * @param pMotif : IMotif : Objet métier.<br/>
	 */
	public MotifController(
			final IMotif pMotif) {
		
		this(new SimpleLongProperty(pMotif.getId()),
				new SimpleStringProperty(pMotif.getNom()), 
				new SimpleStringProperty(pMotif.getMotifJava()), 
				new SimpleStringProperty(pMotif.getSignification()), 
				new SimpleStringProperty(pMotif.getAlias()), 
				new SimpleStringProperty(pMotif.getMotifJavaScript()));
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long getId() {
		return this.id.get();
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setId(
			final Long pId) {
		this.id.set(pId);
	} // Fin de setId(...).________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final LongProperty idProperty() {
		return this.id;
	} // Fin de idProperty().______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNom() {
		return this.nom.get();
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNom(
			final String pNom) {
		this.nom.set(pNom);
	} // Fin de setNom(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty nomProperty() {
		return this.nom;
	} // Fin de nomProperty()._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMotifJava() {
		return this.motifJava.get();
	} // Fin de getMotifJava().____________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMotifJava(
			final String pMotifJava) {
		this.motifJava.set(pMotifJava);
	} // Fin de setMotifJava(...)._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty motifJavaProperty() {
		return this.motifJava;
	} // Fin de motifJavaProperty()._______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getSignification() {
		return this.signification.get();
	} // Fin de getSignification().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setSignification(
			final String pSignification) {
		this.signification.set(pSignification);
	} // Fin de setSignification(...)._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty significationProperty() {
		return this.signification;
	} // Fin de significationProperty().___________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getAlias() {
		return this.alias.get();
	} // Fin de getAlias().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setAlias(
			final String pAlias) {
		this.alias.set(pAlias);
	} // Fin de setAlias(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty aliasProperty() {
		return this.alias;
	} // Fin de aliasProperty().___________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMotifJavaScript() {
		return this.motifJavaScript.get();
	} // Fin de getMotifJavaScript().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMotifJavaScript(
			final String pMotifJavaScript) {
		this.motifJavaScript.set(pMotifJavaScript);
	} // Fin de setMotifJavaScript(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty motifJavaScriptProperty() {
		return this.motifJavaScript;
	} // Fin de motifJavaScriptProperty()._________________________________
	
	
	
} // FIN DE LA CLASSE MotifController.---------------------------------------
