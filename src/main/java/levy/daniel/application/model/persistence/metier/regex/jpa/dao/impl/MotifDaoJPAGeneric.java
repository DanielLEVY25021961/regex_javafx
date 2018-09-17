package levy.daniel.application.model.persistence.metier.regex.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.model.persistence.AbstractDaoGenericJPA;
import levy.daniel.application.model.persistence.JPAUtils;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.metier.regex.jpa.entities.impl.MotifEntityJPA;

/**
 * CLASSE MotifDaoJPAGeneric :<br/>
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
public class MotifDaoJPAGeneric extends AbstractDaoGenericJPA<IMotif, Long> {

	// ************************ATTRIBUTS************************************/
	/**
	 * "Classe MotifDaoJPAGeneric".<br/>
	 */
	public static final String CLASSE_MOTIFDAOJPA 
		= "Classe MotifDaoJPAGeneric";

	/**
	 * SELECT_OBJET : String :<br/>
	 * "select motif from 
	 * MotifEntityJPA as motif ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select motif from "
				+ "MotifEntityJPA as motif ";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifDaoJPAGeneric.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifDaoJPAGeneric() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final MotifEntityJPA entity(
			final IMotif pObject) {
		return new MotifEntityJPA(pObject);
	} // Fin de entity(...)._______________________________________________

	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final IMotif objetMetier(
			final IMotif pObject) {
		
		final MotifEntityJPA entity = (MotifEntityJPA) pObject;
		return new Motif(entity);
		
	} // Fin de objetMetier(...).__________________________________________
	
	
	
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
		
		/* Instanciation d'un entityManager. */
		final EntityManager entityManager 
			= JPAUtils.fournirEntityManager();
		
		/* Cas où this.entityManager == null. */
		if (entityManager == null) {

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
				+ "where motif.nom = :pNom and motif.motifJava = :pMotifJava";

		/* Construction de la requête HQL. */			
		final Query requete 
			= entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pMotifJava", pObject.getMotifJava());
			
		try {

			/* Execution de la requete HQL. */				
			objetResultat 
				= (IMotif) requete.getSingleResult();
			
			/* Fermeture de l'EntityManager. */
			if (entityManager.isOpen()) {
				entityManager.close();
			}
			
		}
		catch (NoResultException noResultExc) {

			/* Fermeture de l'EntityManager. */
			if (entityManager.isOpen()) {
				entityManager.close();
			}
			
			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;

		}
		catch (Exception e) {
			
			/* Fermeture de l'EntityManager. */
			if (entityManager.isOpen()) {
				entityManager.close();
			}

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_MOTIFDAOJPA
						, "Méthode retrieve(IMotif pObject)", e);
		}

		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IMotif> findAllSousClasse() throws AbstractDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IMotif> findAllMaxSousClasse(int pStartPosition, int pMaxResult) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(IMotif pObject) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return null;
	}

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
		
		System.out.println(this.afficherListeObjetsMetier(this.findAll()));

	} // Fin de ecrireStockageDansConsole()._______________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherListeObjetsMetier(
			final List<IMotif> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IMotif objetMetier : pList) {
			
			stb.append(objetMetier.toString());
			stb.append(SAUT_LIGNE_JAVA);
			
		}
		
		return stb.toString();

	} // Fin de afficherListeObjetsMetier(...).____________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(IMotif pObject) throws AbstractDaoException {
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
	public boolean exists(
			final IMotif pObject) throws AbstractDaoException {

		/* return false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		/* Instanciation d'un entityManager. */
		final EntityManager entityManager 
			= JPAUtils.fournirEntityManager();
		
		/* Cas où this.entityManager == null. */
		if (entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		IMotif objetResultat = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where motif.nom = :pNom and motif.motifJava = :pMotifJava";

		/* Construction de la requête HQL. */			
		final Query requete 
			= entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pMotifJava", pObject.getMotifJava());
			
		try {

			/* Execution de la requete HQL. */				
			objetResultat 
				= (IMotif) requete.getSingleResult();
			
			/* Fermeture de l'EntityManager. */
			if (entityManager.isOpen()) {
				entityManager.close();
			}
						
			if (objetResultat != null) {
				return true;
			}
			
		}
		catch (NoResultException noResultExc) {

			/* Fermeture de l'EntityManager. */
			if (entityManager.isOpen()) {
				entityManager.close();
			}
			
			/* retourne null si l'Objet métier n'existe pas en base. */
			return false;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_MOTIFDAOJPA
						, "Méthode retrieve(IMotif pObject)", e);
		}

		return false;

	} // Fin de exists(...)._______________________________________________
	
	

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
	protected final void renseignerClassObjetMetier() {
		this.setClassObjetMetier(IMotif.class);
	} // Fin de renseignerClassObjetMetier().______________________________






	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListe(List<IMotif> pListe) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
