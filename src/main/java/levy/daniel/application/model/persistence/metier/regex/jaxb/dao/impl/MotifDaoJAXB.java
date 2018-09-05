package levy.daniel.application.model.persistence.metier.regex.jaxb.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.model.persistence.metier.regex.jaxb.dao.IMotifDaoJAXB;
import levy.daniel.application.model.persistence.metier.regex.jaxb.entities.impl.MotifEntityJAXB;
import levy.daniel.application.model.persistence.metier.regex.jaxb.entities.impl.TableMotifsEntityJAXB;


/**
 * CLASSE MotifDaoJAXB :<br/>
 * <b>DAO (Data Access Object)</b> 
 * pour les {@link Motif} en <b>JAXB</b>.<br/>
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
 * @since 2 sept. 2018
 *
 */
public class MotifDaoJAXB implements IMotifDaoJAXB {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * context : JAXBContext :<br/>
	 * context JAXB.<br/>
	 */
	private transient JAXBContext context;
		
	/**
	 * marshaller : Marshaller :<br/>
	 * Objet vers XML.<br/>
	 */
	private transient Marshaller marshaller;

	/**
	 * unmarshaller : Unmarshaller :<br/>
	 * XML vers Objet.<br/>
	 */
	private transient Unmarshaller unmarshaller;

	
	/**
	 * fichierXML : File :<br/>
	 * fichier XML dans lequel écrire les entities JAXB.<br/>
	 */
	private File fichierXML;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MotifDaoJAXB.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * @throws JAXBException 
	 */
	public MotifDaoJAXB() throws JAXBException {
		this(null);		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 * 
	 * @throws JAXBException
	 */
	public MotifDaoJAXB(
			final File pFile) throws JAXBException {
		
		super();
		
		this.fichierXML = pFile;
		
		this.instancierContextJAXB();
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	
	/**
	 * method instancierContext() :<br/>
	 * Instancie le context JAXB et les Marshaller et Unmarshaller.<br/>
	 * <ul>
	 * <li>instancie le context pour l'Entity TableMotifsEntityJAXB. </li>
	 * <li>Instancie le Marshaller (Objet vers XML).</li>
	 * <li>Paramètre le Marshaller (Objet vers XML).</li>
	 * <li>Instancie le Unmarshaller (XML vers Objet).</li>
	 * </ul>
	 * 
	 * @throws JAXBException 
	 */
	private void instancierContextJAXB() throws JAXBException {
		
		/* instancie le context pour l'Entity TableMotifsEntityJAXB. */
		this.context 
			= JAXBContext.newInstance(TableMotifsEntityJAXB.class);
		
		/* Instancie le Marshaller (Objet vers XML). */
		this.marshaller = this.context.createMarshaller();
		
		/* Paramètre le Marshaller (Objet vers XML). */
		this.marshaller.setProperty(
				Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		/* Instancie le Unmarshaller (XML vers Objet). */
		this.unmarshaller = this.context.createUnmarshaller();
		
	} // Fin de instancierContextJAXB().___________________________________
	
	
	
	/**
	 * Crée un Objet métier à partir d'une EntityJAXB.<br/>
	 * <br/>
	 * retourne null si pEntity == null.<br/>
	 * <br/>
	 *
	 * @param pEntity : MotifEntityJAXB.<br/>
	 * 
	 * @return : IMotif.<br/>
	 */
	private IMotif creerObjetMetier(
			final MotifEntityJAXB pEntity) {
		
		/* retourne null si pEntity == null. */
		if (pEntity == null) {
			return null;
		}
		
		final IMotif objetMetier 
			= new Motif(pEntity.getId()
					, pEntity.getNom()
					, pEntity.getMotifJava()
					, pEntity.getSignification()
					, pEntity.getAlias()
					, pEntity.getMotifJavaScript());
		
		return objetMetier;
		
	} // Fin de creerPersonne(...).________________________________________
	
	
	
	/**
	 * convertit une Liste de Personne (MODEL) en liste 
	 * de PersonneEntityJAXB (Entities JAXB).<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IMotif&gt;
	 * 
	 * @return : List&lt;MotifEntityJAXB&gt;.<br/>
	 */
	private List<MotifEntityJAXB> convertirListModelEnEntities(
			final List<IMotif> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<MotifEntityJAXB> resultat 
			= new ArrayList<MotifEntityJAXB>();
		
		for (final IMotif objetMetier : pList) {
			
			if (objetMetier != null) {
				
				final MotifEntityJAXB entityJAXB 
					= new MotifEntityJAXB(objetMetier);
				
				resultat.add(entityJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	

		
	/**
	 * convertit une Liste d'Entities JAXB 
	 * en liste d'objets métier (MODEL).<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;MotifEntityJAXB&gt;.<br/>
	 * 
	 * @return : List&lt;IMotif&gt;.<br/>
	 */
	private List<IMotif> convertirListEntitiesEnModel(
			final List<MotifEntityJAXB> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<IMotif> resultat 
			= new ArrayList<IMotif>();
		
		for (final MotifEntityJAXB entity : pList) {
			
			if (entity != null) {
				
				final IMotif objetMetier 
					= this.creerObjetMetier(entity);
				
				resultat.add(objetMetier);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListEntitiesEnModel(...)._________________________
	
	
	
	/**
	 * Instancie une Entity JAXB (Liste correspondant à une table JPA)
	 * à partir d'une Liste de MODEL (objets métier) pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IMotif&gt; : Liste de MODEL 
	 * à transformer en Entities JAXB en vue de la sérialization.<br/>
	 * 
	 * @return : TableMotifsEntityJAXB : Entity serializable 
	 * sous forme de fichier XML.<br/>
	 */
	private TableMotifsEntityJAXB creerTableEntitiesJAXB(
			final List<IMotif> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<MotifEntityJAXB> liste 
			= this.convertirListModelEnEntities(pList);
	
		final TableMotifsEntityJAXB tableEntities 
			= new TableMotifsEntityJAXB(liste);
		
		return tableEntities;
		
	} // Fin de creerEntityJAXB(...).______________________________________



	/* CREATE ************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif create(
			final IMotif pObject) 
			throws JAXBException, IOException {
		
		return this.create(pObject, this.fichierXML);
		
	} // Fin de create(...)._______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif create(
			final IMotif pObject
				, final File pFile) 
						throws JAXBException, IOException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		List<IMotif> listeObjetsMetier = null;
		
		/* récupère ou crée la liste des objets métier déjà stockés 
		 * déjà stockés dans le fichier XML pFile.*/
		if (pFile.exists()) {
			listeObjetsMetier = this.findAll(pFile);
		} else {
			listeObjetsMetier = new ArrayList<IMotif>();
		}
		  		
		if (listeObjetsMetier != null) {
			
			/* ajoute l'objet métier pObject à la liste 
			 * si pObject n'est pas déjà stocké (gestion des doublons). */
			if (!listeObjetsMetier.contains(pObject)) {
				listeObjetsMetier.add(pObject);
			} else {
				return null;
			}
						
			/* enregistre la nouvelle liste dans le fichier XML pFile. */
			this.enregistrer(listeObjetsMetier, pFile);
			
			return pObject;
		} 
			
		return null;
				
	} // Fin de create(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long createReturnId(
			final IMotif pObject) 
							throws IOException, JAXBException {
		
		return this.createReturnId(pObject, this.fichierXML);
		
	} // Fin de createReturnId(...)._______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long createReturnId(
			final IMotif pObject
				, final File pFile) 
							throws IOException, JAXBException {
				
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		List<IMotif> listeObjetsMetier = null;
		
		/* récupère ou crée la liste des objets métier
		 * déjà stockés dans le fichier XML pFile.*/
		if (pFile.exists()) {
			listeObjetsMetier = this.findAll(pFile);
		} else {
			listeObjetsMetier = new ArrayList<IMotif>();
		}
		  		
		if (listeObjetsMetier != null) {
			
			int index = 0;
			Long resultat = 0L;
			
			/* ajoute l'objet métier pObject à la liste 
			 * si pObject n'est pas déjà stocké 
			 * (gestion des doublons). */
			if (!listeObjetsMetier.contains(pObject)) {
				
				listeObjetsMetier.add(pObject);
				index = listeObjetsMetier.indexOf(pObject);
				resultat = Long.valueOf(index);
				
			} else {
				return null;
			}
						
			/* enregistre la nouvelle liste dans 
			 * le fichier XML pFile. */
			this.enregistrer(listeObjetsMetier, pFile);
			
			return resultat;
		} 
			
		return null;
						
	} // Fin de createReturnId(...)._______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Iterable<IMotif> save(
			final Iterable<IMotif> pList) 
						throws IOException, JAXBException {
		
		return this.save(pList, this.fichierXML);
		
	} // Fin de save(...)._________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Iterable<IMotif> save(
			final Iterable<IMotif> pList
				, final File pFile) 
						throws IOException, JAXBException {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		final Iterator<IMotif> ite = pList.iterator();
		
		final List<IMotif> resultat = new ArrayList<IMotif>();
		
		/* itère sur chaque élément de l'itérable. */
		while (ite.hasNext()) {
			
			final IMotif motif = ite.next();
			
			/* stocke chaque élément de l'itérable dans le fichier XML. */
			/* ne crée pas de doublon. */
			final IMotif motifPersiste = this.create(motif, pFile);
			
			if (motifPersiste != null) {
				resultat.add(motifPersiste);
			}
		}
		
		return resultat;
		
	} // Fin de save(...)._________________________________________________
	
	
	
	/**
	 * <b>Enregistre sur disque dans le fichier XML pFile 
	 * la liste de MODEL (objets métier) pList</b>.<br/>
	 * <ul>
	 * <li>Crée pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * <li>crée une entity JAXB de type Table à partir 
	 * de la liste d'objets métier.</li>
	 * <li>enregistre sur disque dans un fichier XML 
	 * l'entity JAXB de type Table.</li>
	 * </ul>
	 * - ne fait rien si pList == null.<br/>
	 * - ne fait rien si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IMotif&gt;.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws JAXBException
	 */
	private void enregistrer(
			final List<IMotif> pList
				, final File pFile) throws JAXBException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		/* crée une entity JAXB de type Table à partir de la liste d'objets métier. */
		final TableMotifsEntityJAXB tableObjetsMetier 
			= this.creerTableEntitiesJAXB(pList);
		
		/* enregistre sur disque dans un fichier XML l'entity JAXB de type Table. */
		this.enregistrer(tableObjetsMetier, pFile);
		
	} // Fin de enregistrer(...).__________________________________________
	
	
	
	/**
	 * <b>Enregistre sur disque dans le fichier XML pFile 
	 * l'Entity JAXB de type Table pTableEntitiesJAXB</b>.<br/>
	 * <ul>
	 * <li>Crée pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * <li>utilise <code>marshaller.marshal(
	 * pTableEntitiesJAXB, pFile)</code></li>
	 * </ul>
	 * - ne fait rien si pTableEntitiesJAXB == null.<br/>
	 * - ne fait rien si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pTableEntitiesJAXB : TableMotifsEntityJAXB.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @throws JAXBException
	 */
	private void enregistrer(
			final TableMotifsEntityJAXB pTableEntitiesJAXB
				, final File pFile) throws JAXBException {
		
		/* ne fait rien si pTableEntitiesJAXB == null. */
		if (pTableEntitiesJAXB == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
							
		/* Ecriture sur disque dur sous forme de fichier XML. */		
		this.marshaller.marshal(pTableEntitiesJAXB, pFile);
						
	} // Fin de enregistrer(...).__________________________________________
	


	/* READ *************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif retrieve(
			final IMotif pObject) 
						throws IOException, JAXBException {
		
		return this.retrieve(pObject, this.fichierXML);
		
	} // Fin de retrieve(...)._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif retrieve(
			final IMotif pObject, 
				final File pFile) 
						throws IOException, JAXBException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return null;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		if (listeObjetsMetier != null) {
			
			for (final IMotif motif : listeObjetsMetier) {
				
				if (motif.equals(pObject)) {
					return motif;
				}
			}
			
		}
		
		
		/* retourne null si l'objet métier n'est pas 
		 * stocké dans le fichier XML pFile. */
		return null;
		
	} // Fin de retrieve(...)._____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif findById(final Long pId) 
						throws IOException, JAXBException {
		
		return this.findById(pId, this.fichierXML);
		
	} // Fin de findById(...)._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif findById(
			final Long pId, 
				final File pFile) 
						throws IOException, JAXBException {
		
		/* retourne null si pId == 0. */
		if (pId == 0) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return null;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		if (listeObjetsMetier != null) {
			/* retourne null si l'index n'existe pas dans la liste. */
			try {
				
				final int indexRecherche = pId.intValue();
				final IMotif resultat 
					= listeObjetsMetier.get(indexRecherche);
				return resultat;
				
			} catch (IndexOutOfBoundsException iobe) {
				return null;
			}
			
		}
		
		/* retourne null si l'objet métier n'est pas 
		 * stocké dans le fichier XML pFile. */
		return null;

	} // Fin de findById(...)._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int retrieveId(
			final IMotif pObject) 
						throws IOException, JAXBException {
		return this.retrieveId(pObject, this.fichierXML);
	} // Fin de retrieveId(...).___________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int retrieveId(
			final IMotif pObject, 
				final File pFile) 
						throws IOException, JAXBException {
		
		/* retourne 0 si pObject == null. */
		if (pObject == null) {
			return 0;
		}
		
		/* retourne 0 si pFile == null. */
		if (pFile == null) {
			return 0;
		}
		
		/* retourne 0 si pFile n'existe pas. */
		if (!pFile.exists()) {
			return 0;
		}
		
		/* retourne 0 si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return 0;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		if (listeObjetsMetier != null) {
			
			for (final IMotif motif : listeObjetsMetier) {
				
				if (motif.equals(pObject)) {
					return listeObjetsMetier.indexOf(motif);
				}
			}
			
		}
				
		/* retourne 0 si l'objet métier n'est pas 
		 * stocké dans le fichier XML pFile. */
		return 0;
		
	} // Fin de retrieveId(...).___________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IMotif> findByMetier(
			final String pString) 
						throws IOException, JAXBException {
		
		return this.findByMetier(pString, this.fichierXML);
		
	} // Fin de findByMetier(...)._________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IMotif> findByMetier(
			final String pString, 
				final File pFile) 
						throws IOException, JAXBException {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return null;
		}
		
		final List<IMotif> resultat = new ArrayList<IMotif>();
		
		/* récupère la liste des objets métier 
		 * stockés dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
	
		if (listeObjetsMetier != null) {
			
			for (final IMotif motif : listeObjetsMetier) {
				
				/* ajoute au résultat tous les objets métier 
				 * remplissant la condition métier.  */
				if (StringUtils.contains(motif.getNom(), pString)) {
					resultat.add(motif);
				}
			}
			
		}
		
		return resultat;
		
	} // Fin de findByMetier(...)._________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IMotif> findAll() 
					throws JAXBException, IOException {
		
		return this.findAll(this.fichierXML);
		
	} // Fin de findAll()._________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IMotif> findAll(
			final File pFile) 
					throws JAXBException, IOException {
		
		/* return null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* return null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* return null si pFile n'est pas un fichier simple. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		List<IMotif> resultat = null;
		
		/* récupère la modélisation du fichier XML sous forme d'entité JAXB. */
		final TableMotifsEntityJAXB tableEntities 
			= this.recupererEntites(pFile);
		
		if (tableEntities != null) {
			
			/* récupère la liste des entités JAXB contenues 
			 * dans la modélisation du fichier XML. */
			final List<MotifEntityJAXB> listeEntities 
				= tableEntities.getListeMotifs();
			
			/* convertit la liste d'entités JAXB en liste d'objets métier. */
			resultat 
				= this.convertirListEntitiesEnModel(listeEntities);
			
		}
				
		return resultat;
		
	} // Fin de findAll(...).______________________________________________
	

	
	/**
	 * <b>retourne la liste des pMax objets métier 
	 * persistés dans le stockage</b> à partir de la 
	 * position pStartPosition.<br/>
	 * <ul>
	 * <li>retourne par exemple les 50 objets métier stockés 
	 * à partir du 100ème.</li>
	 * </ul>
	 * - return null si pFile == null.<br/>
	 * - return null si pFile n'existe pas.<br/>
	 * - return null si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pStartPosition : int : index (0-based) de départ.<br/>
	 * @param pMaxResult : int : 
	 * nombre maximum d'objets métier à retourner.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return : List&lt;IMotif&gt; : 
	 * liste des pMax objets métier persistés dans le stockage 
	 * à partir de pStartPosition.<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	public final List<IMotif> findAllMax(
			final int pStartPosition
				, final int pMaxResult
					, final File pFile) 
							throws JAXBException, IOException {
		
		/* return null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* return null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* return null si pFile n'est pas un fichier simple. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		List<IMotif> resultat = null;

		return resultat;
		
	} // Fin de findAllMax(...).___________________________________________
	
	
	
	/* UPDATE *************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif update(
			final int pIndex
				, final IMotif pObjectModifie) 
							throws JAXBException, IOException {
		
		return this.update(pIndex, pObjectModifie, this.fichierXML);
		
	} // Fin de update(...)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif update(
			final int pIndex
				, final IMotif pObjectModifie
					, final File pFile) 
							throws JAXBException, IOException {
		
		/* retourne null si pIndex == 0. */
		if (pIndex == 0) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return null;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
			
		if (listeObjetsMetier != null) {
			
			final int taille = listeObjetsMetier.size();
			
			/* retourne null si pIndex est en dehors 
			 * de la liste des objets métier. */
			if (pIndex > taille - 1) {
				return null;
			}
			
			final List<IMotif> listeModifiee 
				= new ArrayList<IMotif>();
			
			for (int i = 0; i < taille ; i ++) {
				
				/* substitue pObjectModifie à pIndex. */
				if (i == pIndex) {
					listeModifiee.add(pObjectModifie);
				} else {
					listeModifiee.add(listeObjetsMetier.get(i));
				}
			}
			
			/* enregistre la liste modifiée sur disque. */
			this.enregistrer(listeModifiee, pFile);
			
			return pObjectModifie;
		}

		return null;
		
	} // Fin de update(...)._______________________________________________
	

	
	/* DELETE *************/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean delete(
			final IMotif pObject) 
						throws JAXBException, IOException {
		
		return this.delete(pObject, this.fichierXML);
		
	} // Fin de delete(...)._______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean delete(
			final IMotif pObject
				, final File pFile) 
						throws JAXBException, IOException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		/* retourne false si pFile == null. */
		if (pFile == null) {
			return false;
		}
		
		/* retourne false si pFile n'existe pas. */
		if (!pFile.exists()) {
			return false;
		}
		
		/* retourne false si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return false;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		boolean resultat = false;
		
		if (listeObjetsMetier != null) {
			
			final List<IMotif> listeModifiee 
				= new ArrayList<IMotif>();
			
			for (final IMotif objetMetier : listeObjetsMetier) {
				
				/* retire pObject de la liste si il existe. */
				if (!objetMetier.equals(pObject)) {
					listeModifiee.add(objetMetier);
				} else {
					resultat = true;
				}
			}
			
			/* enregistre la liste modifiée sur disque. */
			this.enregistrer(listeModifiee, pFile);
			
			return resultat;
			
		}

		return false;
		
	} // Fin de delete(...)._______________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteById(final Long pIndex) 
						throws JAXBException, IOException {
		
		this.deleteById(pIndex, this.fichierXML);
		
	} // Fin de deleteById(...).___________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteById(
			final Long pIndex
				, final File pFile) 
						throws JAXBException, IOException {
				
		/* ne fait rien si pIndex == 0. */
		if (pIndex == 0) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		/* ne fait rien si pFile n'existe pas. */
		if (!pFile.exists()) {
			return;
		}
		
		/* ne fait rien si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		if (listeObjetsMetier != null) {

			final int taille = listeObjetsMetier.size();

			/*
			 * ne fait rien si pIndex est en dehors 
			 * de la liste des objets métier.
			 */
			if (pIndex > taille - 1) {
				return;
			}

			/* récupère l'objet métier à retirer par index. */
			final IMotif objetARetirer = this.findById(pIndex, pFile);
			
			/* ne fait rien si l'objet métier d'index pIndex n'existe pas. */
			if (objetARetirer == null) {
				return;
			}

			final List<IMotif> listeModifiee = new ArrayList<IMotif>();
			
			for (final IMotif objetMetier : listeObjetsMetier) {

				/* retire l'objet de la liste si il existe. */
				if (!objetMetier.equals(objetARetirer)) {
					listeModifiee.add(objetMetier);
				}

			}
						
			/* enregistre la liste modifiée sur disque. */
			this.enregistrer(listeModifiee, pFile);

		}
		
	} // Fin de deleteById(...).___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteByIdBoolean(
								final Long pIndex) 
									throws JAXBException, IOException {
		
		return this.deleteByIdBoolean(pIndex, this.fichierXML);
		
	} // Fin de deleteByIdBoolean(...).____________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteByIdBoolean(
			final Long pIndex
				, final File pFile) 
						throws JAXBException, IOException {
				
		/* retourne false si pIndex == 0. */
		if (pIndex == 0) {
			return false;
		}
		
		/* retourne false si pFile == null. */
		if (pFile == null) {
			return false;
		}
		
		/* retourne false si pFile n'existe pas. */
		if (!pFile.exists()) {
			return false;
		}
		
		/* retourne false si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return false;
		}
		
		boolean resultat = false;
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		if (listeObjetsMetier != null) {
		
			final int taille = listeObjetsMetier.size();
		
			/*
			 * retourne false si pIndex est en dehors 
			 * de la liste des objets métier.
			 */
			if (pIndex > taille - 1) {
				return false;
			}
		
			/* récupère l'objet métier à retirer par index. */
			final IMotif objetARetirer = this.findById(pIndex, pFile);
			
			/* retourne false si l'objet métier d'index pIndex 
			 * n'existe pas. */
			if (objetARetirer == null) {
				return false;
			}
					
			final List<IMotif> listeModifiee = new ArrayList<IMotif>();
			
			for (final IMotif objetMetier : listeObjetsMetier) {
		
				/* retire l'objet de la liste si il existe. */
				if (!objetMetier.equals(objetARetirer)) {
					listeModifiee.add(objetMetier);
				} else {
					resultat = true;
				}
		
			}
						
			/* enregistre la liste modifiée sur disque. */
			this.enregistrer(listeModifiee, pFile);
		
		}
		
		return resultat;
		
	} // Fin de deleteByIdBoolean(...).____________________________________

	
	
	/* TOOLS *************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final IMotif pObject) 
						throws JAXBException, IOException {
		
		return this.exists(pObject, this.fichierXML);
		
	} // Fin de exists(...)._______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final IMotif pObject
				, final File pFile) 
						throws JAXBException, IOException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		/* retourne false si pFile == null. */
		if (pFile == null) {
			return false;
		}
		
		/* retourne false si pFile n'existe pas. */
		if (!pFile.exists()) {
			return false;
		}
		
		/* retourne false si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return false;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		boolean resultat = false;
		
		if (listeObjetsMetier != null) {
			
			for (final IMotif objetMetier : listeObjetsMetier) {
				
				/* retourne false si la liste ne contient 
				 * pas l'objet métier. */
				if (objetMetier.equals(pObject)) {
					
					/* retourne true si la liste 
					 * contient l'objet métier. */
					resultat = true;
				}
			}
		}
		
		return resultat;
		
	} // Fin de exists(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long count() 
			throws IOException, JAXBException {
		return this.count(this.fichierXML);
	} // Fin de count().___________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long count(
			final File pFile) 
					throws IOException, JAXBException {
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return null;
		}
		
		/* récupère le liste des objets métier 
		 * stockés dans le fichier XML. */
		final List<IMotif> liste = this.findAll(pFile);
		
		Long resultat = null;
		
		if (liste != null) {
			
			/* retourne le nombre d'éléments de la liste 
			 * sous forme de Long. */
			resultat = Long.valueOf(liste.size());
			
		}
				
		return resultat;
		
	} // Fin de Long count(...).___________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void ecrireListeObjetsMetierXMLConsole() 
					throws JAXBException, IOException {
		
		this.ecrireListeObjetsMetierXMLConsole(this.fichierXML);
		
	} // Fin de ecrireListeObjetsMetierXMLConsole()._______________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void ecrireListeObjetsMetierXMLConsole(
			final File pFile) 
					throws JAXBException, IOException {
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		/* ne fait rien si pFile n'existe pas. */
		if (!pFile.exists()) {
			return;
		}
		
		/* ne fait rien si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return;
		}
		
		final List<IMotif> liste = this.findAll(pFile);
		
		/* ne fait rien si il est impossible de récupérer 
		 * la liste d'enregistrements dans pFile.*/
		if (liste != null) {
			this.ecrireListeObjetsMetierXMLConsole(liste);
		}
		
	} // Fin de ecrireListeObjetsMetierXMLConsole(...).____________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireListeObjetsMetierXMLConsole(
			final List<IMotif> pList) throws JAXBException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		final List<MotifEntityJAXB> listeEntitiesJAXB 
			= this.convertirListModelEnEntities(pList);
		
		final TableMotifsEntityJAXB tableEntitiesJAXB 
			= new TableMotifsEntityJAXB(listeEntitiesJAXB);
		
		this.ecrireTableEntitiesConsole(tableEntitiesJAXB);
						
	} // Fin de ecrireListeObjetsMetierXMLConsole(...).____________________
	

	
	/**
	 * Affiche à la console l'Entity JAXB pTableEntitiesJAXB
	 * (fichier XML correspondant à une table JPA) 
	 * sous forme de fichier XML.<br/>
	 * <ul>
	 * <li>utilise <code>marshaller.marshal(
	 * pTableEntitiesJAXB, System.out)</code>.</li>
	 * </ul>
	 * - ne fait rien si pTableEntitiesJAXB == null.<br/>
	 * <br/>
	 *
	 * @param pTableEntitiesJAXB : TableMotifsEntityJAXB.<br/>
	 * 
	 * @throws JAXBException 
	 */
	private void ecrireTableEntitiesConsole(
			final TableMotifsEntityJAXB pTableEntitiesJAXB) 
					throws JAXBException {
		
		/* ne fait rien si pTableEntitiesJAXB == null. */
		if (pTableEntitiesJAXB == null) {
			return;
		}
		
		/* Ecriture dans la console sous forme de fichier XML. */
		this.marshaller.marshal(pTableEntitiesJAXB, System.out);
		
	} // Fin de ecrireContactsConsole(...).________________________________
	
		
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TableMotifsEntityJAXB recupererEntites(
			final File pFile) 
					throws JAXBException, IOException {
		
		/* return null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* return null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* return null si pFile n'est pas un fichier simple. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		/* ouvre un flux FileReader. */
		final FileReader fileReader = new FileReader(pFile);
		
		final TableMotifsEntityJAXB resultat 
			= (TableMotifsEntityJAXB) this.unmarshaller.unmarshal(fileReader);
		
		/* fermeture des flux. */
		fileReader.close();
				
		return resultat;
		
	} // Fin de recupererEntites(...)._____________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeEntitiesDansTable(
			final TableMotifsEntityJAXB pTableEntities) {
		
		/* retourne null si pTableEntities == null. */
		if (pTableEntities == null) {
			return null;
		}
		
		final List<MotifEntityJAXB> listeEntities 
			= pTableEntities.getListeMotifs();
		
		return this.afficherListeEntityJAXB(listeEntities);
		
	} // Fin de afficherListeEntitiesDansTable(...)._______________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(
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
	public String afficherListeEntityJAXB(
			final List<MotifEntityJAXB> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final MotifEntityJAXB entityJAXB : pList) {
			
			stb.append(entityJAXB.toString());
			stb.append(SAUT_LIGNE_JAVA);
			
		}
		
		return stb.toString();		

	} // Fin de afficherListePersonneJAXB(...).____________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getFichierXML() {
		return this.fichierXML;
	} // Fin de getFichierXML().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFichierXML(
			final File pFichierXML) {
		this.fichierXML = pFichierXML;
	} // Fin de setFichierXML(...).________________________________________
	


} // FIN DE LA CLASSE MotifDaoJAXB.------------------------------------------
