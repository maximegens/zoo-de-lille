package com.platine.zoodelille.utils;

import android.content.Context;

import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.dao.AnimalDao;


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
		
		/** Les Mamiféres **/
//		AnimalDao animalDao = DatabaseManager.getDao().getAnimalDao();
//		Animal alpaga = new Animal("Alpaga", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal capucinBrun = new Animal("Capucin brun", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal capybara = new Animal("Capybara", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal chatPecheur = new Animal("Chat pêcheur", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal coatiBrun = new Animal("Coati brun", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal gibbonAMainsBlanches = new Animal("Gibbon à mains blanches", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal elandDuCap = new Animal("Eland du Cap", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal kinkajou = new Animal("Kinkajou", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal lievreDePatagonie = new Animal("Lièvre de Patagonie", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal lorisLentPygmee = new Animal("Loris lent pygmée", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal makiCatta = new Animal("Maki catta", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal mangousteJaune = new Animal("Mangouste jaune", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal ouistitiDeGeoffroy = new Animal("Ouistiti de Geoffroy", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal pandaRoux = new Animal("Panda roux", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal petitChevrotainMalais = new Animal("Petit chevrotain malais", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal porcEpicACrete = new Animal("Porc-épic à crête", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal renardVolant = new Animal("Renard volant", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal rhinocerosBlanc = new Animal("Rhinocéros blanc", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal siamang = new Animal("Siamang", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal suricate = new Animal("Suricate", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal tamarinEmpereur = new Animal("Tamarin empereur", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal tamarinLabie = new Animal("Tamarin labié", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal tapirTerrestre = new Animal("Tapir terrestre", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal variNoirEtBlanc = new Animal("Vari noir et blanc", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
//		Animal variRoux = new Animal("Vari roux", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal zebreDeBurchell = new Animal("Zèbre de Burchell", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		
//		animalDao.save(alpaga);
//		animalDao.save(capucinBrun);
//		animalDao.save(capybara);
//		animalDao.save(chatPecheur);
//		animalDao.save(coatiBrun);
//		animalDao.save(gibbonAMainsBlanches);
//		animalDao.save(elandDuCap);
//		animalDao.save(kinkajou);
//		animalDao.save(lievreDePatagonie);
//		animalDao.save(lorisLentPygmee);
//		animalDao.save(makiCatta);
//		animalDao.save(mangousteJaune);
//		animalDao.save(ouistitiDeGeoffroy);
//		animalDao.save(pandaRoux);
//		animalDao.save(petitChevrotainMalais);
//		animalDao.save(porcEpicACrete);
//		animalDao.save(renardVolant);
//		animalDao.save(rhinocerosBlanc);
//		animalDao.save(siamang);
//		animalDao.save(suricate);
//		animalDao.save(tamarinEmpereur);
//		animalDao.save(tamarinLabie);
//		animalDao.save(tapirTerrestre);
//		animalDao.save(variNoirEtBlanc);
//		animalDao.save(variRoux);
//		animalDao.save(zebreDeBurchell);
		
		/** Les Reptiles **/
//		Animal agameCommun = new Animal("Agame commun", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal boaConstrictor = new Animal("Boa constrictor", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal boaDesArbresDeMadagascar = new Animal("Boa des arbres de Madagascar", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal couleuvreDAsie = new Animal("Couleuvre d’Asie", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal couleuvreDelAmour = new Animal("Couleuvre de l'Amour", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal iguaneVert = new Animal("Iguane vert", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal pelomeduseRoussatre = new Animal("Péloméduse roussâtre", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal serpentDeLait = new Animal("Serpent de lait", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal serpentDesBles = new Animal("Serpent des blés", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal serpentRoi = new Animal("Serpent roi", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal tortueDAldabra = new Animal("Tortue d’Aldabra", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal tortueDeFloride = new Animal("Tortue de Floride", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
//		Animal tortueGrecque = new Animal("Tortue grecque", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		
//		animalDao.save(agameCommun);
//		animalDao.save(boaConstrictor);
//		animalDao.save(boaDesArbresDeMadagascar);
//		animalDao.save(couleuvreDAsie);
//		animalDao.save(couleuvreDelAmour);
//		animalDao.save(iguaneVert);
//		animalDao.save(pelomeduseRoussatre);
//		animalDao.save(serpentDeLait);
//		animalDao.save(serpentDesBles);
//		animalDao.save(serpentRoi);
//		animalDao.save(tortueDAldabra);
//		animalDao.save(tortueDeFloride);
//		animalDao.save(tortueGrecque);
	

	}	
}
