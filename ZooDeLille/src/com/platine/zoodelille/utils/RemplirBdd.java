package com.platine.zoodelille.utils;

import java.util.Date;

import android.content.Context;

import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.beans.Article;
import com.platine.zoodelille.beans.PracticalInformation;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.ArticleDao;
import com.platine.zoodelille.dao.PracticalInformationDao;


/**
 * Classe de développement servant à remplir manuellement la base de données. 
 *
 */
public class RemplirBdd {

	/**
	 * Permet de remplir la base de données avec des animaux.
	 * @param ctx Le contexte d'application.
	 */
	public static void ajouterDesAnimaux(){
		
		/** Les Mamiféres **/
		AnimalDao animalDao = DatabaseManager.getDao().getAnimalDao();
		Animal alpaga = new Animal("Alpaga", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal capucinBrun = new Animal("Capucin brun", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal capybara = new Animal("Capybara", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal chatPecheur = new Animal("Chat pêcheur", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal coatiBrun = new Animal("Coati brun", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal gibbonAMainsBlanches = new Animal("Gibbon à mains blanches", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal elandDuCap = new Animal("Eland du Cap", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal kinkajou = new Animal("Kinkajou", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal lievreDePatagonie = new Animal("Lièvre de Patagonie", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal lorisLentPygmee = new Animal("Loris lent pygmée", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal makiCatta = new Animal("Maki catta", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal mangousteJaune = new Animal("Mangouste jaune", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal ouistitiDeGeoffroy = new Animal("Ouistiti de Geoffroy", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal pandaRoux = new Animal("Panda roux", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal petitChevrotainMalais = new Animal("Petit chevrotain malais", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal porcEpicACrete = new Animal("Porc-épic à crête", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal renardVolant = new Animal("Renard volant", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal rhinocerosBlanc = new Animal("Rhinocéros blanc", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal siamang = new Animal("Siamang", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal suricate = new Animal("Suricate", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal tamarinEmpereur = new Animal("Tamarin empereur", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal tamarinLabie = new Animal("Tamarin labié", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal tapirTerrestre = new Animal("Tapir terrestre", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal variNoirEtBlanc = new Animal("Vari noir et blanc", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		Animal variRoux = new Animal("Vari roux", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal zebreDeBurchell = new Animal("Zèbre de Burchell", 1, 1, "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, null);
		
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
		Animal agameCommun = new Animal("Agame commun", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal boaConstrictor = new Animal("Boa constrictor", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal boaDesArbresDeMadagascar = new Animal("Boa des arbres de Madagascar", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal couleuvreDAsie = new Animal("Couleuvre d’Asie", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal couleuvreDelAmour = new Animal("Couleuvre de l'Amour", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal iguaneVert = new Animal("Iguane vert", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal pelomeduseRoussatre = new Animal("Péloméduse roussâtre", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal serpentDeLait = new Animal("Serpent de lait", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal serpentDesBles = new Animal("Serpent des blés", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal serpentRoi = new Animal("Serpent roi", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal tortueDAldabra = new Animal("Tortue d’Aldabra", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal tortueDeFloride = new Animal("Tortue de Floride", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		Animal tortueGrecque = new Animal("Tortue grecque", 1, 1, "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, null);
		
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
	
	public static void ajouterArticle(Context context){
		ArticleDao articleDao = DatabaseManager.getDao().getArticleDao();
		Article a1= new Article("Le Zoo se cherche un avenir", "Il est nécessaire de faire aboutir le projet d’agrandissement et modernisation du zoo de Lille. C’est le message que rappelle à la mairie l'association Zooalil, " +
				"qui a participé à une étude préalable, lancée il y a trois ans par la municipalité."+
				"Le but : faire passer le zoo de 3,5 à 12 ha, tout en améliorant la pédagogie et l’accueil des animaux. Le parc a été créé en 1953, il a aujourd’hui vieilli dans son fonctionnement, déplore Pierre Dhénin, président de Zooalil. " +
				"Il est nécessaire de moderniser ce lieu, qui est le plus visité de la région, avec " +
				"un million de visiteurs par an. L'époque de la simple exhibition des animaux est terminée. Il faut dorénavant un vrai projet à la fois scientifique, social et culturel."+
				"Un projet gelé faute de moyens Le projet estimé à 100 millions deuros, qui propose dix thématiques en particulier autour des relations de l'homme et des animaux, a été gelé pour raisons budgétaires. " +
				"Au début du mandat, je ne disposais que de 10 millions d’euros sur ce dossier, nous indique Cyrille Pradal, conseiller municipal (EELV) chargé du zoo." +
				"Selon lui, les cartes vont être rebattues à l’occasion des élections municipales, même si ce n’est pas une priorité vitale : Le zoo pourrait très bien rester " +
				"gratuit pour les Lillois, qui l’ont financé pendant des années, et devenir payant pour les Nordistes qui représentent 83 % des visites. Le conseil régional pourrait aussi mettre la main au portefeuille."+
				"Selon un sondage réalisé auprès d’une centaine de visiteurs, ceux-ci accepteraient de payer si cela se traduit pas de meilleures conditions de captivité et si des programmes de conservation des espèces " +
				"sont mis en place.", new Date().toString(), "Le projet d’agrandissement et de modernisation a été mis entre parenthèse par la mairie de Lille pour des raisons budgétaires. ","zoo_avenir_elephant");
		
		Article a2= new Article("Arrivée de Bonobo du Congo", "Après le décès de Grishka, tigre de Sibérie, mort de vieillesse à 18 ans le 29 juillet. Radja le nouveau tigre est finalement arrivé au zoo après un voyage assez éprouvant. " +
				"Ses premiers pas lui ont permis de découvrir son enclos et son nouvel environnement. Les tigres blancs, des hôtes de zoo très recherchés :Il ne reste, au mieux, que 4.000 tigres à l'état sauvage. Par contre, en captivité, " +
				"ils sont peut-être des dizaines de milliers à travers le monde, il n'existe aucun recensement officiel. Il pourrait s'agir d'un argument de poids en faveur des zoos et des collections privées. Si les tigres arrivent à survivre" +
				"et à se reproduire correctement en captivité, alors pourrait-on peut-être en réintroduire davantage dans la nature, quand leurs habitats seront sûrs.Mais ce système ne fonctionne pas comme on le pense. " +
				"En captivité, les tigres sont très souvent des hybrides de diverses sous-espèces tellement consanguines qu'ils ne seront jamais adaptés à une réintroduction dans la nature. " +
				"Et aucun tigre n'est plus emblématique de ce problème que le tigre blanc. Ces félins ne sont pas une sous-espèce, mais le résultat d'un gène mutant sélectionné artificiellement " +
				"par consanguinité.", new Date().toString(), "Suite et fin du voyage de radja, le jeune tigre blanc. Après plusieurs centaines de kilomètres, le petit tigre blanc est arrivée hier soir au zoo d' Asson en Béarn. " +
				"Un animal mythique très attendu sur place.","bonobo");
		
		Article a3= new Article("Dernier jour d’ouverture, ce dimanche, avant la trêve", "C’est le dernier jour, ce dimanche 8 décembre (de 10 h à 17 h), pour rendre visite aux quelque 350 animaux (70 espèces, présentées dans six zones thématiques) " +
				"du zoo de Lille. L’occasion pour les pensionnaires de se retrouver un peu entre eux et pour le personnel de réaliser de menus travaux. Le zoo rouvrira le 9 février. Avenue Mathias-Delobel. " +
				"Entrée gratuite. 03 28 52 07 00.", new Date().toString(), "Le parc ferme ce dimanche soir à 17h et ne rouvrira que le 9 février, après la trêve hivernale.","dernier_jour");
		
		Article a4= new Article("Un singe s'échappe du zoo de Lille", "Nicolas, un gibbon du zoo de Lille, a réussi ce matin à s'échapper de son enclos puis du parc animalier, situé dans les jardins de la Citadelle, à proximité du centre-ville. " +
				"Sitôt son escapade constatée, les autorités ont fermé les entrées du zoo et formé un cordon de sécurité, raconte la Voix du Nord.Le personnel du zoo s'est équipé de grandes filets et de fléchettes tranquillisantes pour récupérer" +
				" Nicolas, mais, comme on peut l'imaginer, difficile d'attraper un singe aussi agile ... Le gibbon a ainsi nargué pendant une heure et demi le personnel, " +
				"sous l'oeil amusé des passants.", new Date().toString(), "Nicolas, un gibbon du zoo de Lille, a réussi ce matin à s'échapper de son enclos puis du parc animalier","singe_echappe");
		
		Article a5= new Article("Le Zoo de Lille met à l'honneur les espèces asiatiques", "Par grand froid, il arrive toutefois que plusieurs espèces, comme le saki, se voient interdites d'accès extérieur. D'autres, comme l'alpaga ou la chouette" +
				" Harfang des neiges, originaire du Nord de l'Europe, sont en revanche tout à fait à leur aise. « Nous adaptons leur traitement, explique un soignant. Mais les animaux savent répondre à leurs propres besoins. Quand ils ont trop froid, " +
				"ils restent de toute façon à l'intérieur. » Cet hiver, l'équipe du zoo n'a pas eu à soigner le moindre rhume.Chat pêcheur, panda roux « Quand on est fermé au public, les animaux sont un peu plus calmes, observe le soignant. " +
				"Certains osent davantage se promener. » L'équipe du zoo a profité de ces quelques semaines de battement pour préparer la campagne de sensibilisation sur les animaux d'Asie du Sud-Est, qui durera jusqu'au 28 avril. " +
				"Pendant les vacances de février, chaque mercredi et dimanche à 14 h et 15 h, aura lieu une présentation ou un nourrissage des espèces asiatiques du zoo : panda roux d'Himalaya, gibbon à mains blanches d'Indonésie, " +
				"porc épiça, chat pêcheur, renard volant des Philippines... Membre de plusieurs associations mondiales qui oeuvrent pour la conservation des espèces, le zoo de Lille mène des opérations de sensibilisation tout au long de l'année." +
				"Si le parc attire en premier lieu les habitants de la métropole, beaucoup de Belges ou de touristes parisiens en profitent pour y prendre un bon bol d'air.« À Paris, à part le zoo de Vincennes en banlieue, " +
				"il n'y a que des ménageries, plus petites que ce zoo », témoigne une jeune femme. Le parc lillois s'étend en effet sur 3,5 ha. " +
				"De quoi s'autoriser une belle balade.", new Date().toString(), "Maintenant au Zoo, Panda roux d'Himalaya, gibbon à mains blanches d'Indonésie, porc épiça, chat pêcheur, renard volant des Philippines","zoo_asiatique");
		
		
		articleDao.save(a1);
		articleDao.save(a2);
		articleDao.save(a3);
		articleDao.save(a4);
		articleDao.save(a5);
	}
	
	public static void ajouterPraticalInformation(){
		
		PracticalInformationDao practicalInformationDao = DatabaseManager.getDao().getPracticalInformationDao();			
		// ouvre a 9h
		String summer_week_opening_time = "9";
		// ferme a 18h
		String summer_week_closing_time = "18";
		// ouvre 9h
		String summer_weekend_opening_time = "9";
		// ferme a 19h
		String summer_weekend_closing_time = "19";
		// ouvre a 10h
		String winter_week_opening_time = "10";
		// ferme a 17h
		String winter_week_closing_time = "17";
		// ouvre a 10h
		String winter_weekend_opening_time = "10";
		// ferme a 17h
		String winter_weekend_closing_time = "17";
		// ferme 9 decembre (pour 2013)
		String annual_closing = "9/12/2013";
		// ouverture 9 février 2014
		String annual_opening = "09/02/2014";
	
		PracticalInformation p = new PracticalInformation(summer_week_opening_time,summer_week_closing_time,summer_weekend_opening_time,summer_weekend_closing_time,winter_week_opening_time,winter_week_closing_time,winter_weekend_opening_time,winter_weekend_closing_time,annual_closing,annual_opening);
		practicalInformationDao.save(p);	
	}
	
}
