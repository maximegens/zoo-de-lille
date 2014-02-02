package com.platine.zoodelille.utils;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;

import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.PracticalInformation;
import com.platine.zoodelille.dao.PracticalInformationDao;


/**
 * Classe effectuant des opérations concernant les horaires du Zoo. 
 *
 */
public class HoraireZoo {
	
	PracticalInformationDao practicalInformationDao;
	List<PracticalInformation> lespracticalInformationDao;
	PracticalInformation p;
	
	DateTime now;
	Interval closing_period;
	Interval summer;
	Interval winter;
	
	public HoraireZoo(){
		
		/** Recupération des horaires **/
		practicalInformationDao = DatabaseManager.getDao().getPracticalInformationDao();
		lespracticalInformationDao = practicalInformationDao.findAll();
		p = lespracticalInformationDao.get(0);
		
		/** les Dates d'ouverture et de fermeture annuelles sont sous la forme jj/mm/yyyy, on doit compte les spliter **/
		String str[]=p.getAnnual_opening().split("/");
		int annual_opening_day = Integer.parseInt(str[0]);
		int annual_opening_month = Integer.parseInt(str[1]);
		int annual_opening_year = Integer.parseInt(str[2]);
		
		String str2[]=p.getAnnual_closing().split("/");
		int annual_closing_day = Integer.parseInt(str2[0]);
		int annual_closing_month = Integer.parseInt(str2[1]);
		int annual_closing_year = Integer.parseInt(str2[2]);
			
		/*** Date de test **/	
//		now = new DateTime(2014,06,25,15,32,00); //mercredi 25 juin 2014 15h32 ouvert
//		now = new DateTime(2014,11,8,11,0,00); //samedi 8 novembre 2014 11h00 ouvert
//		now = new DateTime(2014,04,22,18,15,00); //mardi 22 avril 2014 18h15 fermé
//		now = new DateTime(2014,04,20,18,15,00); //dimanche 20 avril 2014 18h15 ouvert
//		now = new DateTime(2015,1,15,17,30,00); //jeudi 15 janvier 2015 17h30 fermé
	
		/** creation des interval d'ouverture, de période d'été et d'hiver **/
		now = new DateTime();
		Instant annual_openning = new DateTime(annual_opening_year,annual_opening_month,annual_opening_day,0,0,0).toInstant();
		Instant annual_closing = new DateTime(annual_closing_year,annual_closing_month,annual_closing_day,0,0,0).toInstant();
		closing_period = new Interval(annual_closing, annual_openning);
		
	    /** Les périodes d’été et d’hiver correspondent aux dates officielles de changement d’heure d’été et d’hiver. **/
		Instant summer_start = new DateTime(now.getYear(),04,01,0,0,0,0).toInstant(); //fin mars = 1 avril
		Instant summer_end = new DateTime(now.getYear(),10,31,0,0,0,0).toInstant(); // fin octobre = 31 octobre
		summer = new Interval(summer_start, summer_end);
		
		Instant winter_start = new DateTime(now.getYear(),11,1,0,0,0,0).toInstant(); // fin octobre = 1novembre
		Instant winter_end = new DateTime(now.getYear()+1,03,31,0,0,0,0).toInstant(); //fin mars = 31 mars
		winter = new Interval(winter_start, winter_end);
		
		
	}
	
	/**
	 * Permet de savoir si on est en été ou hiver
	 * @return 1 pour l'été, 2 pour l'hiver, 0 si erreur
	 */
	public int SummerOrWinter(){
		if(summer.contains(now))
			return 1;
		else if(winter.contains(now))
			return 2;
		else 
			return 0;
	}
	
	/**
	 * Permet de connaitre l'état du Zoo, de savoir si il est actuellement ouvert ou fermé.
	 * @return Un boolean indiquant si le Zoo est ouvert ou non.
	 */	
	public boolean zooIsOpen(){
			
		if(closing_period.contains(now))
			return false;
		else{
			if(summer.contains(now)){
				if(now.getDayOfWeek() >= 1 && now.getDayOfWeek() <6){ //la semaine
					if(now.getHourOfDay() >= Integer.parseInt(p.getSummer_week_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getSummer_week_closing_time()))
						return true;
					else
						return false; 
				}else{ // le week end
					if(now.getHourOfDay() >= Integer.parseInt(p.getSummer_weekend_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getSummer_weekend_closing_time()))
						return true;
					else
						return false;
				}
			}
			else if(winter.contains(now)){
				if(now.getDayOfWeek() >= 1 && now.getDayOfWeek() <6){ //la semaine
					if(now.getHourOfDay() >= Integer.parseInt(p.getWinter_week_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getWinter_week_closing_time()))
						return true; 
					else
						return false;
				}else{ //le week end
					if(now.getHourOfDay() >= Integer.parseInt(p.getWinter_weekend_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getWinter_weekend_closing_time()))
						return true; 
					else
						return false;
				}
			}
			else
				return false;
		}	
	}
	
	
	/**
	 * Permet de connaitre la prochaine heure d'ouverture ou de fermeture du zoo
	 * @return Un String indique l'heure ou la date de la prochaine ouverture ou fermeture.
	 */	
	public String getNextOpenning(){
			
		if(closing_period.contains(now))
			return p.getAnnual_opening();
		else{
			if(summer.contains(now)){
				if(now.getDayOfWeek() >= 1 && now.getDayOfWeek() <6){ //la semaine
					if(now.getHourOfDay() >= Integer.parseInt(p.getSummer_week_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getSummer_week_closing_time()))
						return p.getSummer_week_closing_time()+Constantes.HEURE;
					else{ //fermé
						if(now.getHourOfDay() == 5) // le lendemain on sera le week end
							return p.getSummer_weekend_opening_time()+Constantes.HEURE;
						else
							return p.getSummer_week_opening_time()+Constantes.HEURE;
					}
				}else{ // le week end
					if(now.getHourOfDay() >= Integer.parseInt(p.getSummer_weekend_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getSummer_weekend_closing_time()))
						return p.getSummer_weekend_closing_time()+Constantes.HEURE;
					else{ //fermé
						if(now.getHourOfDay() == 7) // le lendemain on sera le lundi donc la semaine
							return p.getSummer_week_opening_time()+Constantes.HEURE;
						else
							return p.getSummer_weekend_opening_time()+Constantes.HEURE;
					}
				}
			}
			else if(winter.contains(now)){
				if(now.getDayOfWeek() >= 1 && now.getDayOfWeek() <6){ //la semaine
					if(now.getHourOfDay() >= Integer.parseInt(p.getWinter_week_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getWinter_week_closing_time()))
						return p.getWinter_week_closing_time()+Constantes.HEURE; 
					else{//fermé
						if(now.getHourOfDay() == 5) // le lendemain on sera le weekend
							return p.getWinter_weekend_opening_time()+Constantes.HEURE;
						else
							return p.getWinter_week_opening_time()+Constantes.HEURE;
					}
				}else{ //le week end
					if(now.getHourOfDay() >= Integer.parseInt(p.getWinter_weekend_opening_time()) && now.getHourOfDay() < Integer.parseInt(p.getWinter_weekend_closing_time()))
						return p.getWinter_weekend_closing_time()+Constantes.HEURE; 
					else
						if(now.getHourOfDay() == 7) // le lendemain on sera le lundi donc la semaine
							return p.getWinter_week_opening_time()+Constantes.HEURE;
						else
							return p.getWinter_weekend_opening_time()+Constantes.HEURE;
				}
			}
			else
				return "indéfini";
		}	
	}
	
}
