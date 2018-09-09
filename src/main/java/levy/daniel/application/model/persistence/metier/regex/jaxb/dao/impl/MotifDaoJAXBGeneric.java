package levy.daniel.application.model.persistence.metier.regex.jaxb.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.model.persistence.AbstractDaoGenericJAXB;
import levy.daniel.application.model.persistence.metier.regex.jaxb.entities.impl.MotifEntityJAXB;
import levy.daniel.application.model.persistence.metier.regex.jaxb.entities.impl.TableMotifsEntityJAXB;

/**
 * CLASSE MotifDaoJAXBGeneric :<br/>
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
 * @since 7 sept. 2018
 *
 */
public class MotifDaoJAXBGeneric extends AbstractDaoGenericJAXB<IMotif, Long> {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifDaoJAXBGeneric.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * @throws JAXBException 
	 */
	public MotifDaoJAXBGeneric() throws JAXBException {
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
	public MotifDaoJAXBGeneric(
			final File pFile) throws JAXBException {
		
		super(pFile);
		
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
	 * convertit une Liste d'objeets métier (MODEL) en liste 
	 * d' Entities (Entities JAXB).<br/>
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
	 * fournit une String pour l'affichage à la console 
	 * de la liste d'entités simples contenues dans une Entity JAXB 
	 * pTableEntities modélisant une table d'entités.<br/>
	 * <ul>
	 * <li>retourne null si pTableEntities == null.</li>
	 * </ul>
	 *
	 * @param pTableEntities : TableMotifsEntityJAXB.<br/>
	 * 
	 * @return : String.<br/>
	 */
	private String afficherListeEntitiesDansTable(
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
	 * fournit une String pour l'affichage à la console 
	 * d'une Liste d'Entities JAXB.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;MotifEntityJAXB&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	private String afficherListeEntityJAXB(
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
	@Override
	protected void enregistrer(
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
	 * Récupère une Entity JAXB contenant tous les objets métier 
	 * (homogène à une Table JPA) modélisant le fichier XML pFile.<br/>
	 * <ul>
	 * <li>utilise :<br/>
	 * <code>FileReader fileReader = new FileReader(pFile);<br/>
	 * (TableMotifsEntityJAXB) this.unmarshaller.unmarshal(fileReader)</code></li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 * - return null si pFile == null.<br/>
	 * - return null si pFile n'existe pas.<br/>
	 * - return null si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @return TableMotifsEntityJAXB : 
	 * Entity JAXB modélisant le contenu du fichier XML pFile.<br/>
	 * 
	 * @throws IOException 
	 * @throws JAXBException
	 */
	private TableMotifsEntityJAXB recupererEntites(
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
	
	

	/* CREATE ************/

		
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
	


	/* READ *************/

	
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
	public final Long retrieveId(
			final IMotif pObject, 
				final File pFile) 
						throws IOException, JAXBException {
		
		/* retourne 0 si pObject == null. */
		if (pObject == null) {
			return 0L;
		}
		
		/* retourne 0 si pFile == null. */
		if (pFile == null) {
			return 0L;
		}
		
		/* retourne 0 si pFile n'existe pas. */
		if (!pFile.exists()) {
			return 0L;
		}
		
		/* retourne 0 si pFile n'est pas un fichier simple. */
		if (!pFile.isFile()) {
			return 0L;
		}
		
		/* récupère la liste des objets métier stockés 
		 * dans le fichier XML. */
		final List<IMotif> listeObjetsMetier 
			= this.findAll(pFile);
		
		if (listeObjetsMetier != null) {
			
			for (final IMotif motif : listeObjetsMetier) {
				
				if (motif.equals(pObject)) {
					return Long.valueOf(listeObjetsMetier.indexOf(motif));
				}
			}
			
		}
				
		/* retourne 0 si l'objet métier n'est pas 
		 * stocké dans le fichier XML pFile. */
		return 0L;
		
	} // Fin de retrieveId(...).___________________________________________


	
	/**
	 * <b>retourne le liste des objets métier stockés dans le fichier XML 
	 * pFile qui remplissent une condition métier</b>.<br/>
	 * <ul>
	 * <li>retourne une <b>liste vide</b> si 
	 * <i>aucune correspondance n'est trouvée</i>.</li>
	 * <li>récupère la liste des objets métier 
	 * stockés dans le fichier XML.</li>
	 * <li>ajoute au résultat tous les objets métier 
	 * remplissant la condition métier.</li>
	 * </ul>
	 * - retourne null si pString est blank.<br/>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pString : String : 
	 * String devant être contenue dans le nom des IMotif.<br/>
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @return List&lt;IMotif&gt; : 
	 * liste des IMotif stockés dans le fichier XML 
	 * dont le nom contient pString.<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
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
	

	
	
	/* UPDATE *************/


	/**
	 * <b>modifie sur disque dur dans le fichier XML pFile 
	 * l'objet d'index (0-based) pIndex avec les valeurs 
	 * contenues dans pObjectModifie</b>.<br/>
	 * <ul>
	 * <li><b>pIndex doit correspondre à l'index (0-based) 
	 * de l'objet métier à modifier</b>.</li>
	 * <li>récupère la liste des objets métier stockés 
	 * dans le fichier XML.</li>
	 * <li>substitue pObjectModifie à l'objet métier situé à pIndex.</li>
	 * <li>enregistre la liste modifiée sur disque.</li>
	 * </ul>
	 * - retourne null si pIndex == null ou 0.<br/>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un fichier simple.<br/> 
	 * - retourne null si pIndex est en dehors 
	 * de la liste des objets métier.<br/>
	 * <br/>
	 *
	 * @param pIndex : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pObjectModifie : IMotif : 
	 * Objet métier modifié.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return IMotif : objet métier modifié.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	@Override
	public final IMotif update(
			final Long pIndex
				, final IMotif pObjectModifie
					, final File pFile) 
							throws JAXBException, IOException {
		
		/* retourne null si pIndex == 0. */
		if (pIndex== null || pIndex == 0) {
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
	 * <b>retire l'objet métier d'index (0-based) pIndex 
	 * dans le fichier XML 
	 * pFile</b>.<br/>
	 * <ul>
	 * <li>ne fait rien si pIndex est en dehors 
	 * de la liste des objets métier.</li>
	 * <li>récupère la liste des objets métier stockés 
	 * dans le fichier XML.</li>
	 * <li>récupère l'objet métier à retirer par index.</li>
	 * <li>ne fait rien si l'objet métier d'index pIndex 
	 * n'existe pas.</li>
	 * <li>retire l'objet de la liste si il existe.</li>
	 * <li>enregistre la liste modifiée sur disque.</li>
	 * </ul>
	 * - ne fait rien si pIndex == 0.<br/>
	 * - ne fait rien si pFile == null.<br/>
	 * - ne fait rien si pFile n'existe pas.<br/>
	 * - ne fait rien si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pIndex : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
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
	 * <b>retire l'objet métier d'index (0-based) pIndex 
	 * dans le fichier XML 
	 * pFile</b>.<br/>
	 * retourne true si le retrait à bien été effectué.<br/>
	 * <ul>
	 * <li>retourne false si pIndex est en dehors 
	 * de la liste des objets métier.</li>
	 * <li>récupère la liste des objets métier stockés 
	 * dans le fichier XML.</li>
	 * <li>récupère l'objet métier à retirer par index.</li>
	 * <li>retourne false si l'objet métier d'index pIndex 
	 * n'existe pas.</li>
	 * <li>retire l'objet de la liste si il existe.</li>
	 * <li>enregistre la liste modifiée sur disque.</li>
	 * </ul>
	 * - retourne false si pIndex == 0.<br/>
	 * - retourne false si pFile == null.<br/>
	 * - retourne false si pFile n'existe pas.<br/>
	 * - retourne false si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pIndex : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return boolean : true si le retrait à bien été effectué.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
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
	 * <b>retourne true si l'objet métier pObject 
	 * d'identifiant ou d'index (0-based) pIndex 
	 * existe dans le stockage</b>.<br/>
	 *
	 * @param pIndex : Long : 
	 * identifiant ou index (0-based) de l'objet métier à 
	 * trouver dans le stockage.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return boolean : 
	 * true si l'objet métier existe dans le stockage.<br/>
	 *
	 * @throws JAXBException
	 * @throws IOException
	 */
	@Override
	public final boolean exists(
			final Long pIndex
				, final File pFile) 
						throws JAXBException, IOException  {
		return false;
	}
	

	
	/**
	 * Affiche à la console la liste de MODEL 
	 *(objets métier) pList sous forme de fichier XML.<br/>
	 * <ul>
	 * <li>ne fait rien si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IMotif&gt;
	 * 
	 * @throws JAXBException
	 */
	@Override
	public final void ecrireListeObjetsMetierXMLConsole(
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
	 * fournit une String pour l'affichage à la console 
	 * d'une Liste d'Objets métier.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IMotif&gt;.<br/>
	 * 
	 * @return : String.<br/>
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
	


} // FIN DE LA CLASSE MotifDaoJAXBGeneric.-----------------------------------
