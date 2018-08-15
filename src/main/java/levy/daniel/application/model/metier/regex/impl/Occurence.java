package levy.daniel.application.model.metier.regex.impl;

import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IExportateurCsv;
import levy.daniel.application.model.metier.regex.IExportateurJTable;


/**
 * CLASSE <b>Occurence</b> :<br/>
 * Modélisation de l'occurence d'un motif RegEx Java dans un texte.<br/>
 * Par exemple : <br/>
 * pour le motif Regex Java <code>"avec"</code> 
 * dans le texte :<br/>
 * <b>avec</b> le temps, <b>avec</b> le temps va...<br/>
 * <b>Occurence</b> va servir à encapsuler toutes les occurences 
 * <b>(numéro, contenu, position de début, position de fin)</b> 
 * du motif "avec" dans le texte.<br/>
 * <br/>
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
 * @since 14 août 2018
 *
 */
public class Occurence implements 
	Comparable<Occurence>, Cloneable, IExportateurCsv, IExportateurJTable {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
		
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";

	
	
	/**
	 * ", ".<br/>
	 */
	public static final String VIRGULE = ", ";
	
	/**
	 * numero d'ordre (1-based) de l'occurence 
	 * du motif dans un texte.<br/>
	 * (1ère occurence, 2nde occurence, ...)
	 */
	public transient int numero;
	
	/**
	 * contenu de l'occurence du motif dans le texte.<br/>
	 */
	public transient String contenu;
	
	/**
	 * position (0-based) du début de l'occurence du motif.<br/>
	 */
	public transient int indexDebut;
	
	/**
	 * position (0-based) de la fin de l'occurence du motif.<br/>
	 */
	public transient int indexFin;
	
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(Occurence.class);


	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pNumero : int : 
	 * numero d'ordre (1-based) de l'occurence 
	 * du motif dans un texte.<br/>
	 * (1ère occurence, 2nde occurence, ...)
	 * @param pContenu : String : 
	 * contenu de l'occurence du motif dans le texte.<br/>
	 * @param pIndexDebut : int : 
	 * position (0-based) du début de l'occurence du motif.<br/>
	 * @param pIndexFin : int : 
	 * position (0-based) de la fin de l'occurence du motif.<br/>
	 */
	public Occurence(
			final int pNumero
				, final String pContenu
					, final int pIndexDebut
						, final int pIndexFin) {
		
		super();
		
		this.numero = pNumero;
		this.contenu = pContenu;
		this.indexDebut = pIndexDebut;
		this.indexFin = pIndexFin;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.numero;
		result = prime * result + ((this.contenu == null) ? 0 : this.contenu.hashCode());		
		return result;
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(
			final Object pObject) {
		
		if (this == pObject) {
			return true;
		}
		if (pObject == null) {
			return false;
		}
		if (!(pObject instanceof Occurence)) {
			return false;
		}
		
		final Occurence other = (Occurence) pObject;
		
		if (this.contenu == null) {
			if (other.contenu != null) {
				return false;
			}
		}
		else if (!this.contenu.equals(other.contenu)) {
			return false;
		}
		if (this.numero != other.numero) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final Occurence pObject) {
		
		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}
		
		int compareContenu = 0;
		int compareNumero = 0;
		
		if (this.getContenu() == null) {
			if (pObject.getContenu() != null) {
				return +1;
			}
		} else {
			if (pObject.getContenu() == null) {
				return -1;
			}
		}
		
		if (this.getContenu() != null) {
			
			compareContenu 
			= this.getContenu().compareToIgnoreCase(pObject.getContenu());
		
			if (compareContenu != 0) {
				return compareContenu;
			}
			
		}
		
		
		compareNumero = this.getNumero() - pObject.getNumero();
		
		return compareNumero;
		
	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Occurence clone() throws CloneNotSupportedException {
		
		final Occurence occurenceClone = (Occurence) super.clone();
		
		occurenceClone.numero = this.numero;
		occurenceClone.contenu = this.contenu;
		occurenceClone.indexDebut = this.indexDebut;
		occurenceClone.indexFin = this.indexFin;
		
		return occurenceClone;
		
	} // Fin de clone().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Occurence [numero=");
		builder.append(this.numero);
		
		builder.append(VIRGULE);
		
		builder.append("contenu=");
		if (this.contenu != null) {			
			builder.append(this.contenu);
			
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		builder.append("indexDebut=");
		builder.append(this.indexDebut);
		
		builder.append(", indexFin=");
		builder.append(this.indexFin);
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String getEnTeteCsv() {
		return "numéro;contenu;indexDebut;indexFin;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	@Override
	public final String toStringCsv() {

		final StringBuilder stb = new StringBuilder();
		
		/* numero. */
		stb.append(this.numero);
		stb.append(POINT_VIRGULE);
		
		/* contenu. */
		stb.append(this.contenu);
		stb.append(POINT_VIRGULE);
		
		/* indexDebut. */
		stb.append(this.indexDebut);
		stb.append(POINT_VIRGULE);
		
		/* indexFin. */
		stb.append(this.indexFin);
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String getEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "numéro";
			break;
			
		case 1:
			entete = "contenu";
			break;
			
		case 2:
			entete = "indexDebut";
			break;
			
		case 3:
			entete = "indexFin";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final Object getValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			valeur = String.valueOf(this.numero);			
			break;

		case 1:
			if (this.contenu != null) {
				valeur = this.contenu;
			}			
			break;
			
		case 2:
			valeur = String.valueOf(this.indexDebut);
			break;
			
		case 3:
			valeur = String.valueOf(this.indexFin);
			break;
			
		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;
		
	} // Fin de getValeurColonne(...)._____________________________________


	
	/**
	 * Getter du numero d'ordre (1-based) de l'occurence 
	 * du motif dans un texte.<br/>
	 * (1ère occurence, 2ème occurence, ...).<br/>
	 *
	 * @return this.numero : int.<br/>
	 */
	public int getNumero() {
		return this.numero;
	} // Fin de getNumero()._______________________________________________


	
	/**
	 * Getter du contenu de l'occurence du motif dans le texte.<br/>
	 *
	 * @return this.contenu : String.<br/>
	 */
	public String getContenu() {
		return this.contenu;
	} // Fin de getContenu().______________________________________________


	
	/**
	 * Getter de la position (0-based) du début 
	 * de l'occurence du motif.<br/>
	 *
	 * @return this.indexDebut : int.<br/>
	 */
	public int getIndexDebut() {
		return this.indexDebut;
	} // Fin de getIndexDebut().___________________________________________


	
	/**
	 * Getter de la position (0-based) de la fin 
	 * de l'occurence du motif.<br/>
	 * <br/>
	 *
	 * @return this.indexFin : int.<br/>
	 */
	public int getIndexFin() {
		return this.indexFin;
	} // Fin de getIndexFin()._____________________________________________


	
} // FIN DE LA CLASSE Occurence.---------------------------------------------
