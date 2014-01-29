package com.platine.zoodelille.utils;

import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.beans.Enclosure;
import com.platine.zoodelille.beans.Garbage;
import com.platine.zoodelille.beans.LocatableElement;
import com.platine.zoodelille.beans.Restroom;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.EnclosureDao;
import com.platine.zoodelille.dao.GarbageDao;
import com.platine.zoodelille.dao.RestroomDao;


/**
 * Classe de développement servant à remplir manuellement la base de données. 
 *
 */
public class RemplirBdd {

	/**
	 * Permet de remplir la base de données avec des animaux.
	 * @param ctx Le contexte d'application.
	 */
	public static void ajouterDesAnimaux(Context ctx){
		
		EnclosureDao enclosureDao = DatabaseManager.getDao().getEnclosureDao();
		List<Enclosure> enclosures = enclosureDao.findAll();
		HashMap<String, Enclosure> enclosures_dico = EnclosureHelper.transformToHashMap(enclosures);
		
		
		/** Les Mamiféres **/
		AnimalDao animalDao = DatabaseManager.getDao().getAnimalDao();
		Animal alpaga = new Animal("Alpaga", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Asie"));
		Animal capucinBrun = new Animal("Capucin brun", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Volières"));
		Animal capybara = new Animal("Capybara", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal chatPecheur = new Animal("Chat pêcheur", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Asie"));
		Animal coatiBrun = new Animal("Coati brun", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Amérique"));
		Animal gibbonAMainsBlanches = new Animal("Gibbon à mains blanches", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Afrique"));
		Animal elandDuCap = new Animal("Eland du Cap", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Amérique"));
		Animal kinkajou = new Animal("Kinkajou", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Afrique"));
		Animal lievreDePatagonie = new Animal("Lièvre de Patagonie", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal lorisLentPygmee = new Animal("Loris lent pygmée", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Afrique"));
		Animal makiCatta = new Animal("Maki catta", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Amérique"));
		Animal mangousteJaune = new Animal("Mangouste jaune", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Madagascar"));
		Animal ouistitiDeGeoffroy = new Animal("Ouistiti de Geoffroy", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Ile des singes"));
		Animal pandaRoux = new Animal("Panda roux", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Asie"));
		Animal petitChevrotainMalais = new Animal("Petit chevrotain malais", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal porcEpicACrete = new Animal("Porc-épic à crête", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Afrique"));
		Animal renardVolant = new Animal("Renard volant", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal rhinocerosBlanc = new Animal("Rhinocéros blanc", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Volières"));
		Animal siamang = new Animal("Siamang", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Ile des singes"));
		Animal suricate = new Animal("Suricate", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Madagascar"));
		Animal tamarinEmpereur = new Animal("Tamarin empereur", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal tamarinLabie = new Animal("Tamarin labié", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Afrique"));
		Animal tapirTerrestre = new Animal("Tapir terrestre", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal variNoirEtBlanc = new Animal("Vari noir et blanc", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Terre d'Afrique"));
		Animal variRoux = new Animal("Vari roux", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Volières"));
		Animal zebreDeBurchell = new Animal("Zèbre de Burchell", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null, enclosures_dico.get("Madagascar"));
		
		animalDao.save(alpaga);
		animalDao.save(capucinBrun);
		animalDao.save(capybara);
		animalDao.save(chatPecheur);
		animalDao.save(coatiBrun);
		animalDao.save(gibbonAMainsBlanches);
		animalDao.save(elandDuCap);
		animalDao.save(kinkajou);
		animalDao.save(lievreDePatagonie);
		animalDao.save(lorisLentPygmee);
		animalDao.save(makiCatta);
		animalDao.save(mangousteJaune);
		animalDao.save(ouistitiDeGeoffroy);
		animalDao.save(pandaRoux);
		animalDao.save(petitChevrotainMalais);
		animalDao.save(porcEpicACrete);
		animalDao.save(renardVolant);
		animalDao.save(rhinocerosBlanc);
		animalDao.save(siamang);
		animalDao.save(suricate);
		animalDao.save(tamarinEmpereur);
		animalDao.save(tamarinLabie);
		animalDao.save(tapirTerrestre);
		animalDao.save(variNoirEtBlanc);
		animalDao.save(variRoux);
		animalDao.save(zebreDeBurchell);
		
		/** Les Reptiles **/
		Animal agameCommun = new Animal("Agame commun", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal boaConstrictor = new Animal("Boa constrictor", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal boaDesArbresDeMadagascar = new Animal("Boa des arbres de Madagascar", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal couleuvreDAsie = new Animal("Couleuvre d’Asie", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal couleuvreDelAmour = new Animal("Couleuvre de l'Amour", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal iguaneVert = new Animal("Iguane vert", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal pelomeduseRoussatre = new Animal("Péloméduse roussâtre", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Terre d'Afrique"));
		Animal serpentDeLait = new Animal("Serpent de lait", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal serpentDesBles = new Animal("Serpent des blés", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal serpentRoi = new Animal("Serpent roi", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal tortueDAldabra = new Animal("Tortue d’Aldabra", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal tortueDeFloride = new Animal("Tortue de Floride", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		Animal tortueGrecque = new Animal("Tortue grecque", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null, enclosures_dico.get("Maison tropicale"));
		
		animalDao.save(agameCommun);
		animalDao.save(boaConstrictor);
		animalDao.save(boaDesArbresDeMadagascar);
		animalDao.save(couleuvreDAsie);
		animalDao.save(couleuvreDelAmour);
		animalDao.save(iguaneVert);
		animalDao.save(pelomeduseRoussatre);
		animalDao.save(serpentDeLait);
		animalDao.save(serpentDesBles);
		animalDao.save(serpentRoi);
		animalDao.save(tortueDAldabra);
		animalDao.save(tortueDeFloride);
		animalDao.save(tortueGrecque);
	

	}	
	
	/**
	 * Ajoute les poubelles à la base de données
	 * @param ctx
	 */
	public static void addGarbages(Context ctx){
		GarbageDao gDao = DatabaseManager.getDao().getGarbageDao();
		Garbage g1 = new Garbage(new LocatableElement(86,49));
		Garbage g2 = new Garbage(new LocatableElement(68,93));

		gDao.save(g1);
		gDao.save(g2);
	}
	
	/**
	 * Ajoute les toilettes à la base de données
	 * @param ctx
	 */
	public static void addRestroom(Context ctx){
		RestroomDao rDao = DatabaseManager.getDao().getRestroomDao();
		Restroom r1 = new Restroom(new LocatableElement(81, 53));
		
		rDao.save(r1);
	}
	
	/**
	 * Ajoute les enclos à la base de données
	 * @param ctx
	 */
	public static void addEnclosures(Context ctx){
		EnclosureDao eDao = DatabaseManager.getDao().getEnclosureDao();
		
		Enclosure ile_singes = new Enclosure("Ile des singes", new LocatableElement(24, 25));
		Enclosure amerique = new Enclosure("Terre d'Amérique", new LocatableElement(57, 56));
		Enclosure tropicale = new Enclosure("Maison tropicale", new LocatableElement(76, 42));
		Enclosure voliere = new Enclosure("Volières", new LocatableElement(87, 65));
		Enclosure asie = new Enclosure("Terre d'Asie", new LocatableElement(43, 24));
		Enclosure madagascar = new Enclosure("Madagascar", new LocatableElement(76, 68));
		Enclosure afrique = new Enclosure("Terre d'Afrique", new LocatableElement(38, 79));
		
		eDao.save(ile_singes);
		eDao.save(amerique);
		eDao.save(tropicale);
		eDao.save(voliere);
		eDao.save(asie);
		eDao.save(madagascar);
		eDao.save(afrique);
	}
}
