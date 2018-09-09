package levy.daniel.application.model.persistence.metier.regex.jpa.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.persistence.AbstractDaoGenericJPASpring;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;


/**
 * CLASSE MotifDaoJPASpringGeneric :<br/>
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
 * @since 8 sept. 2018
 *
 */
public class MotifDaoJPASpringGeneric 
			extends AbstractDaoGenericJPASpring<IMotif, Long> {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe MotifDaoJPASpringGeneric".<br/>
	 */
	public static final String CLASSE_MOTIFDAOJPASPRING 
		= "Classe MotifDaoJPASpringGeneric";

	/**
	 * SELECT_OBJET : String :<br/>
	 * "select motif from 
	 * MotifEntityJPASpring as motif ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select motif from "
				+ "MotifEntityJPASpring as motif ";

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifDaoJPASpringGeneric.class);
	
	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifDaoJPASpringGeneric() {
		super();		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	



	/* CREATE ************/


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final IMotif pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		/* Crée l'Objet en base ou jette une AbstractDaoException. */
		final IMotif objetPersistant 
			= this.create(pObject);

		/* retourne null si l'objet pObject n'a pu être créé en base. */
		if (objetPersistant == null) {
			return null;
		}

		/* retourne l'ID de l'objet persistant. */
		return objetPersistant.getId();	
		
	} // Fin de createReturnId(...)._______________________________________
	
	

	/* READ *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public IMotif retrieve(
			final IMotif pObject) throws AbstractDaoException {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		IMotif objetResultat = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where motif.nom = :pNom and motif.motifJava = :pMotifJava;";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pMotifJava", pObject.getMotifJava());

		try {

			/* Execution de la requete HQL. */
			objetResultat 
				= (IMotif) requete.getSingleResult();

		}
		catch (NoResultException noResultExc) {

			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_MOTIFDAOJPASPRING
						, "Méthode retrieve(IMotif pObject)", e);
		}

		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IMotif> findAllSousClasse() throws AbstractDaoException {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from MotifEntityJPASpring";

		List<IMotif> resultat = null;

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_MOTIFDAOJPASPRING
						, "Méthode findAllSousClasse()", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAllSousClasse()._______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IMotif> findAllMaxSousClasse(
			final int pStartPosition
				, final int pMaxResult) throws AbstractDaoException {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from MotifEntityJPASpring";

		List<IMotif> resultat = null;

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString)
					.setFirstResult(pStartPosition).setMaxResults(pMaxResult);

			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_MOTIFDAOJPASPRING
						, "Méthode findAllMaxSousClasse(int pStartPosition, int pMaxResult)", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAllMaxSousClasse(...)._________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAllSousClasse() throws AbstractDaoException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBooleanSousClasse() throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long countSousClasse() throws AbstractDaoException {
		// TODO Auto-generated method stub
		return null;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(
			final IMotif pObject) throws AbstractDaoException {
		
		final IMotif profil = this.retrieve(pObject);
		
		Long resultat = null;
		
		if (profil != null) {
			resultat = profil.getId();
		}
		
		return resultat;
		
	} // Fin de retrieveId(...).___________________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IMotif update(Long pIndex, IMotif pObjectModifie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(Iterable<IMotif> pList) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(Iterable<IMotif> pList) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(List<IMotif> pList) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(Long pId) throws AbstractDaoException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(Long pId) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(IMotif pObject) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(Long pId) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListe(List<IMotif> pListe) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void renseignerClassObjetMetier() {
		// TODO Auto-generated method stub
		
	}
}
