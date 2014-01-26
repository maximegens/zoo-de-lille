package com.platine.zoodelille.utils;


/**
 * Classe effectuant des opérations concernant les horaires du Zoo. 
 *
 */
public class HoraireZoo {

	/**
	 * Permet de connaitre l'état du Zoo, de savoir si il est actuellement ouvert ou fermé.
	 * @return Un boolean indiquant si le Zoo est ouvert ou non.
	 */
	public static boolean ZooOpen(){
		
		
//		Horaires d'été*, de fin mars à fin octobre : 
//		- 9h à 18h la semaine
//		- 9h à 19h les week-ends et jours fériés
//
//		Horaires d'hiver*, de fin octobre à fin mars : 
//		- 10h à 17h la semaine et les week-ends
//
//		Période de fermeture annuelle : 
//		- Du 9 décembre 2013 au 9 février 2014 inclus
//
//		Les périodes d’été et d’hiver correspondent aux dates officielles de changement d’heure d’été et d’hiver.
		
	//http://thecodersbreakfast.net/index.php?post/2013/01/29/Gagnez-du-temps-avec-Joda-Time
		
//		DateTime now = new DateTime(2014,8,25,0,0,0);
//		DateTime ouverture = new DateTime(2014,2,9,0,0,0);
//		Instant summer_start = new DateTime(2014,04,01,0,0,0,0).toInstant(); //fin mars = 1 avril
//		Instant summer_end = new DateTime(2014,10,31,0,0,0,0).toInstant(); // fin octobre = 31 octobre
//		Interval summer = new Interval(summer_start, summer_end);
//		
//		Instant winter_start = new DateTime(2014,12,21,0,0,0,0).toInstant(); // fin octobre = 1novembre
//		Instant winter_end = new DateTime(2015,03,31,0,0,0,0).toInstant(); //fin mars = 31 mars
//		Interval winter = new Interval(winter_start, winter_end);
//		
//		if(ouverture.isAfterNow())
//			System.out.println("fermé 1");
//		else{
//			if(summer.contains(now)){
//				System.out.println("summer");
//			}
//			else if(winter.contains(now)){
//				System.out.println("winter");
//			}
//			else
//				System.out.println("fermé 2");
//		}
//		
//	}
		
		
		return false;
	}
}
