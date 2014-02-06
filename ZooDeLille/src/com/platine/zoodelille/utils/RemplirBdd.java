package com.platine.zoodelille.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.beans.AnimalCategory;
import com.platine.zoodelille.beans.Article;
import com.platine.zoodelille.beans.Country;
import com.platine.zoodelille.beans.Enclosure;
import com.platine.zoodelille.beans.Garbage;
import com.platine.zoodelille.beans.LocatableElement;
import com.platine.zoodelille.beans.PracticalInformation;
import com.platine.zoodelille.beans.Restroom;
import com.platine.zoodelille.dao.AnimalCategoryDao;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.ArticleDao;
import com.platine.zoodelille.dao.CountryDao;
import com.platine.zoodelille.dao.EnclosureDao;
import com.platine.zoodelille.dao.GarbageDao;
import com.platine.zoodelille.dao.PracticalInformationDao;
import com.platine.zoodelille.dao.RestroomDao;

/**
 * Classe de développement servant à remplir manuellement la base de données. 
 *
 */
public class RemplirBdd {

	public static void addAnimalCategories()
	{
		AnimalCategoryDao animalCategoryDao = DatabaseManager.getDao().getAnimalCategoryDao();
		
		AnimalCategory mamifere = new AnimalCategory("Mamifère");
		AnimalCategory oiseau = new AnimalCategory("Oiseau");
		AnimalCategory reptile = new AnimalCategory("Reptile");
		
		animalCategoryDao.save(mamifere);
		animalCategoryDao.save(oiseau);
		animalCategoryDao.save(reptile);
	}
	
	public static void addAnimalCountries()
	{
		CountryDao countryDao = DatabaseManager.getDao().getCountryDao();
		
		Country australie = new Country("Australie");
		Country congo = new Country("Congo");
		Country bresil = new Country("Brésil");
		Country canada = new Country("Canada");
		
		countryDao.save(australie);
		countryDao.save(congo);
		countryDao.save(bresil);
		countryDao.save(canada);
	}
	
