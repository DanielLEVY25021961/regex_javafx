package levy.daniel.application.model.dao.metier.regex.jaxb.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBException;

import levy.daniel.application.model.dao.metier.regex.jaxb.entities.impl.MotifEntityJAXB;
import levy.daniel.application.model.dao.metier.regex.jaxb.entities.impl.TableMotifsEntityJAXB;
import levy.daniel.application.model.metier.regex.IMotif;


/**
 * INTERFACE <b>IMotifDaoJAXB</b> :<br/>
 * Interface factorisant les comportements des DAO MotifDaoJAXB.<br/>
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
public interface IMotifDaoJAXB {
	
	

	/**
	 * SAUT_LIGNE_JAVA : Character :<br/>
	 * saut de ligne "\n".<br/>
	 */
	String SAUT_LIGNE_JAVA = "\n";


	
	/**
	 * <b>stocke l'objet métier pObject 
	 * dans le fichier XML <code>this.fichierXML</code></b>.<br/>
	 * <ul>
	 * <li>crée sur disque le fichier <code>this.fichierXML</code> 
	 * si il n'existe pas.</li>
	 * <li>récupère ou crée la liste des objets métier 
	 * déjà stockés dans le fichier XML <code>this.fichierXML</code>.</li>
	 * <li>ajoute l'objet métier pObject à la liste 
	 * si pObject n'est pas déjà stocké (<b>gestion des doublons</b>).</li>
	 * <li>enregistre la nouvelle liste dans le fichier XML 
	 * <code>this.fichierXML</code>.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * - retourne null si this.fichierXML == null.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif.<br/>
	 *  
	 * @return : IMotif : le MODEL stocké dans le fichier.<br/>
	 * 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	IMotif create(IMotif pObject) 
			throws FileNotFoundException, JAXBException;
	
	
	
	/**
	 * <b>stocke l'objet métier pObject 
	 * dans un fichier XML pFile</b>.<br/>
	 * <ul>
	 * <li>crée sur disque le fichier pFile si il n'existe pas.</li>
	 * <li>récupère ou crée la liste des objets métier 
	 * déjà stockés dans le fichier XML pFile.</li>
	 * <li>ajoute l'objet métier pObject à la liste 
	 * si pObject n'est pas déjà stocké (<b>gestion des doublons</b>).</li>
	 * <li>enregistre la nouvelle liste dans le fichier XML pFile.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * - retourne null si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif.<br/>
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 *  
	 * @return : IMotif : le MODEL stocké dans le fichier.<br/>
	 * 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	IMotif create(IMotif pObject, File pFile) 
				throws FileNotFoundException, JAXBException;



	/**
	 * Enregistre sur disque dans le fichier XML pFile 
	 * la liste de MODEL (objets métier) pList.<br/>
	 * <ul>
	 * <li>Crée pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * <li>ne fait rien si pList == null.</li>
	 * <li>ne fait rien si pFile == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IMotif&gt;.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws JAXBException
	 */
	void enregistrer(List<IMotif> pList, File pFile) 
				throws JAXBException;


	
	/**
	 * <b>écrit à la console le contenu du fichier XML 
	 * <code>this.fichierXML</code></b>.<br/>
	 * <ul>
	 * <li>utilise <code>marshaller.marshal(
	 * pTableEntitiesJAXB, System.out)</code>.</li>
	 * </ul>
	 * - ne fait rien si <code>this.fichierXML</code> == null.<br/>
	 * - ne fait rien si <code>this.fichierXML</code> n'existe pas.<br/>
	 * - ne fait rien si <code>this.fichierXML</code> n'est pas un fichier simple.<br/>
	 * - ne fait rien si il est impossible de récupérer 
	 * la liste d'enregistrements dans <code>this.fichierXML</code>.<br/>
	 * <br/>
	 *
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	void ecrireListeObjetsMetierXMLConsole() 
					throws JAXBException, FileNotFoundException;
	
	
	
	/**
	 * <b>écrit à la console le contenu du fichier XML pFile</b>.<br/>
	 * <ul>
	 * <li>utilise <code>marshaller.marshal(
	 * pTableEntitiesJAXB, System.out)</code>.</li>
	 * </ul>
	 * - ne fait rien si pFile == null.<br/>
	 * - ne fait rien si pFile n'existe pas.<br/>
	 * - ne fait rien si pFile n'est pas un fichier simple.<br/>
	 * - ne fait rien si il est impossible de récupérer 
	 * la liste d'enregistrements dans pFile.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	void ecrireListeObjetsMetierXMLConsole(
			File pFile) 
					throws JAXBException, FileNotFoundException;
	
	
	
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
	void ecrireListeObjetsMetierXMLConsole(List<IMotif> pList) 
				throws JAXBException;



	/**
	 * Récupére la liste des MODEL dans le fichier XML 
	 * correspondant à une Entity JAXB.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @return List&lt;IMotif&gt;.<br/>
	 * 
	 * @throws FileNotFoundException
	 * @throws JAXBException :  :  .<br/>
	 */
	List<IMotif> recupererListeModeles(File pFile) 
			throws FileNotFoundException, JAXBException;



	/**
	 * Récupère une Entity JAXB à partir du fichier XML pFile.<br/>
	 * <ul>
	 * <li>return null si pFile == null.</li>
	 * <li>return null si pFile n'existe pas.</li>
	 * <li>return null si pFile n'est pas un fichier simple.</li>
	 * </ul>
	 *
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @return TableMotifsEntityJAXB : 
	 * Entity JAXB modélisant le contenu du fichier XML pFile.<br/>
	 * 
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 */
	TableMotifsEntityJAXB recupererEntites(File pFile) 
			throws FileNotFoundException, JAXBException;



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
	String afficherListeEntitiesDansTable(TableMotifsEntityJAXB pTableEntities);



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
	String afficherListeObjetsMetier(List<IMotif> pList);



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
	String afficherListeEntityJAXB(List<MotifEntityJAXB> pList);



	/**
	 * method getFichierXML() :<br/>
	 * Getter du fichier XML dans lequel écrire les entities JAXB.<br/>
	 * <br/>
	 *
	 * @return fichierXML : File.<br/>
	 */
	File getFichierXML();



	/**
	* method setFichierXML(
	* File pFichierXML) :<br/>
	* Setter du fichier XML dans lequel écrire les entities JAXB.<br/>
	* <br/>
	*
	* @param pFichierXML : File : valeur à passer à fichierXML.<br/>
	*/
	void setFichierXML(File pFichierXML);
	
	
	
} // FIN DE L'INTERFACE IMotifDaoJAXB.-------------------------------------
