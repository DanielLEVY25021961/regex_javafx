package levy.daniel.application.model.persistence.metier.regex.jaxb.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.persistence.metier.regex.jaxb.entities.impl.MotifEntityJAXB;
import levy.daniel.application.model.persistence.metier.regex.jaxb.entities.impl.TableMotifsEntityJAXB;


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



	/* CREATE ************/

	
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
	 * @throws IOException 
	 */
	IMotif create(IMotif pObject) 
			throws IOException, JAXBException;
	
	
	
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
	 * @throws IOException 
	 */
	IMotif create(IMotif pObject, File pFile) 
				throws IOException, JAXBException;


	
	/**
	 * <b>stocke sur disque l'itérable d'objets métier pList 
	 * dans un fichier XML <code>this.fichierXML</code></b>.<br/>
	 * <ul>
	 * <li>crée sur disque le fichier <code>this.fichierXML</code> 
	 * si il n'existe pas.</li>
	 * <li>itère sur chaque élément de l'itérable.</li>
	 * <li>stocke chaque élément de l'itérable dans le fichier XML 
	 * <i>si il ne crée pas de doublon</i> 
	 * (<b>gestion des doublons</b>).</li>
	 * </ul>
	 * - retourne null si pList == null.<br/>
	 * - retourne null si <code>this.fichierXML</code> == null.<br/>
	 * <br/>
	 *
	 * @param pList : Iterable&lt;IMotif&gt; : 
	 * liste d'objets métier.<br/>
	 * 
	 * @return Iterable&lt;IMotif&gt;
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	Iterable<IMotif> save(
			Iterable<IMotif> pList) 
						throws IOException, JAXBException;
	
	
	
	/**
	 * <b>stocke sur disque l'itérable d'objets métier pList 
	 * dans un fichier XML pFile</b>.<br/>
	 * <ul>
	 * <li>crée sur disque le fichier pFile si il n'existe pas.</li>
	 * <li>itère sur chaque élément de l'itérable.</li>
	 * <li>stocke chaque élément de l'itérable dans le fichier XML 
	 * <i>si il ne crée pas de doublon</i> 
	 * (<b>gestion des doublons</b>).</li>
	 * </ul>
	 * - retourne null si pList == null.<br/>
	 * - retourne null si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pList : Iterable&lt;IMotif&gt; : 
	 * liste d'objets métier.<br/>
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @return Iterable&lt;IMotif&gt;
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	Iterable<IMotif> save(
			Iterable<IMotif> pList
				, File pFile) 
						throws IOException, JAXBException;
	


	/* READ *************/

	
	/**
	 * <b>retourne un objet métier stocké dans le fichier XML 
	 * <code>this.fichierXML</code></b>.<br/>
	 * <ul>
	 * <li>recherche l'objet métier par son égalité métier 
	 * (equals()).</li>
	 * <li>retourne null si l'objet métier n'est pas 
	 * stocké dans le fichier XML <code>this.fichierXML</code>.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * - retourne null si <code>this.fichierXML</code> == null.<br/>
	 * - retourne null si <code>this.fichierXML</code> n'existe pas.<br/>
	 * - retourne null si <code>this.fichierXML</code> n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * 
	 * @return : IMotif : objet métier recherché.<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	IMotif retrieve(
			IMotif pObject) 
					throws IOException, JAXBException;
	
	
	
	/**
	 * <b>retourne un objet métier stocké dans le fichier XML 
	 * pFile</b>.<br/>
	 * <ul>
	 * <li>recherche l'objet métier par son égalité métier 
	 * (equals()).</li>
	 * <li>retourne null si l'objet métier n'est pas 
	 * stocké dans le fichier XML pFile.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @return : IMotif : objet métier recherché.<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	IMotif retrieve(
			IMotif pObject, 
				File pFile) 
					throws IOException, JAXBException;
	

	
	/**
	 * <b>retourne un objet métier recherché par son index (0-based) 
	 * dans la liste des objets métier modélisant le fichier XML 
	 * <code>this.fichierXML</code></b>.<br/>
	 * <ul>
	 * <li>recherche l'objet métier par son index (0-based) 
	 * dans la liste d'objets métier modélisant le fichier XML 
	 * <code>this.fichierXML</code>.</li>
	 * <li>retourne null si l'index n'existe pas dans la liste.</li>
	 * </ul>
	 * - retourne null si pId == 0.<br/>
	 * - retourne null si <code>this.fichierXML</code> == null.<br/>
	 * - retourne null si <code>this.fichierXML</code> 
	 * n'existe pas.<br/>
	 * - retourne null si <code>this.fichierXML</code> 
	 * n'est pas un fichier simple.<br/>
	 * <br/> 
	 *
	 * @param pId : int : 
	 * index (0-based) de l'objet métier dans la liste modélisant 
	 * le fichier XML.<br/> 
	 * 
	 * @return : IMotif : 
	 * objet métier recherché par son index (0-based).<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	IMotif findById(int pId) 
						throws IOException, JAXBException;

	
	
	/**
	 * <b>retourne un objet métier recherché par son index (0-based) 
	 * dans la liste des objets métier modélisant le fichier XML 
	 * pFile</b>.<br/>
	 * <ul>
	 * <li>recherche l'objet métier par son index (0-based)
	 * dans la liste d'objets métier modélisant le fichier XML 
	 * pFile.</li>
	 * <li>retourne null si l'index n'existe pas dans la liste.</li>
	 * </ul>
	 * - retourne null si pId == 0.<br/>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un fichier simple.<br/>
	 * <br/> 
	 *
	 * @param pId : int : 
	 * index (0-based) de l'objet métier dans la liste modélisant 
	 * le fichier XML.<br/> 
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @return : IMotif : 
	 * objet métier recherché par son index (0-based).<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	IMotif findById(
			int pId, 
				File pFile) 
						throws IOException, JAXBException;
	
	

	/**
	 * <b>retourne l'index (0-based) de l'objet métier pObject 
	 * dans la liste des objet métier stockés dans le fichier XML 
	 * <code>this.fichierXML</code></b>.<br/>
	 * <ul>
	 * <li>recherche l'objet métier par son égalité métier 
	 * (equals()).</li>
	 * <li>retourne 0 si l'objet métier n'est pas 
	 * stocké dans le fichier XML <code>this.fichierXML</code>.</li>
	 * </ul>
	 * - retourne 0 si pObject == null.<br/>
	 * - retourne 0 si <code>this.fichierXML</code> == null.<br/>
	 * - retourne 0 si <code>this.fichierXML</code> 
	 * n'existe pas.<br/>
	 * - retourne 0 si <code>this.fichierXML</code> 
	 * n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @return : int : index (0-based).<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	int retrieveId(
			IMotif pObject) 
						throws IOException, JAXBException;
	
	
	
	/**
	 * <b>retourne l'index (0-based) de l'objet métier pObject 
	 * dans la liste des objet métier stockés dans le fichier XML 
	 * pFile</b>.<br/>
	 * <ul>
	 * <li>recherche l'objet métier par son égalité métier 
	 * (equals()).</li>
	 * <li>retourne 0 si l'objet métier n'est pas 
	 * stocké dans le fichier XML pFile.</li>
	 * </ul>
	 * - retourne 0 si pObject == null.<br/>
	 * - retourne 0 si pFile == null.<br/>
	 * - retourne 0 si pFile n'existe pas.<br/>
	 * - retourne 0 si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @return : int : index (0-based).<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	int retrieveId(
			IMotif pObject, 
				File pFile) 
						throws IOException, JAXBException;
	
	

	/**
	 * <b>retourne le liste des objets métier stockés dans le fichier XML 
	 * <code>this.fichierXML</code> qui remplissent une condition métier</b>.<br/>
	 * <ul>
	 * <li>retourne une <b>liste vide</b> si 
	 * <i>aucune correspondance n'est trouvée</i>.</li>
	 * <li>récupère la liste des objets métier 
	 * stockés dans le fichier XML.</li>
	 * <li>ajoute au résultat tous les objets métier 
	 * remplissant la condition métier.</li>
	 * </ul>
	 * - retourne null si pString est blank.<br/>
	 * - retourne null si <code>this.fichierXML</code> == null.<br/>
	 * - retourne null si <code>this.fichierXML</code> 
	 * n'existe pas.<br/>
	 * - retourne null si <code>this.fichierXML</code> 
	 * n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pString : String : 
	 * String devant être contenue dans le nom des IMotif.<br/>
	 * 
	 * @return List&lt;IMotif&gt; : 
	 * liste des IMotif stockés dans le fichier XML 
	 * dont le nom contient pString.<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	List<IMotif> findByMetier(String pString) 
					throws IOException, JAXBException;
	
	
	
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
	List<IMotif> findByMetier(
			String pString, 
				File pFile) 
					throws IOException, JAXBException;
	

	
	/**
	 * <b>Récupére la liste de tous les MODEL</b> 
	 * stockés dans le fichier XML <code>this.fichierXML</code>
	 * correspondant à une Entity JAXB.<br/>
	 * <ul>
	 * <li>récupère la modélisation du fichier XML 
	 * sous forme d'entité JAXB.</li>
	 * <li>récupère la liste des entités JAXB contenues 
	 * dans la modélisation du fichier XML.</li>
	 * <li>convertit la liste d'entités JAXB en liste 
	 * d'objets métier.</li>
	 * </ul>
	 * - return null si <code>this.fichierXML</code> == null.<br/>
	 * - return null si <code>this.fichierXML</code> n'existe pas.<br/>
	 * - return null si <code>this.fichierXML</code> n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @return List&lt;IMotif&gt; : 
	 * liste de tous les Objets métier dans le stockage.<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	List<IMotif> findAll() 
					throws JAXBException, IOException;
	
	
	
	/**
	 * <b>Récupére la liste de tous les MODEL</b> 
	 * stockés dans le fichier XML 
	 * correspondant à une Entity JAXB.<br/>
	 * <ul>
	 * <li>récupère la modélisation du fichier XML 
	 * sous forme d'entité JAXB.</li>
	 * <li>récupère la liste des entités JAXB contenues 
	 * dans la modélisation du fichier XML.</li>
	 * <li>convertit la liste d'entités JAXB en liste 
	 * d'objets métier.</li>
	 * </ul>
	 * - return null si pFile == null.<br/>
	 * - return null si pFile n'existe pas.<br/>
	 * - return null si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return List&lt;IMotif&gt; : 
	 * liste de tous les Objets métier dans le stockage.<br/>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	List<IMotif> findAll(File pFile) 
			throws IOException, JAXBException;
	


	/* UPDATE *************/

	
	/**
	 * <b>modifie sur disque dur dans le fichier XML 
	 * <code>this.fichierXML</code> 
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
	 * - retourne null si pIndex == 0.<br/>
	 * - retourne null si <code>this.fichierXML</code> == null.<br/>
	 * - retourne null si <code>this.fichierXML</code> n'existe pas.<br/>
	 * - retourne null si <code>this.fichierXML</code> n'est pas un fichier simple.<br/> 
	 * - retourne null si pIndex est en dehors 
	 * de la liste des objets métier.<br/>
	 * <br/>
	 *
	 * @param pIndex : int : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pObjectModifie : IMotif : 
	 * Objet métier modifié.<br/>
	 * 
	 * @return IMotif : objet métier modifié.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	IMotif update(
			int pIndex
				, IMotif pObjectModifie) 
							throws JAXBException, IOException;
	
	

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
	 * - retourne null si pIndex == 0.<br/>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un fichier simple.<br/> 
	 * - retourne null si pIndex est en dehors 
	 * de la liste des objets métier.<br/>
	 * <br/>
	 *
	 * @param pIndex : int : 
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
	IMotif update(
			int pIndex
				, IMotif pObjectModifie
					, File pFile) 
							throws JAXBException, IOException;


	
	/* DELETE *************/
	
	/**
	 * <b>retire l'objet métier pObject dans le fichier XML 
	 * <code>this.fichierXML</code></b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 * <ul>
	 * <li>récupère la liste des objets métier 
	 * stockés dans le fichier XML.</li>
	 * <li>retire pObject de la liste si il existe.</li>
	 * <li>enregistre la liste modifiée sur disque.</li>
	 * <li>retourne false si pObject n'est pas stocké 
	 * dans le fichier XML.</li>
	 * </ul>
	 * - retourne false si pObject == null.<br/>
	 * - retourne false si <code>this.fichierXML</code> == null.<br/>
	 * - retourne false si <code>this.fichierXML</code> n'existe pas.<br/>
	 * - retourne false si <code>this.fichierXML</code> n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à détruire.<br/>
	 * 
	 * @return : boolean : 
	 * true si l'objet métier a été détruit.<br/>
	 * 
	 * @throws IOException 
	 * @throws JAXBException 
	 */
	boolean delete(
			IMotif pObject) 
						throws JAXBException, IOException;
	

	
	/**
	 * <b>retire l'objet métier pObject dans le fichier XML 
	 * pFile</b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 * <ul>
	 * <li>récupère la liste des objets métier 
	 * stockés dans le fichier XML.</li>
	 * <li>retire pObject de la liste si il existe.</li>
	 * <li>enregistre la liste modifiée sur disque.</li>
	 * <li>retourne false si pObject n'est pas stocké 
	 * dans le fichier XML.</li>
	 * </ul>
	 * - retourne false si pObject == null.<br/>
	 * - retourne false si pFile == null.<br/>
	 * - retourne false si pFile n'existe pas.<br/>
	 * - retourne false si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à détruire.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return : boolean : 
	 * true si l'objet métier a été détruit.<br/>
	 * 
	 * @throws IOException 
	 * @throws JAXBException 
	 */
	boolean delete(
			IMotif pObject
				, File pFile) 
						throws JAXBException, IOException;


	
	/**
	 * <b>retire l'objet métier d'index (0-based) pIndex 
	 * dans le fichier XML 
	 * <code>this.fichierXML</code></b>.<br/>
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
	 * - ne fait rien si <code>this.fichierXML</code> == null.<br/>
	 * - ne fait rien si <code>this.fichierXML</code> 
	 * n'existe pas.<br/>
	 * - ne fait rien si <code>this.fichierXML</code> 
	 * n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pIndex : int : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	void deleteById(
			int pIndex) throws JAXBException, IOException;

	
	
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
	 * @param pIndex : int : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	void deleteById(
			int pIndex
				, File pFile) 
						throws JAXBException, IOException;
	

	
	/**
	 * <b>retire l'objet métier d'index (0-based) pIndex 
	 * dans le fichier XML 
	 * <code>this.fichierXML</code></b>.<br/>
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
	 * - retourne false si <code>this.fichierXML</code> == null.<br/>
	 * - retourne false si <code>this.fichierXML</code> 
	 * n'existe pas.<br/>
	 * - retourne false si <code>this.fichierXML</code> 
	 * n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pIndex : int : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * 
	 * @return boolean : true si le retrait à bien été effectué.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	boolean deleteByIdBoolean(int pIndex) 
						throws JAXBException, IOException;
	
	
	
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
	 * @param pIndex : int : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return boolean : true si le retrait à bien été effectué.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	boolean deleteByIdBoolean(
			int pIndex
				, File pFile) 
						throws JAXBException, IOException;
	
	

	/* TOOLS *************/

	
	/**
	 * <b>retourne true si l'objet métier pObject 
	 * existe dans le fichier XML <code>this.fichierXML</code></b>.<br/>
	 * <ul>
	 * <li>récupère la liste des objets métier stockés 
	 * dans le fichier XML.</li>
	 * <li>retourne false si la liste ne contient pas 
	 * l'objet métier.</li>
	 * <li>retourne true si la liste contient l'objet métier.</li>
	 * </ul>
	 * - retourne false si pObject == null.<br/>
	 * - retourne false si <code>this.fichierXML</code> == null.<br/>
	 * - retourne false si <code>this.fichierXML</code> 
	 * n'existe pas.<br/>
	 * - retourne false si <code>this.fichierXML</code> 
	 * n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * 
	 * @return boolean : 
	 * true si l'objet métier existe dans le fichier XML.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	boolean exists(
			IMotif pObject) 
						throws JAXBException, IOException;
	
	
	
	/**
	 * <b>retourne true si l'objet métier pObject 
	 * existe dans le fichier XML pFile</b>.<br/>
	 * <ul>
	 * <li>récupère la liste des objets métier stockés 
	 * dans le fichier XML.</li>
	 * <li>retourne false si la liste ne contient pas 
	 * l'objet métier.</li>
	 * <li>retourne true si la liste contient l'objet métier.</li>
	 * </ul>
	 * - retourne false si pObject == null.<br/>
	 * - retourne false si pFile == null.<br/>
	 * - retourne false si pFile n'existe pas.<br/>
	 * - retourne false si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * @param pFile : java.io.File : fichier XML.<br/>
	 * 
	 * @return boolean : 
	 * true si l'objet métier existe dans le fichier XML.<br/>
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	boolean exists(
			IMotif pObject
				, File pFile) 
						throws JAXBException, IOException;
	
	
	
	/**
	 * <b>retourne le nombre d'objets métier</b> 
	 * stockés dans le fichier XML <code>this.fichierXML</code>.<br/>
	 * <ul>
	 * <li>récupère le liste des objets métier stockés 
	 * dans le fichier XML.</li>
	 * <li>retourne le nombre d'éléments de la liste 
	 * sous forme de Long.</li>
	 * </ul>
	 * - retourne null si <code>this.fichierXML</code> == null.<br/>
	 * - retourne null si <code>this.fichierXML</code> 
	 * n'existe pas.<br/>
	 * - retourne null si <code>this.fichierXML</code> 
	 * n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @return : Long : 
	 * nombre d'enregistrements dans le stockage.<br/>
	 * 
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	Long count() throws IOException, JAXBException;
	
	
	
	/**
	 * <b>retourne le nombre d'objets métier</b> 
	 * stockés dans le fichier XML pFile.<br/>
	 * <ul>
	 * <li>récupère le liste des objets métier stockés 
	 * dans le fichier XML.</li>
	 * <li>retourne le nombre d'éléments de la liste 
	 * sous forme de Long.</li>
	 * </ul>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier XML.<br/>
	 * 
	 * @return : Long : 
	 * nombre d'enregistrements dans le stockage.<br/>
	 * 
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	Long count(File pFile) 
					throws IOException, JAXBException;
	
	
	
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
	 * @throws IOException
	 */
	void ecrireListeObjetsMetierXMLConsole() 
					throws JAXBException, IOException;
	
	
	
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
	 * @throws IOException
	 */
	void ecrireListeObjetsMetierXMLConsole(
			File pFile) 
					throws JAXBException, IOException;
	
	
	
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
	 * @throws @throws IOException 
	 * @throws JAXBException
	 */
	TableMotifsEntityJAXB recupererEntites(File pFile) 
							throws IOException , JAXBException;



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