	/**
	 * Permet de remplir la base de données avec des animaux.
	 */
	public static void ajouterDesAnimaux(){
		CountryDao countryDao = DatabaseManager.getDao().getCountryDao();
		EnclosureDao enclosureDao = DatabaseManager.getDao().getEnclosureDao();
		AnimalCategoryDao animalCategoryDao = DatabaseManager.getDao().getAnimalCategoryDao();
		List<Enclosure> enclosures = enclosureDao.findAll();
		List<AnimalCategory> animalCategories = animalCategoryDao.findAll();
		List<Country> countries = countryDao.findAll();
		HashMap<String, Enclosure> enclosures_dico = NamableElementHelper.transformToHashMap(enclosures);
		HashMap<String, Country> countries_dico = NamableElementHelper.transformToHashMap(countries);
		HashMap<String, AnimalCategory> animalCategories_dico = NamableElementHelper.transformToHashMap(animalCategories);
		
		/** Les Mamiféres **/
		AnimalDao animalDao = DatabaseManager.getDao().getAnimalDao();
		Animal alpaga = new Animal("Alpaga",  animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "L'alpaga (Vicugna pacos) est un mammifère domestique membre de la famille des petits camélidés, comme le lama, le guanaco et la vigogne. Longtemps considéré comme un descendant du guanaco (tout comme le lama), une étude de 2001 a montré qu'il descendait de la vigogne1. Comme ces derniers, il rumine mais n'est pas classé dans la famille des ruminants. Selon leur pelage, on distingue deux types d'alpagas : les suris et les huacayas.", "jungle", "5 a 10 ans", 1, 125, 9,"alpage1,alpage2", enclosures_dico.get("Terre d'Asie"));
		Animal capucinBrun = new Animal("Capucin brun", animalCategories_dico.get("Mamifère"), countries_dico.get("Congo"), "omme toutes les espèces de capucin (cebus spp.), le capucin brun (Cebus apella) vit dans les forêts tropicales du continent américain, au sein de groupes dune dizaine d'individus en moyenne.", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "capucin1", enclosures_dico.get("Volières"));
		Animal capybara = new Animal("Capybara", animalCategories_dico.get("Mamifère"), countries_dico.get("Brésil"), "Le Capybara (Hydrochoerus hydrochaeris) est une espèce de rongeur, un hystricognathe dont la taxinomie et la classification sont encore discutées et varient selon les auteurs. C'est le plus gros rongeur actuel. Il vit en Amérique du Sud où il mène la vie d'un mammifère social et semi-aquatique. Le capybara nage très bien et vit en groupe, les adultes s'organisant pour garder les petits.", "jungle", "5 a 10 ans", 1, 125, 9, "capybara", enclosures_dico.get("Terre d'Afrique"));
		Animal chatPecheur = new Animal("Chat pêcheur", animalCategories_dico.get("Mamifère"), countries_dico.get("Brésil"), "Le chat viverrin fait environ 40 cm de hauteur au garrot, il pèse entre 5 et 10 kg, il peut atteindre 85 cm de longueur avec une queue de 30 cm de long. Ce chat aux pattes courtes, à la tête plate et aux oreilles minuscules, ne vit qu'à proximité de l'eau. On le suppose capable de pêcher facilement des poissons, grâce à ses pattes légèrement palmées. Il est capable de plonger à la poursuite des poissons. Il se nourrit également de petits mammifères, d'oiseaux, de crustacés...À l'issue d'une gestation de 63 à 70 jours, les femelles mettent au monde entre 2 à 4 petits par portée. Il atteint sa maturité sexuelle au bout de 9 mois. Ce félidé a une longévité de 10 à 12 ans.", "arbres ou en cage", "10 a 12 ans", 1, 12, 5, "chatpecheur11", enclosures_dico.get("Terre d'Asie"));
		Animal coatiBrun = new Animal("Coati brun", animalCategories_dico.get("Mamifère"), countries_dico.get("Brésil"), "Le coati à nez blanc (Nasua narica) nommé aussi coati à museau blanc1, coati brun1, ou plus simplement coati1, est un mammifère omnivore appartenant à la famille des procyonidae.", "jungle", "5 a 10 ans", 1, 125, 9, "coatibrun1", enclosures_dico.get("Terre d'Amérique"));
		Animal gibbonAMainsBlanches = new Animal("Gibbon à mains blanches", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Le gibbon est l’anthropoïde le plus primitif et le plus petit. La lignée évolutive du gibbon a divergé de celle de l'homme il y a environ 18 millions d'années, soit 6 millions d'années avant l'orang-outan et 10 millions d'années avant le chimpanzé et le gorille.[réf. nécessaire] D'une taille comprise aux environs de 90 centimètres et d'un poids de 8 à 11 kilogrammes, il a la face encadrée de blanc et les extrémités des mains blanches. Sa plante de pieds est recouverte d'une peau dure. Il possède 5 doigts à chaque mains munis de 3 articulations avec un pouce opposable. Il possède des ongles noirs pas de griffes. Il se déplace avec habileté dans la jungle asiatique et indonésienne, il peut faire des bonds de 10 à 15 mètres entre deux arbres, par brachiation. Contrairement aux autres singes anthropoïdes, lorsqu'il marche debout, il garde son équilibre en se servant de ses bras comme balancier. Cette espèce protège son territoire en lançant des cris.", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "gibbonmb1", enclosures_dico.get("Terre d'Afrique"));
		Animal elandDuCap = new Animal("Eland du Cap", animalCategories_dico.get("Mamifère"), countries_dico.get("Canada"), "L'Éland, Taurotragus oryx, est une espèce de ruminants de la famille des Bovidés. L'éland est la plus grande des antilopes d'Afrique.", "jungle", "5 a 10 ans", 1, 125, 9, "elan1", enclosures_dico.get("Terre d'Amérique"));
		Animal kinkajou = new Animal("Kinkajou", animalCategories_dico.get("Mamifère"), countries_dico.get("Brésil"), "Le kinkajou ou potos (Potos flavus)1 est une espèce de mammifère mustéloïde arboricole et nocturne de la forêt humide des Guyanes, de l'Amazonie, des Andes et de l'Amérique centrale. Animal étrange même pour les autochtones, le kinkajou est longtemps resté inclassable. Ayant mis à rude épreuve l'élaboration d'une nomenclature scientifique par les naturalistes, il reste une curiosité biologique parmi les carnivores, et par sa physiologie, et par son comportement. La fascination qu'il a toujours exercée ne laisse pas d'interroger les rapports entre l'homme et la Nature et soulève plus précisément aujourd'hui les questions de la pérennité des milieux tropicaux et du risque sanitaire associé aux animaux exotiques.", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Terre d'Afrique"));
		Animal lievreDePatagonie = new Animal("Lièvre de Patagonie", animalCategories_dico.get("Mamifère"), countries_dico.get("Brésil"), "Le Mara (Dolichotis patagonum) est une espèce de Rongeurs de la famille des Cavidés, comme les cobayes communs, bien que son apparence rappelle celle des lièvres. Ce mammifère est endémique d'Argentine et classé dans la Liste rouge de l'UICN comme « Quasi menacé »2. Après le capybara et les castors, ce mara est le troisième plus gros rongeur vivant.", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Afrique"));
		Animal lorisLentPygmee = new Animal("Loris lent pygmée", animalCategories_dico.get("Mamifère"), countries_dico.get("Brésil"), "En zoologie, l'appellation Loris peut désigner plusieurs espèces de primates de genres différents, tels que Nycticebus ou Loris. Le mot provient du néerlandais loeris signifiant clown. Le genre des Loris appartient au sous-ordre des lémuriens. Le Loris est le seul primate sécrétant du venin. Son venin, très puissant, se déverse sur le tissu capillaire de mammifère asiatique. Ce venin est constitué de liquide sécrété par des glandes se situant près du coude, l'huile brachiale, mélangée à sa salive. Il lui sert à repousser les parasites et les prédateurs.", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Terre d'Afrique"));
		Animal makiCatta = new Animal("Maki catta", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Le Maki catta (Lemur catta) ou Maki mococo est un lémuriforme appartenant à la famille des lémuriens, il est le seul représentant du genre Lemur.", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Amérique"));
		Animal mangousteJaune = new Animal("Mangouste jaune", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "La mangouste jaune (Cynictis penicillata), ou mangouste fauve est la seule espèce du genre Cynictis.On la trouve dans les zones semi-désertiques ou de savane en Angola, Botswana, Afrique du Sud, Namibie et au Zimbabwe. Elle vit en colonies de 8 à 20 individus formées d'un couple reproducteur et de leur progéniture.", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Madagascar"));
		Animal ouistitiDeGeoffroy = new Animal("Ouistiti de Geoffroy", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Le Ouistiti à face blanche (Callithrix geoffroyi) est une espèce de primate de la famille des Callitrichidae qui se rencontre au Brésil.", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Ile des singes"));
		Animal pandaRoux = new Animal("Panda roux", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Le petit panda, panda roux, panda fuligineux ou panda éclatant (Ailurus fulgens), est un mammifère originaire de l'Himalaya et de la Chine méridionale. Ailurus fulgens est le seul représentant du genre Ailurus.", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Terre d'Asie"));
		Animal petitChevrotainMalais = new Animal("Petit chevrotain malais", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Chevrotain, ou chevrotin, désigne en zoologie certains petits mammifères ruminants : Chevrotain désigne certaines espèces de la famille des Tragulidae (Chevrotain aquatique, Chevrotain indien, Chevrotain malais (Tragulus javanicus), etc.) ; Chevrotain porte-musc désigne les espèces de la famille des Moschidae. Elles produisent le musc utilisé en parfumerie.", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Afrique"));
//		Animal porcEpicACrete = new Animal("Porc-épic à crête", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Terre d'Afrique"));
//		Animal renardVolant = new Animal("Renard volant", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Afrique"));
//		Animal rhinocerosBlanc = new Animal("Rhinocéros blanc", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Volières"));
//		Animal siamang = new Animal("Siamang", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Ile des singes"));
//		Animal suricate = new Animal("Suricate", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Madagascar"));
//		Animal tamarinEmpereur = new Animal("Tamarin empereur", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Afrique"));
//		Animal tamarinLabie = new Animal("Tamarin labié", animalCategories_dico.get("Mamifère"),countries_dico.get("Australie"), "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Terre d'Afrique"));
//		Animal tapirTerrestre = new Animal("Tapir terrestre", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Afrique"));
//		Animal variNoirEtBlanc = new Animal("Vari noir et blanc", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Terre d'Afrique"));
//		Animal variRoux = new Animal("Vari roux", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Volières"));
//		Animal zebreDeBurchell = new Animal("Zèbre de Burchell", animalCategories_dico.get("Mamifère"), countries_dico.get("Australie"), "Ceci est un perroquet féroce", "arbres ou en cage", "5 a 10 ans", 1, 12, 5, "alpage1", enclosures_dico.get("Madagascar"));
		
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
//		
		/** Les Reptiles **/
		Animal agameCommun = new Animal("Agame commun", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Afrique"));
		Animal boaConstrictor = new Animal("Boa constrictor", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal boaDesArbresDeMadagascar = new Animal("Boa des arbres de Madagascar", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal couleuvreDAsie = new Animal("Couleuvre d’Asie", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal couleuvreDelAmour = new Animal("Couleuvre de l'Amour", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal iguaneVert = new Animal("Iguane vert", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal pelomeduseRoussatre = new Animal("Péloméduse roussâtre", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Terre d'Afrique"));
		Animal serpentDeLait = new Animal("Serpent de lait", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal serpentDesBles = new Animal("Serpent des blés", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal serpentRoi = new Animal("Serpent roi", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal tortueDAldabra = new Animal("Tortue d’Aldabra", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal tortueDeFloride = new Animal("Tortue de Floride", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		Animal tortueGrecque = new Animal("Tortue grecque", animalCategories_dico.get("Reptile"), countries_dico.get("Australie"), "Ceci est un lion féroce", "jungle", "5 a 10 ans", 1, 125, 9, "alpage1", enclosures_dico.get("Maison tropicale"));
		
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
	
	public static void ajouterArticle(){
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
	
	/**
	 * Ajoute les poubelles à la base de données
	 */
	public static void addGarbages(){
		GarbageDao gDao = DatabaseManager.getDao().getGarbageDao();
		Garbage g1 = new Garbage(new LocatableElement(86,49));
		Garbage g2 = new Garbage(new LocatableElement(68,93));

		gDao.save(g1);
		gDao.save(g2);
	}
	
	/**
	 * Ajoute les toilettes à la base de données
	 */
	public static void addRestroom(){
		RestroomDao rDao = DatabaseManager.getDao().getRestroomDao();
		Restroom r1 = new Restroom(new LocatableElement(81, 53));
		
		rDao.save(r1);
	}
	
	/**
	 * Ajoute les enclos à la base de données
	 */
	public static void addEnclosures(){
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
