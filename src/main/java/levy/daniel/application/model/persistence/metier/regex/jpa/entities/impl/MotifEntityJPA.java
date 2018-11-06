package levy.daniel.application.model.persistence.metier.regex.jpa.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IMotif;

/**
 * CLASSE <b>MotifEntityJPA</b> :<br/>
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
 * @since 10 sept. 2018
 *
 */
@Entity(name="MotifEntityJPA")
@Table(name="MOTIFS_JPA", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_NOM_MOTIFJAVA"
, columnNames={"NOM", "MOTIFJAVA"})
, indexes={@Index(name="INDEX_NOM_MOTIFJAVA", columnList="NOM, MOTIFJAVA")})
public class MotifEntityJPA implements IMotif {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * identifiant en base.<br/>
	 */
	private Long id;
	
	/**
	 * nom du motif Regex Java.<br/>
	 */
	private String nom;
	
	/**
	 * motif Regex Java.<br/>
	 */
	private String motifJava;
	
	/**
	 * signification du motif Java.<br/>
	 */
	private String signification;
	
	/**
	 * autre façon d'écrire le motif Regex Java.<br/>
	 */
	private String alias;
	
	/**
	 * motif Regex JavaScript.<br/>
	 */
	private String motifJavaScript;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifEntityJPA.class);
	

	// *************************METHODES************************************/

	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifEntityJPA() {
		
		this(null, null, null, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 *  @param pNom : String : 
	 * nom du motif Regex Java.<br/> 
	 * @param pMotifJava : String : 
	 * motif Regex Java.<br/>
	 * @param pSignification : String : 
	 * signification du motif Java.<br/> 
	 * @param pAlias : String : 
	 * autre façon d'écrire le motif Regex Java.<br/>
	 * @param pMotifJavaScript : String : 
	 * motif Regex JavaScript.<br/>
	 */
	public MotifEntityJPA(
				final String pNom, 
				final String pMotifJava, 
				final String pSignification, 
				final String pAlias,
				final String pMotifJavaScript) {
		
		this(null
				, pNom, pMotifJava
				, pSignification, pAlias, pMotifJavaScript);
		
	} // Fin de  CONSTRUCTEUR COMPLET._____________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId : Long : 
	 * identifiant en base.<br/>
	 * @param pNom : String : 
	 * nom du motif Regex Java.<br/> 
	 * @param pMotifJava : String : 
	 * motif Regex Java.<br/>
	 * @param pSignification : String : 
	 * signification du motif Java.<br/> 
	 * @param pAlias : String : 
	 * autre façon d'écrire le motif Regex Java.<br/>
	 * @param pMotifJavaScript : String : 
	 * motif Regex JavaScript.<br/>
	 */
	public MotifEntityJPA(
			final Long pId, 
				final String pNom, 
				final String pMotifJava, 
				final String pSignification, 
				final String pAlias,
				final String pMotifJavaScript) {
		
		super();
		
		this.id = pId;
		this.nom = pNom;
		this.motifJava = pMotifJava;
		this.signification = pSignification;
		this.alias = pAlias;
		this.motifJavaScript = pMotifJavaScript;
		
	} // Fin du CONSTRUCTEUR COMPLET BASE._________________________________


	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * Permet d'instancier une Entity 
	 * à partir d'un Objet Métier.<br/>
	 *
	 * @param pMotif : IMotif.<br/>
	 */
	public MotifEntityJPA(
			final IMotif pMotif) {
		
		super();
		
		if (pMotif != null) {
			this.id = pMotif.getId();
			this.nom = pMotif.getNom();
			this.motifJava = pMotif.getMotifJava();
			this.signification = pMotif.getSignification();
			this.alias = pMotif.getAlias();
			this.motifJavaScript = pMotif.getMotifJavaScript();
		}
				
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result
			+ ((this.motifJava == null) ? 0 : this.motifJava.hashCode());
		result = prime * result 
				+ ((this.nom == null) ? 0 : this.nom.hashCode());
		
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
		if (!(pObject instanceof IMotif)) {
			return false;
		}
		
		final IMotif other 
			= (IMotif) pObject;
		
		/* nom. */
		if (this.nom == null) {
			if (other.getNom() != null) {
				return false;
			}
		}
		else if (!this.nom.equals(other.getNom())) {
			return false;
		}
		
		/* motifJava. */
		if (this.motifJava == null) {
			if (other.getMotifJava() != null) {
				return false;
			}
		}
		else if (!this.motifJava.equals(other.getMotifJava())) {
			return false;
		}
				
		return true;
		
	} // Fin de equals(...)._______________________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IMotif pObject) {
		
		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}
		
		int compareNom = 0;
		int compareMotifJava = 0;
		
		/* nom. */
		if (this.getNom() == null) {
			if (pObject.getNom() != null) {
				return +1;
			}
		} else {
			if (pObject.getNom() == null) {
				return -1;
			}
		}
		
		if (this.getNom() != null) {
			
			compareNom 
			= this.getNom().compareToIgnoreCase(pObject.getNom());
		
			if (compareNom != 0) {
				return compareNom;
			}
			
		}
		
		/* motifJava. */
		if (this.getMotifJava() == null) {
			if (pObject.getMotifJava() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pObject.getMotifJava() == null) {
			return -1;
		}
		
		compareMotifJava 
			= this.getMotifJava()
				.compareToIgnoreCase(pObject.getMotifJava());
		
		return compareMotifJava;

	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final MotifEntityJPA clone() throws CloneNotSupportedException {
		
		final MotifEntityJPA motifClone = (MotifEntityJPA) super.clone();
		
		motifClone.id = this.id;
		motifClone.nom = this.nom;
		motifClone.motifJava = this.motifJava;
		motifClone.signification = this.signification;
		motifClone.alias = this.alias;
		motifClone.motifJavaScript = this.motifJavaScript;
		
		return motifClone;
		
	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("MotifEntityJPA [");
		
		/* id. */
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* nom. */
		builder.append("nom=");
		if (this.nom != null) {			
			builder.append(this.nom);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* motifJava. */
		builder.append("motifJava=");
		if (this.motifJava != null) {			
			builder.append(this.motifJava);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* signification. */
		builder.append("signification=");
		if (this.signification != null) {			
			builder.append(this.signification);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* alias. */
		builder.append("alias=");
		if (this.alias != null) {			
			builder.append(this.alias);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE);
		
		/* motifJavaScript. */
		builder.append("motifJavaScript=");
		if (this.motifJavaScript != null) {		
			builder.append(this.motifJavaScript);
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Transient
	@Override
	public final String getEnTeteCsv() {
		return "id;nom;motifJava;signification;alias;motifJavaScript;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toStringCsv() {
		
		final StringBuilder stb = new StringBuilder();
		
		/* id. */
		stb.append(this.id);
		stb.append(POINT_VIRGULE);
		
		/* nom. */
		stb.append(this.nom);
		stb.append(POINT_VIRGULE);
		
		/* motifJava. */
		stb.append(this.motifJava);
		stb.append(POINT_VIRGULE);
		
		/* signification. */
		stb.append(this.signification);
		stb.append(POINT_VIRGULE);
		
		/* alias. */
		stb.append(this.alias);
		stb.append(POINT_VIRGULE);
		
		/* motifJavaScript. */
		stb.append(this.motifJavaScript);
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;
			
		case 1:
			entete = "nom";
			break;
		
		case 2:
			entete = "motifJava";
			break;
			
		case 3:
			entete = "signification";
			break;
			
		case 4:
			entete = "alias";
			break;
			
		case 5:
			entete = "motifJavaScript";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object getValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			valeur = String.valueOf(this.id);			
			break;

		case 1:
			if (this.nom != null) {
				valeur = this.nom;
			}			
			break;
			
		case 2:
			if (this.motifJava != null) {
				valeur = this.motifJava;
			}			
			break;
			
		case 3:
			if (this.signification != null) {
				valeur = this.signification;
			}	
			break;
			
		case 4:
			if (this.alias != null) {
				valeur = this.alias;
			}	
			break;
			
		case 5:
			if (this.motifJavaScript != null) {
				valeur = this.motifJavaScript;
			}	
			break;
			
		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;
		
	} // Fin de getValeurColonne(...)._____________________________________
		
	
	
	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	@Override
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="NOM"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	@Override
	public String getNom() {
		return this.nom;
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {
		this.nom = pNom;
	} // Fin de setNom(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="MOTIFJAVA"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	@Override
	public String getMotifJava() {
		return this.motifJava;
	} // Fin de getMotifJava().____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMotifJava(
			final String pMotifJava) {
		this.motifJava = pMotifJava;
	} // Fin de setMotifJava(...)._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="SIGNIFICATION"
			, unique = false, updatable = true
			, insertable = true, nullable = true)
	@Override
	public String getSignification() {
		return this.signification;
	} // Fin de getSignification().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSignification(
			final String pSignification) {
		this.signification = pSignification;
	} // Fin de setSignification(...)._____________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="ALIAS"
			, unique = false, updatable = true
			, insertable = true, nullable = true)
	@Override
	public String getAlias() {
		return this.alias;
	} // Fin de getAlias().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlias(
			final String pAlias) {
		this.alias = pAlias;
	} // Fin de setAlias(...)._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="MOTIFJAVASCRIPT"
			, unique = false, updatable = true
			, insertable = true, nullable = true)
	@Override
	public String getMotifJavaScript() {
		return this.motifJavaScript;
	} // Fin de getMotifJavaScript().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMotifJavaScript(
			final String pMotifJavaScript) {
		this.motifJavaScript = pMotifJavaScript;
	} // Fin de setMotifJavaScript(...).___________________________________


	
} // FIN DE LA CLASSE MotifEntityJPA.----------------------------------------
