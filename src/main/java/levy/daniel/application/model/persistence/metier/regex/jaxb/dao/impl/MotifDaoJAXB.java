package levy.daniel.application.model.persistence.metier.regex.jaxb.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif create(
			final IMotif pObject) 
			throws FileNotFoundException, JAXBException {
		
		return this.create(pObject, this.fichierXML);
		
	} // Fin de create(...)._______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IMotif create(
			final IMotif pObject
				, final File pFile) 
						throws FileNotFoundException, JAXBException {
		
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
			listeObjetsMetier = this.recupererListeModeles(pFile);
		} else {
			listeObjetsMetier = new ArrayList<IMotif>();
		}
		  		
		if (listeObjetsMetier != null) {
			
			/* ajoute l'objet métier pObject à la liste 
			 * si pObject n'est pas déjà stocké (gestion des doublons). */
			if (!listeObjetsMetier.contains(pObject)) {
				listeObjetsMetier.add(pObject);
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
	public final Iterable<IMotif> save(
			final Iterable<IMotif> pList) 
						throws FileNotFoundException, JAXBException {
		
		return this.save(pList, this.fichierXML);
		
	} // Fin de save(...)._________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Iterable<IMotif> save(
			final Iterable<IMotif> pList
				, final File pFile) 
						throws FileNotFoundException, JAXBException {
		
		/* retourne null si pList == null. */
		if (pList == null) {
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

		final Iterator<IMotif> ite = pList.iterator();
		
		/* itère sur chaque élément de l'itérable. */
		while (ite.hasNext()) {
			
			final IMotif motif = ite.next();
			
			/* stocke chaque élément de l'itérable dans le fichier XML. */
			this.create(motif, pFile);
		}
		
		return pList;
		
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
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long count() 
			throws FileNotFoundException, JAXBException {
		return this.count(this.fichierXML);
	} // Fin de count().___________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long count(
			final File pFile) 
					throws FileNotFoundException, JAXBException {
		
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
		final List<IMotif> liste = this.recupererListeModeles(pFile);
		
		Long resultat = null;
		
		/* retourne le nombre d'éléments de la liste 
		 * sous forme de Long. */
		resultat = Long.valueOf(liste.size());
		
		return resultat;
		
	} // Fin de Long count(...).___________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void ecrireListeObjetsMetierXMLConsole() 
					throws JAXBException, FileNotFoundException {
		
		this.ecrireListeObjetsMetierXMLConsole(this.fichierXML);
		
	} // Fin de ecrireListeObjetsMetierXMLConsole()._______________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void ecrireListeObjetsMetierXMLConsole(
			final File pFile) 
					throws JAXBException, FileNotFoundException {
		
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
		
		final List<IMotif> liste = this.recupererListeModeles(pFile);
		
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
	public List<IMotif> recupererListeModeles(
			final File pFile) 
					throws FileNotFoundException, JAXBException {
		
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
		
		final TableMotifsEntityJAXB tableEntities 
			= this.recupererEntites(pFile);
		
		final List<MotifEntityJAXB> listeEntities 
			= tableEntities.getListeMotifs();
		
		final List<IMotif> resultat 
			= this.convertirListEntitiesEnModel(listeEntities);
		
		return resultat;
		
	} // Fin de recupererListeModeles(...).________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TableMotifsEntityJAXB recupererEntites(
			final File pFile) 
					throws FileNotFoundException, JAXBException {
		
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
		
		final FileReader fileReader = new FileReader(pFile);
		
		final TableMotifsEntityJAXB resultat 
			= (TableMotifsEntityJAXB) this.unmarshaller.unmarshal(fileReader);
		
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
